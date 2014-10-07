package com.michiget.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.michiget.beans.Board;

@Controller
public interface MichigetBoardController {

	@RequestMapping("/write")
	public ModelAndView writeAction() throws Exception;

	@RequestMapping("/contentDelete")
	public ModelAndView contentDeleteAction(HttpServletRequest request)
			throws Exception;

	@RequestMapping(value = "/board", method = RequestMethod.POST)
	public ModelAndView boardInsertAction(@ModelAttribute Board board,
			HttpServletRequest request) throws Exception;

	@RequestMapping("/board")
	public ModelAndView boardAction(HttpServletRequest request)
			throws Exception;

	@RequestMapping("/emp")
	public ModelAndView empAction(HttpServletRequest request) throws Exception;

	@RequestMapping("/dept")
	public ModelAndView deptAction(HttpServletRequest request) throws Exception;

	@RequestMapping("/salgrade")
	public ModelAndView salgradeAction(HttpServletRequest request)
			throws Exception;

	@RequestMapping("/content")
	public ModelAndView contentAction(HttpServletRequest request)
			throws Exception;
}
