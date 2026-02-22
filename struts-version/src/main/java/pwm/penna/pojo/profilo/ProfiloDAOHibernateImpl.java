package pwm.penna.pojo.profilo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pwm.penna.utils.HibernateUtil;

public class ProfiloDAOHibernateImpl implements ProfiloDAO {
	protected ProfiloDAOHibernateImpl() {}
	
	@Override
	public boolean creaProfilo(Profilo p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.persist(p);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		
		return false;
	}
}
