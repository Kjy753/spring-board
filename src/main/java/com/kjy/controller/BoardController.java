package com.kjy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kjy.domain.BoardAttachVO;
import com.kjy.domain.BoardVO;
import com.kjy.domain.Criteria;
import com.kjy.domain.PageDTO;
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
	public void list(Criteria cri ,Model model) {
		log.info("list...........");
			
		model.addAttribute("list", service.getList(cri));
		
		int total = service.getTotal(cri);
		log.info("전체 데이터 갯수: " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		/* 페이지 DTO를 사용 할수 있게 Model 에 담음. */

	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		/* 등록 작업이 끝난 후 다시 목록 화면으로 가도록 하기 위해서 REdirectAttributes 를 파라미터로 사용 */
		log.info("register: " + board);
		
		if(board.getAttachList() != null) {
			board.getAttachList().forEach(attach -> log.info(attach));
		}
		service.register(board);

		rttr.addFlashAttribute("result", board.getBno());

		return "redirect:/board/list";

		/* POST 방식 이후에는 'redirect:/~~ 를 이용해서 별도의 페이지 이동 혹은 메시지 출력 방식 */
	}

	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		/* @RequestParam 을 하는 이유는 bno 값을 좀더 명시적으로 처리 하기 위해서
		 * ModelAttribute 는 자동으로 Model에 데이터를 지정한 이름으로 담아준다. */
		log.info("get 혹은 modify");
		model.addAttribute("board", service.get(bno));
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {

		log.info("modify: " + board);

		if (service.modify(board)) {
			
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		return "redirect:/board/list";
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno,  @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		
		log.info("remove : " + bno);
		
		if(service.remove(bno)) {
			
			rttr.addFlashAttribute("result","success");
		}
		
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@GetMapping(value = "/getAttachList", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno){
		// 게시물 번호를 이용해서 첨부파일 관련 데이터를 json 으로 반환 
		log.info("get AttachList =" + bno);
		return new ResponseEntity<>(service.getAttachList(bno),HttpStatus.OK);
	}
	
}
