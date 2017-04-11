package com.bluemingo.bluemingo.controller;

import java.io.File;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.bluemingo.bluemingo.domain.ImageVO;
import com.bluemingo.bluemingo.domain.Item_companyVO;
import com.bluemingo.bluemingo.domain.Ref_listVO;
import com.bluemingo.bluemingo.domain.SearchVO;
import com.bluemingo.bluemingo.domain.SellerVO;
import com.bluemingo.bluemingo.service.AdvService;
import com.bluemingo.bluemingo.service.ImageService;
import com.bluemingo.bluemingo.service.Item_companyService;
import com.bluemingo.bluemingo.service.Ref_listService;
import com.bluemingo.bluemingo.service.SellerService;
import com.bluemingo.bluemingo.util.FileUtils;

/** Last Edit 2017-02-26 
 * 판매자-제품-묶음-광고 CRUD 컨트롤러
 * 
 */
@Controller
@RequestMapping("/servlet/crud/*")
public class CrudController {
	
	private static final Logger logger = LoggerFactory.getLogger(CrudController.class);
	
	@Autowired(required = true)
	private AdvService advService;
	
	@Autowired(required = true)
    private Item_companyService item_companyService;
    
    @Autowired(required = true)
    private Ref_listService ref_listService;
	
	@Autowired(required = true)
	private FileUtils fileUtils;
	
	@Autowired(required = true)
	private ImageService imageService;
	
	/** Last Edit 2017-03-03 
	 *  All Controller must have this Method
	 *  webPage msg Controller(to javaScript)
	 */	
	public void msgCreate(String purpose, String from, String status, Object value,
			RedirectAttributes rttr, Model model){
		
		if(rttr != null){
			rttr.addFlashAttribute("msg_purpose", purpose);
			rttr.addFlashAttribute("msg_from", from);
			rttr.addFlashAttribute("msg_status", status);
			rttr.addFlashAttribute("msg_value", value);
		}else{
			model.addAttribute("msg_purpose", purpose);
			model.addAttribute("msg_from", from);
			model.addAttribute("msg_status", status);
			model.addAttribute("msg_value", value);
		}
		
	}
	
	/** Last Edit 2017-02-27 
	 *  imageUpload - image file upload to server in /www/bluemingo/image
	 *  with javaScript & ajax
	 *  in file data(request) out result-stored_file_name(response)
	 */	
	@RequestMapping(value="/imageUpload", method = RequestMethod.POST)
	@ResponseBody
	public String imageUpload(HttpServletRequest request, HttpServletResponse response) throws Exception{
		logger.info("ImageUpload - item is called..... ");
		ImageVO cvo = null;
		if(request == null){
			return "fail";
		}else{
			if((cvo = imageService.imageInsert(request)) == null) {
				logger.info("image upload fail");
				return "fail";
			}
			else {
				logger.info("image upload Success");
				return cvo.getStored_file_name();
			}
		}
	}// imageUploadPost()
	
	/** Last Edit 2017-03-09 
	 *  Company Create 
	 *  CreateGet
	 */	
	@RequestMapping(value="/companyCreate", method = RequestMethod.GET)
	public void companyCreateGet(Model model) {
		logger.info("companyCreateGet is called..... ");
		
	}// itemCreateGET()
	
	/** Last Edit 2017-03-09 
	 *  Company Create 
	 *  CreatePost
	 */	
	@RequestMapping(value="/companyCreate", method = RequestMethod.POST)
	public String companyCreatePost(Item_companyVO vo, RedirectAttributes rttr) throws Exception{
		logger.info("companyCreatePost is called..... ");
		Item_companyVO icVO = null;
		
		if(vo != null){
			logger.info("create ICVO data : "+vo.getCompany_name());
			
			try{
				icVO = item_companyService.insertProcedure(vo,"company");
			}catch(Exception e){
				e.printStackTrace();
				
				msgCreate("create", "company", "fail", "잘못된 데이터", rttr, null);
				return "redirect:/servlet/crud/companyCreate";
			}
			logger.info("companyCreatePost success");
			msgCreate("create", "company", "success", "판매자 삽입", rttr, null);
			rttr.addAttribute("company_key", icVO.getCompany_key());
			return "redirect:/servlet/crud/companyUpdate";
		}else{
			// 데이터가 전달이 안되었을 경우 즉 NO DATA
			// 다시 처음부터!, 업로드된 이미지 모두 삭제.
			logger.info("companyCreatePost fail");
			msgCreate("create", "company", "fail_no_data", "다시 시도해주세요", rttr, null);
			return "redirect:/servlet/crud/companyCreate";
		}
	}// companyCreatePost()
	
