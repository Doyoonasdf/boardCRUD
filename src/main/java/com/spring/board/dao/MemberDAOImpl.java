package com.spring.board.dao;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.*;
import com.spring.board.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession session;
	
	private static String namespace = "com.spring.board.dao.MemberDAO.";
	
	public MemberDTO getMember(String id) throws Exception{
		return session.selectOne(namespace+"getMember",id);
	}
	
	public int insert(MemberDTO mem) throws Exception{
		return session.insert(namespace+"insert",mem);
	}

}
