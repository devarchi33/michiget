package com.michiget.service;
import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.michiget.model.MichigetDao;
import com.michiget.controller.*;
import com.michiget.beans.UserInfo;

@Service
public class MichigetService implements MichigetController{
	
	@Autowired
	private MichigetDao michigetDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MichigetService.class);
	
	@Override
	public ModelAndView home() throws Exception {
		logger.info("home 로그");
		
		return new ModelAndView("home");
	}
	@Override
	public ModelAndView joinAction() throws Exception {
		logger.info("회원가입 페이지");
		
		return new ModelAndView("join");
	}
	@Override
	public ModelAndView memberAction(@ModelAttribute UserInfo userInfo, HttpServletRequest request) throws Exception {
		logger.info("회원가입DB접속 페이지");
		
		userInfo.setRegIp(request.getRemoteAddr());
		
		michigetDao.insertMember(userInfo);
		
		return new ModelAndView("redirect:");	
	}
	@Override
	public ModelAndView listAction() throws Exception {
		logger.info("회원리스트 조회");
				
		ArrayList<UserInfo> userList = michigetDao.getMemberList();
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("userList", userList);
	
	    return mav;
	}
}

