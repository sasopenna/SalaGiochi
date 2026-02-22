package pwm.penna.salagiochi.form.mapper.base;

import org.mapstruct.MappingTarget;

public interface BaseMapper<E, F> {
    E toEntity(F form);

    F toForm(E entity);

    void updateEntityFromForm(F form, @MappingTarget E entity);
}