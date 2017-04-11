package com.bluemingo.bluemingo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bluemingo.bluemingo.domain.AdvVO;
import com.bluemingo.bluemingo.domain.Item_companyVO;
import com.bluemingo.bluemingo.domain.Ref_listVO;
import com.bluemingo.bluemingo.domain.SearchVO;
import com.bluemingo.bluemingo.service.AdvService;
import com.bluemingo.bluemingo.service.Item_companyService;
import com.bluemingo.bluemingo.service.Ref_listService;

/** Last Edit 2017-02-17 
 * AdvVO - AdvDAO - AdvService - AdvController
 * 광고 리스트 페이지
 * listAllget() advCount추가
 * pageDetail() 
 */
@Secured("ROLE_USER")
@Controller
@RequestMapping("/servlet/advertise/*")
public class AdvController {
 
	private static final Logger logger = LoggerFactory.getLogger(AdvController.class);
	
    @Autowired(required = true)
    private AdvService advService;
    
    @Autowired(required = true)
    private Item_companyService item_companyService;
    
    @Autowired(required = true)
    private Ref_listService ref_listService;
    
    /** Last Edit 2017-02-17 
     * 구분 광고번호/거래번호 광고타이틀/광고메시지/광고티커 시작일/마감일 현재수량/목표수량 가격3종 광고상태
     * Product 데이터 추가
     * 최근 거래일 기준으로 정렬(adv_time)
     * if(svo==null) 1. 광고 리스트 출력
     * else 2. 검색기능 사용 출력
     * 광고 현황판 advCount 추가함 (2017-02-17)
     */
    @RequestMapping(value="/listAll", method = RequestMethod.GET)
	public void listAllget(SearchVO svo, Model model){
		if(svo.getSearch_key() == null){
			logger.info("Adv listAllGET is called......");
			model.addAttribute("list", advService.listAll(null,null));
		}else {
			System.out.println("param : "+svo.getSearch_key());
			System.out.println("param : "+svo.getSearch_table());
			logger.info("Adv Search is called......");
			
			model.addAttribute("list", advService.search(svo));
		}
		logger.info("Adv Count add......");
		model.addAttribute("advCount", advService.listAll(null,"count").get(0));
		
	}// listAllGET()
    
    /** Last Edit 2017-02-14
     * 광고-묶음-거래키/ 묶음id-ref_list-제품-회사/ 묶음id-ref_list-제품id-ref_list(옵션)
     * listAll에서 AdvVO전달받음 SearchVO생성 후 ItemCompanyVO, RefListVO 조회
     */
    @RequestMapping(value="/detail", method = RequestMethod.GET)
	public void pageDetail(Integer adv_key, Model model){
    	logger.info("Adv PageDetail called......");
    	SearchVO svo = new SearchVO();
    	
    	if(adv_key != null){
    		logger.info("Adv PageDetail AdvVO add......"+adv_key);
    		svo.setAdv_key(adv_key);
    		AdvVO avo = advService.search(svo).get(0);
    		model.addAttribute("advVO", avo);
    		
    		svo.setProduct_id(avo.getProduct_id());
    		logger.info("Adv PageDetail ItemCompany ref_list select......");
    		List<Item_companyVO> ic_list = item_companyService.listAll(svo,null);
    		
    		logger.info("Adv PageDetail ItemOption ref_list select......");
    		svo.setSearch_table("item_option");
    		List<Ref_listVO> option_list = ref_listService.listAll(svo,"ref_list");

    		List<Item_companyVO> ic_result = ref_listService.setOptionList(option_list, ic_list);

    		model.addAttribute("itemCompanylist", ic_result);
    	}
    }
    
    
    
}