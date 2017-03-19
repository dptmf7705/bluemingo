package com.bluemingo.bluemingo.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bluemingo.bluemingo.domain.ImageVO;
import com.bluemingo.bluemingo.generic.GenericDAOImpl;

@Repository("imageDao")
public class ImageDAOImpl extends GenericDAOImpl<ImageVO, Integer> implements ImageDAO {

	public ImageDAOImpl() {
		super(ImageVO.class);
	}
	
}
