package pwm.penna.pojo.cassiere;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pwm.penna.pojo.account.Account;
import pwm.penna.utils.HibernateUtil;

public class CassiereDAOHibernateImpl implements CassiereDAO {
	protected CassiereDAOHibernateImpl() {}

	@Override
	public Cassiere getCassiere(Integer c) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {			
			return (Cassiere) session.get(Cassiere.class, c);
		} catch (HibernateException e) {
		} finally {
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public long countCassieri() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		long count = 0;
		try {
			transaction = session.beginTransaction();
			
			count = session.createQuery("select count(*) from Cassiere", Long.class).getSingleResult();
			
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
	public List<Cassiere> getLista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Cassiere> res = null;
		try {
			transaction = session.beginTransaction();

			res = session.createQuery("from Cassiere", Cassiere.class).list();
			
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
	public boolean creaCassiere(Cassiere c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			c.getProfilo().setAccount(Account.fromProfilo(c.getProfilo()));
			session.persist(c);
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
	public boolean aggiornaCassiere(Cassiere c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.merge(c);
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
	public boolean eliminaCassiere(Integer c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.remove(getCassiere(c));
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
