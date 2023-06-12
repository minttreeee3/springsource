package com.example.restaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class SearchImageItem {
	// 네이버 api에서 정해준거 
	private String title;	// 이미지가 검색된 문서제목
	private String link;	// 이미지의 URL
	private String thumbnail;	// 썸네일 이미지의 URL
	private String sizeheight;	// 이미지 세로크기 (단위: 픽셀)
	private String sizewidth;		// 이미지 가로크기 (단위: 픽셀)

}
