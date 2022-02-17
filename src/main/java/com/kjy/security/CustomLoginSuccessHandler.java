package com.kjy.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		
		log.warn("로그인 성공");

		List<String> roleNames = new ArrayList<>();
		
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
			
		});
		
		log.warn("권한 명: "+ roleNames);
		
		if(roleNames.contains("ROLE_ADMIN")) {
			//로그인한 계정이 권한으로 "ROLE_ADMIN"을 가지고있을 경우
			
			response.sendRedirect("/sample/admin");
			// /sample/admin 으로 전송
			return;
		}
		
		if(roleNames.contains("ROLE_MEMBER")) {
			//로그인한 계정이 권한으로 "ROLE_MEMBER" 을 가지고 있을 경우
			response.sendRedirect("/sample/member");
			// /sample/member 으로 전송
			return;
		}
		
		response.sendRedirect("/");
	}
	

}
