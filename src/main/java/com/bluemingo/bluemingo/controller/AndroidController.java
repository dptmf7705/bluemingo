package com.bluemingo.bluemingo.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluemingo.bluemingo.domain.AdvVO;
import com.bluemingo.bluemingo.domain.ImageVO;
import com.bluemingo.bluemingo.domain.Item_companyVO;
import com.bluemingo.bluemingo.domain.LoginVO;
import com.bluemingo.bluemingo.domain.Ref_listVO;
import com.bluemingo.bluemingo.domain.SearchVO;
import com.bluemingo.bluemingo.domain.UserVO;
import com.bluemingo.bluemingo.service.AdvService;
import com.bluemingo.bluemingo.service.ImageService;
import com.bluemingo.bluemingo.service.Item_companyService;
import com.bluemingo.bluemingo.service.OrderService;
import com.bluemingo.bluemingo.service.Ref_listService;
import com.bluemingo.bluemingo.service.UserService;
import com.mysql.fabric.Response;

@Controller
@RequestMapping("/servlet/android/*")
public class AndroidController {
	private static final Logger logger = LoggerFactory.getLogger(AndroidController.class);
	
	@Autowired(required = true)
	private OrderService orderService;
	
	@Autowired(required = true)
	private AdvService advService;
	
	@Autowired(required = true)
	private ImageService imageService;
	
	@Autowired(required = true)
    private Item_companyService item_companyService;
    
    @Autowired(required = true)
    private Ref_listService ref_listService;
		
    @Autowired(required = true)
    private UserService userService;
	
	@RequestMapping(value="/test")
	public void androidTest() {
		System.out.println("android TEST");
	}
	
	/*
	@RequestMapping(value="/loginCheck", method = RequestMethod.POST)
	@ResponseBody
	public String loginCheck(@RequestBody LoginVO body) {
		System.out.println("loginCheck");
		System.out.println("id : "+body.getUser_id());
		// DB에 id,pass조회후 author(권한)획득
		// 로그인 불,허 리턴
		String author = null;
		
		// 16.12.14 테스트용으로 허가만 리턴
		author = "approve";
		return author;
	}*/
	/*
	@RequestMapping(value="/loginCheck2", method = RequestMethod.POST)
	public String loginCheck2() {
		System.out.println("loginCheck2");
		
		// DB에 id,pass조회후 author(권한)획득
		// 로그인 불,허 리턴
		String author = null;
		
		// 16.12.14 테스트용으로 불허만 리턴
		author = "denied";
		return author;
	}*/
	
	/** 안드로이드 로그인 테스트용 */
	@RequestMapping(value="/loginTest")
	public void loginTest(){
		logger.info("android loginTest called ......");
		
	}

	/** 로그인 실패 */
	@RequestMapping(value="/loginFail")
	public @ResponseBody String loginFail(){
		logger.info("android login fail ......");
		String result = "fail";
		return result;
	}
	
	/** 로그인 성공 */
	@RequestMapping(value="/loginSuccess")
	public @ResponseBody String loginSuccess(){
		logger.info("android login success ......");
		String result = "success";
		return result;
	}
	
	/** 로그인 유저 정보 json 출력 - security에서 관리하는 principal 객체 */
	@RequestMapping(value="/getUserInfo")
	@ResponseBody
	public UserVO getPrincipal(){
		logger.info("android getUser called.......");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserVO user = null;
		Object principal = auth.getPrincipal();
		if(principal != null && principal instanceof UserVO){
			user = (UserVO)principal;
		}
		return user;
	}
	
	/** 회원 가입 */
	@RequestMapping(value="/createUser")
	@ResponseBody
	public UserVO singIn(@RequestBody UserVO uservo){
		logger.info("android createUser called.......");
		
		return userService.insertProcedure(uservo);
	}
	
	@RequestMapping(value="/idCheck")
	@ResponseBody
	public int idCheck(@RequestBody String userId){
		logger.info("android idCheck called.......");
		SearchVO svo = new SearchVO();
		svo.setSearch_key(userId);
		
		if(userService.search(svo).get(0) != null) 
			return -1; // 이미 존재하는 id
		else
			return 0; // 사용 가능 id
	}
	
