package com.kjy.domain;

import lombok.Data;

@Data
public class BoardAttachVO {
	// 게시물에 첨부파일 등록 관련 vo
			
	private String uuid;	//uuid 값
	private String uploadPath;	//실제 파일의 업로드 경로
	private String fileName;	// 파일 이름
	private boolean fileType;	//이미지 파일 여부 
	
	private Long bno;	// 해당 게시물 번호 지정
}
