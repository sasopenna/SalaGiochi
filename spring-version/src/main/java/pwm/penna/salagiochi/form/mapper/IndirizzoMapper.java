package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import pwm.penna.salagiochi.form.dto.IndirizzoForm;
import pwm.penna.salagiochi.model.salagiochi.Indirizzo;

@Mapper(componentModel = "spring")
public interface IndirizzoMapper {

    IndirizzoForm toForm(Indirizzo entity);

    Indirizzo toEntity(IndirizzoForm form);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromForm(IndirizzoForm form, @MappingTarget Indirizzo entity);
}
