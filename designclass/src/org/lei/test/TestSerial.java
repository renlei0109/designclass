package org.lei.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.lei.dao.SerialDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSerial {
	private BeanFactory beanFactory;
	private SerialDao serialDao;
	@Test
	public void testAddBatchSerial() {
		beanFactory =new  ClassPathXmlApplicationContext("org/lei/resourse/applicationContext.xml");
		serialDao = (SerialDao)beanFactory.getBean("serialDao");
		try {
			serialDao.insertBatchSerial();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
