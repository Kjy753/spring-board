package com.kjy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kjy.domain.Criteria;
import com.kjy.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insert(ReplyVO vo);
	/* 등록 작업 */
	
	public ReplyVO read(Long bno);
	/* 댓글 조회 작업 */
	
	public int delete (Long rno);
	/* 댓글 삭제 작업 */
	
	public int update(ReplyVO vo);
	/* 댓글 수정 작업 */
	
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
	/* 댓글 목록을 조회 하는 작업 */
	
	public int getCountByBno(Long bno);
	/* 전체 댓글의 숫자 파악 */
}
