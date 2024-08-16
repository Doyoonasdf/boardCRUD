package com.spring.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@PostMapping("/member/login")
	public String PostLogin(
			@RequestParam Map<String, Object> memberInfo, 
			HttpSession session) throws Exception {
	    try {
	        String id = (String) memberInfo.get("id");
	        String pwd = (String) memberInfo.get("pwd");
	        
	        MemberDTO member = memberService.getMember(id);
	        if (member == null) {
	        	System.out.println("User not found");
	            return "redirect:/member/login";
	        } else { // id는 맞음 
	        	
	            if (!member.getPwd().equals(pwd)) { // 비밀번호는 틀림
	            	 System.out.println("Password does not match");
	            	return "redirect:/member/login";
	            } else { // 비밀번호도 맞음 
	                session.setAttribute("MEMBER_session", member);
	                System.out.println("User logged in and session created: " + session.getAttribute("MEMBER_session"));
	                return "redirect:/board/list";
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); 
	        //        return "error/500";
	    }
	    return "redirect:/member/login";

	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		   session.invalidate();
		   
		    // 세션 무효화 후 세션 확인
		    try {
		        System.out.println("Session after invalidate: " + session.getAttribute("MEMBER_session")); // 무효화된 세션에서 정보를 가져오려 시도
		    } catch (IllegalStateException e) {
		        System.out.println("Session is already invalidated."); // 세션이 이미 무효화된 경우
		    }
		    
		    
	        return "redirect:/member/login";
	}
	
}