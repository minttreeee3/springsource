package com.spring.dependency;

public class TvMain {
	
	String str = "String";  // == new와 같은 역할  -> 이거안하면 널포인트익셉션 나서 
	
	public static void main(String[] args) {
		
//		SonySpeaker speaker = new SonySpeaker();		
//		TV tv = new SamsungTV(speaker);

//		TV tv = new SamsungTV(new SonySpeaker());
		
		// setter를 사용한 멤버 변수 초기화
		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(new SonySpeaker());
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		
//		TvMain obj = new TvMain();
//		obj.test();
	}
	
//	public void test() {
//		System.out.println(str);
//		System.out.println(str.length());
//	}

}
