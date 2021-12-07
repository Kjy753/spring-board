package com.kjy.domain;

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
	
	public Criteria() {
		this(1,10); 
		/* 생성자를 통해 기본 값을 1페이지, 10개 데이터로 지정 */
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}
