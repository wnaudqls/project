package com.yori.zori.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	@RequestMapping("/")
	public String index() {
		return "main";
	}
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	@RequestMapping("recipe_list")
	public String recipe() {
		return "recipe_list";
	}
	@RequestMapping("stream")
	public String stream() {
		return "broadcast_stream";
	}
	@RequestMapping("watch")
	public String watch() {
		return "broadcast_watch";
	}
}
