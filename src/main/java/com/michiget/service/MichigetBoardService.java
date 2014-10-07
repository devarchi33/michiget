package com.michiget.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.michiget.beans.Board;
import com.michiget.beans.Dept;
import com.michiget.beans.Emp;
import com.michiget.beans.Salgrade;
import com.michiget.controller.MichigetBoardController;
import com.michiget.model.MichigetDao;

@Service
public class MichigetBoardService implements MichigetBoardController {
	@Autowired
	private MichigetDao michigetDao;

	private static final Logger logger = LoggerFactory
			.getLogger(MichigetBoardService.class);

	@Override
	public ModelAndView writeAction() throws Exception {
		logger.info("글쓰기 페이지");

		return new ModelAndView("write");
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
}
