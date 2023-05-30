package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.spring.domain.FileDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		logger.info("uploadForm 요청");
	}
	
	
//	// 첨부파일이 한개인 경우
//	@PostMapping("/uploadForm")
//	public void uploadPost(FileDTO dto) {
//		logger.info("upload 요청 "+dto);
//		
//		logger.info("file Name "+dto.getFile().getOriginalFilename());
//		logger.info("file Name "+dto.getFile().getContentType());
//		logger.info("file Name "+dto.getFile().getSize());
//		
//		String uploadPath = "c:\\upload";
//		File saveFile = new File(uploadPath, dto.getFile().getOriginalFilename());
//		
//		
//		try {
//			// 폴더에 저장
//			dto.getFile().transferTo(saveFile);
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	
//	}
	
	
	// 첨부파일이 여러개인 경우 -> for
		@PostMapping("/uploadForm")
		public void uploadPost(FileDTO dto) {
			logger.info("upload 요청 "+dto);
			
			String uploadPath = "c:\\upload";
			
			for(MultipartFile multipartFile : dto.getFile()) {
				logger.info("file Name "+multipartFile.getOriginalFilename());
				logger.info("file Name "+multipartFile.getContentType());
				logger.info("file Name "+multipartFile.getSize());
				
				// 중복되는 파일명 막기위해 유효아이디 랜덤값으로 생성해서 붙여줌 
				UUID uuid = UUID.randomUUID();
				String fileName = uuid.toString() + "_" + multipartFile.getOriginalFilename();	
				
				File saveFile = new File(uploadPath, fileName);
				
				try {
					// 폴더에 저장
					multipartFile.transferTo(saveFile);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}		
			}					
		}
	
	
	
	
		
}
