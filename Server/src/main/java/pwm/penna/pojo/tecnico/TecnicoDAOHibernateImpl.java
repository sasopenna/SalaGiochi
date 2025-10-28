package pwm.penna.pojo.tecnico;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pwm.penna.pojo.account.Account;
import pwm.penna.utils.HibernateUtil;

public class TecnicoDAOHibernateImpl implements TecnicoDAO {
	protected TecnicoDAOHibernateImpl() {}

	@Override
	public Tecnico getTecnico(int t) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {			
			return (Tecnico) session.get(Tecnico.class, t);
		} catch (HibernateException e) {
		} finally {
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public long countTecnici() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		long count = 0;
		try {
			transaction = session.beginTransaction();
			
			count = session.createQuery("select count(*) from Tecnico", Long.class).getSingleResult();
			
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
	public List<Tecnico> getLista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Tecnico> res = null;
		try {
			transaction = session.beginTransaction();

			res = session.createQuery("from Tecnico", Tecnico.class).list();
			
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
	public boolean eliminaTecnico(Integer t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Tecnico tecnico = (Tecnico) session.get(Tecnico.class, t);
			session.remove(tecnico);
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
	public boolean creaTecnico(Tecnico t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			t.getProfilo().setAccount(Account.fromProfilo(t.getProfilo()));
			session.persist(t);
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
	public boolean aggiornaTecnico(Tecnico t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.merge(t);
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
}
