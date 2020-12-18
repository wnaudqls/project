package com.yori.zori.common.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("[LogingInterceptor]:prehandle");
		//아래 조건일때만 controller로 넘어갑니다.
		if(	request.getRequestURI().contains("/YORIZORI/login")||
			request.getRequestURI().contains("/YORIZORI/loginres") || 
			request.getRequestURI().contains("/YORIZORI/success") ||
			request.getRequestURI().contains("/YORIZORI/recipelist")||
			request.getRequestURI().contains("/YORIZORI/resources")||
			request.getRequestURI().contains("/YORIZORI/broadcastselectlist")||
			request.getRequestURI().contains("/YORIZORI/broadcastlist")
			||(request.getSession().getAttribute("login")!=null)) 
		
		{
			return true;
		}
		
		//session에 값이 없으면,
		if(request.getSession().getAttribute("login")==null) {
			response.sendRedirect("/YORIZORI/login");
			return false;
		}
		
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws IOException {
		logger.info("[LoginInterceptor] : postHandle");
		
		if(modelAndView != null) {
			logger.info(modelAndView.getViewName());
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		logger.info("[LoginInterceptor] : afterCompletion");
	}
}
