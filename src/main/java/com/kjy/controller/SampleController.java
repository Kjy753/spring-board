package com.kjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/sample/*")
@Controller
public class SampleController {

	
	@GetMapping("/all")
	public void doAll() {
		
		log.info("모든 접속자 다 가능");
	}
	
	@GetMapping("/member")
	public void doMemeber() {
		
		log.info("가입자 로그인");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		
		log.info("관리자 로그인");
	}
}
