package com.sero.sts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sero.sts.service.AdminService;
import com.sero.sts.vo.QnaVO;

@RequestMapping("/admin")
@Controller
public class AdminQnaController {

	@Autowired
	AdminService adminService;

	// 관리자 qna 리스트
	@RequestMapping(value = "/qnaPage", method = RequestMethod.GET)
	public String qnaPage(Model model) throws Exception {
		List<QnaVO> qnaList = adminService.qnaList();
		model.addAttribute("qnaList", qnaList);

		return "admin/qna/qnaList";
	}

	// 관리자 qna 상세 페이지
	@RequestMapping(value = "/qnaDetail", method = RequestMethod.POST)
	public String qnaDetail(@RequestParam("qseq") String qseq, Model model) throws Exception {
		int qseqs = Integer.parseInt(qseq);
		QnaVO qnaVO = adminService.qnaDetail(qseqs);

		model.addAttribute("qnaVO", qnaVO);
		return "admin/qna/qnaDetail";
	}	

	// 관리자 qna 수정
	@RequestMapping(value = "/qnaModify", method = RequestMethod.GET)
	public String qnaModify(@RequestParam("qseq") String qseq, @RequestParam("reply") String reply, Model model)
			throws Exception {
		int qseqs = Integer.parseInt(qseq);
		int qnaVO = adminService.qnaUpdate(qseqs, reply);
        model.addAttribute("qnaVO",qnaVO);
		return "redirect:/admin/qnaPage";
	}

}
