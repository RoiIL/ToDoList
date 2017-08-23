package il.ac.hit.todolist.model;

public interface IToDoListDAO 
{
	/**
	 *User API functions
	 */
	public boolean addUser(User newUser);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);
	
	public boolean isUserExist(User user);
	
	//////////////////////////////////////////////////////////////////
	
	/**
	 * Item API functions
	 */
	public boolean addItem(Item newItem);
	
	public boolean updateItem(Item item);
	
	public boolean deleteItem(Item item);
}
