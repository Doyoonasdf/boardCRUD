package com.spring.board.service;

import java.util.*;

import com.spring.board.common.Pagination;
import com.spring.board.domain.boardDTO;

public interface BoardService {
	List<boardDTO> getList(Pagination pagination) throws Exception;
	int insertService(boardDTO dto) throws Exception;
	boardDTO detailView(int bno) throws Exception; //단일행 반환이니깐
	int updateBoard (boardDTO dto) throws Exception;
	int deleteBoard (boardDTO dto) throws Exception;
	
    public int getBoardListCnt()throws Exception;//총 게시글개수 확인
	
}
