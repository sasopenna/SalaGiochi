package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.*;
import pwm.penna.salagiochi.form.dto.AssegnazioneForm;
import pwm.penna.salagiochi.form.mapper.base.BaseMapper;
import pwm.penna.salagiochi.model.assegna.Assegna;

@Mapper(componentModel = "spring")
public interface AssegnaMapper extends BaseMapper<Assegna, AssegnazioneForm> {

    @Override
    AssegnazioneForm toForm(Assegna entity);

    @Override
    @Mapping(target = "richiede", ignore = true)
    Assegna toEntity(AssegnazioneForm form);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "richiede", ignore = true)
    void updateEntityFromForm(AssegnazioneForm form, @MappingTarget Assegna entity);
}
