package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.*;
import pwm.penna.salagiochi.form.dto.TecnicoForm;
import pwm.penna.salagiochi.form.mapper.base.BaseMapper;
import pwm.penna.salagiochi.model.tecnico.Tecnico;

@Mapper(componentModel = "spring", uses = {DipendenteMapper.class})
public interface TecnicoMapper extends BaseMapper<Tecnico, TecnicoForm> {

    TecnicoForm toForm(Tecnico tecnico);

    @Mapping(target = "riparazioni", ignore = true)
    Tecnico toEntity(TecnicoForm form);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "riparazioni", ignore = true)
    void updateEntityFromForm(TecnicoForm form, @MappingTarget Tecnico tecnico);
}