	/** Last Edit 2017-03-09 
	 *  Company Update 
	 *  UpdateGet
	 */	
	@RequestMapping(value="/companyUpdate", method = RequestMethod.GET)
	public String companyUpdateGet(@RequestParam("company_key")Integer company_key, Model model, RedirectAttributes rttr){
		logger.info("companyUpdateGet is called..... ");
		SearchVO svo = new SearchVO();
		if(company_key != null){
			
			logger.info("companyUpdateGet companyVO search......");
			svo.setCompany_key(company_key);
			List<Item_companyVO> ic_list = item_companyService.search(svo);			
			
			
			if(!ic_list.isEmpty()){
				model.addAttribute("icVO", ic_list.get(0));
				msgCreate("read", "company", "success", "판매자 조회", null, model);
			}else{
				msgCreate("read", "company", "fail_no_data", "판매자 조회", rttr, null);
				return "redirect:/servlet/crud/multiRead";
			}
		}
		return null;
	}// companyUpdateGet()
	
	/** Last Edit 2017-02-26 
	 *  Item Create - option(Ref_list)
	 *  CreateGet - new item_id make
	 */	
	@RequestMapping(value="/itemCreate", method = RequestMethod.GET)
	public void itemCreateGet(Model model) {
		logger.info("itemCreateGET is called..... ");
		
		Calendar cal = Calendar.getInstance();
		TimeZone zone = TimeZone.getTimeZone("Asia/Seoul");
		cal.setTimeZone(zone);
		long  now_time = cal.getTimeInMillis();
		Date date = new Date(now_time);
        String str_nowTime = (new SimpleDateFormat("yyyy_MM_dd").format(date));

		String item_id = null;
		item_id = item_companyService.listAll(null, "item_id").get(0).getItem_id();
		if(item_id != null) {
			logger.info("itemCreateGET is called..... " + item_id.substring(1,11));
			
			logger.info("itemCreateGET is called..... " + str_nowTime);
			String sub_id = item_id.substring(1,11);
			Integer id_num = Integer.parseInt(item_id.substring(12,item_id.length()));
			logger.info("itemCreateGET is called..... " + id_num);
			if(sub_id.equals(str_nowTime)){
				item_id = "i"+sub_id+"_"+(id_num+1);
			}else{
				item_id = "i"+str_nowTime+"_"+0;
			}
		}
		model.addAttribute("item_id", item_id);
		
	}// itemCreateGET()
	
