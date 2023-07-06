package com.spring.util;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Component;

import com.spring.domain.MemberDTO;


@Component
public class MailUtil {
	
	
public void sendEmail(MemberDTO dto) throws Exception{
		
		//Mail Server 설정
		String charSet="utf-8";
		String hostSMTP="smtp.gmail.com";
		String hostSMTPid="soltour80"; //관리자 이메일 아이디
		String hostSMTPpw="ujzxovkzgminqjes"; //관리자 이메일 비밀번호 (구글 앱 비밀번호 발급)
		
		//보내는 사람 
		String fromEmail="soltour80@gmail.com"; //보내는 사람 이메일 
		String fromName="SOLtour"; //보내는 사람 이름
		
		String subject="SOLtour 임시 비밀번호 안내"; //메일 제목
		String msg="";
		
		msg +="<div align='lift'";
		msg +="<h3>";
		msg +=dto.getUsername() + "님의 임시 비밀번호입니다. <br>로그인 후 비밀번호를 변경해 주세요.</h3>";
		msg +="<p>임시 비밀번호:";
		msg +=dto.getPassword() + "</p></div>";
		
		//email전송
		String mailRecipient=dto.getEmail();//받는 사람 이메일 주소
		try {
			//객체 선언
			HtmlEmail mail = new HtmlEmail();
			mail.setDebug(true);
			mail.setCharset(charSet);
			mail.setSSLOnConnect(true);
			mail.setHostName(hostSMTP);
			mail.setSmtpPort(587); 
			mail.setAuthentication(hostSMTPid, hostSMTPpw);
			mail.setStartTLSEnabled(true);
			mail.addTo(mailRecipient,charSet);
			mail.setFrom(fromEmail, fromName, charSet);
			mail.setSubject(subject);
			mail.setHtmlMsg(msg);
			mail.send();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void findPwd(HttpServletResponse response, MemberDTO dto) {
		response.setContentType("text/html;charset=utf-8");
		
	}

}
