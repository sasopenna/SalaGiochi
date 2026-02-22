package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.*;
import pwm.penna.salagiochi.form.dto.RichiedeForm;
import pwm.penna.salagiochi.form.mapper.base.BaseMapper;
import pwm.penna.salagiochi.model.richiede.Richiede;

@Mapper(componentModel = "spring")
public interface RichiedeMapper extends BaseMapper<Richiede, RichiedeForm> {

    @Override
    RichiedeForm toForm(Richiede entity);

    @Override
    @Mapping(target = "assegnazione", ignore = true)
    Richiede toEntity(RichiedeForm form);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "assegnazione", ignore = true)
    void updateEntityFromForm(RichiedeForm form, @MappingTarget Richiede entity);
}
