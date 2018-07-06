package pers.dzgodly.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthorizationInterceptor implements HandlerInterceptor {

	private static final String[] IGNORE_URI= {"/login","/","/exit"};
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		//mv.clear();
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView mv)
			throws Exception {
		//mv.clear();
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean flag= false;
		String servletPath=request.getServletPath();
		for(String s:IGNORE_URI) {
			if(servletPath.contains(s)) {
				flag=true;
				break;
			}
		}
		if(!flag) {
			if(request.getSession().getAttribute("student")==null&&request.getSession().getAttribute("houseowner")==null) {
				request.setAttribute("message", "请先登录");
				request.getRequestDispatcher("loginForm").forward(request, response);
			}else {
				flag=true;
			}
		}
		return flag;
	}

}
