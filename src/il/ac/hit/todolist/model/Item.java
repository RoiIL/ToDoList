package il.ac.hit.todolist.model;

import java.util.Date;

public class Item 
{
	
	/**
	 * the item id, also the key for the data base
	 */
	private long itemId;
	
	/**
	 * the user id this item belongs to. act also as the connection to the user in the data base
	 */
	private long userId;
	
	/**
	 * the date this item was created
	 */
	private Date date;
	
	/**
	 * the item's content
	 */
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
	 * @param content
	 */
	public Item(long itemId, long userId, String content) {
		super();
		this.itemId = itemId;
		this.userId = userId;
		this.date = new Date();
		this.content = content;
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
