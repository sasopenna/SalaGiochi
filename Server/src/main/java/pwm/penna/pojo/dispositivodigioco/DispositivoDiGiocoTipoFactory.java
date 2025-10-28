package pwm.penna.pojo.dispositivodigioco;

import pwm.penna.pojo.dispositivodigioco.tipo.PC;
import pwm.penna.pojo.dispositivodigioco.tipo.PlayStation;
import pwm.penna.pojo.dispositivodigioco.tipo.Xbox;

public class DispositivoDiGiocoTipoFactory {
    public static DispositivoDiGioco crea(String tipo, DispositivoDiGioco d, String discriminator) {
        switch (tipo) {
            case PC.DISCRIMINATOR: return new PC(d, discriminator);
            case Xbox.DISCRIMINATOR: return new Xbox(d, discriminator);
            case PlayStation.DISCRIMINATOR: return new PlayStation(d, discriminator);
        }
        //sarebbe meglio un throw di errore ma evito
        return null; 
    }
}

