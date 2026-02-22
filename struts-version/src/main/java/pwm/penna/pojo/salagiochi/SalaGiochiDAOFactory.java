package pwm.penna.pojo.salagiochi;

public class SalaGiochiDAOFactory {
	private static SalaGiochiDAO dao = null;

	private SalaGiochiDAOFactory() {}

	public static synchronized SalaGiochiDAO getDAO() {
		if (dao == null) {
			dao = new SalaGiochiDAOHibernateImpl();
		}
		return dao;
	} 
}