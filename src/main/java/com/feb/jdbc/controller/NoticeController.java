package com.feb.jdbc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feb.jdbc.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/notice.do")
	public ModelAndView asdf(@RequestParam HashMap<String, String> params) {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.write(params);
		mv.addObject("resultCode", result);
		if (result == 1) {
			mv.addObject("resultMsg", "등록 성공");
		} else {
			mv.addObject("resultMsg", "등록 실패");
		}
		return mv;
	}
}
