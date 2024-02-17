package com.feb.jdbc.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.feb.jdbc.dao.LoginDao;
import com.feb.jdbc.entity.Member;
import com.feb.jdbc.entity.MemberRowMapper;

public class LoginDaoImpl extends JdbcDaoSupport implements LoginDao{

	@Override
	public Member login(String memberId) {
		String sql = "select count(1) from " + "lecture.member where member_id = ? and email = ?";
		//and passwd = 이런 형식은 하면 안됨
		Member member = getJdbcTemplate().queryForObject(sql, new Object[] {memberId}, new MemberRowMapper());
		return member;
	}
}