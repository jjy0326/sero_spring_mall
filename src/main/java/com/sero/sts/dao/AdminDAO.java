package com.sero.sts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.sero.sts.vo.OrderVO;
import com.sero.sts.vo.ProductVO;
import com.sero.sts.vo.QnaVO;
import com.sero.sts.vo.MemberVO;


@Repository
public class AdminDAO {

	static Logger logger = LoggerFactory.getLogger(AdminDAO.class);
	
	@Autowired
	private SqlSession sqlSession;

	// qna 리스트
	public List<QnaVO> qnaList() throws DataAccessException {
		List<QnaVO> qnaList = sqlSession.selectList("mapper.mall.selectQna");

		return qnaList;
	}

	// qna 상세
	public QnaVO qnaDetail(int qseq) throws DataAccessException {
		QnaVO qnaDetail = sqlSession.selectOne("mapper.mall.detailQna", qseq);
		return qnaDetail;
	}

	// Qna 답변
	public int updateQna(int qseq, String reply) throws DataAccessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("qseq", qseq);
		params.put("reply", reply);

		int result = sqlSession.update("mapper.mall.updateQna", params);
		return result;
	}
	// -----------------------------------
	
	// order 리스트
	public List<OrderVO> orderList(String mname) throws DataAccessException {
	    Map<String, Object> paramMap = new HashMap<String, Object>();
	    paramMap.put("mname", mname);

	    List<OrderVO> orderList = sqlSession.selectList("mapper.mall.selectOrder", paramMap);
	    return orderList;
	}
	
	// order 주문 처리
	public int updateOrder(int odseq) throws DataAccessException{
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("odseq",odseq);
		int result = sqlSession.update("mapper.mall.updateOrder", params);
		return result;
		
	}

	/**
	 * @param id
	 * @return selectOne 결과
	 * @author 명원식
	 **/
    public int checkWorker(String id, String pwd) throws DataAccessException {
    	Map<String, String> params = new HashMap<String, String>();
    	params.put("id", id);
    	params.put("pwd", pwd);
    	return sqlSession.selectOne("checkWorker", params);
    }
    
    public List<ProductVO> showProductList(String name) throws DataAccessException {
    	Map<String, Object> params = new HashMap<String,Object>();
    	params.put("name",name);
    	List<ProductVO> productList = sqlSession.selectList("mapper.mall.showProductList", params);
    	return productList;
    }

    public ProductVO selectProduct(int pseq) throws DataAccessException {
    	ProductVO productView = null;
    	productView = sqlSession.selectOne("mapper.mall.selectProduct", pseq);
    	return productView;
    }
 
    public int updateProduct(ProductVO product) throws DataAccessException {
    	int result = sqlSession.update("mapper.mall.updateProduct", product);
    	return result;
    }

	public int addProduct(ProductVO product) throws DataAccessException {
		int result = sqlSession.insert("mapper.mall.addProduct", product);
		return result;
	}

    public List<MemberVO> showMemberList(String name) throws DataAccessException {
     	Map<String, Object> params = new HashMap<String,Object>();  	
     	params.put("name",name);
    	List<MemberVO> memberList = sqlSession.selectList("mapper.mall.showMemberList", params);
    	return memberList;
    }

	public int removeMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.mall.removeMember", id);
		return result;
	}

}
