package org.lei.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.lei.dao.SerialDao;
import org.lei.model.SeriInfo;
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
		
		public int delSeriInfo(String []id){
			try{
				serialDao.delSerial(id);
				return 1;
			}catch(Exception e){
				return 0;
			}
		}
		
}
