package org.lei.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.lei.dao.SerialDao;
import org.lei.model.SeriInfo;
import org.lei.util.ReadFile;
import org.springframework.stereotype.Component;

@Component("serialService")
public class SerialService {
		private SerialDao serialDao;

		public SerialDao getSerialDao() {
			return serialDao;
		}
		@Resource
		public void setSerialDao(SerialDao serialDao) {
			this.serialDao = serialDao;
		}
		
		/**
		 * 分页查询seriinfo分页加载
		 * @param currentPage
		 * @return
		 */
		public List<SeriInfo>getSeriInfos(int currentPage){
			List<SeriInfo>seriInfos = serialDao.queryListSeriInfos(currentPage);
			return seriInfos;
		}
		
		public int addBatchSerial(){
			try {
				serialDao.insertBatchSerial();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
		/**
		 * 删除指定的序列
		 * @param id
		 * @return
		 */
		public int delSeriInfo(String []id){
			try{
				serialDao.delSerial(id);
				return 1;
			}catch(Exception e){
				return 0;
			}
		}
		
		/**
		 * 增加序列
		 * @param seriInfo
		 * @return
		 */
		public int addSerial(SeriInfo seriInfo){
			seriInfo.setQuality(new ReadFile().getQuality(seriInfo.getSerial()));
			if(serialDao.insertSerial(seriInfo)>0)
				return 1;
			return 0;
		}
		
		/**
		 * 根据输入的字符串和当前页数，分页加载精确查找的结果
		 * @param currentPage
		 * @param exactstr
		 * @return
		 */
		public List<SeriInfo>exactFindSeriInfos(int currentPage,String exactstr){
				return serialDao.exactSelectSeriInfos(currentPage, exactstr);
		}
		
		/**
		 * 根据输入的字符串和当前页数，分页加载精确查找的结果
		 * @param currentPage
		 * @param inexactstr
		 * @return
		 */
		public List<SeriInfo>inexactFindSeriInfos(int currentPage,String inexactStr){
				return serialDao.exactSelectSeriInfos(currentPage, inexactStr);
		}
		
		
		
		
}
