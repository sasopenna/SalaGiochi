package pwm.penna.pojo.assegna;

public class AssegnaDAOFactory {
	private static AssegnaDAO dao = null;

	private AssegnaDAOFactory() {}

	public static synchronized AssegnaDAO getDAO() {
		if (dao == null) {
			dao = new AssegnaDAOHibernateImpl();
		}
		return dao;
	} 
}