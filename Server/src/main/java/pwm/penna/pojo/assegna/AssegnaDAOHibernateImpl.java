package pwm.penna.pojo.assegna;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pwm.penna.utils.HibernateUtil;

public class AssegnaDAOHibernateImpl implements AssegnaDAO {
	protected AssegnaDAOHibernateImpl() {}

	@Override
	public Assegna getAssegnazione(Integer a) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {			
			return (Assegna) session.get(Assegna.class, a);
		} catch (HibernateException e) {
		} finally {
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public List<Assegna> getLista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Assegna> res = null;
		try {
			transaction = session.beginTransaction();
			
			res = session.createQuery("from Assegna", Assegna.class).list();
			
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
	public boolean creaAssegnazione(Assegna a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.persist(a);
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

	@Override
	public boolean aggiornaAssegnazione(Assegna a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.merge(a);
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
	public boolean eliminaAssegnazione(Integer a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.remove(getAssegnazione(a));
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
