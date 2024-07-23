package com.spring.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.domain.boardDTO;
import com.spring.board.service.BoardService;


@Controller
public class BoardController {
	
//	private Logger logger = Logger.getLogger(BoardController.class);
	
	private Logger logger = LogManager.getLogger("egovLogger");  
	
	@Autowired
	private BoardService boardService;
	
//	게시판 목록
	@GetMapping("/board/list")
	public String getBoardList(Model model) throws Exception {
		try {
			List<boardDTO> boardList = boardService.getList();
			logger.info("info-boardList : ");
			logger.debug("debug-boardList : ");
			logger.warn("warn-boardList : ");
			logger.error("error-boardList : ");
			logger.info(boardList);
			model.addAttribute("boardList", boardList);
		}catch(Exception e ) {
			e.printStackTrace();
			model.addAttribute("message","Error occurred while retrieving board list.");
		}
		return "boardList";
	}
	

	// 글등록 폼 이동
	@GetMapping("/board/write")
	public String getBoardWrite() {
		return "boardWrite";
	}
	
//	글등록 처리 
	@PostMapping("/board/insert")
	public String Boardwrite(HttpServletRequest request, Model model) {
		try {
			boardDTO dto = new boardDTO();
			
			dto.setContent(request.getParameter("content"));
			dto.setWriter(request.getParameter("writer"));
			dto.setTitle(request.getParameter("title"));
			
			boardService.insertService(dto);
		}catch(Exception e ) {
			e.printStackTrace();
			model.addAttribute("message","Error occurred while retrieving board insert.");
		}

		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/read", method = RequestMethod.GET)
	public String getBoardRead (@RequestParam("IDX") int bno, Model model) {
		try {
			boardDTO boardList = boardService.detailView(bno);
			model.addAttribute("boardList",boardList);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		return "boardRead";
	}
	
	@RequestMapping(value="/board/updateForm", method= RequestMethod.GET)
	public String updateBoardForm (@RequestParam("IDX") int bno,Model model) {
		try {
			boardDTO boardList = boardService.detailView(bno);
			model.addAttribute("boardList",boardList);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		return "boardUpdate";
	}

	@RequestMapping(value="/board/update", method= RequestMethod.POST)
	public String updateBoard (@ModelAttribute boardDTO board, Model model ) {
		
		System.out.println("/board/update 진입");
		
		try {
			boardService.updateBoard(board);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		return  "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/delete", method= RequestMethod.GET)
	public String deleteBoard (@RequestParam("IDX") int bno, @RequestParam("writer") String writer  ) {

		try {
	        boardDTO board = new boardDTO();
	        board.setBno(bno);
	        board.setWriter(writer);
			boardService.deleteBoard(board);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		return  "redirect:/board/list";
	}
}