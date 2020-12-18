package com.yori.zori.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yori.zori.model.dto.BroadcastDto;
import com.yori.zori.model.dto.BroadcastDto_Reservation;
import com.yori.zori.model.dao.BroadcastDao;
import com.yori.zori.model.dao.BroadcastDao_Reservation;
import com.yori.zori.model.dao.BroadcastDao_ReservationImpl;

@Service
public class BroadcastBizImpl implements BroadcastBiz{
	
	@Autowired
	private BroadcastDao Broadcastdao;
	
	@Autowired
	private BroadcastDao_Reservation dao_Reservation;
	@Override
	public List<BroadcastDto> selectList() {
		return Broadcastdao.selectList();

	}
	@Override
	public BroadcastDto selectone(String broadcast_title) {

		return Broadcastdao.selectone(broadcast_title);
	}
	@Override
	public int insert(BroadcastDto dto) {
	
		return Broadcastdao.insert(dto);
	}
	@Override
	public int update(BroadcastDto dto) {
	
		return Broadcastdao.update(dto);
	}
	@Override
	public int delete(BroadcastDto seq) {
	
		return Broadcastdao.delete(seq);
	}
	public List<BroadcastDto_Reservation> checklist(String id){
		return dao_Reservation.checklist(id);
	}
	@Override
	public int updateCurrentClient(BroadcastDto dto) {
		// TODO Auto-generated method stub
		return Broadcastdao.updateCurrentClient(dto);
	}
	@Override
	public List<BroadcastDto> search(BroadcastDto dto) {
		// TODO Auto-generated method stub
		return Broadcastdao.search(dto);
	}
}
