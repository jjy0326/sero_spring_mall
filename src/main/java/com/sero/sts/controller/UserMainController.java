package com.sero.sts.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sero.sts.service.MainService;
import com.sero.sts.vo.ProductVO;
import com.sun.media.jfxmedia.logging.Logger;

@Controller("mainController")
public class UserMainController {
	public UserMainController() {
		System.out.println("컨트롤러 ");
	}
	
	@Autowired
	private MainService mainService;

	// 신 상품, 베스트 상품
	@RequestMapping(value = "/mall/mainPage", method = RequestMethod.GET)
	public String mainPage(Model model) throws Exception {
	    List<ProductVO> newProductList = mainService.newList();
	    List<ProductVO> bestProductList = mainService.bestList();

	    model.addAttribute("newProducts", newProductList);
	    model.addAttribute("bestProducts", bestProductList);
	    
	    return "mainPage"; // View 이름 반환
	}

	// 상품 상세 페이지
	@RequestMapping(value = "/mall/productDetail", method = RequestMethod.GET)
	public String productDetail(@RequestParam("pseq") String pseq, Model model) throws Exception {
	    int pseqs = Integer.parseInt(pseq); // 문자열을 숫자로 변환
	    ProductVO productVO = mainService.productDetail(pseqs);
	    
	    model.addAttribute("productVO", productVO);
	    return "product/productDetail";
	}
	
	// 상품 상세 카테고리
		@RequestMapping(value = "/mall/ProductKind", method = RequestMethod.GET)
		public String productKind(@RequestParam("kind") String kind, Model model) throws Exception {
		    int kinds = Integer.parseInt(kind); // 문자열을 숫자로 변환
		    List<ProductVO> productVO = mainService.productKind(kinds);
		    model.addAttribute("productVO", productVO);
		    return "product/productKind";
		}
	
	
}