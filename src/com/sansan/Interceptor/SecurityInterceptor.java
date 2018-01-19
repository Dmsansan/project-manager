package com.sansan.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class SecurityInterceptor implements HandlerInterceptor{
	//日志记录
	private static final Logger log = Logger.getLogger(SecurityInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("拦截器开始..............");
		HttpSession session = request.getSession();
		String isAutoLogin  = (String) session.getAttribute("isAutoLogin");
		log.info("+++++++++++++++++"+isAutoLogin+"++++++++++++++++++++++++");
		if(isAutoLogin == null || isAutoLogin.equals("false")){
			 request.getRequestDispatcher("login.jsp").forward(request,response);
	         return false;
		}
		
		return true;
	}
		
}
