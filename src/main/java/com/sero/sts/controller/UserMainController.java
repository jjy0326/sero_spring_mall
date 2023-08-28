package com.sero.sts.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sero.sts.service.MainService;
import com.sero.sts.vo.ProductVO;

@Controller("mainController")
public class UserMainController {
	public UserMainController() {
		System.out.println("컨트롤러 ");
	}
	
	@Autowired
	private MainService mainService;

	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public ModelAndView mainPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List<ProductVO> newProductList = mainService.newList();
		List<ProductVO> bestProductList = mainService.bestList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("newProductList", newProductList);
		mav.addObject("bestProductList", bestProductList);
		return mav;

	}

}
