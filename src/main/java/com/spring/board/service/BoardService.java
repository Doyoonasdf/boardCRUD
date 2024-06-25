package com.spring.board.service;

import java.util.*;
import com.spring.board.domain.boardDTO;

public interface BoardService {
	List<boardDTO> getList() throws Exception;
}