package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.*;
import pwm.penna.salagiochi.form.dto.SocioForm;
import pwm.penna.salagiochi.form.mapper.base.BaseMapper;
import pwm.penna.salagiochi.model.socio.Socio;

@Mapper(componentModel = "spring", uses = {ProfiloMapper.class})
public interface SocioMapper extends BaseMapper<Socio, SocioForm> {

    @Override
    SocioForm toForm(Socio entity);

    @Override
    @Mapping(target = "cliente", ignore = true)
    Socio toEntity(SocioForm form);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "cliente", ignore = true)
    void updateEntityFromForm(SocioForm form, @MappingTarget Socio entity);
}
