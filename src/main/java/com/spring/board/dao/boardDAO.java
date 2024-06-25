package com.spring.board.dao;

import java.util.*;
import com.spring.board.*;
import com.spring.board.domain.boardDTO;


public interface boardDAO {
	List<boardDTO> selectAll() throws Exception;
	
}