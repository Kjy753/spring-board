package com.kjy.mapper;

import java.util.List;

import com.kjy.domain.BoardAttachVO;

public interface BoardAttachMapper {

	public void insert(BoardAttachVO board);
	// 첨부파일 등록
	public void delete(String uuid);
	// 첨부파일 삭제
	public List<BoardAttachVO> findByBno(Long bno);
	//특정 번호를 이용해 첨부파일 찾는 작업
}
