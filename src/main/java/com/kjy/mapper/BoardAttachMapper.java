package com.kjy.mapper;

import java.util.List;

import com.kjy.domain.BoardAttachVO;

public interface BoardAttachMapper {
	
	public void insert(BoardAttachVO vo);
	
	public void delete(String uuid);
	
	public List<BoardAttachVO> findByBno(Long bno);
	
	public void deleteAll(Long bno);

	public List<BoardAttachVO> getOldFiles(); 
	// 첨부파일의 목록을 가져오는 친구
	
}
