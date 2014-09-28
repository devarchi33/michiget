package com.michiget.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.michiget.beans.UserInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public interface MichigetController {
	
	@RequestMapping("/")
	public abstract ModelAndView home() throws Exception;
	
	@RequestMapping("/join")
	public abstract ModelAndView joinAction() throws Exception;
	
	//(value="/member", method=RequestMethod.GET)
	@RequestMapping(value="/member", method=RequestMethod.GET)
	public abstract ModelAndView memberAction(@ModelAttribute UserInfo userInfo, HttpServletRequest request) throws Exception;
	
	@RequestMapping("/list")
	public abstract ModelAndView listAction() throws Exception;
	
}
