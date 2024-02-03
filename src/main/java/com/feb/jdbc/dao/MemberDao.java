package com.feb.jdbc.dao;

import java.util.HashMap;

import com.feb.jdbc.entity.Member;

public interface MemberDao {
	
	public HashMap<String, Object> findMember(String memberId);
	public Member findMember2(String memberId);
}
