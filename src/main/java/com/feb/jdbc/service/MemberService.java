package com.feb.jdbc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.feb.jdbc.dao.MemberDao;
import com.feb.jdbc.dto.EmailDto;
import com.feb.jdbc.entity.Member;
import com.feb.jdbc.util.EmailUtil;
import com.feb.jdbc.util.Sha512Encoder;

public class MemberService {
	
	private MemberDao memberDao;
	private EmailUtil emailUtil;

	public void setEmailUtil(EmailUtil emailUtil) {
		this.emailUtil = emailUtil;
	}
	
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
	
	public int join(HashMap<String, String> params) {
		return memberDao.join(params);
	}
	
	public ArrayList<Member> memberList(HashMap<String, Object> params) {
		return memberDao.memberList(params);
	}
	
	public boolean findPasswd(HashMap<String, String> params) {
		int result = memberDao.findMember(
				params.get("memberId"), params.get("email"));
		System.out.println("result:" + result);
		//ID email 맞는 사용자는 무조건 1명이어야 함.
		if(result == 1) {
			//to do 이메일로 임시비밀번호 발송
			//랜덤한 문자열 생성
			String uuid = UUID.randomUUID().toString();
			System.out.println("newPw1:" + uuid);
			//필요없는 문자 제거
			String newPw = uuid.replaceAll("-","");
			System.out.println("newPw2:" + newPw);
			//암호화
			String encodePw= Sha512Encoder.getInstance().getSecurePassword(newPw);
			System.out.println("newPw3:" + encodePw);
			
			EmailDto emailDto = new EmailDto();
			emailDto.setFrom("admin@gyeol.com");
			emailDto.setReceiver(params.get("email"));
			emailDto.setSubject("임시 비밀번호를 전송해드립니다.");
			emailDto.setText(newPw);
			//db데이터 수정은 가장 마지막에! 
			try {
				//이메일 발송 실패 시 예외처리
			emailUtil.sendMail(emailDto);
			}catch(Exception e) {
				e.printStackTrace();
			}
			//to-do 임시비밀번호로 업데이트
			// 사용자 테이블에 비밀번호 칼럼 수정하는 메서드 작성
			// interface > impl > service
			// update lecture.member set passwd = ?
			// where member_id = ? and email = ?
			int updateResult = memberDao.updatePasswd(newPw, params.get("memberId"), params.get("email"));
			
			return updateResult == 1;
		}
		return false;
	}
}
