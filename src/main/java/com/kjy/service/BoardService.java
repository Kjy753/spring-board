package com.kjy.service;

import java.util.List;

import com.kjy.domain.BoardVO;

public interface BoardService {

	public void register(BoardVO vo);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO vo);
	
	public boolean remove(Long bno);
	
	public List<BoardVO> getList();
	
}
