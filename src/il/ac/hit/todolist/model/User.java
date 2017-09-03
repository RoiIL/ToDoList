package il.ac.hit.todolist.model;

/**
 * @author IR
 *
 */
/**
 * @author IR
 *
 */
/**
 * @author IR
 *
 */
public class User 
{
	/**
	 * the user id, act as the key for the data base
	 */
	private long userId;
	
	/**
	 * the user's user name
	 */
	private String userName;
	
	/**
	 * the user's first name
	 */
	private String firstName;
	
	/**
	 * the user's last name
	 */
	private String lastName;
	
	/**
	 * the user's password
	 */
	private String password;
	
	/**
	 * Default constructor
	 */
	public User()
	{
	}
	
	/**
	 * @param userId
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param password
	 */
	public User(long userId, String userName, String firstName, String lastName, String password)
	{
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String privateName) {
		this.firstName = privateName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String familyName) {
		this.lastName = familyName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
