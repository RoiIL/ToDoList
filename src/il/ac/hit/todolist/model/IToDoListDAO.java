package il.ac.hit.todolist.model;

import java.util.List;

public interface IToDoListDAO 
{
	/**
	 *User API functions
	 */
	
	/**
	 * @param newUser
	 * @return if user was added successfully
	 * @throws ToDoListException
	 */
	public boolean addUser(User newUser) throws ToDoListException;
	
	/**
	 * @param user
	 * @return if user's data was updated successfully
	 * @throws ToDoListException
	 */
	public boolean updateUser(User user) throws ToDoListException;
	
	/**
	 * @param user
	 * @return if user was deleted successfully
	 * @throws ToDoListException
	 */
	public boolean deleteUser(User user) throws ToDoListException;
	
	/**
	 * @param user
	 * @return if user exist in the date base
	 * @throws ToDoListException
	 */
	public boolean isUserExist(User user) throws ToDoListException;
	
	/**
	 * Authenticate user by user name and password.
	 * @param userName
	 * @param password
	 * @return Authenticated user, null otherwise
	 * @throws ToDoListException 
	 */
	public User getAuthenticatedUser(String userName, String password) throws ToDoListException;
	
	/**
	 * @param userId
	 * @return user by it's id parameter, if exist
	 * @throws ToDoListException
	 */
	public User getUserById(long userId) throws ToDoListException;
	
	/**
	 * @param userId
	 * @return all user items
	 * @throws ToDoListException
	 */
	public List<Item> getUserItems(long userId) throws ToDoListException;
	
	//////////////////////////////////////////////////////////////////
	
	/**
	 * Item API functions
	 */
	
	/**
	 * @param newItem
	 * @return if item was added successfully
	 * @throws ToDoListException
	 */
	public boolean addItem(Item newItem) throws ToDoListException;
	
	/**
	 * @param item
	 * @return if item's data was updated successfully
	 * @throws ToDoListException
	 */
	public boolean updateItem(Item item) throws ToDoListException;
	
	/**
	 * @param item
	 * @return if user was deleted successfully 
	 * @throws ToDoListException
	 */
	public boolean deleteItem(Item item) throws ToDoListException;
	
	/**
	 * @param item
	 * @return if user exist in the data base
	 * @throws ToDoListException
	 */
	public boolean isItemExist(Item item) throws ToDoListException;
}
