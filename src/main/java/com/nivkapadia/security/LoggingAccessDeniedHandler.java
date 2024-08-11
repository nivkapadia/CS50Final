package com.nivkapadia.security;



import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//This class handles the Access denied cases by forwarding to permission-denied page.
//It implements the AccessDeniedHandler interface.
@Component
 public class LoggingAccessDeniedHandler implements AccessDeniedHandler{
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		//Get authentication object to check whether a user logs on to web app. server
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		//if auth is null, it means a user doesn't log on or incorrect credential.
		if (auth != null) {
			System.out.println(auth.getName()
			+ " was trying to access protected resource: "
			+ request.getRequestURI());
		}
		//forward to permission denied page.
		response.sendRedirect(request.getContextPath() + "/permission-denied");

		
	}

}