	/** Last Edit 2017-02-26 
	 *  Item Create - option(Ref_list)
	 *  CreateGet - new item_id make
	 */	
	@RequestMapping(value="/itemCreate", method = RequestMethod.POST)
	public String itemCreatePost(Item_companyVO vo, RedirectAttributes rttr) throws Exception{
		logger.info("itemCreatePOST is called..... ");
		Item_companyVO icVO = null;
		SearchVO svo = new SearchVO();
		int count = 0;
		
		if(vo != null){
			logger.info("create ICVO data : "+vo.getItem_name());
			
			try{
				icVO = item_companyService.insertProcedure(vo,"item");
			}catch(Exception e){
				e.printStackTrace();
				//데이터 삽입 실패한 경우 필요 데이터가 없거나 DB문제, MySqal query문제 등등
				try{
					svo.setStored_file_name(vo.getItem_image());
					count += (Integer)imageService.deleteProcedure(svo).getResult();
					svo.setStored_file_name(vo.getItem_detail_image());
					count += (Integer)imageService.deleteProcedure(svo).getResult();
				}catch(Exception e2){
					e2.printStackTrace();
				}
				msgCreate("create", "item", "fail", vo.getItem_id(), rttr, null);
				return "redirect:/servlet/crud/itemCreate";
			}
			String item_id = vo.getItem_id();
			
			if(vo.getOption_list() != null && icVO != null){
				logger.info("option_list size : "+vo.getOption_list().size());
				
				for (int i = 0; i < vo.getOption_list().size(); i++) {
					if (vo.getOption_list().get(i).getOption_price() != null) {
						vo.getOption_list().get(i).setItem_id(item_id);
						try {
							count += (Integer)ref_listService.createProcedure(
									vo.getOption_list().get(i)).getResult();
						} catch (Exception e) {
							//제품 DATA는 전송된 상태, 옵션은 처움부터 다시 작성하라고 하는게 좋을듯
							//데이터 삽입 실패한 경우 필요 데이터가 없거나 DB문제, MySqal query문제 등등
							//만약 count>0 이면 삽입된 데이터 존재, 해당 데이터 삭제 진행해야함.
							e.printStackTrace();
							break;
						}
					}
				}
				if(count == vo.getOption_list().size()){
					// 제품+옵션까지 모두 정상적으로 삽입된 경우, 완전한 성공
					// 옵션이 0개인 경우 이 과정으로 접근이 안된다.
					logger.info("itemCreatePOST success");
					msgCreate("create", "item", "success", item_id, rttr, null);
					
				}else{
					// 전송받은 옵션이 모두 정상적으로 삽입되지 않은 경우이다.
					// 제품 DATA는 전송된 상태, 옵션은 처움부터 다시 작성하라고 하는게 좋을듯
					// 실패시 먼저 삽입된 데이터 (count>0 일 경우) 삭제 시켜야한다.
					if(count > 0){
						svo.setItem_id(item_id);
						while(count != 0){
							try{
								count -= (Integer)ref_listService.deleteProcedure(svo).getResult();
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					}
					logger.info("itemCreatePOST option_list");
					msgCreate("create", "item", "fail_option", item_id, rttr, null);
				}
			}
			// 제품+옵션 모두 성공 or 제품만 성공한 경우(옵션실패)
			rttr.addAttribute("item_id", icVO.getItem_id());
			return "redirect:/servlet/crud/itemUpdate";
		}else{
			// 데이터가 전달이 안되었을 경우 즉 NO DATA
			// 다시 처음부터!, 업로드된 이미지 모두 삭제.
			logger.info("itemCreatePOST fail");
			msgCreate("create", "item", "fail_no_data", "다시 시도해주세요", rttr, null);
			return "redirect:/servlet/crud/itemCreate";
		}
	}// itemCreatePOST()
	
	/** Last Edit 2017-02-26 
	 *  Item Update = Item Read (Item_companyVO + Ref_listVO)
	 */	
	@RequestMapping(value="/itemUpdate", method = RequestMethod.GET)
	public String itemUpdateGet(@RequestParam("item_id")String item_id, Model model, RedirectAttributes rttr){
		logger.info("itemUpdateGet is called..... ");
		SearchVO svo = new SearchVO();
		if(item_id != null){
			
			logger.info("itemUpdateGet ItemOption ref_list select......");
			svo.setItem_id(item_id);
			List<Ref_listVO> option_list = ref_listService.listAll(svo,"ref_list");
			
			logger.info("itemUpdateGet item data get id : "+item_id);
			svo.setItem_id(item_id);			
			List<Item_companyVO> ic_list = item_companyService.search(svo);
			
			List<Item_companyVO> ic_result = ref_listService.setOptionList(option_list, ic_list);
			
			if(!ic_result.isEmpty()){
				model.addAttribute("icVO", ic_result.get(0));
				msgCreate("read", "item", "success", item_id, null, model);
			}else{
				msgCreate("read", "item", "fail_no_data", item_id, rttr, null);
				return "redirect:/servlet/crud/multiRead";
			}
		}
		return null;
	}// itemUpdateGet()
	
	/**
	 * updatePost 미구현되있네 ? ㅅㅂ
	 */
	
	
	/** Last Edit 2017-03-02
	 *  Multi Read - search_data get
	 */	
	@RequestMapping(value="/multiRead", method = RequestMethod.GET)
	public void multiRead(Model model, RedirectAttributes rttr){
		
	}
	
	/** Last Edit 2017-03-02
	 *  Multi Read Search - company,product,item,advertise - to _Update
	 */	
	@RequestMapping(value="/multiReadSearch", method = RequestMethod.GET)
	public String multiReadSearch(SearchVO svo, Model model, RedirectAttributes rttr){
		logger.info("multiRead searchKey : "+svo.getSearch_key());
		if(svo.getSearch_key() != null){
			if(svo.getSearch_table().equals("item_id")){
				rttr.addAttribute("item_id", svo.getSearch_key());
				return "redirect:/servlet/crud/itemUpdate";
			}
		}
		return null;
	}

	
	/*
	@RequestMapping(value="/itemUpdate", method = RequestMethod.GET)
	public void advCreateGET(@RequestParam("adv_key")Integer adv_key, Model model){
		logger.info("createGET is called..... ");
		if(adv_key != 0){
			logger.info("createREAD is called..... ");
			AdvVO vo = advService.read(adv_key);
			model.addAttribute("advVO", vo);
		}
		
	}// createGET()
	
	@RequestMapping(value="/itemUpdate", method = RequestMethod.POST)
	public String advCreatePOST(AdvVO vo, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		logger.info("createPOST is called..... ");
		ImageVO cvo = null;
		if((cvo = imageService.imageCreate(request)) == null) {
			logger.info("image upload fail");
			rttr.addFlashAttribute("createMsg", "image upload fail");			
		}
		else {
			vo.setAdv_image(cvo.getStored_file_name());
			logger.info("image upload Success");
			rttr.addFlashAttribute("createMsg", "Image upload Success");
		}
		
		logger.info("create AdvVO data : "+vo.getAdv_image());
		logger.info("create AdvVO data : "+vo.getAdv_title());
		logger.info("create AdvVO data : "+vo.getAdv_ticker());
		logger.info("create AdvVO data : "+vo.getAdv_time());
		logger.info("create AdvVO data : "+vo.getAdv_message());
		List<AdvVO> list = advService.procedure(vo);
		if(list.get(0) != null){
			rttr.addFlashAttribute("createMsg", "success");
			rttr.addAttribute("adv_key", list.get(0).getAdv_key());
		}
		
		return "redirect:/servlet/create/advCreate";
		
	}// createPOST()
*/	
	
	
	
	
	
	
	/**
	 * advertiseService Create,Read,Delete,Update (CRUD)
	 */
	/*
	@RequestMapping(value="/advList", method = RequestMethod.GET)
	public void listAllGET(Model model){
		
		logger.info("listAllGET is called......");
		List<AdvertiseVO> list = advertiseService.listAll();
		String stored_file_name = null;
		for(int i=0; i<list.size(); i++){
			list.get(i).setNow_count();
		}
		
		
		model.addAttribute("list", list);
		
	}// listAllGET()
	
	@RequestMapping(value="/advCreate", method = RequestMethod.GET)
	public void advCreateGET(@RequestParam("adv_key")Integer adv_key, Model model){
		logger.info("createGET is called..... ");
		if(adv_key != 0){
			logger.info("createREAD is called..... ");
			AdvVO vo = advService.read(adv_key);
			model.addAttribute("advVO", vo);
		}
		
	}// createGET()
	
	@RequestMapping(value="/advCreate", method = RequestMethod.POST)
	public String advCreatePOST(AdvVO vo, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		logger.info("createPOST is called..... ");
		ImageVO cvo = null;
		if((cvo = imageService.imageCreate(request)) == null) {
			logger.info("image upload fail");
			rttr.addFlashAttribute("createMsg", "image upload fail");			
		}
		else {
			vo.setAdv_image(cvo.getStored_file_name());
			logger.info("image upload Success");
			rttr.addFlashAttribute("createMsg", "Image upload Success");
		}
		
		logger.info("create AdvVO data : "+vo.getAdv_image());
		logger.info("create AdvVO data : "+vo.getAdv_title());
		logger.info("create AdvVO data : "+vo.getAdv_ticker());
		logger.info("create AdvVO data : "+vo.getAdv_time());
		logger.info("create AdvVO data : "+vo.getAdv_message());
		List<AdvVO> list = advService.procedure(vo);
		if(list.get(0) != null){
			rttr.addFlashAttribute("createMsg", "success");
			rttr.addAttribute("adv_key", list.get(0).getAdv_key());
		}
		
		return "redirect:/servlet/create/advCreate";
		
	}// createPOST()
	
	@RequestMapping(value="/imageDownload")
	public void downloadFile(Integer image_key, HttpServletResponse response) throws Exception{
		logger.info("ImageDownloading.....");
		ImageVO ivo = imageService.read(image_key);

	    fileUtils.downloadFile(ivo, response);

	}
	
	@RequestMapping(value="/advRead", method= RequestMethod.GET)
	public void advReadGET(@RequestParam("adv_key") Integer adv_key, Model model){
		
		model.addAttribute("advVO", advertiseService.read(adv_key));
		
	}// readGET()
	
	@RequestMapping(value="/advUpdate", method=RequestMethod.GET)
	public void advUpdateGET(@RequestParam("adv_key") Integer adv_key, Model model){
		
		model.addAttribute("advVO", advertiseService.read(adv_key));
		
	}// updateGET()
	
	@RequestMapping(value="/advUpdate", method=RequestMethod.POST)
	public String advUpdatePOST(AdvertiseVO vo, RedirectAttributes rttr){
		
		logger.info("updatePOST is called......");
		
		advertiseService.update(vo);
		
		rttr.addFlashAttribute("updateMsg", "success");
		
		return "redirect:/servlet/create/main";
		
	}// updatePOST()
	
	@RequestMapping(value="/advDelete", method= RequestMethod.POST)
	public String advDeletePOST(@RequestParam("adv_key") Integer adv_key, RedirectAttributes rttr){
		
		advertiseService.delete(adv_key);
		
		rttr.addFlashAttribute("deleteMsg", "success");
		rttr.addFlashAttribute("adv_key", adv_key);
		
		return "redirect:/servlet/create/main";
	}

	
	
	*//**
	 * itemService Create,Read,Delete,Update (CRUD)
	 *//*
	
	@RequestMapping(value="/itemCreate", method = RequestMethod.GET)
	public void itemCreateGET(){
		
		logger.info("createGET is called......");
		
	}// createGET()
	
	@RequestMapping(value="/itemCreate", method = RequestMethod.POST)
	public String itemCreatePOST(ItemCompanyVO vo, RedirectAttributes rttr){
		
		logger.info("createPOST is called......");
		
		itemService.create(vo);
		
		rttr.addFlashAttribute("createMsg", "success");
		
		return "redirect:/servlet/create/main";
		
	}// createPOST()
	
	@RequestMapping(value="/itemRead", method= RequestMethod.GET)
	public void itemReadGET(@RequestParam("item_key") Integer item_key, Model model){
		
		model.addAttribute("itemVO", itemService.read(item_key));
		
	}// readGET()
	
	@RequestMapping(value="/itemUpdate", method=RequestMethod.GET)
	public void itemUpdateGET(@RequestParam("item_key") Integer item_key, Model model){
		
		model.addAttribute("itemVO", itemService.read(item_key));
		
	}// updateGET()
	
	@RequestMapping(value="/itemUpdate", method=RequestMethod.POST)
	public String itemUpdatePOST(ItemCompanyVO vo, RedirectAttributes rttr){
		
		logger.info("updatePOST is called......");
		
		itemService.update(vo);
		
		rttr.addFlashAttribute("updateMsg", "success");
		
		return "redirect:/servlet/create/main";
		
	}// updatePOST()
	
	@RequestMapping(value="/itemDelete", method= RequestMethod.POST)
	public String itemDeletePOST(@RequestParam("item_key") Integer item_key, RedirectAttributes rttr){
		
		itemService.delete(item_key);
		
		rttr.addFlashAttribute("deleteMsg", "success");
		rttr.addFlashAttribute("item_key", item_key);
		
		return "redirect:/servlet/create/main";
	}
	

	
	*//**
	 * productService Create,Read,Delete,Update (CRUD)
	 *//*
	
	@RequestMapping(value="/productCreate", method = RequestMethod.GET)
	public void productCreateGET(){
		
		logger.info("createGET is called......");
		
	}// createGET()
	
	@RequestMapping(value="/productCreate", method = RequestMethod.POST)
	public String productCreatePOST(ProductVO vo, RedirectAttributes rttr){
		
		logger.info("createPOST is called......");
		
		productService.create(vo);
		
		rttr.addFlashAttribute("createMsg", "success");
		
		return "redirect:/servlet/create/main";
		
	}// createPOST()
	
	@RequestMapping(value="/productRead", method= RequestMethod.GET)
	public void productReadGET(@RequestParam("product_key") Integer product_key, Model model){
		
		model.addAttribute("productVO", productService.read(product_key));
		
	}// readGET()
	
	@RequestMapping(value="/productUpdate", method=RequestMethod.GET)
	public void productUpdateGET(@RequestParam("product_key") Integer product_key, Model model){
		
		model.addAttribute("productVO", productService.read(product_key));
		
	}// updateGET()
	
	@RequestMapping(value="/productUpdate", method=RequestMethod.GET)
	public String productUpdatePOST(RedirectAttributes rttr){
		
		logger.info("updatePOST is called......");
		
		ProductVO vo = new ProductVO();
		vo.setProduct_min(3);
		vo.setDeliver_company(1);
		vo.setDeliver_price(3000);
		vo.setProduct_num(7);
		
		Calendar cal = Calendar.getInstance();
		TimeZone zone = TimeZone.getTimeZone("Asia/Seoul");
		cal.setTimeZone(zone);
		long  now_time = cal.getTimeInMillis();
		Date date = new Date(now_time);
        String str_nowTime = (new SimpleDateFormat("yyyy_MM_dd").format(date));
        
		String id = "p"+str_nowTime+"_"+vo.getProduct_num();
		
		vo.setProduct_id(id);
		
		List<ProductVO> list = productService.procedure(vo);
		
		//rttr.addFlashAttribute("updateMsg", "success");
		rttr.addAttribute("pkey", list.get(0).getProduct_key());
		
		return "redirect:/servlet/create/productList";
		
	}// updatePOST()
	
	@RequestMapping(value="/productList")
	public void productlistAllGET(@RequestParam("pkey") int pkey, Model model){
		
		logger.info("listAllGET is called......");
		//List<ProductVO> list = productService.procedure(vo);
		List<ProductVO> list = new ArrayList<ProductVO>();
		ProductVO pvo = productService.read(pkey);
		
		list.add(pvo);
		
		model.addAttribute("list", list);
		//return  "productList";
	}// listAllGET()
	
	@RequestMapping(value="/productUpdate", method=RequestMethod.POST)
	public String productUpdatePOST(ProductVO vo, RedirectAttributes rttr){
		
		logger.info("updatePOST is called......");
		
		productService.update(vo);
		
		rttr.addFlashAttribute("updateMsg", "success");
		
		return "redirect:/servlet/create/main";
		
	}// updatePOST()
	
	@RequestMapping(value="/productDelete", method= RequestMethod.POST)
	public String productDeletePOST(@RequestParam("product_key") Integer product_key, RedirectAttributes rttr){
		
		productService.delete(product_key);
		
		rttr.addFlashAttribute("deleteMsg", "success");
		rttr.addFlashAttribute("product_key", product_key);
		
		return "redirect:/servlet/create/main";
	}
	
	
	*//** seller(company)
	 * sellerService Create,Read,Delete,Update (CRUD)
	 *//*
	
	@RequestMapping(value="/companyCreate", method = RequestMethod.GET)
	public void companyCreateGET(){
		
		logger.info("createGET is called......");
		
	}// createGET()
	
	@RequestMapping(value="/companyCreate", method = RequestMethod.POST)
	public String companyCreatePOST(SellerVO vo, RedirectAttributes rttr){
		
		logger.info("createPOST is called......");
		
		sellerService.create(vo);
		
		rttr.addFlashAttribute("createMsg", "success");
		
		return "redirect:/servlet/create/main";
		
	}// createPOST()
	
	@RequestMapping(value="/companyRead", method= RequestMethod.GET)
	public void companyReadGET(@RequestParam("company_key") Integer company_key, Model model){
		
		model.addAttribute("companyVO", sellerService.read(company_key));
		
	}// readGET()
	
	@RequestMapping(value="/companyUpdate", method=RequestMethod.GET)
	public void companyUpdateGET(@RequestParam("company_key") Integer company_key, Model model){
		
		model.addAttribute("companyVO", sellerService.read(company_key));
		
	}// updateGET()
	
	@RequestMapping(value="/companyUpdate", method=RequestMethod.POST)
	public String companyUpdatePOST(SellerVO vo, RedirectAttributes rttr){
		
		logger.info("updatePOST is called......");
		
		sellerService.update(vo);
		
		rttr.addFlashAttribute("updateMsg", "success");
		
		return "redirect:/servlet/create/main";
		
	}// updatePOST()
	
	@RequestMapping(value="/companyDelete", method= RequestMethod.POST)
	public String companyDeletePOST(@RequestParam("company_key") Integer company_key, RedirectAttributes rttr){
		
		sellerService.delete(company_key);
		
		rttr.addFlashAttribute("deleteMsg", "success");
		rttr.addFlashAttribute("company_key", company_key);
		
		return "redirect:/servlet/create/main";
	}*/
}
