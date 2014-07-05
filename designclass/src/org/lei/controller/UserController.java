package org.lei.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes({"u","a"})
public class UserController  {

	@RequestMapping(value="/user.do")
	public String reg(String uname){
		System.out.println("UserController.reg()");
		System.out.println(uname);
		//userService.add(uname);
		return "/index";
	}
	
	@RequestMapping(params="method=reg2")
	public ModelAndView reg2(String uname){
		System.out.println("UserController.reg2()");
		
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	
	@RequestMapping(value="/test2")
	public String reg3(@RequestParam("uname") String name,HttpServletRequest req,ModelMap map){
		System.out.println("UserController.reg()");
		System.out.println(name);
		req.getSession().setAttribute("c", "ccc");
		map.put("a", "aaa");
		
		return "index";
	}
	
	@RequestMapping(params="method=reg4")
	public String reg4(@ModelAttribute("a") String a,HttpServletRequest req,ModelMap map){
		System.out.println("UserController.reg4()");
		System.out.println(a);
		return "redirect:http://www.baidu.com";
	}
	
	/*@RequestMapping(params="method=reg5")
	public ModelAndView reg5(String uname){
		System.out.println("UserController.reg5()");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		
		User u = new User("¿œ∏ﬂ");
		User u2 = new User("∏ﬂ‰ø");
		
		mav.addObject(u);
		mav.addObject("uu", u2);
		
		return mav;
	}*/
/*
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
*/
	
}
