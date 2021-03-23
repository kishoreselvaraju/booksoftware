package com.libary.books.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class DataUtil {

	public static String getRoleFromSession(HttpServletRequest httpreq) {
		String role = (String) httpreq.getSession().getAttribute("AccessToken");
		return role;
	}

	public static void removeRoleFromSession(HttpServletRequest httpreq) {
		httpreq.getSession().removeAttribute("AccessToken");
		
	}
	
	 

	

}
