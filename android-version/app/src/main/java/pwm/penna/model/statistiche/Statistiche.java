package pwm.penna.model.statistiche;

import java.util.List;

import pwm.penna.model.soci.Socio;

public class Statistiche {
    private long uomo, donna;
    private int pc, xbox, play;
    private List<Socio> top5, fedeli5;

    public long getUomo() {
        return uomo;
    }

    public void setUomo(long uomo) {
        this.uomo = uomo;
    }

    public long getDonna() {
        return donna;
    }

    public void setDonna(long donna) {
        this.donna = donna;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getXbox() {
        return xbox;
    }

    public void setXbox(int xbox) {
        this.xbox = xbox;
    }

    public int getPlay() {
        return play;
    }

    public void setPlay(int play) {
        this.play = play;
    }

    public List<Socio> getTop5() {
        return top5;
    }

    public void setTop5(List<Socio> top5) {
        this.top5 = top5;
    }

    public List<Socio> getFedeli5() {
        return fedeli5;
    }

    public void setFedeli5(List<Socio> fedeli5) {
        this.fedeli5 = fedeli5;
    }
}
