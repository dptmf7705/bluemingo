package com.bluemingo.bluemingo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bluemingo.bluemingo.domain.AdvVO;
import com.bluemingo.bluemingo.domain.SearchVO;
import com.bluemingo.bluemingo.domain.SellerVO;
import com.bluemingo.bluemingo.service.SellerService;

/** Last Edit 2017-02-17 
 * SellerVO - SellerDAO - SellerService - SellerController
 * 판매자 리스트 페이지에서 사용됨
 * listAllget() 
 * pageDetail()
 */
@Controller
@RequestMapping("/servlet/seller/*")
public class SellerController {
	private static final Logger logger = LoggerFactory.getLogger(SellerController.class);
	
    @Autowired(required = true)
    private SellerService sellerService;
	
    
    /** Last Edit 2017-02-17 
     * 구분/판매자키/상호명/대표명/회사전화/대표전화/진행광고수/총광고수
     * Product 데이터 추가
     * 최근 거래일 기준으로 정렬(if(max>priority,max,priority)) max(trade_key)
     * if(svo==null) 1. 광고 리스트 출력
     * else 2. 검색기능 사용 출력
     * 판매자 기준 광고 현황판 companyCount 추가함 (2017-02-17)
     */
	@RequestMapping(value="/listAll", method = RequestMethod.GET)
	public void listAllget(SearchVO svo, Model model){
		if(svo.getSearch_key() == null){
			logger.info("Seller listAllGET is called......");
			model.addAttribute("list", sellerService.listAll(null,null));
		}else {
			System.out.println("param : "+svo.getSearch_key());
			System.out.println("param : "+svo.getSearch_table());
			logger.info("Seller search is called......");
			
			model.addAttribute("list", sellerService.search(svo));
		}
		logger.info("Seller Count add......");
		model.addAttribute("companyCount", sellerService.listAll(null,"count").get(0));
		
	}// listAllGET()
	
	/** Last Edit 2017-02-17
     * 판매자 정보 All / 판매자가 연관된 모든 광고, 제품,가격,광고일(시작~마감) 상태값 출력
     * procedure - seller_select(company_key)
     */
    @RequestMapping(value="/detail", method = RequestMethod.GET)
	public void pageDetail(Integer company_key, Model model){
    	logger.info("Seller PageDetail called......");
    	SearchVO svo = new SearchVO();
    	
    	if(company_key != null){
    		logger.info("Seller PageDetail CompanyVO add......"+company_key);
    		svo.setCompany_key(company_key);
    		model.addAttribute("sellerVO", sellerService.search(svo).get(0));
    		
    		logger.info("Seller PageDetail seller-item list add......"+company_key);
    		model.addAttribute("sellerItemlist",sellerService.listAll(svo,"select"));
    	}
    }

	
}
