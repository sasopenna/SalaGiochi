package pwm.penna.pojo.account;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pwm.penna.utils.HibernateUtil;

public class AccountDAOHibernateImpl implements AccountDAO {
	protected AccountDAOHibernateImpl() {}

	@Override
	public Account getAccount(String a) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {			
			return (Account) session.get(Account.class, a);
		} catch (HibernateException e) {
		} finally {
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public List<Account> getLista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Account> res = null;
		try {
			transaction = session.beginTransaction();
			
			res = session.createQuery("from Account", Account.class).list();
			
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
	public boolean aggiornaAccount(Account a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.merge(a);
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
	public boolean eliminaAccount(String email) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.remove(getAccount(email));
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
