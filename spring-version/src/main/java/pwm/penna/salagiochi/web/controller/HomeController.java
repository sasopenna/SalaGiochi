package pwm.penna.salagiochi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pwm.penna.salagiochi.form.service.StatsService;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    StatsService statsService;

    @RequestMapping
    public String home(Model model) {
        model.addAllAttributes(statsService.home());
        return "home/home";
    }

    @GetMapping("statistiche")
    public String statistiche(Model model) {
        model.addAllAttributes(statsService.stats());
        return "home/statistiche";
    }

    @GetMapping("dove-siamo")
    public String doveSiamo(Model model) {
        model.addAttribute("sale", statsService.sale());
        return "home/dove-siamo";
    }
}
