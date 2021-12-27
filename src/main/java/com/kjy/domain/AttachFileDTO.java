package com.kjy.domain;

import lombok.Data;

@Data
public class AttachFileDTO {
	//첨부파일의 정보를 저장하는 클래스
	private String fileName; // 원본 파일 이름
	private String uploadPath; //업로드 경로
	private String uuid; // 랜덤 uuid
	private boolean image; //이미지 타입 여부 
	
}
