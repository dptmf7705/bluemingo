package com.bluemingo.bluemingo.service;

import java.util.List;

import com.bluemingo.bluemingo.domain.Item_companyVO;
import com.bluemingo.bluemingo.domain.Ref_listVO;
import com.bluemingo.bluemingo.generic.GenericService;


/** Last Edit 2017-02-16
 * RefListVO - RefListDAO - RefListService - RefListController
 * product-item
 * item-option
 * reservation-deliver
 * 
 * product-item option list -> item_id기준으로 정리하는 함수 setOptionList()추가 (2017-02-16)
 */
public interface Ref_listService extends GenericService<Ref_listVO, Integer> {

	public List<Item_companyVO> setOptionList(List<Ref_listVO> refList, List<Item_companyVO> icList);
	
}
