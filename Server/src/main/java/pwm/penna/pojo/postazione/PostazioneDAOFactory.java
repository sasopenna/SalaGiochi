package pwm.penna.pojo.postazione;

public class PostazioneDAOFactory {
	private static PostazioneDAO dao = null;

	private PostazioneDAOFactory() {}

	public static synchronized PostazioneDAO getDAO() {
		if (dao == null) {
			dao = new PostazioneDAOHibernateImpl();
		}
		return dao;
	} 
}