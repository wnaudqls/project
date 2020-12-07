package com.yori.zori.model.dao;



import com.yori.zori.model.dto.ChatDto;


public interface ChatDao {

	String namespace = "chat.";
   public int insert(ChatDto dto);
}