package com.kjy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kjy.domain.Criteria;
import com.kjy.domain.ReplyPageDTO;
import com.kjy.domain.ReplyVO;
import com.kjy.mapper.BoardMapper;
import com.kjy.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardmapper;
	
	

	@Transactional
	@Override
	public int register(ReplyVO vo) {
		log.info("등록"+vo);
		
		boardmapper.updateReplyCnt(vo.getBno(), 1);
		// 댓글 등록시 board에서도 댓글 갯수가 업데이트
		
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		
		log.info("조회" + rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		
		log.info("수정 작업" + vo);
		
		return mapper.update(vo);
	}

	@Transactional
	@Override
	public int remove(Long rno) {
		
		log.info("댓글 삭제" + rno);
		ReplyVO vo = mapper.read(rno);
		
		boardmapper.updateReplyCnt(vo.getBno(), -1);
		// 댓글 삭제시 board에서도 댓글 갯수가 업데이트
		
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("댓글 목록"+ bno);
		
		return mapper.getListWithPaging(cri, bno);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		
		return new ReplyPageDTO(mapper.getCountByBno(bno),mapper.getListWithPaging(cri, bno));
	}
	
	
	
	

}
