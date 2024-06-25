package com.spring.board.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.board.dao.boardDAO;
import com.spring.board.domain.boardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	boardDAO boardDao;
	
	public List<boardDTO> getList() throws Exception {
		return boardDao.selectAll();
	}
	
	
}