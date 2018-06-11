package cc.ligu.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionTool {
	
	public static HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}

	public static void setUserInfo2Session(HttpServletRequest request,String clientId,Object obj){
		HttpSession session = request.getSession();
		session.setAttribute(clientId,obj);
	}
	
	public static void clearSessionByKey(HttpServletRequest request,String key){
		HttpSession session = request.getSession();
		session.removeAttribute(key); 
	}
	public static Object getUserInfoFromSession(HttpServletRequest request,String clientId){
		HttpSession session = request.getSession(false);
		if(session == null){
			return null;
		}
		return session.getAttribute(clientId);
	}
	public static Object getUrlInfoFromSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		return session.getAttribute("url"); 
	}
}
