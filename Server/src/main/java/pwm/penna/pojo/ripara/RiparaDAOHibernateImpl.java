package pwm.penna.pojo.ripara;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pwm.penna.utils.HibernateUtil;

public class RiparaDAOHibernateImpl implements RiparaDAO {
	protected RiparaDAOHibernateImpl() {}

	@Override
	public Ripara getRiparazione(Integer r) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			return (Ripara) session.get(Ripara.class, r);
		} catch (HibernateException e) {
		} finally {
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public List<Ripara> getLista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Ripara> res = null;
		try {
			transaction = session.beginTransaction();
			
			res = session.createQuery("from Ripara", Ripara.class).list();
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return res;
	}

	@Override
	public boolean creaRiparazione(Ripara r) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.persist(r);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		
		return false;
	}

	@Override
	public boolean aggiornaRiparazione(Ripara r) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.merge(r);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		
		return false;
	}

	@Override
	public boolean eliminaRiparazione(Integer r) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.remove(getRiparazione(r));
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
