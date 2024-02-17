package com.feb.jdbc.dao;

import com.feb.jdbc.entity.Member;

public interface LoginDao {
	
	public Member login(String memberId);
}
