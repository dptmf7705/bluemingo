package com.bluemingo.bluemingo.domain;

import javax.validation.constraints.NotNull;

/** Last Edit 2017-02-18 
 * OrderO - OrderDAO - OrderService - OrderController
 * 주문 리스트 페이지에서 사용됨
 */
public class OrderVO {
	
	/** 회원번호 / 주문번호 / 구매방법 / 제품id / 구매자이름 / 구매자아이디 / 주문금액 / 주문수량 / 주문상태
	 *  res_id기준 금액합, 수량합
	 */
	// order_list
	private Integer res_key;
	private String res_id;
	private Integer user_key;
	private String res_type;
	private String user_id;
	private String user_name;
	private String item_id;
	private Integer res_price;
	private Integer res_quantity;
	private String res_status;
	private Integer sum_price;
	private Integer sum_quantity;
	private Long purchase_date;
	private Long res_date;
	
	// order_count
	private Integer nowday_count;
	private Integer yesterday_count;
	
	// order_select
	private String item_name;
	private String option_name;
	private String option_value;
	private Integer option_price;
	private String item_option;
	
	
	public Long getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Long purchase_date) {
		this.purchase_date = purchase_date;
	}
	public Long getRes_date() {
		return res_date;
	}
	public void setRes_date(Long res_date) {
		this.res_date = res_date;
	}
	public Integer getNowday_count() {
		return nowday_count;
	}
	public void setNowday_count(Integer nowday_count) {
		this.nowday_count = nowday_count;
	}
	public Integer getYesterday_count() {
		return yesterday_count;
	}
	public void setYesterday_count(Integer yesterday_count) {
		this.yesterday_count = yesterday_count;
	}
	public Integer getRes_key() {
		return res_key;
	}
	public void setRes_key(Integer res_key) {
		this.res_key = res_key;
	}
	public String getItem_option() {
		return item_option;
	}
	public void setItem_option() {
		this.item_option = option_name + ", " + option_value;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
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
	public String getRes_id() {
		return res_id;
	}
	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}
	public Integer getUser_key() {
		return user_key;
	}
	public void setUser_key(Integer user_key) {
		this.user_key = user_key;
	}
	public String getRes_type() {
		return res_type;
	}
	public void setRes_type(Integer res_type) {
		switch (res_type) {
		case 1:
			this.res_type = "공동구매";
			break;
		case 2:
			this.res_type = "즉시구매";
			break;
		default:
			break;
		}
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public Integer getRes_price() {
		return res_price;
	}
	public void setRes_price(Integer res_price) {
		this.res_price = res_price;
	}
	public Integer getRes_quantity() {
		return res_quantity;
	}
	public void setRes_quantity(Integer res_quantity) {
		this.res_quantity = res_quantity;
	}
	public String getRes_status() {
		return res_status;
	}
	public void setRes_status(Integer res_status) {
		switch (res_status) {
		case 1:
			this.res_status = "공구예약";
			break;
		case 2:
			this.res_status = "결제대기";
			break;
		case 3:
			this.res_status = "결제완료";
			break;
		case 4:
			this.res_status = "배송중";
			break;
		case 5:
			this.res_status = "배송완료";
			break;
		case 6:
			this.res_status = "구매확정";
			break;
		default:
			break;
		}
	}
	public Integer getSum_price() {
		return sum_price;
	}
	public void setSum_price(Integer sum_price) {
		this.sum_price = sum_price;
	}
	public Integer getSum_quantity() {
		return sum_quantity;
	}
	public void setSum_quantity(Integer sum_quantity) {
		this.sum_quantity = sum_quantity;
	}
	
	
	
}
