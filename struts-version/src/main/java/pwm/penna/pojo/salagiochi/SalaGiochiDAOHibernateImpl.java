package pwm.penna.pojo.salagiochi;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pwm.penna.utils.HibernateUtil;

public class SalaGiochiDAOHibernateImpl implements SalaGiochiDAO {
	protected SalaGiochiDAOHibernateImpl() {}

	@Override
	public SalaGiochi getSala(Integer s) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {			
			return (SalaGiochi) session.get(SalaGiochi.class, s);
		} catch (HibernateException e) {
		} finally {
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public List<SalaGiochi> getLista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<SalaGiochi> res = null;
		try {
			transaction = session.beginTransaction();
			res = session.createQuery("from SalaGiochi", SalaGiochi.class).list();
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
	public long countSale() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		long count = 0;
		try {
			transaction = session.beginTransaction();
			count = session.createQuery("select count(*) from SalaGiochi", Long.class).getSingleResult();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return count;
	}

	@Override
	public boolean aggiornaSala(SalaGiochi s) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.merge(s);
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
	public boolean creaSala(SalaGiochi s) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.persist(s);
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
	public boolean eliminaSala(Integer s) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.remove(getSala(s));
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
	public SalaGiochi getSalaAndPostazioni(Integer s) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		SalaGiochi res = null;

		try {
			transaction = session.beginTransaction();
			res = (SalaGiochi) session.get(SalaGiochi.class, s);
			Hibernate.initialize(res.getPostazioni());
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		
		return res;
	}
}
