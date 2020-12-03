package com.yori.zori.model.dto;

import java.sql.Date;

public class BroadcastDto {

	private int broadcast_no;
	private int broadcast_maxclient;
	private int broadcast_currentclient;
	private String member_nick;
	private String member_id;
	private String broadcast_title;
	private String broadcast_password;
	private String search;
	private Date broadcast_date;
	
	
	 

	
	public BroadcastDto() {
		
		
	}
	public BroadcastDto(int broadcast_no, String member_id, String broadcast_title, String broadcast_password,
			int broadcast_maxclient, int broadcast_currentclient, Date broadcast_date, String search, String member_nick) {
		
		this.member_nick = member_nick;
		this.broadcast_no = broadcast_no;
		this.member_id = member_id;
		this.broadcast_title = broadcast_title;
		this.broadcast_password = broadcast_password;
		this.broadcast_maxclient = broadcast_maxclient;
		this.broadcast_currentclient = broadcast_currentclient;
		this.broadcast_date = broadcast_date;
		this.search = search;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	public String getSearch() {
		return search;
	}
	
	public void setSearch(String search) {
		this.search = search;
	}
	
	public int getBroadcast_no() {
		return broadcast_no;
	}
	public void setBroadcast_no(int broadcast_no) {
		this.broadcast_no = broadcast_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getBroadcast_title() {
		return broadcast_title;
	}
	public void setBroadcast_title(String broadcast_title) {
		this.broadcast_title = broadcast_title;
	}
	public String getBroadcast_password() {
		return broadcast_password;
	}
	public void setBroadcast_password(String broadcast_password) {
		this.broadcast_password = broadcast_password;
	}
	public int getBroadcast_maxclient() {
		return broadcast_maxclient;
	}
	public void setBroadcast_maxclient(int broadcast_maxclient) {
		this.broadcast_maxclient = broadcast_maxclient;
	}
	public int getBroadcast_currentclient() {
		return broadcast_currentclient;
	}
	public void setBroadcast_currentclient(int broadcast_currentclient) {
		this.broadcast_currentclient = broadcast_currentclient;
	}
	public Date getBroadcast_date() {
		return broadcast_date;
	}
	public void setBroadcast_date(Date broadcast_date) {
		this.broadcast_date = broadcast_date;
	}


}
