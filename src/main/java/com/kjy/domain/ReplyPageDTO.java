package com.kjy.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class ReplyPageDTO {
	/* 댓글 페이징을 위한 데이터 전송객체 */

	private int replyCnt; // 댓글 갯수
	private List<ReplyVO> list; //댓글 목록
}
