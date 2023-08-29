package com.sero.sts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.sero.sts.dao.AdminDAO;
import com.sero.sts.vo.OrderVO;
import com.sero.sts.vo.QnaVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sero.sts.vo.ProductVO;

@Service("adminService")
@Transactional(propagation = Propagation.REQUIRED)
public class AdminService{
	
	public AdminService() {
		System.out.println("관리자  서비스 시작");
	}

	static Logger logger = LoggerFactory.getLogger(AdminService.class);

	@Autowired
	private AdminDAO adminDAO;

	// qna 리스트
	public List<QnaVO> qnaList() throws DataAccessException {
		List<QnaVO> qnaList = adminDAO.qnaList();
		return qnaList;
	}

	// qna 상세
	public QnaVO qnaDetail(int qseq) throws DataAccessException{
		QnaVO qnaDetail = adminDAO.qnaDetail(qseq);
	return qnaDetail;
	}

	// qna 답변
	public int qnaUpdate(int qseq, String reply) throws DataAccessException {
		return adminDAO.updateQna(qseq, reply);
	}
	
	// -----------------------------------------------------
	
	//order 리스트
	public List<OrderVO> orderList(String key) throws DataAccessException{
		List<OrderVO> orderList = adminDAO.orderList(key);
		return orderList;
	}
	
	// order 주문 처리	
	public int orderUpdate(int oseqs) throws DataAccessException{

		return adminDAO.updateOrder(oseqs);
	}



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
	

}
