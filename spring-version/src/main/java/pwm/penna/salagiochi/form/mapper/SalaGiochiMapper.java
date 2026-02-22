package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.*;
import pwm.penna.salagiochi.form.dto.SalaGiochiForm;
import pwm.penna.salagiochi.form.mapper.base.BaseMapper;
import pwm.penna.salagiochi.model.salagiochi.SalaGiochi;

@Mapper(componentModel = "spring", uses = {IndirizzoMapper.class})
public interface SalaGiochiMapper extends BaseMapper<SalaGiochi, SalaGiochiForm> {

    @Override
    SalaGiochiForm toForm(SalaGiochi sala);

    @Override
    @Mapping(target = "dirigenti", ignore = true)
    @Mapping(target = "postazioni", ignore = true)
    SalaGiochi toEntity(SalaGiochiForm form);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "dirigenti", ignore = true)
    @Mapping(target = "postazioni", ignore = true)
    void updateEntityFromForm(SalaGiochiForm form, @MappingTarget SalaGiochi sala);
}
