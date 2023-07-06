package com.spring.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.ChatRoomRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// 채팅 화면을 보여주기 위한 컨트롤러

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
@Slf4j
public class RoomController {

	private final ChatRoomRepository repository;

	// 채팅방 목록 조회
	@GetMapping(value = "/roomlist")
	public ModelAndView roomlist() {

		log.info("# All Chat Rooms");
		ModelAndView mv = new ModelAndView("chat/roomlist");

		mv.addObject("list", repository.findAllRooms());

		return mv;
	}
	
	// 채팅방 개설
	@PostMapping(value = "/room")
	public String create(@RequestParam String name,RedirectAttributes rttr, Principal principal) {

		log.info("# Create Chat Room , name: " + name + ", ");
		log.info("채팅방 개설 유저아이디: "+principal.getName());
		rttr.addFlashAttribute("roomName", repository.createChatRoomDTO(name));
		rttr.addFlashAttribute("username", principal.getName());
		return "redirect:/chat/roomlist";
	}

	// 채팅방 조회
	@GetMapping("/room")
	public void getRoom(String roomId, Model model, Principal principal) {

		log.info("# get Chat Room, roomID : " + roomId + ", 입장유저" + principal.getName());

		model.addAttribute("room", repository.findRoomById(roomId));
		model.addAttribute("username", principal.getName());
	}
	
//	@GetMapping("/room/join/{roomId}")
//	public String roomJoin(Model model, @PathVariable String roomId) {
//		model.addAttribute("roomId", roomId);
//		return "/chat/roomJoin";
//	}



}
