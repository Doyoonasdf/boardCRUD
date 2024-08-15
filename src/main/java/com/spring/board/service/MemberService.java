package com.spring.board.service;

import java.util.*;


import com.spring.board.domain.MemberDTO;


public interface MemberService {
	
	MemberDTO getMember(String id)throws Exception;
	int insertService(MemberDTO mem) throws Exception;

	
}
