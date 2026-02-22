package pwm.penna.salagiochi.form.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pwm.penna.salagiochi.model.postazione.PostazioneId;
import pwm.penna.salagiochi.model.salagiochi.SalaGiochi;

@Component
public class StringToPostazioneIdConverter implements Converter<String, PostazioneId> {
    @Override
    public PostazioneId convert(String source) {
        String[] parts = source.split("_");
        SalaGiochi sala = new SalaGiochi();
        sala.setCodice(Integer.parseInt(parts[0]));

        return new PostazioneId(
                sala, //sala
                Integer.parseInt(parts[1]), //stanza
                Integer.parseInt(parts[2]) //posto
        );
    }
}