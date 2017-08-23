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
		if (isUserExist(user))
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
		if (isUserExist(user))
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
	public User getUserById(long userId) {
		Session session = factory.openSession();
		User user = (User) session.get(User.class, userId);
		session.close();
		
		return user;
	}
	
	@Override
	public boolean addItem(Item newItem) {
		boolean result = false;
		if (!isItemExist(newItem) && (null != getUserById(newItem.getUserId())))
		{
			Session session = factory.openSession();
			session.beginTransaction();
			session.save(newItem);
			session.getTransaction().commit();
			session.close();
			result = true;
		}
		return result;
	}

	@Override
	public boolean updateItem(Item item) {
		boolean result = false;
		if (isItemExist(item))
		{
			Session session = factory.openSession();
			session.beginTransaction();
			session.update(item);
			session.getTransaction().commit();
			session.close();
			result = true;
		}
		return result;
	}

	@Override
	public boolean deleteItem(Item item) {
		boolean result = false;
		if (isItemExist(item))
		{
			Session session = factory.openSession();
			session.beginTransaction();
			session.delete(item);
			session.getTransaction().commit();
			session.close();
			result = true;
		}
		return result;
	}

	@Override
	public boolean isItemExist(Item item) {
		Session session = factory.openSession();
		Object object = session.get(item.getClass(), item.getUserId());
		session.close();
		return object != null;
	}
}
