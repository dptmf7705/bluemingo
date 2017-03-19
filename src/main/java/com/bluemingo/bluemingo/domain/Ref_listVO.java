package com.bluemingo.bluemingo.domain;

import java.util.List;

/** Last Edit 2017-02-16
 * Ref_listVO - Ref_listDAO - Ref_listService - Controller
 * product-ref_list : item list
 * item-ref_list : option list
 * reservation-ref_list : deliver information
 */
public class Ref_listVO {
	
	private Integer ref_list_key;
	private String ref_id;
	private String item_id;
	private String option_name;
	private String option_value;
	private Integer option_price;
	
	//RowCount()
	private Integer count;
	
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getRef_list_key() {
		return ref_list_key;
	}
	public void setRef_list_key(Integer ref_list_key) {
		this.ref_list_key = ref_list_key;
	}
	public String getRef_id() {
		return ref_id;
	}
	public void setRef_id(String ref_id) {
		this.ref_id = ref_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getOption_name() {
		return option_name;
	}
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}
	public String getOption_value() {
		return option_value;
	}
	public void setOption_value(String option_value) {
		this.option_value = option_value;
	}
	public Integer getOption_price() {
		return option_price;
	}
	public void setOption_price(Integer option_price) {
		this.option_price = option_price;
	}
	
	

}
