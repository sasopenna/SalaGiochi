package pwm.penna.pojo.socio;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pwm.penna.pojo.account.Account;
import pwm.penna.utils.HibernateUtil;

public class SocioDAOHibernateImpl implements SocioDAO {
	protected SocioDAOHibernateImpl() {}

	@Override
	public Socio getSocio(Integer s) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {			
			return (Socio) session.get(Socio.class, s);
		} catch (HibernateException e) {
		} finally {
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public long countSoci() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		long count = 0;
		try {
			transaction = session.beginTransaction();
			count = session.createQuery("select count(*) from Socio", Long.class).getSingleResult();
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
	public long countSociPerSesso(String sesso) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		long count = 0;
		try {
			transaction = session.beginTransaction();

			count = session.createQuery("select count(*) from Socio where profilo.sesso=?1", Long.class)
					.setParameter(1, sesso)
					.getSingleResult();
			
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
	public List<Socio> orderSoci(String param, String ordering, int limit) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Socio> res = null;
		try {
			transaction = session.beginTransaction();

			//per fare le query "order by parametro ordine" non mi fa fare query.setParamter 
			res = session.createQuery("from Socio order by "+param+" "+ordering, Socio.class).setMaxResults(limit).list();
			
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

	@Override
	public List<Socio> getLista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Socio> res = null;
		try {
			transaction = session.beginTransaction();

			res = session.createQuery("from Socio", Socio.class).list();
			
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
	public boolean aggiornaSocio(Socio s) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.merge(s);
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
	public boolean registraSocio(Socio s) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.persist(s);
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
	public boolean creaSocio(Socio s) {
		s.getProfilo().setAccount(Account.fromProfilo(s.getProfilo()));
		return registraSocio(s);
	}

	@Override
	public boolean eliminaSocio(Integer s) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.remove(getSocio(s));
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
