package pwm.penna.salagiochi.form.mapper;

import org.mapstruct.*;
import pwm.penna.salagiochi.form.dto.DispositivoDiGiocoForm;
import pwm.penna.salagiochi.form.mapper.base.BaseMapper;
import pwm.penna.salagiochi.model.dispositivodigioco.DispositivoDiGioco;
import pwm.penna.salagiochi.model.dispositivodigioco.tipo.PC;
import pwm.penna.salagiochi.model.dispositivodigioco.tipo.PlayStation;
import pwm.penna.salagiochi.model.dispositivodigioco.tipo.Xbox;

@Mapper(componentModel = "spring")
public interface DispositivoDiGiocoMapper extends BaseMapper<DispositivoDiGioco, DispositivoDiGiocoForm> {

    @Override
    @Mapping(target = "tipo", expression = "java(entity.getTipo())")
    DispositivoDiGiocoForm toForm(DispositivoDiGioco entity);

    @Override
    @Mapping(target = "postazione", ignore = true)
    @Mapping(target = "riparazioni", ignore = true)
    DispositivoDiGioco toEntity(DispositivoDiGiocoForm form);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "postazione", ignore = true)
    @Mapping(target = "riparazioni", ignore = true)
    void updateEntityFromForm(DispositivoDiGiocoForm form, @MappingTarget DispositivoDiGioco entity);

    @ObjectFactory
    default DispositivoDiGioco istanza(DispositivoDiGiocoForm form) {
        return switch (form.getTipo().toUpperCase()) {
            case "PC" -> {
                PC pc = new PC();
                pc.setWindows(form.getDiscriminator());
                yield pc;
            }
            case "XBOX" -> {
                Xbox xbox = new Xbox();
                xbox.setGenerazione(form.getDiscriminator());
                yield xbox;
            }
            case "PLAYSTATION" -> {
                PlayStation playStation = new PlayStation();
                playStation.setGenerazione(form.getDiscriminator());
                yield playStation;
            }
            default -> throw new IllegalArgumentException("Tipo dispositivo non valido: " + form.getTipo());
        };
    }
}
