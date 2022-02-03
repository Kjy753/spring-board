package com.kjy.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kjy.domain.BoardAttachVO;
import com.kjy.mapper.BoardAttachMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class FileChaekTask {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardAttachMapper attachMapper;

	private String getFolderYesterDay() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, -1);
		
		String str = sdf.format(cal.getTime());
		
		return str.replace("-", File.separator);
		
	}
	
	
	
	@Scheduled(cron="0 0 2 * * *")
	public void checkFiles() throws Exception{
		
		log.warn("파일 체크 스케줄러 실해웅..");
		
		log.warn(new Date());
		
		// file list in database
		List<BoardAttachVO> fileList = attachMapper.getOldFiles();
		
		// 데이터베이스 파일 목록 폴더에서 파일 확인 
		List<Path> fileListPaths = fileList.stream().map(vo -> Paths.get("D:\\upload", vo.getUploadPath(),  vo.getUuid() + "_" + vo.getFileName())).collect(Collectors.toList());
		
		// image file has tumnail file
		fileList.stream().filter(vo -> vo.isFileType() == true).map(vo -> Paths.get("D:\\upload", vo.getUploadPath(), "s_" + vo.getUuid() + "_" + vo.getFileName())).forEach(p -> fileListPaths.add(p));
		
		log.warn("=======================");
		
		fileListPaths.forEach(p -> log.warn(p));
		
		// files in yesterday directory
		File targetDir = Paths.get("D:\\upload", getFolderYesterDay()).toFile();
		
		File[] removeFIles = targetDir.listFiles(file -> fileListPaths.contains(file.toPath()) == false);
		log.warn("---------------------------------------");
		
		for (File file : removeFIles) {
			log.warn(file.getAbsolutePath());
			file.delete();
		}
	}
}
