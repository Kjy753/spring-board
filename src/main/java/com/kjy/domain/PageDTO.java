package com.kjy.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	/* 페이징 처리를 위한 전송 객체 */
	
	private int startPage; // 첫 페이지
	private int endPage; //끝 페이지
	private boolean prev,next; //pre : < next : >
	
	private int total; // 전체 데이터 수 
	private Criteria cri; // 검색 기준
	
	public PageDTO(Criteria cri, int total) {
	
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		/*페이징으 끝 번호 계산 페이지 번호를 10개씩 보인다고 가정 할 경우 
		 * Math.ceil() 을 통해 소수점을 올림 으로 처리*/
		this.startPage = this.endPage -9;
		/*시작 번호는 무조건 끝번호에서 -9만큼 뺸 값*/
		
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount() ));
		/* 진짜 끝 페이지 구하기*/
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
			/* 진짜 끝 페이지가 미리 구해놓은 끝 번호보다 작으면 끝버호는 작은 값이 되어야 함. */
			
		}
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEnd;
		
	}
	
}
