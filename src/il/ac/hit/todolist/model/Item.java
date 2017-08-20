package il.ac.hit.todolist.model;

import java.util.Date;

public class Item 
{
	private long userId;
	private long itemId;
	private Date date;
	private String content;
	
	/**
	 * Default Constructor
	 */
	public Item()
	{
	}
	
	/**
	 * @param userId
	 * @param itemId
	 * @param date
	 * @param content
	 */
	public Item(long userId, long itemId, Date date, String content) {
		super();
		this.userId = userId;
		this.itemId = itemId;
		this.date = date;
		this.content = content;
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
	 * @return the itemId
	 */
	public long getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
