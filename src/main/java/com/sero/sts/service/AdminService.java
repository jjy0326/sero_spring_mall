package com.sero.sts.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.sero.sts.dao.AdminDAO;
import com.sero.sts.vo.ProductVO;

@Service("adminService")
@Transactional(propagation = Propagation.REQUIRED)
public class AdminService{
	
	@Autowired
	private AdminDAO adminDAO;
	
	static Logger logger = LoggerFactory.getLogger(AdminService.class);


	/**
	 * @param workerId
	 * @param workerPwd
	 * @return
	 **/
    public boolean checkWorker(String id, String pwd) {
        int result = adminDAO.checkWorker(id, pwd);
    	return result ==1;
	}

	public List<ProductVO> showProductList() {
		List<ProductVO> productList = adminDAO.showProductList();
		return productList;
	}
}
