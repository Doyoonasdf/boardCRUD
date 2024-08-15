package com.spring.board.dao;

import java.util.*;
import com.spring.board.*;
import com.spring.board.common.Pagination;
import com.spring.board.domain.MemberDTO;
import com.spring.board.domain.boardDTO;


public interface MemberDAO {	
	//로그인여부판단
	MemberDTO getMember(String id) throws Exception;
	//회원가입 
	int insert(MemberDTO mem) throws Exception;
	
	

}
