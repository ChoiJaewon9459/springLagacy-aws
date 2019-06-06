package com.cos.blog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.Board;

@Repository
public class BoardRepository {
	
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "com.cos.blog.model.Board";

	public List<Board> findAll() throws Exception {
		List<Board> boardList = session.selectList(NAMESPACE+".findAll");
		return boardList;
	}
	
	public Board findById(int boardId) throws Exception {
		Board board = session.selectOne(NAMESPACE+".findById", boardId);
		return board;
	}
	
	public void deleteById(int boardId) throws Exception {
		session.delete(NAMESPACE+".deleteById", boardId);
	}
	
	public void updateById(Board board) throws Exception {
		session.delete(NAMESPACE+".updateById", board);
	}
	
	public void create(Board board) throws Exception {
		session.insert(NAMESPACE+".create", board);
	}
}
