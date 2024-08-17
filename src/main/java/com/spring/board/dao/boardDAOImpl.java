package com.spring.board.dao;


import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.common.Pagination;
import com.spring.board.domain.boardDTO;

@Repository
public class boardDAOImpl implements boardDAO {
	@Autowired
	private SqlSession session;
	
	private static String namespace = "com.spring.board.dao.boardDAO.";
	
    @Override
    public List<boardDTO> selectAll(Pagination pagination, String searchType, String keyword) throws Exception {
        Map<String, Object> params = new HashMap<>();
        //params.put("pagination", pagination);
        params.put("startList", pagination.getStartList());
        params.put("listSize", pagination.getListSize());
        params.put("searchType", searchType);
        params.put("keyword", keyword);
    	return session.selectList(namespace+"selectAll",params);
    }
    
    public int insert(boardDTO dto) throws Exception {
    	return session.insert(namespace+"insert",dto);
    }
    
    public boardDTO detailView(int bno) throws Exception {
    	return session.selectOne(namespace+"detailView",bno);
    }
    
    public int updateBoard(boardDTO board) throws Exception{
    	return session.update(namespace+"updateBoard",board);
    }
	
    public int deleteBoard(boardDTO dto) throws Exception{
    	return session.delete(namespace+"deleteBoard",dto);
    }

    //총 게시글개수 확인
	@Override
	public int getBoardListCnt(String searchType, String keyword) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("searchType", searchType);
		params.put("keyword", keyword);
		return session.selectOne(namespace+"getBoardListCnt",params);
	}
	
	public int updateViewCnt(int bno) throws Exception{
		return session.update(namespace+"updateViewCnt", bno);
	};
    
    
}