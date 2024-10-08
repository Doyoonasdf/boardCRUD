package com.spring.board.dao;

import java.util.*;
import com.spring.board.*;
import com.spring.board.common.Pagination;
import com.spring.board.domain.boardDTO;


public interface boardDAO {
	List<boardDTO> selectAll(Pagination pagination, String searchType, String keyword) throws Exception;
	
	int insert(boardDTO dto) throws Exception;
	boardDTO detailView(int bno) throws Exception;
	int updateBoard(boardDTO dto)throws Exception;
	int deleteBoard(boardDTO dto) throws Exception;
	
	public int getBoardListCnt(String searchType, String keyword) throws Exception;     //총 게시글개수 확인
	
	int updateViewCnt(int bno) throws Exception;
}
