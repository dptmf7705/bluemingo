package com.bluemingo.bluemingo.generic;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bluemingo.bluemingo.domain.SearchVO;

/** Last Edit 2017-02-11 
 * 프로시저 사용을 위해 기능별 함수 정의 및 구현
 */
@Service
public abstract class GenericServiceImpl<E, K> 
        implements GenericService<E, K> {
 
	private static final Logger logger = LoggerFactory.getLogger(GenericServiceImpl.class);
	
	private GenericDAO<E, K> genericDao;
	 
    public GenericServiceImpl(GenericDAO<E,K> genericDao) {
        this.genericDao=genericDao;
    }
    
    public GenericServiceImpl() {
    }
   
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public SearchVO deleteProcedure(SearchVO svo){
    	return genericDao.deleteProcedure(svo);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public SearchVO createProcedure(E vo){
    	return genericDao.createProcedure(vo);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public E insertProcedure(E vo){
    	return genericDao.insertProcedure(vo);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public SearchVO updateProcedure(E vo){
    	return genericDao.updateProcedure(vo);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public SearchVO procedure(SearchVO svo, String PREFIX) {
    	return genericDao.procedure(svo,PREFIX);
    }
   
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> listAll(SearchVO svo, String PREFIX) {
    	return genericDao.listAll(svo, PREFIX);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> search(SearchVO svo) {
    	return genericDao.search(svo);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public void multiCreate(List<E> list) {
    	genericDao.multiCreate(list);
    }
    
   
    
    
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Date getDateTime() {
    	return genericDao.getDateTime();
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int create(E vo) {
    	return genericDao.create(vo);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public E read(K pkey) {
    	return genericDao.read(pkey);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(E vo) {
    	genericDao.update(vo);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(K pkey) {
    	genericDao.delete(pkey);
    }
    
    /*@Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> infiniteScrollUp(K pkey) {
    	return genericDao.infiniteScrollUp(pkey);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> infiniteScrollDown(K pkey) {
    	return genericDao.infiniteScrollDown(pkey);
    }*/
}