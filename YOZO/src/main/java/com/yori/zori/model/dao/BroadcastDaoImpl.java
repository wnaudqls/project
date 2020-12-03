package com.yori.zori.model.dao;

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

	public BroadcastDto selectone(BroadcastDto dto) {
		try {
			dto = session.selectOne(namespace + "selectOne", dto);
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
		} finally {
			
		}
		return res;
	}

	public int update(BroadcastDto dto) {
		int res = 0;
		try {
			res = session.insert(namespace + "update", dto);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return res;
	}

	public int delete(BroadcastDto dto) {
	
		int res = 0;
		try {
			res = session.insert(namespace + "delete", dto);
			if (res > 0) {
				session.commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	
	/*
	public int multidelete(String[] seq) {

	}

	public List<BroadcastDto> getViewList(String id, String yM) {

	}

	public int getViewCount(String id, String ymd) {

	}*/
}
