 package com.yunjun.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yunjun.springboot.MyDataMongo;
import com.yunjun.springboot.repositories.MyDataMongoRepository;

@Controller
public class HeloController {
	@Autowired
	MyDataMongoRepository repository;
	
	/**
	 * 	@fn		public ModelAndView index(ModelAndView mav)
	 * 
	 *	@brief	초기 페이지 설정
	 *
	 *	@details
	 *
	 *	@author	권연준
	 *	@date	2019-06-20
	 
	 *	@param 	mav ModelAndView
	 *
	 *	@remark	웹 페이지를 불러오기 위한 초기페이지 설정 [2019-06-20; 권연준]
	 *
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");

		Iterable<MyDataMongo> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}

	/**
	 *
	 * @fn 		public ModelAndView insert(ModelAndView mav)
	 * 
	 * @brief 	입력 페이지 설정 
	 *
	 * @author 	권연준
	 * @date 	2019-06-20
	 *
	 * @param	mav ModelAndView
	 *
	 * @remark 	웹 페이지를 불러오기 위한 초기페이지 설정[2019-06-20; 권연준] \n
	 *
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView insert(ModelAndView mav) {
		mav.setViewName("insert");

		return mav;
	}
	
	/**
	 *
	 * @fn 		public ModelAndView insert(ModelAndView mav)
	 * 
	 * @brief 	입력 페이지 설정 
	 *
	 * @author 	권연준
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	폼에 입력된 값을 받아온 후 객체에 저장		[2019-06-20; 권연준] \n
	 *		   	save 메소드를 이용해 DB에 저장			[2019-06-20; 권연준] \n
	 *
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView form(
			@RequestParam("name") String name, 
			@RequestParam("phone1") String phone1,
			@RequestParam("phone2") String phone2,
			@RequestParam("phone3") String phone3,
			@RequestParam("pos") String pos,
			@RequestParam("email") String email,
			@RequestParam("sex") String sex,
			@RequestParam("memo") String memo,      
			ModelAndView mov) {
		MyDataMongo mydata = new MyDataMongo(name, pos, email, sex, memo, phone1, phone2, phone3);
		repository.save(mydata);
		
		return new ModelAndView("redirect:/");
	}

	/**
	 *
	 * @fn 		public ModelAndView detail(ModelAndView mav)
	 * 
	 * @brief 	상세 조회 페이지
	 *
	 * @author 	권연준
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	findBy 를 이용한 조건검색 후 출력	[2019-06-20; 권연준] \n
	 *
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("id") String id, ModelAndView mav) {
		mav.setViewName("detail");

		List<MyDataMongo> list = repository.findById(id);
		mav.addObject("datalist", list);
		return mav;
	}
	
	/**
	 *
	 * @fn 		public ModelAndView edit(ModelAndView mav)
	 * 
	 * @brief 	수정페이지
	 *
	 * @author 	권연준
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	findBy를 이용해 조건에 충족되는 데이터를 List에 저장 후 화면에 표시	[2019-06-20; 권연준] \n
	 *
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") String id, ModelAndView mav) {
		mav.setViewName("edit");
		
		List<MyDataMongo> list = repository.findById(id);
		mav.addObject("datalist", list);
		return mav;
	}
	
	/**
	 *
	 * @fn 		public ModelAndView editpost(ModelAndView mav)
	 * 
	 * @brief 	데이터 수정
	 *
	 * @author 	권연준
	 * @date 	2019-06-20
	 *
	 * @param 	mav ModelAndView
	 *
	 * @remark	폼에 입력된 값을 받아온 후 객체에 저장	[2019-06-20; 권연준] \n
	 *		   	save 메소드를 이용해 DB에 저장		[2019-06-20; 권연준] \n
	 *			deleteBy를 이용해 이전데이터 삭제	[2019-06-20; 권연준] \n
	 *
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editpost(
			@RequestParam("id") String id, 
			@RequestParam("name") String name, 
			@RequestParam("phone1") String phone1,
			@RequestParam("phone2") String phone2,
			@RequestParam("phone3") String phone3,
			@RequestParam("pos") String pos,
			@RequestParam("email") String email,
			@RequestParam("sex") String sex,
			@RequestParam("memo") String memo,      
			ModelAndView mov) {
		MyDataMongo mydata = new MyDataMongo(name, pos, email, sex, memo, phone1, phone2, phone3);
		repository.save(mydata);
		repository.deleteById(id);
		
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView removecheck(@PathVariable("id") String id, ModelAndView mav) {
		mav.setViewName("delete");

		List<MyDataMongo> list = repository.findById(id);
		mav.addObject("datalist", list);
		return mav;
	}
}
