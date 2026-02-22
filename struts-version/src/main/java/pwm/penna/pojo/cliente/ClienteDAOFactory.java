package pwm.penna.pojo.cliente;

public class ClienteDAOFactory {
	private static ClienteDAO dao = null;

	private ClienteDAOFactory() {}

	public static synchronized ClienteDAO getDAO() {
		if (dao == null) {
			dao = new ClienteDAOHibernateImpl();
		}
		return dao;
	} 
}