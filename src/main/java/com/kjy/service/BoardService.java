package com.kjy.service;

import java.util.List;

import com.kjy.domain.BoardVO;
import com.kjy.domain.Criteria;

public interface BoardService {

	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	//public List<BoardVO> getList();
	
	/* 검색의 기준인 cri 를 포함한 목록 조회로 변경 */
	public List<BoardVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);
	
}
