package pwm.penna.salagiochi.form.service.base;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import pwm.penna.salagiochi.form.dto.base.BaseForm;
import pwm.penna.salagiochi.form.mapper.base.BaseMapper;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseService<E, F extends BaseForm<ID>, ID, R extends JpaRepository<E, ID>> {
    @Autowired
    private R repository;
    @Autowired
    private BaseMapper<E, F> mapper;
    private final Class<E> entityClass;

    @SuppressWarnings("unchecked")
    protected BaseService() {
        this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public E findById(ID id) {
        try {
            if (id == null) return entityClass.getDeclaredConstructor().newInstance();
            return repository.findById(id).orElseThrow();
        } catch (Exception ignored) {
        }
        return null;
    }

    public List<E> lista() {
        return repository.findAll();
    }

    @Transactional
    public void crea(F form) {
        repository.save(mapper.toEntity(form));
    }

    @Transactional
    public void aggiorna(F form) {
        E entity = findById(form.getKey());

        mapper.updateEntityFromForm(form, entity);

        repository.save(entity);
    }

    @Transactional
    public void elimina(ID id) {
        repository.deleteById(id);
    }

    public F getForm(ID id) {
        return mapper.toForm(findById(id));
    }

    public BaseMapper<E, F> getMapper() {
        return mapper;
    }

    public R getRepository() {
        return repository;
    }
}