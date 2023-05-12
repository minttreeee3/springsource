package com.spring.mapper;

import org.apache.ibatis.annotations.Insert;

public interface SampleMapper1 {
	
		@Insert("insert into tbl_sample1(col1) values(#{data})") //sql짧아서 여기에 바로 
		public int insertCol1(String data);
	

}
