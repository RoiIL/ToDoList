package il.ac.hit.todolist.model;

import il.ac.hit.todolist.model.HibernateToDoListDAO;
import il.ac.hit.todolist.model.User;

public class TestApp {

	public static void main(String[] args) {
		User user1 = new User(233, "roiial", "Roii", "Israel", "222");
		HibernateToDoListDAO hibernate = HibernateToDoListDAO.getInstance();
		
		System.out.println(hibernate.isUserExist(user1));
		hibernate.addUser(user1);
		System.out.println(hibernate.isUserExist(user1));
		

	}

}
