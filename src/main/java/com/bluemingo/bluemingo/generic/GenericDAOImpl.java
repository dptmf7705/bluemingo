package com.bluemingo.bluemingo.generic;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bluemingo.bluemingo.domain.SearchVO;

//E-DataSet
//K-DataType

/** Last Edit 2017-02-11 
 * 프로시저 사용을 위해 기능별 함수 정의 및 구현
 */
@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDAOImpl<E, K extends Serializable> implements GenericDAO<E, K>  {

	private static Logger log = LoggerFactory.getLogger(GenericDAOImpl.class);
	
	//Define prefixes mapper
	public static final String PREFIX_DATE_TIME = "getNow";
	public static final String PREFIX_CREATE = "create";
	public static final String PREFIX_READ = "read";
	public static final String PREFIX_UPDATE = "update";
	public static final String PREFIX_DELETE = "delete";
	public static final String PREFIX_LISTALL = "listAll_";
	public static final String PREFIX_SEARCH = "search";
	public static final String PREFIX_PROCEDURE = "procedure_";
	public static final String PREFIX_INFINITE_SCROLL_UP = "infiniteScrollUP";
	public static final String PREFIX_INFINITE_SCROLL_DOWN = "infiniteScrollDown";
	public static final String PREFIX_INSERT = "insert";
	public static final String PREFIX_SELECT = "select";
	
	public static final String MAPPER = "Mapper";
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	protected Class<? extends E> daoType;
	
	//Default Constructor
	public GenericDAOImpl(Class<E> daoType){
		this.daoType = daoType;
	}
	//Default Constructor
	public GenericDAOImpl(Class<E> daoType, SqlSessionFactory sqlSessionFactory){
		this.daoType = daoType;
		this.sqlSessionFactory = sqlSessionFactory;
		if(sqlSessionFactory == null)
			log.equals("Error: Could not instantiate MyBatisDAO. Loading myBatis sessionFactory failed.");
	}
	
	// Use this method to get a session factory for using in any methods impelmented in child dao classes 
    protected SqlSessionFactory getSessionFactory() {
        return sqlSessionFactory;
    }
    
    /*Make query
     * ex) mappers/*.xml 's namespace = "com.bluemingo.bluemingo.domain.AdvVOMapper"
     * 1. daoType's src : this.daoType.getName() => "com.bluemingo.bluemingo.domain.AdvVO"
     * 2. "Mapper"
     * 3. mappers/*.xml 's Query id ex) create
     * result = "com.bluemingo.bluemingo.domain.AdvVOMapper.create"
     */
    
    // 프로시저를 통한 삭제 기능, 결과 상태값을 리턴, 사용되는 각 컨트롤러에서 별도의 메시징함수를 통해 문자열로 전환
    @Override
    public SearchVO deleteProcedure(SearchVO svo) {
    	SqlSession session = sqlSessionFactory.openSession(); 
    	SearchVO result = null;
        try
        {  	
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_PROCEDURE+PREFIX_DELETE;
        	result = (SearchVO)session.selectOne(query,svo);  
            session.commit();  
        }
        finally
        {
            session.close();
        }
        return result;
    }
    
    @Override
    public SearchVO createProcedure(E vo) {
    	SqlSession session = sqlSessionFactory.openSession(); 
   	 	SearchVO result = null;
        try
        {  	
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_PROCEDURE+PREFIX_CREATE;
        	result = (SearchVO)session.selectOne(query,vo);      
        }
        finally
        {
            session.close();
        }
        return result;
    }
    
    @Override
    public E insertProcedure(E vo) {
    	SqlSession session = sqlSessionFactory.openSession(); 
        E obj = null;
        try
        {  	
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_PROCEDURE+PREFIX_INSERT;
        	obj = (E)session.selectOne(query,vo);      
        }
        finally
        {
            session.close();
        }
        return obj;
    }
    
    @Override
    public SearchVO updateProcedure(E vo) {
    	SqlSession session = sqlSessionFactory.openSession(); 
    	 SearchVO result = null;
        try
        {  	
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_PROCEDURE+PREFIX_INSERT;
        	result = (SearchVO)session.selectOne(query,vo);      
        }
        finally
        {
            session.close();
        }
        return result;
    }
    
    // 각종 기능 프로시저, 특정기능 수행을 위한 PREFIX인자로 받음, 기능 수행 결과값을 리턴
    @Override
    public SearchVO procedure(SearchVO svo, String PREFIX) {
    	SqlSession session = sqlSessionFactory.openSession(); 
        SearchVO result = null;
        try
        {  	
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_PROCEDURE+PREFIX;
        	result = (SearchVO)session.selectOne(query,svo);      
        }
        finally
        {
            session.close();
        }
        return result;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<E> listAll(SearchVO svo, String PREFIX) {
    	SqlSession session = sqlSessionFactory.openSession();
    	String prefix = null;
    	if(PREFIX != null) prefix = PREFIX;
        List<E> list = null;
        try
        {  	
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_LISTALL+prefix;
        	if(svo == null){
        	list = (List<E>)session.selectList(query);      
        	} else {
        		list = (List<E>)session.selectList(query,svo);
        	}
        }
        finally
        {
            session.close();
        }
        return list;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<E> search(SearchVO svo) {
    	SqlSession session = sqlSessionFactory.openSession(); 
        List<E> list = null;
        try
        {  	
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_SEARCH;
        	list = (List<E>)session.selectList(query,svo);      
        }
        finally
        {
            session.close();
        }
        return list;
    }   

    @Override
    public void multiCreate(List<E> list) {
    	SqlSession session = sqlSessionFactory.openSession();
        Integer status = null;
        try
        {   
        	for(int i=0; i<list.size(); i++){
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_CREATE;
            status = (Integer)session.insert(query, list.get(i));
            session.commit();   
        	}
        }
        finally
        {	
            session.close();
        } 
    }
    


    @Override
    @SuppressWarnings("unchecked")
    public Date getDateTime() throws PersistenceException{
    	SqlSession session = sqlSessionFactory.openSession();
        Date date = null;
        try
        {   
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_DATE_TIME;
            date = (Date)session.selectOne(query);
        }
        finally
        {
            session.close();
        } 
        return date;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public int create(E vo) throws PersistenceException{
    	SqlSession session = sqlSessionFactory.openSession();
        Integer status = null;
        try
        {   
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_CREATE;
            status = (Integer)session.insert(query, vo);
            session.commit();   
        }
        finally
        {
            session.close();
        } 
        return status;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public E read(K pKey) throws PersistenceException {
        SqlSession session = sqlSessionFactory.openSession(); 
        E obj = null;
        try
        {  	//namespace = com.bluemingo.bluemingo.domain.AdvVOMapper
        	//session.selectOne(namespace+".read", key);
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_READ;
            obj = (E)session.selectOne(query,pKey);  
        }
        finally
        {
            session.close();
        }
        return obj;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public void update(E vo) {
    	SqlSession session = sqlSessionFactory.openSession();
        Integer status = null;
        try
        {   
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_UPDATE;
            status = (Integer)session.update(query, vo);
            session.commit();   
        }
        finally
        {
            session.close();
        } 
    }

    @Override
    @SuppressWarnings("unchecked")
    public void delete(K pkey) {
    	SqlSession session = sqlSessionFactory.openSession();
        Integer status = null;
        try
        {   
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_DELETE;
            status = (Integer)session.delete(query, pkey);
            session.commit();   
        }
        finally
        {
            session.close();
        } 
    }
    /*
    @Override
    @SuppressWarnings("unchecked")
    public List<E> infiniteScrollUp(K pkey) {
    	SqlSession session = sqlSessionFactory.openSession(); 
        List<E> list = null;
        try
        {  	
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_INFINITE_SCROLL_UP;
        	list = session.selectList(query, pkey);      
        }
        finally
        {
            session.close();
        }
        return list;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<E> infiniteScrollDown(K pkey) {
    	SqlSession session = sqlSessionFactory.openSession(); 
        List<E> list = null;
        try
        {  	
        	String query = this.daoType.getName()+MAPPER+"."+PREFIX_INFINITE_SCROLL_DOWN;
        	list = session.selectList(query, pkey);      
        }
        finally
        {
            session.close();
        }
        return list;
    }
    */
}

