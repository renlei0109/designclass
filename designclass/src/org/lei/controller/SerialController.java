package org.lei.controller;

import java.util.ArrayList;
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
			List<SeriInfo>seriInfos = serialService.getSeriInfos(Integer.valueOf(currentPage));
			HttpSession session = req.getSession();
			session.setAttribute("seriInfos", seriInfos);
			session.setAttribute("currentPage", currentPage);
			mm.put("seriInfos", seriInfos);
			return "index";
		}
		
		@RequestMapping("/delSeriInfo.do")
		public String delSeriInfo(@RequestParam("checked") String []id,HttpServletRequest req,ModelMap mm){
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
			serialService.addSerial(seriInfo);
			getSeriInfos(0+"", req, mm);
			return "index";
		}
		
		
		@RequestMapping("/exactFindSeriInfos.do")
		public String exactFindSeriInfos(@RequestParam("currentPage") String currentPage,@RequestParam("exactStr")String exactStr,HttpServletRequest req,ModelMap mm){
			List<SeriInfo>seriInfos = serialService.exactFindSeriInfos((Integer.valueOf(currentPage)),exactStr.toUpperCase());
			HttpSession session = req.getSession();
			session.setAttribute("seriInfos", seriInfos);
			session.setAttribute("currentPage", currentPage);
			session.setAttribute("exactStr", exactStr);
			mm.put("seriInfos", seriInfos);
			return "exactfindresult";
		}
		/**
		 * 不精确查找序列
		 * @param currentPage
		 * @param inexactStr
		 * @param req
		 * @param mm
		 * @return
		 */
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
		
		/**
		 * @param currentPage
		 * @param m
		 * @param e
		 * @param req
		 * @param mm
		 * @return
		 */
		@RequestMapping("/qualityFindSeriInfos.do")
		public String qualityFindSeriInfos(@RequestParam("currentPage") String currentPage,int m,int e,HttpServletRequest req,ModelMap mm){
			List<SeriInfo>seriInfos = serialService.qualityFindSeriInfos(Integer.valueOf(currentPage) ,m, e);
			HttpSession session = req.getSession();
			session.setAttribute("seriInfos", seriInfos);
			session.setAttribute("currentPage", currentPage);
			session.setAttribute("m", m);
			session.setAttribute("e", e);
			mm.put("seriInfos", seriInfos);
			return "findserialbymeresult";
		}
		
		@RequestMapping("/countQuality.do")
		public  String countQuality(HttpServletRequest req){
			List<Long>qualityCounts = new ArrayList<Long>();
			qualityCounts = serialService.getCountQualitys();
			HttpSession session = req.getSession();
			session.setAttribute("qualityCounts", qualityCounts);
			return "qualityChart";
				
		}
		
		@RequestMapping("/countSerialsLength.do")
		public  String countSerialsLength(HttpServletRequest req){
			List<Integer>serialLengthCounts = new ArrayList<Integer>();
			serialLengthCounts = serialService.getSerialsLength();
			HttpSession session = req.getSession();
			session.setAttribute("serialLengthCounts", serialLengthCounts);
			return "serialsLengthChart";
				
		}
		
		
		
		
		
}
