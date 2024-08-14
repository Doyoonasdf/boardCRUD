package com.spring.board.dao;

import java.util.*;
import com.spring.board.*;
import com.spring.board.common.Pagination;
import com.spring.board.domain.MemberDTO;
import com.spring.board.domain.boardDTO;


public interface MemberDAO {	
	int insert(MemberDTO mem) throws Exception;

}
