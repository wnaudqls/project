package com.yori.zori.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yori.zori.model.dto.BroadcastDto;

@Repository
public class BroadcastDaoImpl implements BroadcastDao{

	@Autowired
	SqlSessionTemplate session;
	public List<BroadcastDto> selectList() {
	
		List<BroadcastDto> list = null;
		try {
			list = session.selectList(namespace + "selectlist");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return list;

	}

	public BroadcastDto selectone(String broadcast_title) {
		BroadcastDto dto = new BroadcastDto();
		try {
			dto = session.selectOne(namespace + "selectone", broadcast_title);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}

	public int insert(BroadcastDto dto) {
		int res = 0;
		try {
			res = session.insert(namespace + "insert", dto);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	public int update(BroadcastDto dto) {
		int res = 0;
		try {
			res = session.update(namespace + "update", dto);
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return res;
	}

	public int delete(BroadcastDto dto) {
	
		int res = 0;
		try {
			res = session.delete(namespace + "delete", dto);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}

	@Override
	public int updateCurrentClient(BroadcastDto dto) {
		// TODO Auto-generated method stub
		int res = 0;
		try {
			res = session.update(namespace + "updateclient", dto);
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return res;
	}

	@Override
	public List<BroadcastDto> search(BroadcastDto dto) {
		// TODO Auto-generated method stub
		List<BroadcastDto> list = new ArrayList<BroadcastDto>();
		try {
			list = session.selectList(namespace+"search",dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	/*
	public int multidelete(String[] seq) {

	}

	public List<BroadcastDto> getViewList(String id, String yM) {

	}

	public int getViewCount(String id, String ymd) {

	}*/
}
