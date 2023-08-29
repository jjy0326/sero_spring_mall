package com.sero.sts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sero.sts.dao.QnaDAO;
import com.sero.sts.vo.QnaVO;

@Service("qnaService")
@Transactional(propagation = Propagation.REQUIRED)
public class QnaService {
	
	@Autowired
	QnaDAO qnaDAO;
	
	public List<QnaVO> qnaList(String id) {
		List<QnaVO> qnaList = qnaDAO.listQna(id);
		
		return qnaList;
	}
	
	public void qnaWrite(QnaVO qnaVO, String id) { // 작성한 qna 내용을 등록		
		qnaDAO.insertqna(qnaVO, id);
	}
	
	public QnaVO qnaView(int qseq) { // qna 상세페이지

		QnaVO qnaVO = qnaDAO.getQna(qseq);
		return qnaVO;
	}

}