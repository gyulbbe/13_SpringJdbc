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
	
	//사용자 아이디와 이메일로 찾음
	public int findMember(String memberId, String email);
	
	public int updatePasswd(String passwd, String memberId, String email);
}
