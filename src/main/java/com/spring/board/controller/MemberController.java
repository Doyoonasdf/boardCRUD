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
public class MemberController {
	
	//회원가입 폼 이동
	@GetMapping("/member/register")
	public String getRegister() {
		return "member/register";
	}
	
	
	
	@GetMapping("/member/login")
	public String getLogin() {
		return "member/login";
	}
}