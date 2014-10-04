package com.michiget.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.michiget.beans.Board;
import com.michiget.beans.UserInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public interface MichigetController {

	@RequestMapping("/")
	public ModelAndView home() throws Exception;

	@RequestMapping("/join")
	public ModelAndView joinAction() throws Exception;

	@RequestMapping("/write")
	public ModelAndView writeAction() throws Exception;

	@RequestMapping("/logout")
	public ModelAndView logout() throws Exception;
	
	@RequestMapping("/b_delete")
	public ModelAndView boardListDelete() throws Exception;

	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public ModelAndView memberInsertAction(@ModelAttribute UserInfo userInfo,
			HttpServletRequest request) throws Exception;

	@RequestMapping(value = "/board", method = RequestMethod.POST)
	public ModelAndView boardInsertAction(@ModelAttribute Board board,
			HttpServletRequest request) throws Exception;

	@RequestMapping("/list")
	public ModelAndView listAction(HttpServletRequest request) throws Exception;

	@RequestMapping("/board")
	public ModelAndView boardAction(HttpServletRequest request) throws Exception;
	
	@RequestMapping("/content")
	public ModelAndView contentAction(
			HttpServletRequest request) throws Exception;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginAction(@RequestParam(value = "id") String id,
			@RequestParam(value = "pass") String pass,
			HttpServletRequest request) throws Exception;

	

}
