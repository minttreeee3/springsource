package com.spring.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.spring.domain.ChatMessageDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//  ChatHandler의 역할을 대신 해줌

@RequiredArgsConstructor // 생성자 주입
@Controller
@Slf4j
public class StompChatController {

    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달
     

    // @MessageMapping : WebSocket으로 들어오는 메세지 발행을 처리
    // Client가 SEND할 수 있는 경로
    // stompConfig에서 설정한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합됨
    
    // 입장시 "/pub/chat/join"로 메세지 발신 요청 
    @MessageMapping(value = "/chat/join")	
    public void join(ChatMessageDTO dto){
    	log.info("### 채팅 입장"+dto);
    	
        dto.setMessage(dto.getWriter() + "님이 채팅방에 참여하였습니다.");
        
        // "/sub/chat/room/[roomId]"로 메세지가 전송됨 (/sub은 구독 경로) , 
        // convertAndSend (전송할 url, 전송할 메시지 객체) 
        template.convertAndSend("/sub/chat/room/" + dto.getRoomId(), dto); 
        
    }

    // 채팅 전송시 "/pub/chat/message"로 발신 요청
    @MessageMapping(value = "/chat/message")
    public void message(ChatMessageDTO dto){
    	log.info("### 채팅 전송 메세지 ㅜㅜㅜㅜ ");
        template.convertAndSend("/sub/chat/room/" + dto.getRoomId(), dto);
    }
    
    
//    @MessageMapping("/chat/message")	
//    @SendTo("/sub/chat/room/{roomId}")
//    public ChatMessageDTO chat(@DestinationVariable String roomId, ChatMessageDTO dto){
//    	
//    	log.info("### 채팅 전송"+dto);
//    	return dto;
//
//    }
    
    
}