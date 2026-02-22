package pwm.penna.pojo.cassiere;

public class CassiereDAOFactory {
	private static CassiereDAO dao = null;

	private CassiereDAOFactory() {}

	public static synchronized CassiereDAO getDAO() {
		if (dao == null) {
			dao = new CassiereDAOHibernateImpl();
		}
		return dao;
	} 
}