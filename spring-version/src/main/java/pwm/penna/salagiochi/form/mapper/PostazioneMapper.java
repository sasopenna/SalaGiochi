package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.*;
import pwm.penna.salagiochi.form.dto.PostazioneForm;
import pwm.penna.salagiochi.form.mapper.base.BaseMapper;
import pwm.penna.salagiochi.model.postazione.Postazione;

@Mapper(componentModel = "spring", uses = {PostazioneIdMapper.class})
public interface PostazioneMapper extends BaseMapper<Postazione, PostazioneForm> {

    @Override
    PostazioneForm toForm(Postazione entity);

    @Override
    @Mapping(target = "id", expression = "java(form.getKey())")
    @Mapping(target = "richieste", ignore = true)
    Postazione toEntity(PostazioneForm form);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", expression = "java(form.getKey())")
    @Mapping(target = "richieste", ignore = true)
    void updateEntityFromForm(PostazioneForm form, @MappingTarget Postazione entity);
}
