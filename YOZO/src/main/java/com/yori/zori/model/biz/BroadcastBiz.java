package com.yori.zori.model.biz;

import java.util.List;

import com.yori.zori.model.dto.BroadcastDto;

public interface BroadcastBiz {
	public List<BroadcastDto> selectList();


	public BroadcastDto selectone(String broadcast_title);
	public int insert(BroadcastDto dto);

	public int update(BroadcastDto dto);

	public int delete(BroadcastDto dto);

}
