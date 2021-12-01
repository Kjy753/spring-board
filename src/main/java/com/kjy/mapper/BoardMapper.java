package com.kjy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kjy.domain.BoardVO;

public interface BoardMapper {

	//@Select("select * from sp_board where bno > 0")
	public List<BoardVO> getList();
	
	/* 단순 기본 인서트 작업 */
	public void insert(BoardVO vo);
	
	/* pk 번호를 알아야 할경우에 사용하는 인서트 작업 */
	public void insertSelectKey(BoardVO vo);
	
	/* 데이터를 조회하는 작업 */
	public BoardVO read(Long bno);
	
	/* 데이터를 삭제 하는 작업 */
	public int delete(Long bno);
	
	/* 데이터를 수정 하는 작업 */
	public int update(BoardVO vo);
	
}
