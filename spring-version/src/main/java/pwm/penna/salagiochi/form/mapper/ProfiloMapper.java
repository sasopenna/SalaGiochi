package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import pwm.penna.salagiochi.form.dto.ProfiloForm;
import pwm.penna.salagiochi.model.profilo.Profilo;

@Mapper(componentModel = "spring", uses = {IndirizzoMapper.class})
public interface ProfiloMapper {

    ProfiloForm toForm(Profilo profilo);

    Profilo toEntity(ProfiloForm form);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromForm(ProfiloForm form, @MappingTarget Profilo profilo);
}
