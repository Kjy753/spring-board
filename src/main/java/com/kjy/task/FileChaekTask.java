package com.kjy.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class FileChaekTask {

	@Scheduled(cron="0 * * * * *")
	public void checkFiles() throws Exception{
		
		log.warn("파일 체크 스케줄러 실해웅..");
		
		log.warn("=======================================");
	}
}
