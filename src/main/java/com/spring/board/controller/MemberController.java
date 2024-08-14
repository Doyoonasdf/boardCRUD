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
import com.spring.board.domain.MemberDTO;
import com.spring.board.domain.boardDTO;
import com.spring.board.service.BoardService;
import com.spring.board.service.MemberService;


@Controller
public class MemberController {
	 @Autowired
	    private MemberService memberService;
	 
	 
	//회원가입 폼 이동
	@GetMapping("/member/register")
	public String getRegister() {
		return "member/register";
	}
	
	//회원가입 등록 처리
	@PostMapping("/member/SaveRegister")
	public String SaveRegister(@RequestParam Map<String, Object> memberInfo,
			Model model)throws Exception {
		try {
			String id = (String) memberInfo.get("id");
			String pwd = (String)memberInfo.get("pwd");
			String name = (String) memberInfo.get("name");
			
			MemberDTO mem = new MemberDTO();
			mem.setId(id);
			mem.setPwd(pwd);
			mem.setName(name);
			
			memberService.insertService(mem);
			
		}catch(Exception e ) {
			
		}
		return "redirect:/board/list";
	}
	
	//로그인 폼 이동
	@GetMapping("/member/login")
	public String getLogin() {
		return "member/login";
	}
}