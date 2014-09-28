package com.michiget.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.michiget.beans.Board;
import com.michiget.beans.UserInfo;

@Repository
public class MichigetDao extends SqlMapClientDaoSupport {

	@Resource(name = "sqlMapClient")
	public void setSuperSqlMapClient(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<UserInfo> getMemberList() throws SQLException {
		return (ArrayList<UserInfo>) getSqlMapClient().queryForList(
				"getMemberList", null);
	}
	
	public ArrayList<Board> getBoardList() throws SQLException {
		return (ArrayList<Board>) getSqlMapClient().queryForList(
				"getBoardList", null);
	}

	public void insertMember(UserInfo userinfo) throws SQLException {
		getSqlMapClient().insert("insertMember", userinfo);
	}

	public UserInfo getId(String id) throws SQLException {
		return (UserInfo) getSqlMapClient().queryForObject("getId", id);
	}
}