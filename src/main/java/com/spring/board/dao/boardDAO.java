package com.spring.board.dao;

import java.util.*;
import com.spring.board.*;
import com.spring.board.domain.boardDTO;


public interface boardDAO {
	List<boardDTO> selectAll() throws Exception;
	
	int insert(boardDTO dto) throws Exception;
	
	boardDTO detailView(int bno) throws Exception;
	int updateBoard(boardDTO dto)throws Exception;
	int deleteBoard(boardDTO dto) throws Exception;
}
