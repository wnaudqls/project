package com.yori.zori.model.dto;

import java.sql.Date;

public class ChatDto {
	public enum MessageType{
		ENTER,LEAVE,CHAT
	}
	
	int broadcast_no;
	String chat_title;
	String user_id;
	String chat_content;
	MessageType type;
	Date regdate;
	public ChatDto() {

	}
	public ChatDto(int broadcast_no, String chat_title, String user_id, String chat_content, MessageType type, Date regdate) {
		this.broadcast_no = broadcast_no;
		this.chat_title = chat_title;
		this.user_id = user_id;
		this.chat_content = chat_content;
		this.type = type;
		this.regdate = regdate;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getBroadcast_no() {
		return broadcast_no;
	}
	public void setBroadcast_no(int broadcast_no) {
		this.broadcast_no = broadcast_no;
	}
	public String getChat_title() {
		return chat_title;
	}
	public void setChat_title(String chat_title) {
		this.chat_title = chat_title;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getChat_content() {
		return chat_content;
	}
	public void setChat_content(String chat_content) {
		this.chat_content = chat_content;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	
	
	
	
	
}
