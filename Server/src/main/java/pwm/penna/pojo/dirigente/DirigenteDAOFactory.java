package pwm.penna.pojo.dirigente;

public class DirigenteDAOFactory {
	private static DirigenteDAO dao = null;

	private DirigenteDAOFactory() {}

	public static synchronized DirigenteDAO getDAO() {
		if (dao == null) {
			dao = new DirigenteDAOHibernateImpl();
		}
		return dao;
	} 
}