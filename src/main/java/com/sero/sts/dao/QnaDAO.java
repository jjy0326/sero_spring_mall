package com.sero.sts.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sero.sts.vo.QnaVO;

@Repository("qnaDAO")
public class QnaDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<QnaVO> listQna(String id) {
		List<QnaVO> qnaList = new ArrayList<QnaVO>();
		qnaList = sqlSession.selectList("mapper.user.listQna", id);

		return qnaList;
	}
	
	public void insertqna(QnaVO qnaVO, String id) {
		Map<String, Object> qnaMap = new HashMap<String, Object>();
		qnaMap.put("subject", qnaVO.getSubject());
		qnaMap.put("content", qnaVO.getContent());
		qnaMap.put("id", id);
		int qnaInsert = sqlSession.insert("mapper.user.insertqna", qnaMap);
	}
	
	public QnaVO getQna(int qseq) {
		QnaVO qnaVO = null;
		qnaVO = sqlSession.selectOne("mapper.user.getQna", qseq);
		return qnaVO;
	}


}
