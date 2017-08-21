package il.ac.hit.todolist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

public class User 
{
	private long userId;
	private String userName;
	private String privateName;
	private String familyName;
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