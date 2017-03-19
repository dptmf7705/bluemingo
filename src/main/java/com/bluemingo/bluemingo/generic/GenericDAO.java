package com.bluemingo.bluemingo.generic;

import java.util.Date;
import java.util.List;

import com.bluemingo.bluemingo.domain.SearchVO;

/** Last Edit 2017-02-11 
 * 프로시저 사용을 위해 기능별 함수 정의 및 구현
 */
public interface GenericDAO<E, K> {
	
	public SearchVO deleteProcedure(SearchVO svo);
	public SearchVO createProcedure(E vo);
	public E insertProcedure(E vo);
	public SearchVO updateProcedure(E vo);
	public SearchVO procedure(SearchVO svo, String PREFIX);
	
	public List<E> listAll(SearchVO svo, String PREFIX);
	public List<E> search(SearchVO svo);
	public void multiCreate(List<E> list);
	
	public Date getDateTime();
	public int create(E vo);
	public E read(K pkey);
	public void update(E vo);
	public void delete(K pkey);
	/*public List<E> infiniteScrollDown(K pkey);		
	public List<E> infiniteScrollUp(K pkey);*/
	
}//interface
