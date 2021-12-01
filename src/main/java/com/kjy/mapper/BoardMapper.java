package com.kjy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kjy.domain.BoardVO;

public interface BoardMapper {

	//@Select("select * from sp_board where bno > 0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO vo);
}
