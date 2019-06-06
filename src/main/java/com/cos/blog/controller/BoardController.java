package com.cos.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cos.blog.model.Board;
import com.cos.blog.repository.BoardRepository;

@Controller
public class BoardController {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String findAll(Model model) throws Exception {	
		List<Board> boardList = boardRepository.findAll();
		model.addAttribute("boardList", boardList);
		return "/board/board";
	}
	
	@RequestMapping(value = "/board/{boardId}", method = RequestMethod.GET)
	public String findById(@PathVariable("boardId") int boardId,Model model) throws Exception {
		Board board = boardRepository.findById(boardId);
		model.addAttribute("board", board);
		return "/board/detail";
	}
	
	@RequestMapping(value = "/board/delete/{boardId}", method = RequestMethod.GET)
	public String deleteById(@PathVariable("boardId") int boardId) throws Exception {
		boardRepository.deleteById(boardId);
		return "redirect:/board";
	}
	
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String update(Board board, Model model) throws Exception {
		System.out.println(board.getBoardId());
		System.out.println(board.getTitle());
		System.out.println(board.getContent());
		boardRepository.updateById(board);
		return "redirect:/board";
	}
	
	@RequestMapping(value = "/board/createForm", method = RequestMethod.GET)
	public String createForm() throws Exception {
		return "/board/createForm";
	}
	
	@RequestMapping(value = "/board/create", method = RequestMethod.POST)
	public String create(Board board) throws Exception {
		boardRepository.create(board);
		return "redirect:/board";
	}
	
}
