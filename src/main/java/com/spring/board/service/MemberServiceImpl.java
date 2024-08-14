package com.spring.board.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.MemberDAO;
import com.spring.board.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDAO memberDao;
	
	public int insertService(MemberDTO mem) throws Exception{
		return memberDao.insert(mem);
	}

	
}
