package com.sero.sts.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.sero.sts.dao.AdminDAO;
import com.sero.sts.vo.MemberVO;
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
	 * @return result(1:true) or (!1:false)
	 **/
    public boolean checkWorker(String id, String pwd) throws DataAccessException {
        int result = adminDAO.checkWorker(id, pwd);
    	return result ==1;
	}

	public List<ProductVO> showProductList() throws DataAccessException {
		List<ProductVO> productList = adminDAO.showProductList();
		return productList;
	}
	
	public ProductVO selectProduct(int pseq) throws DataAccessException {
		return adminDAO.selectProduct(pseq);
	}

	public int updateProduct(ProductVO product) throws DataAccessException {
		return adminDAO.updateProduct(product);
	}
	
	public int addProduct(ProductVO product) throws DataAccessException {
		return adminDAO.addProduct(product);
	}

	public List<MemberVO> showMemberList() throws DataAccessException {
		List<MemberVO> memberList = adminDAO.showMemberList();
		return memberList;
	}

	public int removeMember(String id) throws DataAccessException {
		return adminDAO.removeMember(id);
		
	}
}
