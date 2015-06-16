package java8demo.dao;

import org.bson.Document;

public class StreamsElement extends Document{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 13874285624583L;
	private String id;
	private int i;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
	
}
