package pwm.penna.pojo.socio;

public class SocioDAOFactory {
	private static SocioDAO dao = null;

	private SocioDAOFactory() {}

	public static synchronized SocioDAO getDAO() {
		if (dao == null) {
			dao = new SocioDAOHibernateImpl();
		}
		return dao;
	} 
}