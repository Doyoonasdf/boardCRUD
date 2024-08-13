package com.spring.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.common.Pagination;
import com.spring.board.domain.boardDTO;
import com.spring.board.service.BoardService;


@Controller
public class BoardController {
	
//	private Logger logger = Logger.getLogger(BoardController.class);
	
//	private Logger logger = LogManager.getLogger("egovLogger");  
	private Logger logger = LogManager.getLogger(BoardController.class);  
	
	@Autowired
	private BoardService boardService;
	
//	게시판 목록
	@GetMapping("/board/list")
	public String getBoardList(
		    @RequestParam(required = false) String searchType,
		    @RequestParam(required = false) String keyword,
			@RequestParam Map<String, Object> pageInfo,
			Model model) throws Exception {
		try {	
			//전체 게시글 개수
			
		    // 페이지 번호와 범위 가져오기
	        int page = pageInfo.get("page") != null ? Integer.parseInt((String) pageInfo.get("page")) : 1;
	        int range = pageInfo.get("range") != null ? Integer.parseInt((String) pageInfo.get("range")) : 1;


	        int listCnt = boardService.getBoardListCnt(searchType, keyword);
			//Pagination 객체생성 및 페이징 정보 셋팅
			Pagination pagination = new Pagination();
			pagination.pageInfo(page,range,listCnt);
	        System.out.println("★★★★★Page Info: " + pageInfo);
	        System.out.println("컨트롤러Start Page: " + pagination.getStartPage());
	        System.out.println("컨트롤러End Page: " + pagination.getEndPage());
			// 게시판 목록 가져오기
	        List<boardDTO> boardList = boardService.getList(pagination, searchType, keyword);

			model.addAttribute("pagination", pagination);
			model.addAttribute("boardList", boardList);
			model.addAttribute("searchType", searchType);
			model.addAttribute("keyword", keyword);
			
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
	public String getBoardRead (@RequestParam("IDX") int bno, 
			 @RequestParam(required = false) int page,
			Model model) {
		try {
			boardDTO boardList = boardService.detailView(bno);
			model.addAttribute("boardList",boardList);
			model.addAttribute("page",page);
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