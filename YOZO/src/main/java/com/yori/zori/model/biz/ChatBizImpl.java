package com.yori.zori.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yori.zori.model.dao.ChatDao;
import com.yori.zori.model.dto.ChatDto;

@Service
public class ChatBizImpl implements ChatBiz{

	@Autowired 
	ChatDao dao;
	
	@Override
	public int insert(ChatDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

}
