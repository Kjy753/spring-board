package com.kjy.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		
		log.info("접근 제한 :" + auth);
		
		model.addAttribute("msg", "Access Denied");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		
		log.info("error:" + error);
		log.info("logout: " + logout);
		
		if(error != null) {
			model.addAttribute("error", "로그인 오류 계정을 다시 확인해 주세요!");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "로그아웃!!");
			
		}
	}
}
