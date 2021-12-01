package com.kjy.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kjy.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	@Test
	public void testExist() {
		/* BoardService 객체가 제대로 주입이 되었나 테스트 */
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		
		BoardVO board = new BoardVO();
		board.setTitle("regiter 테스트");
		board.setContent("regiter 테스트");
		board.setWriter("writer");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호는 : " + board.getBno());
	}
	
	@Test
	public void testGetList() {
		/* 전체 목록 조회 */
		service.getList().forEach(board -> log.info(board));
		
	}
	
	@Test
	public void testGet() {
		/* 3번 게시물 조회 */
		log.info(service.get(3L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(3L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("update 제목");
		log.info("Modify Result: " + service.modify(board));
	}
	
	@Test
	public void testDelete() {
		
		log.info("Remove Result: " + service.remove(3L));
	}
}
