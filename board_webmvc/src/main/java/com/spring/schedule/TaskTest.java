package com.spring.schedule;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spring.domain.AttachFileDTO;
import com.spring.mapper.AttachMapper;


@Component
public class TaskTest {
	
	@Autowired
	private AttachMapper mapper;
	
	
	// cron : 순서대로 
	// second
	// minute
	// hour
	// day of month
	// month
	// day of week	를 뜻함 
	@Scheduled(cron="0 0 2 * * *")  //새벽2시에 작동함 
	public void schedulerTest() {
		
		// db에서 어제날짜의 파일목록 가져오기
		List<AttachFileDTO> oldList = mapper.oldFiles();
		
		// oldList ==> 경로로 변경해야 함
		// 이미지 파일이라면 파일목록 + 썸네일 경로 추가
		List<Path> pathList = new ArrayList<Path>();
		
		for (AttachFileDTO dto : oldList) {
			Path path = Paths.get("c:\\upload\\"+dto.getUploadPath()+"\\"+dto.getUuid()+"_"+dto.getFileName());
			pathList.add(path);
			
			if(dto.isFileType()) {
				Path thumb = Paths.get("c:\\upload\\"+dto.getUploadPath()+"\\s_"+dto.getUuid()+"_"+dto.getFileName());
				pathList.add(thumb);
			}
		}
		System.out.println(pathList);
		
		// 어제날짜 구해서 폴더에 접근한 후 폴더에 있는 파일 목록 가져오기
		String yesterday = getFolderYesterDay();
		
		File targetDir = Paths.get("c:\\upload", yesterday).toFile();
		System.out.println("targetDir "+targetDir);
		
		// 비교 후 db와 일치하지 않는 파일은 삭제
		File[] removeFiles = targetDir.listFiles(f -> pathList.contains(f.toPath()) == false);
		
		for (File remove : removeFiles) {
			remove.delete();
		}
		
		
	}
	
	private String getFolderYesterDay() {
		// 어제날짜 추출
		LocalDate yesterday = LocalDate.now().minusDays(1);
		
		String str = yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return str.replace("-", File.separator); //운영체제에 맞는 폴더 구분자(/,\)로 변경 
		
	}
	
	
	
	
//	@Scheduled(fixedDelay = 10000)
//	public void schedulerTest2() {
//		System.out.println("10초마다 스케쥴링...");
//	}
	
	

}