package com.kjy.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {
		
		log.info("upload form");
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model	) {
	
		String uploadFolder = "D:\\upload";
		
		for(MultipartFile multipartFile : uploadFile) {
			log.info("업로드 되는 파일 이름 : " + multipartFile.getOriginalFilename());
			log.info("업로드 되는 파일 크기 : "+ multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			} catch(Exception e) {
				log.error(e.getMessage());
			}//end catch
			
			
		}//end for
	}
}
