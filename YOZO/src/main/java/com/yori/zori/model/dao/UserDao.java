package com.yori.zori.model.dao;


import com.yori.zori.model.dto.MemberDto;

public interface UserDao {

	String namespace = "member";

	public MemberDto login(MemberDto dto);

	public MemberDto idCheck(MemberDto dto);

	public MemberDto nickCheck(MemberDto dto);

	public boolean insert(MemberDto dto);

	public boolean update(MemberDto dto);

	public boolean delete(MemberDto dto);

	public MemberDto findId(MemberDto dto);

	public MemberDto findPw(MemberDto dto);

}
