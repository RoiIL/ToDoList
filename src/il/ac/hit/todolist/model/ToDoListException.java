package il.ac.hit.todolist.model;

public class ToDoListException extends Exception 
{
	/**
	 * Default serial id.
	 */
	private static final long serialVersionUID = 1L;
	
	public ToDoListException(String message, Throwable cause)
	{
		
		super("ToDoList Exception: " + message, cause);
	}
}
