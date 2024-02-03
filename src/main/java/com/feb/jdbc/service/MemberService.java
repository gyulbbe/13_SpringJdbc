package com.feb.jdbc.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.feb.jdbc.dao.MemberDao;
import com.feb.jdbc.entity.Member;

public class MemberService {
	
	private MemberDao memberDao;
	
	public MemberService() {}
	
	public MemberService(MemberDao memberDao) {
		System.out.println(memberDao);
		this.memberDao = memberDao;
	}
	
	public HashMap<String, Object> findMember(String memberId) {
		return memberDao.findMember(memberId);
	}
	
	public Member findMember2(String memberId) {
		return memberDao.findMember2(memberId);
	}

}
