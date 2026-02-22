package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import pwm.penna.salagiochi.form.dto.DipendenteForm;
import pwm.penna.salagiochi.model.dipendente.Dipendente;

@Mapper(componentModel = "spring", uses = {ProfiloMapper.class})
public interface DipendenteMapper {

    DipendenteForm toForm(Dipendente dipendente);

    Dipendente toEntity(DipendenteForm form);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromForm(DipendenteForm form, @MappingTarget Dipendente dipendente);
}
