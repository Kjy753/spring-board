package com.kjy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kjy.domain.BoardAttachVO;
import com.kjy.domain.BoardVO;
import com.kjy.domain.Criteria;
import com.kjy.mapper.BoardAttachMapper;
import com.kjy.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService{

	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private BoardAttachMapper attachMapper;

	@Transactional
	@Override
	public void register(BoardVO board) {
		
		log.info("register :" + board);
		
		mapper.insertSelectKey(board);
		
		if(board.getAttachList() == null || board.getAttachList().size() <= 0) {
			return;
		}
		board.getAttachList().forEach(attach -> {
			log.info("테스트"+ board.getBno());
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
		
	}
	@Override
	public BoardVO get(Long bno) {
		
		log.info("get : " + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		
		log.info("modify : " + board);
		
		return mapper.update(board) == 1;
	}

	@Transactional
	@Override
	public boolean remove(Long bno) {
		
		log.info("remove : " + bno);
		
		attachMapper.deleteAll(bno);
		return mapper.delete(bno) == 1;
	}
	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("get List with criteria: " + cri);
		
		return mapper.getListWithPaging(cri);
	}


	/*
	 * @Override public List<BoardVO> getList() {
	 * 
	 * log.info("getList");
	 * 
	 * return mapper.getList(); }
	 */
	
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		
		return mapper.getTotalCount(cri);
	}
	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		log.info("첨부파일 정보를 가지고 있는 번호" + bno);
		return attachMapper.findByBno(bno);
	}
	

	

	
}
