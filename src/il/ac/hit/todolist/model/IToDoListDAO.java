package il.ac.hit.todolist.model;

import java.util.List;

public interface IToDoListDAO 
{
	/**
	 *User API functions
	 */
	public boolean addUser(User newUser) throws ToDoListException;;
	
	public boolean updateUser(User user) throws ToDoListException;
	
	public boolean deleteUser(User user) throws ToDoListException;
	
	public boolean isUserExist(User user) throws ToDoListException;
	
	public User getUserById(long userId) throws ToDoListException;
	
	public List<Item> getUserItems(long userId) throws ToDoListException;
	
	//////////////////////////////////////////////////////////////////
	
	/**
	 * Item API functions
	 */
	public boolean addItem(Item newItem) throws ToDoListException;
	
	public boolean updateItem(Item item) throws ToDoListException;
	
	public boolean deleteItem(Item item) throws ToDoListException;
	
	public boolean isItemExist(Item item) throws ToDoListException;
}
