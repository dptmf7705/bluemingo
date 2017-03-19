package com.bluemingo.bluemingo.domain;

import java.sql.Date;

import javax.validation.constraints.NotNull;

/** Last Edit 2017-02-16
 * SellerVO - SellerDAO - SellerService - SellerController
 * 판매자 리스트 페이지에서 사용됨
 * 
 */
public class SellerVO {

	// company table - listAll result
	private Integer company_key;
	private String company_name;
	private String company_president;
	private Integer company_type;
	private String company_phone;;
	private String company_prephone;
	// company table - remain
	private String company_serial;
	private String company_address;
	private String company_detail;
	private String company_homepage;
	
	// option value
	private Integer progress_adv; // if(trade_status==2)
	private Integer total_adv; // if(trade_status>1)
	private Integer priority; // if(trade_status==2) max(trade_key)
	private Integer progress_company; // count if(trade_status=2)
	private Integer com_purchase_company; // count if(trade_status=4)
	private Integer complete_company; // count if(trade_status=5)

	// pageDetail
	private String item_name;
	private Integer item_sale_price;
	private String adv_title;
	private Long adv_time;
	private Long product_period;
	private Integer trade_status;

	
	public Integer getTrade_status() {
		return trade_status;
	}
	public void setTrade_status(Integer trade_status) {
		this.trade_status = trade_status;
	}
	public Integer getProgress_company() {
		return progress_company;
	}
	public void setProgress_company(Integer progress_company) {
		this.progress_company = progress_company;
	}
	public Integer getCom_purchase_company() {
		return com_purchase_company;
	}
	public void setCom_purchase_company(Integer com_purchase_company) {
		this.com_purchase_company = com_purchase_company;
	}
	public Integer getComplete_company() {
		return complete_company;
	}
	public void setComplete_company(Integer complete_company) {
		this.complete_company = complete_company;
	}
	public Long getProduct_period() {
		return product_period;
	}
	public void setProduct_period(Long product_period) {
		this.product_period = product_period;
	}
	public Date getAdv_time() {
		if(this.adv_time != null){
		Date adv_date = new Date(adv_time);
		return adv_date;
		}
		else
			return null;
	}
	public void setAdv_time(Date adv_time) {
		this.adv_time = adv_time.getTime();
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public Integer getItem_sale_price() {
		return item_sale_price;
	}
	public void setItem_sale_price(Integer item_sale_price) {
		this.item_sale_price = item_sale_price;
	}
	public String getAdv_title() {
		return adv_title;
	}
	public void setAdv_title(String adv_title) {
		this.adv_title = adv_title;
	}
	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getCompany_address() {
		return company_address;
	}

	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}

	public String getCompany_homepage() {
		return company_homepage;
	}

	public void setCompany_homepage(String company_homepage) {
		this.company_homepage = company_homepage;
	}

	public String getCompany_detail() {
		return company_detail;
	}

	public void setCompany_detail(String company_detail) {
		this.company_detail = company_detail;
	}

	public String getCompany_serial() {
		return company_serial;
	}

	public void setCompany_serial(String company_serial) {
		this.company_serial = company_serial;
	}

	public Integer getCompany_type() {
		return company_type;
	}

	public void setCompany_type(Integer company_type) {
		this.company_type = company_type;
	}

	public Integer getCompany_key() {
		return company_key;
	}

	public void setCompany_key(Integer company_key) {
		this.company_key = company_key;
	}

	public String getCompany_president() {
		return company_president;
	}

	public void setCompany_president(String company_president) {
		this.company_president = company_president;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_phone() {
		return company_phone;
	}

	public void setCompany_phone(String company_phone) {
		this.company_phone = company_phone;
	}

	public String getCompany_prephone() {
		return company_prephone;
	}

	public void setCompany_prephone(String company_prephone) {
		this.company_prephone = company_prephone;
	}

	public Integer getProgress_adv() {
		return progress_adv;
	}

	public void setProgress_adv(Integer progress_adv) {
		this.progress_adv = progress_adv;
	}

	public Integer getTotal_adv() {
		return total_adv;
	}

	public void setTotal_adv(Integer total_adv) {
		this.total_adv = total_adv;
	}

}
