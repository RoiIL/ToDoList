package il.ac.hit.todolist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
	 * the user's private name
	 */
	private String privateName;
	
	/**
	 * the user's family name
	 */
	private String familyName;
	
	/**
	 * the user's password
	 */
	private String password;
	
	public User()
	{
	}
	
	public User(long userId, String userName, String privateName, String familyName, String password)
	{
		this.userId = userId;
		this.userName = userName;
		this.privateName = privateName;
		this.familyName = familyName;
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
	 * @return the privateName
	 */
	public String getPrivateName() {
		return privateName;
	}

	/**
	 * @param privateName the privateName to set
	 */
	public void setPrivateName(String privateName) {
		this.privateName = privateName;
	}

	/**
	 * @return the familyName
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * @param familyName the familyName to set
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
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
