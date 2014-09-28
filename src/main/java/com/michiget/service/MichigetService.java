package com.michiget.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.michiget.beans.Board;
import com.michiget.beans.UserInfo;
import com.michiget.controller.MichigetController;
import com.michiget.model.MichigetDao;

@Service
public class MichigetService implements MichigetController {

	@Autowired
	private MichigetDao michigetDao;

	private static final Logger logger = LoggerFactory
			.getLogger(MichigetService.class);

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
	public ModelAndView logout() throws Exception {
		logger.info("로그아웃 페이지");

		return new ModelAndView("logout");
	}

	@Override
	public ModelAndView memberAction(@ModelAttribute UserInfo userInfo,
			HttpServletRequest request) throws Exception {
		logger.info("회원가입DB접속 페이지");
		request.setCharacterEncoding("UTF-8");

		System.out.println(userInfo.getId());
		System.out.println(userInfo.getNick());

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

	@Override
	public ModelAndView loginAction(@RequestParam(value = "id") String id,
			@RequestParam(value = "pass") String pass,
			HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		int check_return = 0;
		System.out.println(id);
		System.out.println(pass);
		UserInfo temp = michigetDao.getId(id);

		logger.debug("db Id = " + temp.getId());
		logger.debug("db Pass = " + temp.getPass());

		logger.debug("입력한 Id = " + id);
		logger.debug("입력한 Pass = " + pass);

		// logger.debug("temp = " + temp);
		if (temp.getId() != null || temp.getId() != "") {
			if (!(temp.getPass().equals(pass))) {
				ModelAndView mav = new ModelAndView("home");
				check_return = 2;
				mav.addObject("check", check_return);
				return mav;
			}
		} else if (temp == null) {
			ModelAndView mav = new ModelAndView("home");
			check_return = 1;
			mav.addObject("check", check_return);
			return mav;
		}

		logger.debug("db Name = " + temp.getNick());
		ModelAndView mav = new ModelAndView("home");
		check_return = 0;
		mav.addObject("check", check_return);
		mav.addObject("nick", temp.getNick());
		return mav;
	}

	@Override
	@RequestMapping("/board")
	public ModelAndView boardAction() throws Exception {
		logger.info("게시글 리스트 조회");

		ArrayList<Board> boardList = michigetDao.getBoardList();
		ModelAndView mav = new ModelAndView("board");
		mav.addObject("boardList", boardList);

		return mav;
	}
}
