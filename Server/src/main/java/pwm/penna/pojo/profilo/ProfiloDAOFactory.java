package pwm.penna.pojo.profilo;

public class ProfiloDAOFactory {
	private static ProfiloDAO dao = null;

	private ProfiloDAOFactory() {}

	public static synchronized ProfiloDAO getDAO() {
		if (dao == null) {
			dao = new ProfiloDAOHibernateImpl();
		}
		return dao;
	} 
}