	/** json 으로 받은 vo객체 jsp에 넘겨서 자동 submit */
	@RequestMapping(value="/login")
	public void doLogin(Model model, @RequestBody LoginVO lvo){
		logger.info("android login is called......" + lvo.toString());
		model.addAttribute("loginId", lvo.getLoginId());
		model.addAttribute("loginPassword", lvo.getLoginPassword());
	}
	
	
	/** 2017-02-20
	 * 안드로이드-제품리스트 조회
	 */
	@RequestMapping(value="/getAdvList", method = RequestMethod.GET)
	@ResponseBody
	public List<AdvVO> getAdvlist(){
		logger.info("App-Request getAdvList is called......");
		List<AdvVO> result = advService.listAll(null,null);

		return result;
	}
	
	/** 2017-02-24
	 * 안드로이드-제품리스트 조회
	 */
	@RequestMapping(value="/getItemDetail", method = RequestMethod.GET)
	@ResponseBody
	public List<Item_companyVO> getAdvDetail(String product_id){
		logger.info("App-Request getItemDetail called......");
    	SearchVO svo = new SearchVO();
    	
    	if(product_id != null){
    		svo.setProduct_id(product_id);
    		logger.info("App-Request getItemDetail ItemCompany ref_list select......");
    		List<Item_companyVO> ic_list = item_companyService.listAll(svo,null);
    		
    		logger.info("App-Request getItemDetail ItemOption ref_list select......");
    		svo.setSearch_table("item_option");
    		List<Ref_listVO> option_list = ref_listService.listAll(svo,"ref_list");

    		List<Item_companyVO> ic_result = ref_listService.setOptionList(option_list, ic_list);

    		return ic_result;
    	}else{
    		return null;
    	}
	}
	
	
	

	/*
	@RequestMapping(value = "/orderPurchase", method = RequestMethod.POST)
	@ResponseBody
	public String orderPurchase(@RequestBody OrderVO body) {
		System.out.println("android connection Try : orderPurchase");
		String result = null;
		Integer status = 0;
		
		body.setRes_status(1);
		body.setRes_deli_code(null);
		if(checkPeriod(body.getPeriod())){
			status = orderService.create(body);
			System.out.println("status : "+status);
			if(status > 0){
				result = "success";
			}else{
				result = "failed";
			}
		}else{
			result = "failed";
		}
		System.out.println("android connection Try : orderPurchase result : "+result);
		return result;
	}*/
	
	/*@RequestMapping(value = "/orderPurchase", method = RequestMethod.POST)
	public String orderPurchase(@RequestBody OrderVO body, ModelMap model) {
		System.out.println("android connection Try : orderPurchase" + body);
		System.out.println("android connection Try : orderPurchase" + body.getPeriod());
		System.out.println("android connection Try : orderPurchase" + body.getTrade_key());
		String result = null;
		Integer status = null;
		
		model.addAttribute("body",body);
		return "/android/list";
		
		jsonObject.setRes_status(1);
		jsonObject.setRes_deli_code(null);
		if(checkPeriod(jsonObject.getPeriod())){
			status = orderService.create(jsonObject);
			if(status != null){
				result = "success";
			}
			result = "failed";
		}else{
			result = "failed";
		}
		//return result;
	}*/
	
	public Boolean checkPeriod (Long period) {
		TimeZone zone = TimeZone.getTimeZone("Asia/Seoul");
        Calendar cal = new GregorianCalendar(zone).getInstance();
        long now_time = cal.getTimeInMillis();
        long standard = 10;
		
        long res_time = period - now_time;
        System.out.println("res_time : "+res_time);
        System.out.println("standard : "+standard);
        if(res_time >= standard){
        	return true;
        }
        return false;
	}
	
	@RequestMapping(value="/imageList", method = RequestMethod.GET)
	public void imageList(Model model){
		logger.info("listAllGET is called......");
		List<ImageVO> list = imageService.listAll(null,null);
		model.addAttribute("list", list);
	}// listAllGET()
	
	@RequestMapping(value="/imageDownload", method = RequestMethod.GET)
	public void downloadFile(@RequestParam("image_key") Integer image_key, HttpServletResponse response) throws Exception{
		logger.info("ImageDownload is called......");
		ImageVO ivo = imageService.read(image_key);
	    String storedFileName = ivo.getStored_file_name();
	    String originalFileName = ivo.getOriginal_file_name();
	     
	    byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("www/bluemingo/image/"+storedFileName));
	     
	    response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	}
	
	/*@RequestMapping(value="/adv/{adv_key}", method = RequestMethod.GET)
	@ResponseBody
	public AdvVO getShopInJSON(@PathVariable Integer adv_key) {
		System.out.println("android connection Try");
		return advService.read(adv_key);
	}*/
	
	
}// class