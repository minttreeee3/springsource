package com.spring.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.spring.domain.AttachFileDTO;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Slf4j
@Controller
public class UplooadAjaxController {
	
	//uploadAjax 컨트롤러 생성
	@GetMapping("/uploadAjax")
	public void uploadAjaxGet() {
		log.info("uploadAjax 폼 요청");
	}
	
	// 파일 하나일때
//	@PostMapping("/uploadAjax")
//	public ResponseEntity<String> uploadAjaxPost(MultipartFile uploadFile) {
//		log.info("upload 요청");
//		
//		log.info("file name "+uploadFile.getOriginalFilename());
//		log.info("file seze "+uploadFile.getSize());
//		
//		String uploadPath = "D:\\eclipse\\upload";
//		
//		UUID uuid = UUID.randomUUID();
//		String fileName = uuid.toString() + "_" + uploadFile.getOriginalFilename();
//		
//		try {
//			uploadFile.transferTo(new File(uploadPath,fileName));
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		// 상태코드 + 메세지
//		return new ResponseEntity<>(fileName, HttpStatus.OK);		
//	}
	
//	@PostMapping("/uploadAjax")
//	public ResponseEntity<List<String>> uploadAjaxPost(MultipartFile[] uploadFile) {
//		log.info("upload 요청 ");
//		
//		List<String> fileList = new ArrayList<String>();
//		
//		for (MultipartFile multipartFile : uploadFile) {
//			log.info("file name "+multipartFile.getOriginalFilename());
//			log.info("file size "+multipartFile.getSize());
//			
//			String uploadPath = "c:\\upload";
//			UUID uuid = UUID.randomUUID();
//			String fileName = uuid.toString() + "_" + multipartFile.getOriginalFilename();
//			
//			fileList.add(multipartFile.getOriginalFilename());
//			
//			try {
//				multipartFile.transferTo(new File(uploadPath,fileName));
//			} catch (IllegalStateException e) {			
//				e.printStackTrace();
//			} catch (IOException e) {			
//				e.printStackTrace();
//			}			
//		}		
//		//상태코드 + 메세지
//		return new ResponseEntity<>(fileList, HttpStatus.OK);
//	}
	
	// 파일 여러개일때
	@PostMapping("/uploadAjax")
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		log.info("upload 요청");
		
		List<AttachFileDTO> fileList = new ArrayList<AttachFileDTO>();
		
		String uploadPath = "D:\\eclipse\\upload";
		// 폴더 생성 => D:\\eclipse\\upload\\2023\\05\\26 
		String uploadFolderPath = getFolder();
		log.info("uploadFolderPath ",uploadFolderPath);
		
		File uploadFullPath = new File(uploadPath, uploadFolderPath);
		
		// 폴더명이 없을때에만 폴더를 생성 (있을때 또 만들면 이전꺼는 날라가니깐)
		if(!uploadFullPath.exists()) {
				uploadFullPath.mkdirs();
		}
		
		for (MultipartFile multipartFile : uploadFile) {
			log.info("file name "+multipartFile.getOriginalFilename());
			log.info("file size "+multipartFile.getSize());
						
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString() + "_" + multipartFile.getOriginalFilename();
			
			//원본 이미지
			File saveFile = new File(uploadFullPath, fileName);
			
			// 파일 한 개당 AttachFileDTO 생성
			AttachFileDTO attach = new AttachFileDTO();
			// 원본파일명
			attach.setFileName(multipartFile.getOriginalFilename());
			// 새로운파일명
			attach.setUploadPath(uploadFolderPath);
			attach.setUuid(uuid.toString());
			
			try {
				//원본파일저장
				multipartFile.transferTo(saveFile);
				
				//업로드된 파일 타입 체크
				if(checkImageType(saveFile)) {
					attach.setFileType(true);
					
					//이미지 파일이라면 썸네일 이미지로 저장
					//원본 이미지 읽어오기
					BufferedImage origin = ImageIO.read(saveFile);
					//썸네일 파일명
					File thumbnail = new File(uploadFullPath,"s_"+fileName);
					
					double ratio = 10; //축소비율
					int width = (int) (origin.getWidth() / ratio);
					int height = (int) (origin.getHeight() / ratio);
					
					Thumbnails.of(origin).size(width, height).toFile(thumbnail); 							
				}
									
			} catch (Exception e) {
				e.printStackTrace();
			} 					
			fileList.add(attach);
		}				
		// 상태코드 + 메세지
		return new ResponseEntity<>(fileList, HttpStatus.OK);		
	}
	
	
	// 파일이 저장되는건 내 컴퓨터 안이기 때문에
	// 외부(웹)에서 보여주기 위해선 컨트롤러가 필요함
	
	//파일 요청 시 파일 보내주기
	@GetMapping("/display")
	public ResponseEntity<byte[]> getFile(String fileName) {
		log.info("파일 요청 "+fileName);		
		
		File file = new File("D:\\eclipse\\upload");
		
		//springframework Headers
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<byte[]> result = null;
		
		try {
			//서버가 보내는 파일에 대한 타입 지정
			headers.add("content-type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@GetMapping(value="/download", produces= MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName, String userAgent) {
		log.info("파일 다운로드 요청 "+fileName);
		
		Resource resource = new FileSystemResource("D:\\eclipse\\upload"+fileName);
		
		if(!resource.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders headers = new HttpHeaders();
		
		String downloadName = null;
			try {
				if(userAgent.contains("Trident") || userAgent.contains("Edge")) {
					downloadName = URLEncoder.encode(resource.getFilename(), "utf-8").replaceAll("\\+", " ");
				} else {
					downloadName = new String(resource.getFilename().getBytes("utf-8"), "ISO-8859-1");
				}
				
				headers.add("Content-Disposition", "attachmment;filename="+downloadName);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return new ResponseEntity<Resource>(resource,headers,HttpStatus.OK);
	}
	
	
	
	
	
	
	// 일반 메소드(파일 타입 확인) - 파일 타입에 따라 나눠서 저장하기 위해 
	private boolean checkImageType(File file) {
		String contentType;
		try {
			contentType = Files.probeContentType(file.toPath()); // 이미지라면 images/gif, images/jpg... 식으로 들어옴
			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return false;
	}
	// 일반 메소드(폴더 생성) -날짜별로 저장하기 위해
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = new Date(); // 날짜 정보가 길게나옴
		String str = sdf.format(date);  // 2023-05-26
		return str.replace("-", File.separator);  // - 를 /로 바꿔줌 (c:/1.jpg처럼) 
	}



}
