package com.chadgill.entity;



public class Message {

	private MessageType type;
	private String sender;
	private String content;
	
	
	
	/**default message constructor
	 * 
	 */
	public Message() {
		
	}
	
	public enum MessageType{
		CHAT,
		JOIN,
		LEAVE
	}
	
	  public MessageType getType() {
	        return type;
	    }
	  public void setType(MessageType type) {
	        this.type = type;
	    }
	  
	
	/** gets the name of sender
	 * @return this is the sender
	 */
	public String getSender() {
		return sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	/**gets the content
	 * @return this is the content
	 */
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Message [sender=" + sender + ", content=" + content + "]";
	}
	
	
}
