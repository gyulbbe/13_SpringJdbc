package com.feb.jdbc.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feb.jdbc.entity.Member;
import com.feb.jdbc.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@ResponseBody
	@RequestMapping("/findMember.do")
	public String join(@RequestParam HashMap<String, String> params) {
		String memberId = params.get("memberId");
		Member member = memberService.findMember2(memberId);
//		HashMap<String, Object> map = memberService.findMember(memberId);
		return member.getMemberId();
	}
}












