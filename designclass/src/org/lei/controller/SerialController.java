package org.lei.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.lei.model.SeriInfo;
import org.lei.service.SerialService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope("prototype")
@RequestMapping("/serial")
public class SerialController {
		private SerialService serialService;

		public SerialService getSerialService() {
			return serialService;
		}
		@Resource
		public void setSerialService(SerialService serialService) {
			this.serialService = serialService;
		}
		
		public void addBatchSerial(){
			serialService.addBatchSerial();
		}
		
		@RequestMapping("/getSeriInfos.do")
		public String getSeriInfos(@RequestParam("currentPage") String currentPage,HttpServletRequest req,ModelMap mm){
			System.out.println("*************");
			List<SeriInfo>seriInfos = serialService.getSeriInfos(Integer.valueOf(currentPage));
			HttpSession session = req.getSession();
			session.setAttribute("seriInfos", seriInfos);
			session.setAttribute("currentPage", currentPage);
			mm.put("seriInfos", seriInfos);
			System.out.println(seriInfos.size());
			return "index";
		}
		
		@RequestMapping("/delSeriInfo.do")
		public String delSeriInfo(@RequestParam("checked") String []id,HttpServletRequest req,ModelMap mm){
			//String []id = req.getParameterValues("checked");//»òÕßÒ²¿ÉÒÔÕâÑùµÃµ½
			System.out.println(id[0]+"******");
			if(serialService.delSeriInfo(id)>0){
				System.out.println("成功**************");
			}
			else {
				System.out.println("失败*******************");
			}
			String  currentPage = req.getSession().getAttribute("currentPage").toString();
			return "index";
		}
		
		@RequestMapping("/addSeriInfo")
		public String delSeriInfo(SeriInfo seriInfo,HttpServletRequest req,ModelMap mm){
			System.out.println("****************"+seriInfo.toString()+"******************************************");
			serialService.addSerial(seriInfo);
			getSeriInfos(0+"", req, mm);
			return "index";
		}
		
		
		@RequestMapping("/exactFindSeriInfos.do")
		public String exactFindSeriInfos(@RequestParam("currentPage") String currentPage,@RequestParam("exactStr")String exactStr,HttpServletRequest req,ModelMap mm){
			System.out.println("*************"+currentPage+exactStr);
			List<SeriInfo>seriInfos = serialService.exactFindSeriInfos((Integer.valueOf(currentPage)),exactStr);
			HttpSession session = req.getSession();
			session.setAttribute("seriInfos", seriInfos);
			session.setAttribute("currentPage", currentPage);
			session.setAttribute("exactStr", exactStr);
			mm.put("seriInfos", seriInfos);
			return "exactfindresult";
		}
		
		@RequestMapping("/inexactFindSeriInfos.do")
		public String inexactFindSeriInfos(@RequestParam("currentPage") String currentPage,@RequestParam("inexactStr")String inexactStr,HttpServletRequest req,ModelMap mm){
			String []args = inexactStr.split("\\*");
			StringBuffer sb = new StringBuffer();
			for(int i = 0;i<args.length;i++){
				sb.append(args[i]);
			}
			List<SeriInfo>seriInfos = serialService.inexactFindSeriInfos((Integer.valueOf(currentPage)),sb.toString().toUpperCase());
			HttpSession session = req.getSession();
			session.setAttribute("seriInfos", seriInfos);
			session.setAttribute("currentPage", currentPage);
			session.setAttribute("inexactStr", inexactStr);
			mm.put("seriInfos", seriInfos);
			return "inexactfindresult";
		}
		
		
}
