package il.ac.hit.todolist.model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateToDoListDAO implements IToDoListDAO
{
	public static void main(String[] args) 
	{
		//creating factory for getting sessions
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		//creating a new session for adding products
		Session session = factory.openSession();
		session.beginTransaction();
		User user = new User(233, "roiial", "roi", "israel", "123");
		Date date = new Date(20, 8, 17);
		Item item = new Item(20, 233, date, "Hello everyone, how you doing?");
		session.save(user);
		session.save(item);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public boolean addUser(User newUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		return false;
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
