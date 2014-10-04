package com.michiget.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.michiget.beans.Board;
import com.michiget.beans.Dept;
import com.michiget.beans.Emp;
import com.michiget.beans.Salgrade;
import com.michiget.beans.UserInfo;

@Repository
public class MichigetDao extends SqlMapClientDaoSupport {

	static Logger logger = LoggerFactory.getLogger(MichigetDao.class);

	@Resource(name = "sqlMapClient")
	public void setSuperSqlMapClient(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<UserInfo> getMemberList(int page) throws SQLException {
		return (ArrayList<UserInfo>) getSqlMapClient().queryForList(
				"getMemberList", null, page, 8);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Board> getBoardList(int page) throws SQLException {
		return (ArrayList<Board>) getSqlMapClient().queryForList(
				"getBoardList", null, page, 8);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Emp> getEmpList(int page) throws SQLException {
		return (ArrayList<Emp>) getSqlMapClient().queryForList("getEmpList",
				null, page, 8);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Dept> getDeptList(int page) throws SQLException {
		return (ArrayList<Dept>) getSqlMapClient().queryForList("getDeptList",
				null, page, 8);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Salgrade> getSalgradeList(int page) throws SQLException {
		return (ArrayList<Salgrade>) getSqlMapClient().queryForList("getSalgradeList",
				null, page, 8);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Board> getContent(int idx) throws SQLException {
		return (ArrayList<Board>) getSqlMapClient().queryForList("getContent",
				idx);
	}

	public void insertMember(UserInfo userInfo) throws SQLException {
		getSqlMapClient().insert("insertMember", userInfo);
	}

	public void insertBoard(Board board) throws SQLException {
		getSqlMapClient().insert("insertBoard", board);
	}

	public void contentDelete(int idx) throws SQLException {
		getSqlMapClient().delete("contentDelete", idx);
	}

	public UserInfo getLoginId(String id) throws SQLException {
		return (UserInfo) getSqlMapClient().queryForObject("getLoginId", id);
	}

}