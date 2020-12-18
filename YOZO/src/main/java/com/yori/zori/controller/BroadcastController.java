package com.yori.zori.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yori.zori.broadcast.dto.BroadcastDto;
import com.yori.zori.broadcast.dto.BroadcastDto_Reservation;*/



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yori.zori.model.biz.BroadcastBiz;
import com.yori.zori.model.biz.ChatBiz;
import com.yori.zori.model.dto.BroadcastDto;
import com.yori.zori.model.dto.ChatDto;

/**
 * Servlet implementation class CalController
 */
@Controller
public class BroadcastController {
	private static Logger logger = LoggerFactory.getLogger(BroadcastController.class);
	
	@Autowired
	BroadcastBiz biz;
	
	@Autowired
	ChatBiz cbiz;

	@Autowired
	private SimpMessagingTemplate template;
	
	public BroadcastController() {

	}
	
	@RequestMapping("/roomres")
	public String createroom(BroadcastDto dto ) throws UnsupportedEncodingException {
		
		int res = biz.insert(dto);
		String title = dto.getBroadcast_title();
		String encoded = URLEncoder.encode(title,"UTF-8");
		
		if(res > 0) {
			return "redirect:/broadcast/"+encoded;
		}else {
			return "";
		}
	}
	
	@RequestMapping("/broadcastlist")
	@ResponseBody
	public Map<String, List<BroadcastDto>>broadcast(){
		Map<String, List<BroadcastDto>> map = new HashMap<String, List<BroadcastDto>>();
		List<BroadcastDto> list = biz.selectList();
		if(list != null) {
			map.put("list", list);
			logger.info("broadcastlist 담는중");
		}
		return map;
	}
	
	@RequestMapping("/broadcastselectlist")
	@ResponseBody
	public Map<String, List<BroadcastDto>>broadselectlist(@RequestBody BroadcastDto dto){
		Map<String, List<BroadcastDto>> map = new HashMap<String, List<BroadcastDto>>();
		List<BroadcastDto> list = biz.search(dto);
		logger.info("broadcastselectlist 담는중");
		logger.info("검색한 값: {}",biz.search(dto));
		if(list != null) {
			map.put("list", list);
		}
		return map;
	}
	
	@GetMapping("/broadcast/{broadcast_title}")
	public String room(@PathVariable("broadcast_title")String broadcast_title, Model model){
		BroadcastDto dto = biz.selectone(broadcast_title);
		logger.info("방이름: {}",broadcast_title);
		model.addAttribute("dto", dto);
		return "broadcast_room";
	}
	@MessageMapping("/chat/join")
    public void join(ChatDto dto) {
		 //접속했을때 실행
		logger.info(dto.getUser_id()+"님 등장");
		dto.setChat_content(dto.getUser_id() + "님이 입장하셨습니다.");
		BroadcastDto bdto = new BroadcastDto();
		bdto.setBroadcast_no(dto.getBroadcast_no());
        template.convertAndSend("/getmsg/chat/join/"+dto.getChat_title(), dto);
        biz.update(bdto);
        cbiz.insert(dto);
       
    }
	@MessageMapping("/chat/disconnect")
    public void disconnect(ChatDto dto) {
		 //접속했을때 실행
		logger.info(dto.getUser_id()+"님 퇴장");
		dto.setChat_content(dto.getUser_id() + "님이 퇴장하셨습니다.");
		BroadcastDto bdto = new BroadcastDto();
		bdto.setBroadcast_no(dto.getBroadcast_no());
        template.convertAndSend("/getmsg/chat/leave/"+dto.getChat_title(), dto);
        biz.updateCurrentClient(bdto);
        cbiz.insert(dto);
        BroadcastDto checkdto = biz.selectone(dto.getChat_title());
        if(checkdto.getBroadcast_anyone().equals("N")) {
        	if(checkdto.getBroadcast_currentclient() <= 0) {
        		int res = biz.delete(checkdto);
        		if(res > 0) {
        			logger.info("{}방 삭제 성공",checkdto.getBroadcast_title());
        		}else {
        			logger.info("{}방 삭제실패",checkdto.getBroadcast_title());
        		}
        	}
        }
        
    }
	@MessageMapping("/chat/message")
    public void message(ChatDto dto) {
		 //접속했을때 실행
		cbiz.insert(dto);
		logger.info(dto.getChat_title()+"방\n{}: {}",dto.getUser_id(),dto.getChat_content());
        template.convertAndSend("/getmsg/chat/room/"+dto.getChat_title(), dto);
       
    }
	
}
	
	
/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BroadcastBizImpl biz = new BroadcastBizImpl();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String command = request.getParameter("command");
		String url = "view/broadcast/";// 경로지정
		if (command.equals("broadcast")) {
			dispatch(url + "broadcast_list.jsp", request, response);
		} else if (command.equals("list")) {
			String time = request.getParameter("time");// radio의 값을 가져온다 이말임.
			List<BroadcastDto> list = biz.selectList(time);
			// 그 시간대에 해당하는 방송 리스트들을 보여주는 selectList
			request.setAttribute("list", list);
			dispatch(url + "broadcast_selectlist.jsp", request, response);
		} else if (command.equals("checklist")) {
			String name = request.getParameter("name");
			List<BroadcastDto_Reservation> list = biz.checklist(name);
			// 자신이 접속한 id값을 파라미터든 뭐든 어떻게 해서든 넣어야 함
			request.setAttribute("list", list);
			dispatch(url + "broadcast_checktlist.jsp", request, response);

		} else if (command.equals("selectone")) {
			int no = Integer.parseInt(request.getParameter("no"));
			// 방송의 번호를 가져옴
			BroadcastDto dto = biz.selectone(no);
			// 해당 방송의 데이터들을 dto에 저장
			request.setAttribute("dto", dto);
			// 전송
			dispatch(url + "broadcast_selectone.jsp", request, response);

		} else if (command.equals("reserve")) {
			int no = Integer.parseInt(request.getParameter("no"));
			String id = request.getParameter("id");
			System.out.println(id);
			int res = biz.insert(new BroadcastDto_Reservation(1, null, "Y", id));
			if (res > 0) {
				sendmessage("예약완료", "broadcast.do?command=checklist&name=" + id, response);
			} else {
				sendmessage("예약실패", "broadcast.do?command=selectone&no=" + no, response);
			}
		} else if (command.equals("stream")) {
			dispatch(url + "broadcast_stream.jsp", request, response);

		} else if (command.equals("watch")) {

			dispatch(url + "broadcast_watch.jsp", request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public static void sendmessage(String msg, String url, HttpServletResponse response) {
		String s = "<script text/javascript>" + "alert('" + msg + "');" + "location.href='" + url + "';" + "</script>";
		try {
			response.getWriter().append(s);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void dispatch(String url, HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);

		try {
			dispatch.forward(request, response);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}*/

