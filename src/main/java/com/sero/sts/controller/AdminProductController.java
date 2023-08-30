package com.sero.sts.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sero.sts.service.AdminService;
import com.sero.sts.vo.ProductVO;

@RequestMapping("/admin/product")
@Controller
public class AdminProductController {

	@Autowired
	private AdminService adminService;
	
	static Logger logger = LoggerFactory.getLogger(AdminMainController.class);

	/**
	 * MAV 방식으로 productList 반환
	 * @author 명원식
	 * @return admin/product/productList.jsp ("admin/product/productList")를 통해
	 **/
	@RequestMapping(value = "/productList", method = RequestMethod.GET)
//	public ModelAndView productList() {
//	    List<ProductVO> productList = adminService.showProductList();
//
//	    ModelAndView mav = new ModelAndView("admin/product/productList");
//	    mav.addObject("productList", productList);
//
//	    return mav;
//	}
	/**
	 * String 방식으로 productList 반환
	 * @author 명원식
	 * @return admin/product/productList.jsp
	 **/
	public String productList(Model model) {
	    List<ProductVO> productList = adminService.showProductList();
	    
	    model.addAttribute("productList", productList);

	    return "admin/product/productList";
	}


	@RequestMapping(value = "/detail/{pseq}", method = RequestMethod.GET)
	public String productDetail(@PathVariable("pseq") int pseq, Model model) {
		ProductVO productVO = adminService.selectProduct(pseq);
		
		model.addAttribute("productVO", productVO);
		
		return "admin/product/productDetail";

	}

	@RequestMapping(value = "/updateForm/{pseq}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("pseq") int pseq, Model model, HttpServletRequest request) {
		ProductVO productVO = adminService.selectProduct(pseq);
		
		String kindList[] = { "Heels", "Boots", "Sandals", "Slippers", "Sneakers", "Sale" };
		request.setAttribute("kindList", kindList);
		model.addAttribute("productVO", productVO);
		
		return "admin/product/productUpdate";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") ProductVO product, Model model) {
		System.out.println("짠"+product.toString());
		adminService.updateProduct(product) ;
//		model.addAttribute("productVO", product);

		return "redirect:admin/product/productDetail/" + product.getPseq();
//		return "admin/product/detail/{pseq}";

	}
	
	
//	@RequestMapping(value = "/addForm/{pseq}", method = RequestMethod.GET)
	@RequestMapping(value = "/addForm", method = RequestMethod.GET)
	public String addForm(HttpServletRequest request, HttpServletResponse response) {
		return "admin/product/productWrite";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") ProductVO product, Model model) {
		adminService.addProduct(product) ;

		return "redirect:admin/product/productDetail/" + product.getPseq();

	}
}
