package com.bluemingo.bluemingo.persistence;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.inject.Inject;

import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bluemingo.bluemingo.controller.AbstractTest;
import com.bluemingo.bluemingo.domain.AdvVO;
import com.bluemingo.bluemingo.domain.Item_companyVO;
import com.bluemingo.bluemingo.domain.Ref_listVO;
import com.bluemingo.bluemingo.domain.SearchVO;
import com.bluemingo.bluemingo.persistence.AdvDAO;
import com.bluemingo.bluemingo.service.AdvService;
import com.bluemingo.bluemingo.service.Item_companyService;
import com.bluemingo.bluemingo.service.Ref_listService;
import com.bluemingo.bluemingo.util.CommonUtils;


public class AdvDAOTest extends AbstractTest{

	private SqlSessionTemplate session;

	private static final Logger logger = LoggerFactory.getLogger(AdvDAOTest.class);

    @Autowired(required = true)
    private Item_companyService item_companyService;
	
	@Autowired(required = true)
    private Ref_listService ref_listService;
	
	@Test
	public void optionList() {
		SearchVO svo = new SearchVO();
		svo.setItem_id("i2017_02_27_0");			
		
		int count = 0;
		svo = ref_listService.deleteProcedure(svo);
		System.out.println("count : "+svo.getResult());
	}
	
	
	/*@Test
	public void test() {
		logger.info(""+session.getConnection());
		
		//logger.info(""+session.selectOne("com.bluemingo.bluemingo.domain.TimeVOMapper.getNow"));
		
		
	}// test()
*/	
	/*
	@Test
	public void sqlTest3() {
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
		vo.setProduct_period(date);
		
		List<ProductVO> list = new ArrayList<ProductVO>();
		list.add(vo);
		list.add(vo);
		
		pservice.multiCreate(list);
		//int key = pservice.create(vo);
				
		List<ProductVO> list = pservice.procedure(vo);
		//logger.info("procedure:insert_product : "+list.get(0));
		
		System.out.println("key : "+list.get(0).getProduct_key());
	}
	*/
	/*@Test
	public void Time(){
		testTime(service.listAll());
	}
	
	public void testTime(List<AndroidVO> vo){
		Calendar cal = Calendar.getInstance();
		TimeZone zone = TimeZone.getTimeZone("Asia/Seoul");
		cal.setTimeZone(zone);
		
		System.out.println(cal.get(Calendar.YEAR)+"�뀈"+cal.get(Calendar.MONTH)+"�썡"+cal.get(Calendar.DAY_OF_MONTH)+"�씪");
		
		cal = new GregorianCalendar().getInstance();
		System.out.println(cal.get(Calendar.YEAR)+"�뀈"+(cal.get(Calendar.MONTH)+1)+"�썡"+cal.get(Calendar.DAY_OF_MONTH)+"�씪");
		
		cal = new GregorianCalendar(zone).getInstance();
		System.out.println(cal.get(Calendar.YEAR)+"�뀈"+cal.get(Calendar.MONTH)+"�썡"+cal.get(Calendar.DAY_OF_MONTH)+"�씪");
		
		long  now_time = cal.getTimeInMillis();
		System.out.println("long now_time : "+now_time);
		
		 
		Long time = vo.get(0).getPeriod();
        System.out.println("long period.time : "+time);
        
        Date date = new Date(time-now_time);
        String str_resTime = (new SimpleDateFormat("HH:mm:ss").format(date));
        date = new Date(now_time);
        String str_nowTime = (new SimpleDateFormat("yyyy-MM-dd").format(date));
        date = new Date(time);
        String str_getTime = (new SimpleDateFormat("yyyy-MM-dd").format(date));
        
        System.out.println("time-now �궓���떆媛�"+str_resTime);
        System.out.println("now day"+str_nowTime);
        System.out.println("get day"+str_getTime);
        System.out.println("get day.time"+date.getTime());
        
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss",Locale.KOREA);
        
        System.out.println("�쁽�옱�떆媛�"+format.format(cal.getTime()));
        
        Long res = time-now_time;
        String timer = "00:00:00";
        if(res > 0){
        	int hours = (int)(res/(1000*60*60));
        	System.out.println("hours : "+hours);
        	int minutes = (int)(res%(1000*60*60))/(1000*60);
        	System.out.println("minutes : "+minutes);
        	int seconds = (int)((res%(1000*60*60))%(1000*60)/1000);
        	System.out.println("seconds : "+seconds);
        	if(hours>23){
        		timer = String.format("%2d�씪 %02d:%02d:%02d",hours/24,hours-(hours/24)*24,minutes,seconds);
        	}else{
        		timer = String.format("%02d:%02d:%02d",hours,minutes,seconds);
        	}
        }
        System.out.println("�궓���떆媛�"+timer);
        
	}
	*/
	
	
	/*@Test
	public void searchTest() {
		SearchVO svo = new SearchVO();
		svo.setSearch_key("源��긽�궗");
		svo.setSearch_table("c.company_name");
		logger.info(""+service.search(svo));
	}*/
	
	/*@Test
	public void sqlTest() {
		SearchVO svo = new SearchVO();
		svo.setCompany_name("company_name");
		svo.setSearch_key("留덉깶");
		logger.info(""+service.search(svo));
	}*/
	
	/*@Test
	public void sqlTest1() {
		SearchVO svo = new SearchVO();
		svo.setUser_name("user_name");
		svo.setSearch_key("源�吏��뿰");
		logger.info(""+uservice.search(svo));
	}*/
	
	/*@Test
	public void sqlTest2() {
		SearchVO svo = new SearchVO();
		svo.setAdv_key("adv_key");
		svo.setSearch_key(1);
		
		List<AdvertiseVO> list = aservice.search(svo);
		for(int i=0; i<list.size(); i++){
			list.get(i).setNow_count();
		}
		logger.info(""+list);
	}
	
	@Test
	public void sqlTest3() {
		List<AdvertiseVO> list = aservice.listAll();
		for(int i=0; i<list.size(); i++){
			list.get(i).setNow_count();
		}
		logger.info(""+list);
	}*/
	
	
	/*@Test
	public void createTest() {
		AdvVO vo = new AdvVO();
		vo.setAdv_title("@adv_title_1");
		vo.setAdv_message("@adv_message_1");
		vo.setAdv_ticker("@adv_ticker_1");
		vo.setAdv_resource("@adv_resource_1");
		//vo.setAdv_time();
		vo.setProduct_product_key(1);
		ItemVO vo = new ItemVO();
		vo.setItem_name("test_name");
		vo.setItem_price(25000);
		vo.setItem_detail("test_detail");
		vo.setItem_image("test_image");	
		
		dao.create(vo);
	}*/
	/*
	@Test
	public void listAllTest(){
		logger.info(""+service.listAll());
		//logger.info(""+dao.listAll());
	}
	*/
	
	/*@Test
	public void readTest() {
		logger.info("adv_time"+service.read(7).getItem_name());
		//logger.info(""+service.read(1));
	}// readTest()
*/	
	/*
	@Test
	public void updateTest() {
		
		BoardVO bVO = new BoardVO();
		bVO.setBno(1);
		bVO.setTitle("占쎈땾占쎌젟占쎈쭆 疫뀐옙");
		bVO.setContent("占쎈땾占쎌젟占쎈쭆 占쎄땀占쎌뒠");
		bVO.setWriter("user00");
		
	}// readTest()
	
	
	@Test
	public void deleteTest() {
		
		dao.delete(728);
	}// readTest()
	*/
	

}
