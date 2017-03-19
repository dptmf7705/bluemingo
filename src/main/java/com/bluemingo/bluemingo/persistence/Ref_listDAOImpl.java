package com.bluemingo.bluemingo.persistence;

import org.springframework.stereotype.Repository;

import com.bluemingo.bluemingo.domain.AdvVO;
import com.bluemingo.bluemingo.domain.Ref_listVO;
import com.bluemingo.bluemingo.generic.GenericDAOImpl;

/** Last Edit 2017-02-12
 * RefListVO - RefListDAO - RefListService - RefListController
 * product-item
 * item-option
 * reservation-deliver
 */
@Repository("ref_listDao")
public class Ref_listDAOImpl extends GenericDAOImpl<Ref_listVO, Integer> implements Ref_listDAO{

	public Ref_listDAOImpl() {
		super(Ref_listVO.class);
	}
}
