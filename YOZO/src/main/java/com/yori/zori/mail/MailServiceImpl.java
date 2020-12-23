package com.yori.zori.mail;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.yori.zori.model.biz.UserBiz;
import com.yori.zori.model.dto.MemberDto;

@Service
public class MailServiceImpl implements MailService{

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private UserBiz biz;
		@Override
		public void regist(MemberDto member) {
			
		}
		
	    //이메일 인증 키 검증
		@Override
	    public MemberDto userAuth(String authkey) {
			MemberDto dto = new MemberDto();
			return dto;
		}

}


