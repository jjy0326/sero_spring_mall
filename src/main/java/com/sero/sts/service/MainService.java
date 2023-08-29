package com.sero.sts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.sero.sts.dao.MainDAO;
import com.sero.sts.vo.ProductVO;

@Service
public class MainService  {

	public MainService() {
	System.out.println("service");
	}
	
	@Autowired
    private MainDAO mainDAO;
	
	// 신 상품
	public List<ProductVO> newList() throws DataAccessException {
		List<ProductVO> newList =mainDAO.selectNewList();
		return newList;
	}

	// 베스트 상품
	public List<ProductVO> bestList() throws DataAccessException {
		List<ProductVO> bestList =  mainDAO.selectBestList();
		return bestList;
	}


	// 상세 페이지

	public ProductVO productDetail(int pseq) throws DataAccessException {

	    ProductVO productDetail = mainDAO.productDetail(pseq);
	    return productDetail;
	}

	// 상품 카테고리

		public List<ProductVO> productKind(int kind) throws DataAccessException {

			List<ProductVO> productKind = mainDAO.productKind(kind);
		    return productKind;
		}



}



