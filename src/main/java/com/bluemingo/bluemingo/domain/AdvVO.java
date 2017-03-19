package com.bluemingo.bluemingo.domain;

import java.sql.Date;
import java.sql.Time;

import javax.validation.constraints.NotNull;

/** Last Edit 2017-02-17 
 * AdvVO - AdvDAO - AdvService - AdvController
 * 광고 리스트 페이지에서 사용됨
 * Adv Count 추가 (2017-02-17)
 */
public class AdvVO {
	/**
	   AdvertiseController 에서 사용하는 VO (listAll() 결과값과  select() 전달,결과값으로 사용됨)
	   # 구분 광고번호/거래번호 광고타이틀/광고메시지/광고티커 시작일/마감일 현재수량/목표수량 가격3종 광고상태
	     Product 데이터 추가
	   # 최근 거래일 기준으로 정렬(adv_time)
	 */
	
	/* Comment 2017-02-16
	 * adv_time과 product_period의 get&set방식에 차이가 있다. Date와 Long의 차이도 있으며 이로 인한 View페이지 결과를 비교하여 원하는 방향으로 통일시켜야 하겠다.
	 * 여기와 같은 VO는 일단 SellerVO이다.
	 */
	
	private Integer adv_key;
	private String adv_ticker;
	private String adv_title;
	private String adv_message;
	private Long adv_time; //광고(거래) 시작일
	private String adv_image;
	
	private String stored_file_name;

	private String product_id;
	private Integer product_direct_price;
	private Integer product_sale_price;
	private Integer product_naver_price;
	private Integer product_min; //최대 구매 가능 수량(세트)
	private Integer deliver_company;
	private Integer deliver_price;
	
	private Integer trade_key;
	private String trade_status; //광고(거래) 상태값, 숫자 값에 따라 문자 형태로 변경 시켜줘야함
	private Long product_period; //공동구매 예약 마감일(광고(거래) 마감일)
	private Integer trade_rescount; //실시간 예약 수량
	private Integer product_max_count; //최대 목표 수량
	private Integer product_max_extra; //실제 목표 수량
	// for android list
	private Long period;
	
	// Adv Count
	private Integer wait_adv;
	private Integer progress_adv;
	private Integer purchase_adv;
	private Integer deliver_adv;
	private Integer total_adv;
	
	
	public Long getPeriod() {
		return period;
	}
	public void setPeriod(Long period) {
		this.period = period;
	}
	public Integer getWait_adv() {
		return wait_adv;
	}
	public void setWait_adv(Integer wait_adv) {
		this.wait_adv = wait_adv;
	}
	public Integer getProgress_adv() {
		return progress_adv;
	}
	public void setProgress_adv(Integer progress_adv) {
		this.progress_adv = progress_adv;
	}
	public Integer getPurchase_adv() {
		return purchase_adv;
	}
	public void setPurchase_adv(Integer purchase_adv) {
		this.purchase_adv = purchase_adv;
	}
	public Integer getDeliver_adv() {
		return deliver_adv;
	}
	public void setDeliver_adv(Integer deliver_adv) {
		this.deliver_adv = deliver_adv;
	}
	public Integer getTotal_adv() {
		return total_adv;
	}
	public void setTotal_adv(Integer total_adv) {
		this.total_adv = total_adv;
	}
	public Integer getAdv_key() {
		return adv_key;
	}
	public void setAdv_key(Integer adv_key) {
		this.adv_key = adv_key;
	}
	public String getAdv_ticker() {
		return adv_ticker;
	}
	public void setAdv_ticker(String adv_ticker) {
		this.adv_ticker = adv_ticker;
	}
	public String getAdv_title() {
		return adv_title;
	}
	public void setAdv_title(String adv_title) {
		this.adv_title = adv_title;
	}
	public String getAdv_message() {
		return adv_message;
	}
	public void setAdv_message(String adv_message) {
		this.adv_message = adv_message;
	}
	public String getAdv_image() {
		return adv_image;
	}
	public void setAdv_image(String adv_image) {
		this.adv_image = adv_image;
	}
	public String getStored_file_name() {
		return stored_file_name;
	}
	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public Integer getProduct_direct_price() {
		return product_direct_price;
	}
	public void setProduct_direct_price(Integer product_direct_price) {
		this.product_direct_price = product_direct_price;
	}
	public Integer getProduct_sale_price() {
		return product_sale_price;
	}
	public void setProduct_sale_price(Integer product_sale_price) {
		this.product_sale_price = product_sale_price;
	}
	public Integer getProduct_naver_price() {
		return product_naver_price;
	}
	public void setProduct_naver_price(Integer product_naver_price) {
		this.product_naver_price = product_naver_price;
	}
	public Integer getProduct_min() {
		return product_min;
	}
	public void setProduct_min(Integer product_min) {
		this.product_min = product_min;
	}
	public Integer getDeliver_company() {
		return deliver_company;
	}
	public void setDeliver_company(Integer deliver_company) {
		this.deliver_company = deliver_company;
	}
	public Integer getDeliver_price() {
		return deliver_price;
	}
	public void setDeliver_price(Integer deliver_price) {
		this.deliver_price = deliver_price;
	}
	public Integer getTrade_key() {
		return trade_key;
	}
	public void setTrade_key(Integer trade_key) {
		this.trade_key = trade_key;
	}
	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(Integer trade_status) {
		switch (trade_status) {
		case 1:
			this.trade_status = "광고대기";
			break;
		case 2:
			this.trade_status = "광고중";
			break;
		case 3:
			this.trade_status = "결제중";
			break;
		case 4:
			this.trade_status = "결제완료";
			break;
		case 5:
			this.trade_status = "거래완료";
			break;
		case 6:
			this.trade_status = "거래실패";
			break;
		default:
			break;
		}
	}
	public Date getProduct_period() {
		if(this.product_period != null){
			Date product_date = new Date(product_period);
			return product_date;
			}
			else
				return null;
	}
	public void setProduct_period(Date product_period) {
		this.product_period = product_period.getTime();
		setPeriod(this.product_period);
	}
	public Integer getTrade_rescount() {
		return trade_rescount;
	}
	public void setTrade_rescount(Integer trade_rescount) {
		this.trade_rescount = trade_rescount;
	}
	public Integer getProduct_max_count() {
		return product_max_count;
	}
	public void setProduct_max_count(Integer product_max_count) {
		this.product_max_count = product_max_count;
	}
	public Integer getProduct_max_extra() {
		return product_max_extra;
	}
	public void setProduct_max_extra(Integer product_max_extra) {
		this.product_max_extra = product_max_extra;
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
	/*public void setAdv_time(long adv_time) {
		this.adv_time = adv_time;
	}*/
	
	
	
}
