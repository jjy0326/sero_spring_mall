package com.sero.sts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.sero.sts.vo.OrderVO;
import com.sero.sts.vo.QnaVO;

@Repository
public class AdminDAO {

	public AdminDAO() {
		System.out.println("adminDAO 시작");
	}

	@Autowired
	private SqlSession sqlsession;

	// qna 리스트
	public List<QnaVO> qnaList() throws DataAccessException {
		List<QnaVO> qnaList = sqlsession.selectList("mapper.mall.selectQna");

		return qnaList;
	}

	// qna 상세
	public QnaVO qnaDetail(int qseq) throws DataAccessException {
		QnaVO qnaDetail = sqlsession.selectOne("mapper.mall.detailQna", qseq);
		return qnaDetail;
	}

	// Qna 답변
	public int updateQna(int qseq, String reply) throws DataAccessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("qseq", qseq);
		params.put("reply", reply);

		int result = sqlsession.update("mapper.mall.updateQna", params);
		return result;
	}
	// -----------------------------------
	
	// order 리스트
	public List<OrderVO> orderList(String mname) throws DataAccessException {
	    Map<String, Object> paramMap = new HashMap<String, Object>();
	    paramMap.put("mname", mname);

	    List<OrderVO> orderList = sqlsession.selectList("mapper.mall.selectOrder", paramMap);
	    return orderList;
	}
	
	// order 주문 처리
	public int updateOrder(int odseq) throws DataAccessException{
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("odseq",odseq);
		int result = sqlsession.update("mapper.mall.updateOrder", params);
		return result;
		
	}
	
}
