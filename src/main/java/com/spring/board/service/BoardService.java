package com.spring.board.service;

import java.util.*;
import com.spring.board.domain.boardDTO;

public interface BoardService {
	List<boardDTO> getList() throws Exception;
	int insertService(boardDTO dto) throws Exception;
	boardDTO detailView(int bno) throws Exception; //단일행 반환이니깐
	int updateBoard (boardDTO dto) throws Exception;
	int deleteBoard (boardDTO dto) throws Exception;
	
	//test//test
}
