package com.sero.sts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.sero.sts.dao.MainDAO;
import com.sero.sts.vo.ProductVO;

@Service("mainService")
public class MainService  {

	public MainService() {
	System.out.println("service");
	}
	
	@Autowired
    private MainDAO mainDAO;
	
	// 신 상품
	public List<ProductVO> newList() throws DataAccessException {
		List<ProductVO> newList = null;
		newList = mainDAO.selectNewList();		
		return newList;
	}

	public List<ProductVO> bestList() throws DataAccessException {
		List<ProductVO> bestList = null;
		bestList = mainDAO.selectBestList();	
		return bestList;
	}

}
