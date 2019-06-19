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
	 *	@brief	초기 페이지 설정
	 *	@details
	 *
	 *	@author	권연준
	 *	@date	2019-06-20
	 
	 *	@param
	 *	@remark	웹 페이지를 불러오기 위한 초기페이지 설정 [2019-06-20; 권연준]
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {

		mav.setViewName("index");

		Iterable<MyDataMongo> list = repository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public ModelAndView insert(ModelAndView mav) {
		mav.setViewName("insert");

		return mav;
	}
	
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
}
