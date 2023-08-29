package com.sero.sts.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sero.sts.dao.LoginDAO;
import com.sero.sts.service.QnaService;
import com.sero.sts.vo.MemberVO;
import com.sero.sts.vo.QnaVO;


@Controller
@RequestMapping("/qnas")
public class UserQnaController  {

	@Autowired
	QnaService qnaService;
	
	@Autowired
	LoginDAO loginDAO;
	
	@RequestMapping(value = "/qnaList", method = RequestMethod.GET)
	public String qnaList(Model model, HttpServletRequest request) { // qna 리스트 불러오기
		HttpSession session = request.getSession();
		
		
//		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		MemberVO loginUser = new MemberVO();
		loginUser.setId("one");
		System.out.println(loginUser);
		session.setAttribute("id", "one");
		
		if (loginUser == null)
			return "redirect:/members/loginForm";
		else {
			List<QnaVO> qnaList = qnaService.qnaList(loginUser.getId());
			model.addAttribute("qnaList", qnaList);
			return "qna/qnaList";
		}
	
	}
	
	@RequestMapping(value = "/qnaWriteForm", method = RequestMethod.GET)
	private String qnaWriteForm(HttpServletRequest request) { // qna 작성 폼을 불러오기

		HttpSession session = request.getSession();
		
		
//		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		MemberVO loginUser = new MemberVO();
		loginUser.setId("one");
		System.out.println(loginUser);
		session.setAttribute("id", "one");
		
		if (loginUser == null)
			return "redirect:/members/loginForm";
		else {
			return "qna/qnaWrite";
		}
	}
	
	@RequestMapping(value = "/qnaWrite", method = RequestMethod.POST)
	public String qnaWrite(@RequestParam("subject") String subject, @RequestParam("content") String content, Model model, HttpServletRequest request) { // 작성한 qna 내용을 등록

		HttpSession session = request.getSession();
		
		
//		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		MemberVO loginUser = new MemberVO();
		loginUser.setId("one");
		System.out.println(loginUser);
		session.setAttribute("id", "one");
		
		if (loginUser == null) {
			return "redirect:/members/loginForm";
		} else {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setSubject(subject);
			qnaVO.setContent(content);
			qnaService.qnaWrite(qnaVO,loginUser.getId());
			
		}
		return "redirect:/qnas/qnaList";
	}
	
	@RequestMapping(value = "/qnaView", method = RequestMethod.GET)
	private String qnaView(@RequestParam("qseq") String qseq, Model model, HttpServletRequest request) { // qna 상세 페이지

		HttpSession session = request.getSession();
		
		
//		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		MemberVO loginUser = new MemberVO();
		loginUser.setId("one");
		System.out.println(loginUser);
		session.setAttribute("id", "one");
		
		if (loginUser == null)
			return "redirect:/members/loginForm";
		else{

			QnaVO qnaVO = qnaService.qnaView(Integer.parseInt(qseq));
			model.addAttribute("qnaVO", qnaVO);
			return "qna/qnaView";		
		}

	}

}
