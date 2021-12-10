package com.kjy.mapper;

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
	
	
}
