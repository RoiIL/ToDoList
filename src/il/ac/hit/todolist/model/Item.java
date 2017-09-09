package il.ac.hit.todolist.model;

import java.util.Date;

/**
 * @author Roi Israel & Vladimir Shalmai
 * Item class indicates the Item object for the ToDoList app. 
 */
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
		setItemId(itemId);
		setUserId(userId);
		setDate(new Date());
		setContent(content);
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * hashCode function to override the Java function.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (int) (itemId ^ (itemId >>> 32));
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * equals function to override the Java function.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Item)) {
			return false;
		}
		Item other = (Item) obj;
		if (content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!content.equals(other.content)) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (itemId != other.itemId) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * toString function to override the Java function.
	 */
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", userId=" + userId + ", date=" + date + ", content=" + content + "]";
	}
}
