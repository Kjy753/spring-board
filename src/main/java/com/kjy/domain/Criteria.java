package com.kjy.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Criteria {
	/* 검색의 기준 */
	
	private int pageNum; // 페이지 번호
	private int amount; // 페이지당 출력 데이터
	
	private String type; //검색 종류
	private String keyword; //검색어
	
	public Criteria() {
		this(1,10); 
		/* 생성자를 통해 기본 값을 1페이지, 10개 데이터로 지정 */
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		/* 검색 조건을 배열로 만들어서 한번에 처리하도록 한다. */
		return type == null? new String[] {}: type.split("");
	}
	
	public String getListLink() {
		// get 방식으로 파라미터 전송시 문자열을 쉽세 처리하는 클래스 
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		return builder.toUriString();
	}
}
