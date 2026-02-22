package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import pwm.penna.salagiochi.form.dto.RiparaForm;
import pwm.penna.salagiochi.form.mapper.base.BaseMapper;
import pwm.penna.salagiochi.model.ripara.Ripara;

@Mapper(componentModel = "spring")
public interface RiparaMapper extends BaseMapper<Ripara, RiparaForm> {

    @Override
    RiparaForm toForm(Ripara entity);

    @Override
    Ripara toEntity(RiparaForm form);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromForm(RiparaForm form, @MappingTarget Ripara entity);
}
