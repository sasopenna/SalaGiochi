package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.*;
import pwm.penna.salagiochi.form.dto.CassiereForm;
import pwm.penna.salagiochi.form.mapper.base.BaseMapper;
import pwm.penna.salagiochi.model.cassiere.Cassiere;

@Mapper(componentModel = "spring", uses = {DipendenteMapper.class})
public interface CassiereMapper extends BaseMapper<Cassiere, CassiereForm> {

    CassiereForm toForm(Cassiere cassiere);

    @Mapping(target = "assegnazioni", ignore = true)
    Cassiere toEntity(CassiereForm form);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "assegnazioni", ignore = true)
    void updateEntityFromForm(CassiereForm form, @MappingTarget Cassiere cassiere);
}