package pwm.penna.pojo.cliente;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pwm.penna.utils.HibernateUtil;

public class ClienteDAOHibernateImpl implements ClienteDAO {
	protected ClienteDAOHibernateImpl() {}

	@Override
	public Cliente getCliente(int c) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {			
			return (Cliente) session.get(Cliente.class, c);
		} catch (HibernateException e) {
		} finally {
			if (session != null)
				session.close();
		}
		return null;
	}

	@Override
	public List<Cliente> getLista() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Cliente> res = null;
		try {
			transaction = session.beginTransaction();
			res = session.createQuery("from Cliente", Cliente.class).list();
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
	public List<Integer> getListaNotSoci() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Integer> res = null;
		try {
			transaction = session.beginTransaction();
			res = session.createQuery("select numeroCliente from Cliente where numeroCliente NOT IN (select numeroCliente from Socio)", Integer.class).list();
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
	public Cliente creaCliente() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Cliente cliente = new Cliente();
		try {
			transaction = session.beginTransaction();
			session.persist(cliente);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return cliente;
	}
	
	@Override 
	public void loadRichieste(Cliente c) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {			
			transaction = session.beginTransaction();
			session.refresh(c); //il refresh è necessario se non voglio "ricaricare a mano" il cliente
			Hibernate.initialize(c.getRichieste());
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}
}
