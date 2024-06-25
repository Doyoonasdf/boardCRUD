package com.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.board.domain.boardDTO;
import com.spring.board.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/list")
	public String getBoardList(Model model) {
		try {
			List<boardDTO> boardList = boardService.getList();
			model.addAttribute("boardList", boardList);
		}catch(Exception e ) {
			e.printStackTrace();
			model.addAttribute("message","Error occurred while retrieving board list.");
		}
		return "boardList";
	}
	
	
}