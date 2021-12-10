package com.kjy.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kjy.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	private Long[] bnoArr = {59L,58L,57L,56L,55L,54L};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		log.info("----" +mapper);
	}
	
	@Test
	public void testCreate() {
		
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("reply 테스트" + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testRead() {
		
		Long targetRno = 19L;
		
		ReplyVO vo = mapper.read(targetRno);
	}
	
	@Test
	public void testDelete() {
		
		Long targetRno = 17L;
		
		mapper.delete(targetRno);
	}
	
	@Test 
	public void testUpdate() {
		
		Long targetRno = 19L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("update reply");
		
		int count = mapper.update(vo);
		
		log.info("update count:"+count);
	}
}
