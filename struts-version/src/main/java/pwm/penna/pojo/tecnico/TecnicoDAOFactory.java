package pwm.penna.pojo.tecnico;

public class TecnicoDAOFactory {
	private static TecnicoDAO dao = null;

	private TecnicoDAOFactory() {}

	public static synchronized TecnicoDAO getDAO() {
		if (dao == null) {
			dao = new TecnicoDAOHibernateImpl();
		}
		return dao;
	} 
}