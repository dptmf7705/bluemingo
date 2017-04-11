package com.bluemingo.bluemingo.domain;

/** Last Edit 2017-02-11
 * 여러 목적으로 사용되며 검색어인 search_key와 검색기준인 search_table로 이루어져있다. 
 */
public class SearchVO {
	
	private String search_table;
	private Object search_key;
	//����
	private String user_name;
	private String product_id;
	//private Integer user_phone;
	//������
	private Integer adv_key;
	private String trade_status;
	//�Ǹ���
	private Integer company_key;
	private String company_name;
	private String company_phone;
	private String company_prephone;
	private String company_serial;
	private String company_president;
	//�ֹ���
	//private String user_name;
	private String user_id;
	private String user_phone;
	private Integer res_status;
	private Integer user_key;
	private String res_date;
	//
	private String item_id;
	private String item_name;
	//��������
	private String res_id;
	
	//imageFile
	private String stored_file_name;
	
	//procedure result
	private Object result;
	
	
	
	public String getStored_file_name() {
		return stored_file_name;
	}
	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		setSearch_table("product_id");
		setSearch_key(product_id);
		this.product_id = product_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		setSearch_table("item_id");
		setSearch_key(item_id);
		this.item_id = item_id;
	}
	public String getRes_id() {
		return res_id;
	}
	public void setRes_id(String res_id) {
		setSearch_table("res_id");
		setSearch_key(res_id);
		this.res_id = res_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		setSearch_table("item_name");
		setSearch_key(item_name);
		this.item_name = item_name;
	}
	public Integer getAdv_key() {
		return adv_key;
	}
	public void setAdv_key(Integer adv_key) {
		setSearch_table("adv_key");
		setSearch_key(adv_key);
		this.adv_key = adv_key;
	}
	public String getTrade_status() {
		return trade_status;
	}
	public void setTrade_status(String trade_status) {
		setSearch_table("trade_status");
		setSearch_key(trade_status);
		this.trade_status = trade_status;
	}
	public Integer getCompany_key() {
		return company_key;
	}
	public void setCompany_key(Integer company_key) {
		setSearch_table("company_key");
		setSearch_key(company_key);
		this.company_key = company_key;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		setSearch_table("company_name");
		setSearch_key(company_name);
		this.company_name = company_name;
	}
	public String getCompany_phone() {
		return company_phone;
	}
	public void setCompany_phone(String company_phone) {
		setSearch_table("company_phone");
		setSearch_key(company_phone);
		this.company_phone = company_phone;
	}
	public String getCompany_prephone() {
		return company_prephone;
	}
	public void setCompany_prephone(String company_prephone) {
		setSearch_table("company_prephone");
		setSearch_key(company_prephone);
		this.company_prephone = company_prephone;
	}
	public String getCompany_serial() {
		return company_serial;
	}
	public void setCompany_serial(String company_serial) {
		setSearch_table("company_serial");
		setSearch_key(company_serial);
		this.company_serial = company_serial;
	}
	public String getCompany_president() {
		return company_president;
	}
	public void setCompany_president(String company_president) {
		setSearch_table("company_president");
		setSearch_key(company_president);
		this.company_president = company_president;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		setSearch_table("user_id");
		setSearch_key(user_id);
		this.user_id = user_id;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		setSearch_table("user_phone");
		setSearch_key(user_phone);
		this.user_phone = user_phone;
	}
	public Integer getRes_status() {
		return res_status;
	}
	public void setRes_status(String res_status) {
		setSearch_table("res_status");
		setSearch_key(Integer.parseInt(res_status));
		this.res_status = Integer.parseInt(res_status);
	}
	public Integer getUser_key() {
		return user_key;
	}
	public void setUser_key(Integer user_key) {
		setSearch_table("user_key");
		setSearch_key(user_key);
		this.user_key = user_key;
	}
	public String getRes_date() {
		return res_date;
	}
	public void setRes_date(String res_date) {
		setSearch_table("res_date");
		setSearch_key(res_date);
		this.res_date = res_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		setSearch_table("user_name");
		setSearch_key(user_name);
		this.user_name = user_name;
	}
	
	
	public String getSearch_table() {
		return search_table;
	}
	public void setSearch_table(String search_table) {
		this.search_table = search_table;
	}
	public Object getSearch_key() {
		return search_key;
	}
	public void setSearch_key(Object search_key) {
		this.search_key = search_key;
	}

	
}
