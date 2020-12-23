package com.yori.zori.mail;

import javax.activation.DataSource;

import com.yori.zori.model.dto.MemberDto;

public interface MailService {

		public void regist(MemberDto member);
	   
	 
	    public MemberDto userAuth(String authkey);

}


