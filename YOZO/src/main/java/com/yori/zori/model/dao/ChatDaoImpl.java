package com.yori.zori.model.dao;




import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yori.zori.model.dto.ChatDto;




@Repository
public class ChatDaoImpl implements ChatDao{
	@Autowired
	SqlSessionTemplate session;

	@Override
	public int insert(ChatDto dto) {
		// TODO Auto-generated method stub
		int res = 0;
		try {
			res = session.insert(namespace+"insert",dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

 

}