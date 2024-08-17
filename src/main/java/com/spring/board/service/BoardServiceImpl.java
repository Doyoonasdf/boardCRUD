package com.spring.board.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.common.Pagination;
import com.spring.board.dao.boardDAO;
import com.spring.board.domain.boardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	boardDAO boardDao;
	
	public List<boardDTO> getList(Pagination pagination, String searchType, String keyword) throws Exception {
		return boardDao.selectAll(pagination, searchType, keyword);
	}
	
	public int insertService(boardDTO dto) throws Exception{
		return boardDao.insert(dto);
	}
	
	public boardDTO detailView (int bno) throws Exception {
		boardDao.updateViewCnt(bno);
		return boardDao.detailView(bno);
	}
	
	public int updateBoard (boardDTO dto) throws Exception{
		return boardDao.updateBoard(dto);
	}
	
	public int deleteBoard (boardDTO dto) throws Exception{
		return boardDao.deleteBoard(dto);
	}

	@Override
	public int getBoardListCnt(String searchType, String keyword) throws Exception {
		return boardDao.getBoardListCnt(searchType, keyword);
	}
	
	
}