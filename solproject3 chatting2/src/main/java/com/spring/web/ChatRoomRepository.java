package com.spring.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.domain.ChatRoomDTO;

@Repository
public class ChatRoomRepository {

    private Map<String, ChatRoomDTO> chatRoomDTOMap;

    // 초기화 메서드 - jdk버전때문에 @PostConstruct 어노테이션 못씀
    private void init(){
        chatRoomDTOMap = new LinkedHashMap<>();
    }

    public List<ChatRoomDTO> findAllRooms(){
        //채팅방 생성 순서 최근 순으로 반환
        List<ChatRoomDTO> result = new ArrayList<>(chatRoomDTOMap.values());
        Collections.reverse(result);

        return result;
    }

    public ChatRoomDTO findRoomById(String id){
        return chatRoomDTOMap.get(id);
    }

    public ChatRoomDTO createChatRoomDTO(String name){
        ChatRoomDTO room = ChatRoomDTO.create(name);
        chatRoomDTOMap.put(room.getRoomId(), room);

        return room;
    }
}
