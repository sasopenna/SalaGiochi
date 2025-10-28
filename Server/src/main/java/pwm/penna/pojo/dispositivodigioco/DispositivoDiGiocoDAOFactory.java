package pwm.penna.pojo.dispositivodigioco;

public class DispositivoDiGiocoDAOFactory {
	private static DispositivoDiGiocoDAO dao = null;

	private DispositivoDiGiocoDAOFactory() {}

	public static synchronized DispositivoDiGiocoDAO getDAO() {
		if (dao == null) {
			dao = new DispositivoDiGiocoDAOHibernateImpl();
		}
		return dao;
	} 
}