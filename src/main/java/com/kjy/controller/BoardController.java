package com.kjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kjy.domain.BoardVO;
import com.kjy.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list...........");
		
		model.addAttribute("list", service.getList());
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		/* 등록 작업이 끝난 후 다시 목록 화면으로 가도록 하기 위해서 REdirectAttributes 를 파라미터로 사용 */
		log.info("register: "+ board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getBno());
		
		return "redirect:/board/list";
		
		/*POST 방식 이후에는 'redirect:/~~ 를 이용해서 별도의 페이지 이동 혹은 메시지 출력 방식*/
		}
}
