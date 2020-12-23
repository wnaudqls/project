package com.yori.zori.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yori.zori.model.biz.UserBiz;
import com.yori.zori.model.dto.MemberDto;
import com.yori.zori.model.dto.UserDto;

@Controller
@RequestMapping(value="/check")
public class SignupController {
	@Autowired
	UserBiz biz;
	Logger logger = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
	JavaMailSender mailSender;
	
	@RequestMapping("/idcheck")
	public String idcheck(@RequestParam("id") String id, MemberDto dto,Model model) {
		logger.info("id:{} ",id);
		dto.setMember_id(id);
		MemberDto idcheck = biz.idCheck(dto);
		boolean check;
		if(idcheck != null) {
			check = false;
		}else {
			check = true;
			
		}
		model.addAttribute("check", check);
		return "idcheck";
	}
	@RequestMapping("/nickcheck")
	public String nickcheck(@RequestParam("nick") String nick, MemberDto dto, Model model) {
		logger.info("nick:{} ",nick);//닉네임 확인
		dto.setMember_nick(nick);//memberdto에서 member_nick 값을 설정
		
		//닉네임 확인하기 위한 단계
		MemberDto nickcheck = biz.nickCheck(dto);//member_nick의 값을 가진 닉네임이 있는지 db에서 값을 불러옴
		boolean check;//유무를 하기 위한 논리형 check 변수
		if(nickcheck != null) {// 누군가가 닉네임을 사용하고 있는경우
			
			check = false;//거짓으로 설정
		}else {// 아무도 안쓰고 있는 경우
			check = true;//참으로 설정
			
		}
		model.addAttribute("check", check);
		return "nickcheck";
	}
	
	
	@RequestMapping("/emailcheck")
	@ResponseBody
	public Map<String, String> email(@RequestBody MemberDto dto) {
		Random random = new Random(); //난수를 만들어줄 랜덤 클라쓰
		String key = ""; // 인증번호
		Map<String, String> map = new HashMap<String, String>();
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(dto.getMember_email());//스크립트에서 보낸 인증번호를 받을 사용자 이메일 주소 
		for(int i =0; i<3; i++) {
			int idx = random.nextInt(25)+65;//A+Z까지 무작위 알파벳 생성
			key+=(char)idx;//key에 값을 담아줌
		}
		int numberidx = random.nextInt(9999)+1000; //4자리 무작위 정수 생성
		key+=numberidx;//key에 추가
		msg.setSubject("YORIZORI 이메일 인증시스템 입니다.");//이메일 제목
		msg.setText("인증번호: "+key);//이메일 내용
		logger.info("인증번호: {}",key);
		mailSender.send(msg);//전송하기
		
		map.put("rnum", key);
		return map;
	}
}
