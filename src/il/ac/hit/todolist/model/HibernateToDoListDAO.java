package il.ac.hit.todolist.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author Vladimir Shalmai & Roi Israel
 */

public class HibernateToDoListDAO implements IToDoListDAO
{
	
	/**
	 * the singleton instance of this class 
	 */
	public static HibernateToDoListDAO instance = new HibernateToDoListDAO();
	SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
	
	/**
	 * private default constructor to prevent instances of this class
	 */
	private HibernateToDoListDAO()
	{
	}
	
	/**
	 * the interface for using the HibernateToDoListDAO class
	 * @return the class instance
	 */
	public static HibernateToDoListDAO getInstance()
	{
		return instance;
	}
	
	/* (non-Javadoc)
	 * @see il.ac.hit.todolist.model.IToDoListDAO#addUser(il.ac.hit.todolist.model.User)
	 */
	@Override
	public boolean addUser(User newUser) throws ToDoListException {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		
		if (!isUserExist(newUser))
		{
			try
			{
				session = factory.openSession();
				transaction = session.beginTransaction();
				session.save(newUser);
				transaction.commit();
				result = true;
			}
			catch(HibernateException exception)
			{
				rollbackTrasaction(transaction);
				throw new ToDoListException(exception.getMessage(), exception.getCause());
			} 
			finally
			{
				closeSession(session);
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see il.ac.hit.todolist.model.IToDoListDAO#updateUser(il.ac.hit.todolist.model.User)
	 */
	@Override
	public boolean updateUser(User user) throws ToDoListException {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		
		if (isUserExist(user))
		{
			try
			{
				session = factory.openSession();
				transaction = session.beginTransaction();
				session.update(user);
				transaction.commit();
				result = true;
			}
			catch(HibernateException exception)
			{
				rollbackTrasaction(transaction);
				throw new ToDoListException(exception.getMessage(), exception.getCause());
			} 
			finally
			{
				closeSession(session);
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see il.ac.hit.todolist.model.IToDoListDAO#deleteUser(il.ac.hit.todolist.model.User)
	 */
	@Override
	public boolean deleteUser(User user) throws ToDoListException {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		
		{
			if (isUserExist(user))
			try 
			{
				session = factory.openSession();
				transaction = session.beginTransaction();
				
				List<Item> listOfItems = getUserItems(user.getUserId());
				for (Item item : listOfItems) {
					session.delete(item);
				}
				session.delete(user);		
				transaction.commit();
		
				result = true;
			}
			catch(HibernateException exception)
			{
				rollbackTrasaction(transaction);
				throw new ToDoListException(exception.getMessage(), exception.getCause());
			} 
			finally
			{
				closeSession(session);
			}			
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see il.ac.hit.todolist.model.IToDoListDAO#isUserExist(il.ac.hit.todolist.model.User)
	 */
	@Override
	public boolean isUserExist(User user) throws ToDoListException {
		boolean exist = false;
		Session session = null;
		try
		{
			session = factory.openSession();
			Object object = session.get(user.getClass(), user.getUserId());
			exist = object != null;
		}
		catch(HibernateException exception)
		{
			throw new ToDoListException(exception.getMessage(), exception.getCause());
		} 
		finally
		{
			closeSession(session);
		}
		
		return exist;
	}
	
	/* (non-Javadoc)
	 * @see il.ac.hit.todolist.model.IToDoListDAO#getUserById(long)
	 */
	@Override
	public User getUserById(long userId) throws ToDoListException {
		Session session = null;
		User user = null;
		
		try
		{
			session = factory.openSession();
			user = (User)session.get(User.class, userId);
		}
		catch(HibernateException exception)
		{
			throw new ToDoListException(exception.getMessage(), exception.getCause());
		} 
		finally
		{
			closeSession(session);
		}
		
		return user;
	}
	
	/* (non-Javadoc)
	 * @see il.ac.hit.todolist.model.IToDoListDAO#getUserItems(long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getUserItems(long userId) throws ToDoListException {
		Session session = null;
		Transaction transaction = null;
		List<Item> listOfItems = new ArrayList<Item>();

		if (null != getUserById(userId))
		{
			try
			{
				session = factory.openSession();
				transaction = session.beginTransaction();
				Query query = session.createQuery("FROM Item WHERE User_Id = :userId");
				query.setParameter("userId", userId);
				listOfItems = query.list();
			} 
			catch(HibernateException exception)
			{
				rollbackTrasaction(transaction);
				throw new ToDoListException(exception.getMessage(), exception.getCause());
			} 
			finally
			{
				closeSession(session);
			}		
		}
		return listOfItems;
	}
	
	/* (non-Javadoc)
	 * @see il.ac.hit.todolist.model.IToDoListDAO#addItem(il.ac.hit.todolist.model.Item)
	 */
	@Override
	public boolean addItem(Item newItem) throws ToDoListException {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		
		if (!isItemExist(newItem) && (null != getUserById(newItem.getUserId())))
		{
			try
			{
				session = factory.openSession();
				transaction = session.beginTransaction();
				session.save(newItem);
				transaction.commit();
				result = true;
			}
			catch(HibernateException exception)
			{
				rollbackTrasaction(transaction);
				throw new ToDoListException(exception.getMessage(), exception.getCause());
			} 
			finally
			{
				closeSession(session);
			}
		}
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see il.ac.hit.todolist.model.IToDoListDAO#getAuthenticatedUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User getAuthenticatedUser(String userName, String password) throws ToDoListException {
		User user = null;
		Session session = null;
		
		try
		{
			session = factory.openSession();
			Query query = session.createQuery("FROM User WHERE userName = :userName AND password = :password");
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			user = (User)query.uniqueResult();
		}
		catch(HibernateException exception)
		{
			throw new ToDoListException(exception.getMessage(), exception.getCause());
		} 
		finally
		{
			closeSession(session);
		}
		
		return user;
	}

	/* (non-Javadoc)
	 * @see il.ac.hit.todolist.model.IToDoListDAO#updateItem(il.ac.hit.todolist.model.Item)
	 */
	@Override
	public boolean updateItem(Item item) throws ToDoListException {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		
		if (isItemExist(item))
		{
			try
			{
				session = factory.openSession();
				transaction = session.beginTransaction();
				session.update(item);
				transaction.commit();
				result = true;
			}
			catch(HibernateException exception)
			{
				rollbackTrasaction(transaction);
				throw new ToDoListException(exception.getMessage(), exception.getCause());
			} 
			finally
			{
				closeSession(session);
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see il.ac.hit.todolist.model.IToDoListDAO#deleteItem(il.ac.hit.todolist.model.Item)
	 */
	@Override
	public boolean deleteItem(Item item) throws ToDoListException {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		
		if (isItemExist(item))
		{
			try
			{
				session = factory.openSession();
				transaction = session.beginTransaction();
				session.delete(item);
				transaction.commit();			
				result = true;
			}
			catch(HibernateException exception)
			{
				rollbackTrasaction(transaction);
				throw new ToDoListException(exception.getMessage(), exception.getCause());
			} 
			finally
			{
				closeSession(session);
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see il.ac.hit.todolist.model.IToDoListDAO#isItemExist(il.ac.hit.todolist.model.Item)
	 */
	@Override
	public boolean isItemExist(Item item) throws ToDoListException {
		boolean exist = false;
		Session session = null;
		Object object = null;
		
		try
		{
			session = factory.openSession();
			object = session.get(item.getClass(), item.getItemId());
			exist = object != null;
		}
		catch(HibernateException exception)
		{
			throw new ToDoListException(exception.getMessage(), exception.getCause());
		} 
		finally
		{
			closeSession(session);
		}
		
		return exist;
	}
	
	/**
	 * closing the given session
	 * @param session
	 * @throws ToDoListException
	 */
	private void closeSession(Session session) throws ToDoListException
	{
		if (null != session)
		{
			try
			{
				session.close();
			}
			catch (HibernateException exception)
			{
				throw new ToDoListException(exception.getMessage(), exception.getCause());
			}
		}
	}
	
	/**
	 * roll back the transaction if any Hibernate exception was thrown 
	 * @param transaction
	 */
	private void rollbackTrasaction(Transaction transaction)
	{
		if (null != transaction)
		{
			transaction.rollback();
		}
	}
}
