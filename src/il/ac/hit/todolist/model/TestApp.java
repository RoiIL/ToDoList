package il.ac.hit.todolist.model;

import java.util.Date;

import il.ac.hit.todolist.model.HibernateToDoListDAO;
import il.ac.hit.todolist.model.User;
import il.ac.hit.todolist.model.Item;

public class TestApp {

	public static void main(String[] args) {
		User user1 = new User(233, "roiial", "Roi", "Israel", "222");
		HibernateToDoListDAO hibernate = HibernateToDoListDAO.getInstance();
		
		System.out.println(hibernate.isUserExist(user1));
		hibernate.addUser(user1);
		System.out.println(hibernate.isUserExist(user1));
		
		Item item1 = new Item(1, 1, new Date(12, 12, 12), "Hello EveryOne");
		hibernate.addItem(item1);
		item1.setContent("Hello everyone :)");
		hibernate.updateItem(item1);

	}

}
