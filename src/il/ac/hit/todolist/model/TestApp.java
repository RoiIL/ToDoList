package il.ac.hit.todolist.model;

import java.util.Date;
import java.util.List;

import il.ac.hit.todolist.model.HibernateToDoListDAO;
import il.ac.hit.todolist.model.User;
import il.ac.hit.todolist.model.Item;

public class TestApp {

	public static void main(String[] args) throws ToDoListException {
		User user1 = new User(1, "roiial", "Roi", "Israel", "222");
		HibernateToDoListDAO hibernate = HibernateToDoListDAO.getInstance();
		
		System.out.println(hibernate.isUserExist(user1));
		hibernate.addUser(user1);
		System.out.println(hibernate.isUserExist(user1));
		
		Item item1 = new Item(1, 1, new Date(12, 12, 12), "Hello EveryOne");
		hibernate.addItem(item1);
		item1.setContent("Hello everyone :)");
		hibernate.updateItem(item1);

		Item item2 = new Item(2, 1, new Date(12, 12, 12), "Second");
		Item item3 = new Item(3, 1, new Date(13, 12, 12), "Third");
		Item item4 = new Item(4, 1, new Date(14, 12, 12), "Forth");
		
		hibernate.addItem(item2);
		hibernate.addItem(item3);
		hibernate.addItem(item4);
		
		List<Item> user1Items = hibernate.getUserItems(user1.getUserId());
		for (Item item : user1Items) 
		{
			System.out.println(item.getContent());
		}
		
		User authenticateUser = hibernate.getAuthenticatedUser("roiial", "111");
		if (null == authenticateUser)
		{
			System.out.println("First try to authentication failed succesfully");
		}
		authenticateUser = hibernate.getAuthenticatedUser("roiial", "222");
		if (null != authenticateUser)
		{
			System.out.println("Second authentication succeded for " + authenticateUser.getPrivateName());
		}
		
		//hibernate.deleteUser(user1);
	}

}
