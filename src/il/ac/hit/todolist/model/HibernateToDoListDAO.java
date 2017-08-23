package il.ac.hit.todolist.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateToDoListDAO implements IToDoListDAO
{
	public static HibernateToDoListDAO instance = new HibernateToDoListDAO();
	SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
	
	private HibernateToDoListDAO()
	{
	}
	
	public static HibernateToDoListDAO getInstance()
	{
		return instance;
	}
	
	@Override
	public boolean addUser(User newUser) {
		boolean result = false;
		if (!isUserExist(newUser))
		{
			Session session = factory.openSession();
			session.beginTransaction();
			session.save(newUser);
			session.getTransaction().commit();
			session.close();
			result = true;
		}
		return result;
	}

	@Override
	public boolean updateUser(User user) {
		boolean result = false;
		if (!isUserExist(user))
		{
			Session session = factory.openSession();
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
			session.close();
			result = true;
		}
		return result;
	}

	@Override
	public boolean deleteUser(User user) {
		boolean result = false;
		if (!isUserExist(user))
		{
			Session session = factory.openSession();
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
			session.close();
			result = true;
		}
		return result;
	}

	@Override
	public boolean isUserExist(User user) {
		Session session = factory.openSession();
		Object object = session.get(user.getClass(), user.getUserId());
		session.close();
		return object != null;
	}
	
	@Override
	public boolean addItem(Item newItem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}
}
