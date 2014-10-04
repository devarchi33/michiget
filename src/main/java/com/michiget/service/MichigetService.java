package com.michiget.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.michiget.beans.Board;
import com.michiget.beans.Dept;
import com.michiget.beans.Emp;
import com.michiget.beans.Salgrade;
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
	public ModelAndView writeAction() throws Exception {
		logger.info("글쓰기 페이지");

		return new ModelAndView("write");
	}

	@Override
	public ModelAndView logout() throws Exception {
		logger.info("로그아웃 페이지");

		return new ModelAndView("logout");
	}

	@Override
	public ModelAndView contentDeleteAction(HttpServletRequest request)
			throws Exception {
		logger.info("게시글 삭제");

		int idx = 0;

		logger.info("idx : " + request.getParameter("idx"));

		if (request.getParameter("idx") != null) {
			idx = Integer.parseInt(request.getParameter("idx"));
		}

		michigetDao.contentDelete(idx);

		return new ModelAndView("redirect:board");
	}

	@Override
	public ModelAndView memberInsertAction(@ModelAttribute UserInfo userInfo,
			HttpServletRequest request) throws Exception {
		logger.info("회원가입DB접속 페이지");
		request.setCharacterEncoding("UTF-8");

		System.out.println("MichigetService : " + userInfo.getId());
		System.out.println("MichigetService : " + userInfo.getNick());

		userInfo.setRegIp(request.getRemoteAddr());
		michigetDao.insertMember(userInfo);

		return new ModelAndView("redirect:");
	}

	@Override
	public ModelAndView boardInsertAction(Board board,
			HttpServletRequest request) throws Exception {
		logger.info("게시판 글쓰기 페이지");
		request.setCharacterEncoding("UTF-8");

		System.out.println("MichigetService : " + board.getTitle());
		System.out.println("MichigetService : " + board.getWriter());

		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(
				"yyyy.MM.dd HH:mm:ss", Locale.KOREA);
		Date currentTime = new Date();
		String mTime = mSimpleDateFormat.format(currentTime);
		board.setRegdate(mTime);

		michigetDao.insertBoard(board);

		return new ModelAndView("redirect:board");
	}

	@Override
	public ModelAndView listAction(HttpServletRequest request) throws Exception {
		logger.info("회원리스트 조회");

		int page = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		ArrayList<UserInfo> userList = michigetDao.getMemberList(page);
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("userList", userList);
		mav.addObject("page", page);

		return mav;
	}

	@Override
	public ModelAndView boardAction(HttpServletRequest request)
			throws Exception {
		logger.info("게시글 리스트 조회");

		int page = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		ArrayList<Board> boardList = michigetDao.getBoardList(page);
		ModelAndView mav = new ModelAndView("board");
		mav.addObject("boardList", boardList);
		mav.addObject("page", page);

		return mav;
	}

	@Override
	public ModelAndView empAction(HttpServletRequest request) throws Exception {
		logger.info("emp 리스트 조회");

		int page = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		ArrayList<Emp> empList = michigetDao.getEmpList(page);
		ModelAndView mav = new ModelAndView("emp");
		mav.addObject("empList", empList);
		mav.addObject("page", page);

		return mav;
	}

	@Override
	public ModelAndView deptAction(HttpServletRequest request) throws Exception {
		logger.info("dept 리스트 조회");

		int page = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		ArrayList<Dept> deptList = michigetDao.getDeptList(page);
		ModelAndView mav = new ModelAndView("dept");
		mav.addObject("deptList", deptList);
		mav.addObject("page", page);

		return mav;
	}

	@Override
	public ModelAndView salgradeAction(HttpServletRequest request)
			throws Exception {
		logger.info("salgrade 리스트 조회");

		int page = 0;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		ArrayList<Salgrade> salgradeList = michigetDao.getSalgradeList(page);
		ModelAndView mav = new ModelAndView("salgrade");
		mav.addObject("salgradeList", salgradeList);
		mav.addObject("page", page);

		return mav;
	}

	@Override
	public ModelAndView contentAction(HttpServletRequest request)
			throws Exception {
		logger.info("게시글 선택 조회");

		int idx = 0;

		logger.info("idx : " + request.getParameter("idx"));

		if (request.getParameter("idx") != null) {
			idx = Integer.parseInt(request.getParameter("idx"));
		}

		ArrayList<Board> boardContentList = michigetDao.getContent(idx);

		ModelAndView mav = new ModelAndView("content");
		mav.addObject("boardContentList", boardContentList);
		mav.addObject("idx", idx);

		return mav;
	}

	@Override
	public ModelAndView loginAction(@RequestParam(value = "id") String id,
			@RequestParam(value = "pass") String pass,
			HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");

		int check_return = 0;
		System.out.println("MichigetService.java --- id : " + id);
		System.out.println("MichigetService.java --- pass : " + pass);

		UserInfo userInfo = michigetDao.getLoginId(id);
		String loginId = userInfo.getId();
		String loginPass = userInfo.getPass();

		HttpSession session = request.getSession();
		session.setAttribute("userInfo", userInfo);
		session.setAttribute("loginId", loginId);

		logger.debug("db Id = " + loginId);
		logger.debug("db Pass = " + loginPass);

		logger.debug("입력한 Id = " + id);
		logger.debug("입력한 Pass = " + pass);

		// logger.debug("userInfo = " + userInfo);
		if (loginId != null || loginId != "") {
			if (!(userInfo.getPass().equals(pass))) {

				ModelAndView mav = new ModelAndView("home");
				check_return = 2;
				mav.addObject("check", check_return);

				return mav;
			}
		} /*
		 * else if (loginPass != null || loginPass != "") { if (userInfo.getId()
		 * == null) { ModelAndView mav = new ModelAndView("home"); check_return
		 * = 1; mav.addObject("check", check_return); return mav; } }
		 */

		logger.debug("db Name = " + userInfo.getNick());
		ModelAndView mav = new ModelAndView("home");
		check_return = 0;
		mav.addObject("check", check_return);
		mav.addObject("nick", userInfo.getNick());
		return mav;
	}

}
