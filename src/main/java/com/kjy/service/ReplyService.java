package com.kjy.service;

import java.util.List;

import com.kjy.domain.Criteria;
import com.kjy.domain.ReplyPageDTO;
import com.kjy.domain.ReplyVO;


public interface ReplyService {
	
	public int register(ReplyVO vo);
	
	public ReplyVO get(Long rno);
	
	public int modify(ReplyVO vo);
	
	public int remove(Long rno);
	
	//public List<BoardVO> getList();
	
	/* 검색의 기준인 cri 를 포함한 목록 조회로 변경 */
	public List<ReplyVO> getList(Criteria cri, Long bno);
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
	/* 댓글 페이징 관련 인터페이스 */

}
