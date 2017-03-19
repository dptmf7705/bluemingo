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

import com.bluemingo.bluemingo.domain.OrderVO;
import com.bluemingo.bluemingo.domain.SearchVO;
import com.bluemingo.bluemingo.service.OrderService;
import com.bluemingo.bluemingo.service.Ref_listService;

/** Last Edit 2017-02-18 
 * OrderO - OrderDAO - OrderService - OrderController
 * 주문 리스트 페이지에서 사용됨
 */
@Controller
@RequestMapping("/servlet/order/*")
public class OrderController {

	private static final Logger logger = LoggerFactory
			.getLogger(OrderController.class);

	@Autowired(required = true)
	private OrderService orderService;
	
	@Autowired(required = true)
    private Ref_listService ref_listService;

    
    /** Last Edit 2017-02-18 
     * 회원번호 / 주문번호 / 구매방법 / 제품id / 구매자이름 / 구매자아이디 / 주문금액 / 주문수량 / 주문상태
     * 최근 거래일 기준으로 정렬 res_key가 곧 최근거래시점을 나타냄
     * if(svo==null) 1. 광고 리스트 출력
     * else 2. 검색기능 사용 출력
     * 주문량 현황판 orderCount 추가함 (2017-02-18)
     */
	@RequestMapping(value="/listAll", method = RequestMethod.GET)
	public void listAllget(SearchVO svo, Model model){
		if(svo.getSearch_key() == null){
			logger.info("Order listAllGET is called......");
			model.addAttribute("list", orderService.listAll(null,null));
		}else {
			System.out.println("param : "+svo.getSearch_key());
			System.out.println("param : "+svo.getSearch_table());
			logger.info("Seller search is called......");
			
			model.addAttribute("list", orderService.search(svo));
		}
		logger.info("Order Count add......");
		model.addAttribute("orderCount", orderService.listAll(null,"count").get(0));
		
	}// listAllGET()
	
	/** Last Edit 2017-02-18
     * 주문 정보 All / 주문-배송 정보 / res_id그룹 주문 제품정보 리스트
     * procedure - order_search(res_id) 주문-배송 정보
     * procedure - order_select(res_id) 주문-옵션 정보
     * 
     */
    @RequestMapping(value="/detail", method = RequestMethod.GET)
	public void pageDetail(String res_id, Model model){
    	logger.info("Seller PageDetail called......");
    	SearchVO svo = new SearchVO();
    	
    	if(res_id != null){
    		svo.setRes_id(res_id);
    		logger.info("Order PageDetail reservationVO add......"+res_id);
    		model.addAttribute("resVO", orderService.search(svo).get(0));
    		
    		logger.info("Order PageDetail resDeliverVO add......"+res_id);
    		model.addAttribute("resDeliverVO",ref_listService.listAll(svo,"ref_list").get(0));
    		
    		logger.info("Order PageDetail res-itemOption list add......"+res_id);
    		model.addAttribute("resOptionlist", orderService.listAll(svo,"select"));

    	}
    }
    
    
}
