package com.sero.sts.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sero.sts.service.AdminService;
import com.sero.sts.vo.ProductVO;

@RequestMapping("/admin/product")
@Controller
public class AdminProductController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private ServletContext servletContext;
	
	static Logger logger = LoggerFactory.getLogger(AdminMainController.class);

	/**
	 * MAV 방식으로 productList 반환
	 * @author 명원식
	 * @return admin/product/productList.jsp ("admin/product/productList")를 통해
	 **/
	@RequestMapping(value = "/productList", method = { RequestMethod.GET, RequestMethod.POST })
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
	public String productList(Model model, @RequestParam(value = "key", required = false) String key) throws Exception {
	    List<ProductVO> productList = adminService.showProductList(key);
	    
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
	public String updateForm(@PathVariable("pseq") int pseq, Model model) {
		ProductVO productVO = adminService.selectProduct(pseq);
		
		model.addAttribute("productVO", productVO);
		
		return "admin/product/productUpdate";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateProduct(ProductVO product, @RequestParam("imageFile") MultipartFile imageFile)
			throws IOException {
		System.out.println("짠" + product.toString());
		String savePath = servletContext.getRealPath("/resources/static/images/product_images/");
		if (!imageFile.isEmpty()) {
			String originalFilename = imageFile.getOriginalFilename();
			String newFilename = UUID.randomUUID().toString()
					+ originalFilename.substring(originalFilename.lastIndexOf("."));
			File file = new File(savePath, newFilename);
			imageFile.transferTo(file);
			product.setImage(newFilename);
			adminService.updateProduct(product);
		}
//		return "redirect:admin/product/productDetail/" + product.getPseq();
		return "redirect:admin/product/productDetail/";
		// return "redirect:admin/product/detail/{pseq}";
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
