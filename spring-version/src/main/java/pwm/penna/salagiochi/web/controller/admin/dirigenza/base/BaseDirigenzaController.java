package pwm.penna.salagiochi.web.controller.admin.dirigenza.base;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.dto.base.BaseForm;
import pwm.penna.salagiochi.form.service.base.BaseService;
import pwm.penna.salagiochi.web.base.BaseController;

public abstract class BaseDirigenzaController<F extends BaseForm<ID>, ID, S extends BaseService<?, F, ID, ?>> extends BaseController {
    @Autowired
    private S service;

    @RequestMapping
    public String lista(Model model) {
        model.addAttribute("lista", service.lista());
        return "admin/dirigenza/" + getBasePath() + "/lista";
    }

    @GetMapping("/modifica/{pathVar}")
    public String modifica(Model model, @PathVariable ID pathVar) {
        return buildFromId(model, pathVar);
    }

    @GetMapping("/inserisci")
    public String inserisci(Model model) {
        return buildFromId(model, null);
    }

    @PostMapping("/modifica/{pathVar}")
    public String aggiorna(Model model, @PathVariable ID pathVar, @Valid F form, BindingResult bindingResult) {
        form.setKey(pathVar);
        formBinding(form, bindingResult);

        try {
            if (!bindingResult.hasErrors()) {
                service.aggiorna(form);
                success("action.mod.success");
                return "redirect:/admin/dirigenza/" + getBasePath();
            }
        } catch (Exception e) {
            error(model, "action.mod.error");
        }
        return buildFromForm(model, form, true);
    }

    @PostMapping("/inserisci")
    public String crea(Model model, @Valid F form, BindingResult bindingResult) {
        formBinding(form, bindingResult);

        try {
            if (!bindingResult.hasErrors()) {
                service.crea(form);
                success("action.add.success");
                return "redirect:/admin/dirigenza/" + getBasePath();
            }
        } catch (Exception e) {
            error(model, "action.add.error");
        }
        return buildFromForm(model, form, false);
    }

    @GetMapping("/elimina/{pathVar}")
    public String elimina(@PathVariable ID pathVar) {
        try {
            service.elimina(pathVar);
            success("action.del.success");
        } catch (Exception e) {
            error("action.del.error");
        }
        return "redirect:/admin/dirigenza/" + getBasePath();
    }

    private String buildFromForm(Model model, F form, boolean modifica) {
        return buildForm(model, form, modifica);
    }

    private String buildFromId(Model model, ID id) {
        return buildForm(model, service.getForm(id), id != null);
    }

    private String buildForm(Model model, F form, boolean modifica) {
        buildModel(model, form.getKey());
        model.addAttribute("modifica", modifica);
        model.addAttribute(form.getName(), form);
        return "admin/dirigenza/" + getBasePath() + "/form";
    }

    // Vuoti così si modifica solo se si vuole
    protected void buildModel(Model model, ID id) {
    }

    protected void formBinding(F form, BindingResult bindingResult) {
    }

    public S getService() {
        return service;
    }

    protected abstract String getBasePath();
}