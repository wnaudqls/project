package com.yori.zori.controller;

import java.io.IOException;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yori.zori.model.biz.BroadcastBiz;
import com.yori.zori.model.biz.BroadcastBizImpl;
import com.yori.zori.model.dto.BroadcastDto;

/**
 * Servlet implementation class CalController
 */
@Controller
public class BroadcastController {
	private static Logger logger = LoggerFactory.getLogger(BroadcastController.class);
	
	@Autowired
	BroadcastBiz biz;

	public BroadcastController() {

	}
	
	
	@RequestMapping("broadcastlist")
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

