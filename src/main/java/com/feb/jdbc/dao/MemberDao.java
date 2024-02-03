package com.feb.jdbc.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.feb.jdbc.entity.Member;

public interface MemberDao {
	
	public HashMap<String, Object> findMember(String memberId);
	public Member findMember2(String memberId);
	
	public ArrayList<Member> memberList(HashMap<String, Object> params);

	public int join(HashMap<String, String> params);
	
	public int checkId(HashMap<String, String> params);
	
	public HashMap<String, Object> getMemberById(HashMap<String, String> params);
}
