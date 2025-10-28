package pwm.penna.pojo.ripara;

public class RiparaDAOFactory {
	private static RiparaDAO dao = null;

	private RiparaDAOFactory() {}

	public static synchronized RiparaDAO getDAO() {
		if (dao == null) {
			dao = new RiparaDAOHibernateImpl();
		}
		return dao;
	} 
}