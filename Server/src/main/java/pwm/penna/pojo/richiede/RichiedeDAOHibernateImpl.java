package pwm.penna.pojo.richiede;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pwm.penna.pojo.salagiochi.SalaGiochi;
import pwm.penna.utils.HibernateUtil;

@SuppressWarnings("deprecation")
public class RichiedeDAOHibernateImpl implements RichiedeDAO {
	protected RichiedeDAOHibernateImpl() {}

	@Override
	public Richiede getRichiesta(Integer r) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {			
			return (Richiede) session.get(Richiede.class, r);
		} catch (HibernateException e) {
		} finally {
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public List<Richiede> getLista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Richiede> res = null;
		try {
			transaction = session.beginTransaction();
			
			res = session.createQuery("from Richiede", Richiede.class).list();
			
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
	public List<Richiede> getListaNonAssegnatePerSala(SalaGiochi s) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = null;
	    List<Richiede> res = null;
	    try {
	        transaction = session.beginTransaction();
	        
	        res = session.createQuery("from Richiede where prenotazione not in (select prenotazione from Assegna) AND postazione.salaGiochi = :salaGiochi", Richiede.class)
	                     .setParameter("salaGiochi", s)
	                     .list();
	        
	        transaction.commit();
	    } catch (HibernateException e) {
	    	transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        if (session != null)
	            session.close();
	    }
	    return res;
	}

	@Override
	public List<Richiede> getListaNonAssegnate() {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = null;
	    List<Richiede> res = null;
	    try {
	        transaction = session.beginTransaction();
	        
	        res = session.createQuery("from Richiede where prenotazione not in (select prenotazione from Assegna)", Richiede.class).list();
	        
	        transaction.commit();
	    } catch (HibernateException e) {
	    	transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        if (session != null)
	            session.close();
	    }
	    return res;
	}


	@Override
	public long countRichiestePerConsole(Class<?> console) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = null;
	    long count = 0;

	    try {
	        transaction = session.beginTransaction();
	        //https://stackoverflow.com/questions/8911894/hql-query-for-multiple-types-classes/8912227#8912227 seleziona per discriminator
	        count = session.createQuery("select count(*) from Richiede where postazione.dispositivoDiGioco.class = :console", Long.class)
							.setParameter("console", console)
							.uniqueResult();

	        transaction.commit();
	    } catch (HibernateException e) {
            transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        if (session != null)
	            session.close();
	    }

	    return count;
	}


	@Override
	public boolean aggiornaRichiesta(Richiede r) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.update(r);
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
	public boolean creaRichiesta(Richiede r) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.persist(r);
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
	public boolean eliminaRichiesta(Integer r) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.remove(getRichiesta(r));
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
