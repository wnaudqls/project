package com.yori.zori.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yori.zori.model.biz.UserBiz;
import com.yori.zori.model.dto.MemberDto;

@Controller
@RequestMapping(value="/check")
public class SignupController {
	@Autowired
	UserBiz biz;
	Logger logger = LoggerFactory.getLogger(SignupController.class);
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
		logger.info("nick:{} ",nick);
		dto.setMember_nick(nick);
		MemberDto nickcheck = biz.nickCheck(dto);
		boolean check;
		if(nickcheck != null) {
			check = false;
		}else {
			check = true;
			
		}
		model.addAttribute("check", check);
		return "nickcheck";
	}
}
