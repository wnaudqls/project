package com.yori.zori.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yori.zori.model.dto.BroadcastDto;

public interface BroadcastDao{
	String namespace = "Broadcast.";
	public List<BroadcastDto> selectList();


	public BroadcastDto selectone(BroadcastDto dto);
	public int insert(BroadcastDto dto);

	public int update(BroadcastDto dto);

	public int delete(BroadcastDto dto);
	
	/*
	public int multidelete(String[] seq) {

	}

	public List<BroadcastDto> getViewList(String id, String yM) {

	}

	public int getViewCount(String id, String ymd) {

	}*/
}
