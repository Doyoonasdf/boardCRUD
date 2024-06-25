package com.spring.board.dao;


import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.boardDTO;

@Repository
public class boardDAOImpl implements boardDAO {
	@Autowired
	private SqlSession session;
	
	private static String namespace = "com.spring.board.dao.boardDAO.";
	
    @Override
    public List<boardDTO> selectAll() throws Exception {
        return session.selectList(namespace+"selectAll");
    }
	
}