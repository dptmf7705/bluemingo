package com.bluemingo.bluemingo.domain;

public class AdvDetailVO {
	
	/**
	 * Advertise(광고) Data
	 */
	private Integer adv_key;
	private String adv_title;
	private String adv_message;
	private String adv_ticker;
	private Long adv_time; //광고(거래) 시작일
	private String adv_image;
	
	/**
	 * Trade(거래) 관련 Data
	 * 시작일/마감일, 현재수량/목표수량, 광고상태
	 */
	private Integer trade_key;
	private Integer trade_status; //광고(거래) 상태값, 숫자 값에 따라 문자 형태로 변경 시켜줘야함
	private Integer trade_rescount; //현재수량
	
	/**
	 * Product(묶음) Data
	 */
	private Integer product_key;
	private String product_id;
	private Integer product_direct_price;
	private Integer product_sale_price;
	private Integer product_naver_price;
	private Integer product_max_count; //최대 목표 수량
	private Integer product_max_extra; //실제 목표 수량
	private Integer product_min; //최대 구매 가능 수량(세트)
	private Long product_period; //공동구매 예약 마감일(광고(거래) 마감일)
	private Integer deliver_company;
	private Integer deliver_price;
	
	/**
	 * ref_list (product-item) 묶음-제품 리스트
	 */
	private String item_id; //제품구별값
	private Integer option_value; //제품 구매가능 수량
	
	/**
	 * Item(제품) Data
	 */
	private Integer item_key; //제품구별값
	private String item_category_top;
	private String item_category_mid;
	private String item_category_bot;
	private String item_name;
	private Integer item_direct_price;
	private Integer item_sale_price;
	private Integer item_naver_price;
	private String item_inform;
	private String item_detail_inform;
	private String item_image;
	private String item_detail_image;
	
	/**
	 * ref_list (item-option) 제품-옵션 리스트
	 */
	
	
	/**
	 * Company(회사) Data
	 */
	private Integer company_key;
	private String company_name; //상호
	private String company_president; //대표자
	private String company_address; //주소
	private String company_phone; //사업장 번호
	private String company_prephone; //대표자 번호
	private String company_serial; //사업자 번호
	private String company_homepage;
	private String company_detail; //사업체 간단 설명
	private Integer company_type; //type값에 따라 문자 형태로 변경 시켜 주어야 한다.
	
	
	
}
