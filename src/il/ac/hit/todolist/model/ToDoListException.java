package il.ac.hit.todolist.model;

public class ToDoListException extends Exception 
{
	/**
	 * Default serial id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ToDoListException - constructor excepting message only
	 * @param message
	 */
	public ToDoListException(String message) {
		super("ToDoList Exception: " + message);
	}

	/**
	 * ToDoListException - an exception wrapper for the Hibernate framework 
	 * @param message
	 * @param cause
	 */
	public ToDoListException(String message, Throwable cause)
	{		
		super("ToDoList Exception: " + message, cause);
	}
}
