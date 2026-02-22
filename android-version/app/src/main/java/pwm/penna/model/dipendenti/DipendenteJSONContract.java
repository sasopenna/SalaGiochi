package pwm.penna.model.dipendenti;

public class DipendenteJSONContract {
	public static final String ARRAY = "dipendenti";

	public static final String ID_DIPENDENTE = "idDipendente";
	public static final String INIZIO_TURNO = "inizioTurno";
	public static final String FINE_TURNO = "fineTurno";
	public static final String SALARIO = "salario";
	public static final String PROFILO = "profilo";

	public static class DirigenteJSONContract {
		public static final String PERIODO = "periodo";
		public static final String ESPERIENZA = "esperienza";
	}

	public static class CassiereJSONContract {
		public static final String SALA_GIOCHI = "salaGiochi";
		public static final String SPORTELLO = "sportello";
	}

	public static class TecnicoJSONContract {
		public static final String SPECIALIZZAZIONE = "specializzazione";
	}
}

