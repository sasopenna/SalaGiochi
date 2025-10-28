package pwm.penna.pojo.richiede;

public class RichiedeDAOFactory {
	private static RichiedeDAO dao = null;

	private RichiedeDAOFactory() {}

	public static synchronized RichiedeDAO getDAO() {
		if (dao == null) {
			dao = new RichiedeDAOHibernateImpl();
		}
		return dao;
	} 
}