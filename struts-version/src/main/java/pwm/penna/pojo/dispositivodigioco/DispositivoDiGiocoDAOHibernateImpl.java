package pwm.penna.pojo.dispositivodigioco;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pwm.penna.utils.HibernateUtil;

public class DispositivoDiGiocoDAOHibernateImpl implements DispositivoDiGiocoDAO {
	protected DispositivoDiGiocoDAOHibernateImpl() {}

	@Override
	public DispositivoDiGioco getDispositivo(Integer d) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {			
			return (DispositivoDiGioco) session.get(DispositivoDiGioco.class, d);
		} catch (HibernateException e) {
		} finally {
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public long countDispositivi() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		long count = 0;
		try {
			transaction = session.beginTransaction();
			
			count = session.createQuery("select count(*) from DispositivoDiGioco", Long.class).getSingleResult();
			
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
	public List<DispositivoDiGioco> getLista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<DispositivoDiGioco> res = null;
		try {
			transaction = session.beginTransaction();
			
			res = session.createQuery("from DispositivoDiGioco", DispositivoDiGioco.class).list();
			
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
	public boolean creaDispositivo(DispositivoDiGioco d) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.persist(d);
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
	public boolean aggiornaDispositivo(DispositivoDiGioco d) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.merge(d);
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
	public boolean eliminaDispositivo(Integer d) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.remove(getDispositivo(d));
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
	public List<DispositivoDiGioco> getListaNotTaken(DispositivoDiGioco d) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = null;
	    List<DispositivoDiGioco> res = new ArrayList<>();
	    try {
	        transaction = session.beginTransaction();
	        
	        if (d != null) {
	            res.add(d);
	        }
	        
	        List<DispositivoDiGioco> notTakenDevices = session.createQuery("from DispositivoDiGioco where postazione is null", DispositivoDiGioco.class).list();
	        res.addAll(notTakenDevices);
	        
	        transaction.commit();
	    } catch (HibernateException e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return res;
	}
}
