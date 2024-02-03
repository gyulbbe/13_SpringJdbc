package com.feb.jdbc.dao.impl;

import java.util.HashMap;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.feb.jdbc.dao.MemberDao;
import com.feb.jdbc.entity.Member;
import com.feb.jdbc.entity.MemberRowMapper;

public class MemberDaoImpl extends JdbcDaoSupport implements MemberDao {

	@Override
	public HashMap<String, Object> findMember(String memberId) {
		String sql = "select * from lecture.member where member_id = '" + memberId + "'";
		HashMap<String, Object> list = (HashMap<String, Object>) 
				getJdbcTemplate().queryForObject(sql, HashMap.class);
		
		return list;
	}
	
	public Member findMember2(String memberId) {
		String sql = "select member_idx, member_id, passwd, email, join_dtm from lecture.member where member_id = '" + memberId + "'";
		return getJdbcTemplate().queryForObject(sql, new MemberRowMapper());
	}
	
}
