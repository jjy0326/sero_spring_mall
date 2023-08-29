package com.sero.sts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	 * MAV method of returning the productList display
	 * @author 명원식
	 * @return admin/product/productList.jsp through ("admin/product/productList")
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
	 * String method of returning the productList display
	 * @author 명원식
	 * @return admin/product/productList.jsp
	 **/
	public String productList(Model model) {
	    List<ProductVO> productList = adminService.showProductList();
	    
	    model.addAttribute("productList", productList);

	    return "admin/product/productList";
	}


	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String productDetail() {
		return null;

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateProduct() {
		return null;

	}

}
