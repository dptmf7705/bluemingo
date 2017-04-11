package com.bluemingo.bluemingo.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bluemingo.bluemingo.domain.ImageVO;
import com.bluemingo.bluemingo.generic.GenericDAO;
import com.bluemingo.bluemingo.generic.GenericServiceImpl;
import com.bluemingo.bluemingo.persistence.ImageDAO;
import com.bluemingo.bluemingo.util.FileUtils;


@Service("imageService")
public class ImageServiceImpl extends GenericServiceImpl<ImageVO, Integer> implements ImageService {
	
	private static final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);

	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Autowired
	private ImageDAO imageDao;
	
	public ImageServiceImpl() {
		
	}
	@Autowired
	public ImageServiceImpl(@Qualifier("imageDao") GenericDAO<ImageVO, Integer> genericDao) {
        super(genericDao);
        this.imageDao = (ImageDAO) genericDao;
		
	}
	
	/**
	 * request로 file data 받아와서 fileUtils.parseInsertFileInfo()로 상세 데이타(cvo) 뽑고
	 * DB에 전달 후 성공이면 해당 cvo리턴
	 */
	@Override
	public ImageVO imageInsert(HttpServletRequest request) throws Exception {
		ImageVO cvo = null;
		cvo = fileUtils.parseInsertFileInfo(request);
		
		if(imageDao.insertProcedure(cvo,null) != null)
		{
			return cvo;
		}
		else
			return cvo = null;
	}
}
