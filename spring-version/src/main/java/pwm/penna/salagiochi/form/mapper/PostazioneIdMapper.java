package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pwm.penna.salagiochi.form.dto.PostazioneIdForm;
import pwm.penna.salagiochi.form.mapper.base.BaseMapper;
import pwm.penna.salagiochi.model.postazione.PostazioneId;

@Mapper(componentModel = "spring")
public interface PostazioneIdMapper extends BaseMapper<PostazioneId, PostazioneIdForm> {

    @Override
    PostazioneIdForm toForm(PostazioneId entity);

    @Override
    PostazioneId toEntity(PostazioneIdForm form);

    @Override
    void updateEntityFromForm(PostazioneIdForm form, @MappingTarget PostazioneId entity);
}
