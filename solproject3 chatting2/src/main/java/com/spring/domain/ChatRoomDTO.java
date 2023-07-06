package com.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor @NoArgsConstructor
public class ChatRoomDTO {

    private String roomId;
    private String name;
    //WebSocketSession은 Spring에서 Websocket Connection이 맺어진 세션
    private Set<WebSocketSession> sessions = new HashSet<>();

    
    
    public static ChatRoomDTO create(String name){
        ChatRoomDTO room = new ChatRoomDTO();

        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }
}