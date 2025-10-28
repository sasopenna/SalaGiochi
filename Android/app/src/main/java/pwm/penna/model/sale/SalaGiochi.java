package pwm.penna.model.sale;

import java.io.Serializable;
import java.sql.Time;

public class SalaGiochi implements Serializable {
	private Integer codice;
	private String nome;
	private int capienza;
	private Time orarioApertura;
	private Time orarioChiusura;
	private Indirizzo indirizzo;

	public SalaGiochi() {}

	public Integer getCodice() {
		return this.codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCapienza() {
		return this.capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public Time getOrarioApertura() {
		return this.orarioApertura;
	}

	public void setOrarioApertura(Time orarioApertura) {
		this.orarioApertura = orarioApertura;
	}

	public Time getOrarioChiusura() {
		return this.orarioChiusura;
	}

	public void setOrarioChiusura(Time orarioChiusura) {
		this.orarioChiusura = orarioChiusura;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String toString() {
		return "[" + codice + "] " + nome + " / " + indirizzo.toString();
	}
}
