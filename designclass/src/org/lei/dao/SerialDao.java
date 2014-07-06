package org.lei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.lei.model.SeriInfo;
import org.lei.util.Constant;
import org.lei.util.ReadFile;

import com.sun.istack.internal.FinalArrayList;
@Component("serialDao")
public class SerialDao {
	private static final int pageSize = 20;
	private HibernateTemplate hibernateTemplate;
	private JdbcTemplate jdbcTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	/** 
	 * 分页装载Seriinfo的所有持久化对象 
	 * */
	@SuppressWarnings("unchecked")
	public List<SeriInfo>queryListSeriInfos(int currentPage){
		final int currPage = currentPage;
		final String hql = "from SeriInfo";
		List<SeriInfo> seriInfos = null;
		seriInfos = new ArrayList<SeriInfo>();
		seriInfos = hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
			SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((currPage-1)*pageSize);
				query.setMaxResults(pageSize);
				List<SeriInfo>result  = query.list();
				return result;
			}
			
		});
		return seriInfos;
	}
	
	
	/*public List<SeriInfo> queryListSeriInfosByExactStr(String seriString){
		
	}*/
	
	/**
	 * 插入某个serial
	 * @return
	 */
	public int insertSerial(SeriInfo seriInfo){
		try{
			hibernateTemplate.save(seriInfo);
			/*Connection connection = jdbcTemplate.getDataSource().getConnection();
			PreparedStatement ps = null;
			String sql = "insert into seriinfo values(?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, seriInfo.getId());
			ps.setString(2, seriInfo.getDescription());
			ps.setString(3, seriInfo.getSerial());
			ps.setInt(4, seriInfo.getQuality());
			ps.executeUpdate();
			System.out.println(seriInfo.toString());*/
			System.out.println("************************成功**********************");
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 根据id删除某个序列
	 * @param id
	 * @return
	 */
	public int delSerial(final String[] ids){
		final String queryString = "delete SeriInfo where id in (:ids)";
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(queryString);
				query.setParameterList("ids", ids);
				return query.executeUpdate();
				}
		});
		return 1;
		
	}
	/**
	 * 修改某个序列的信息
	 * @param seriInfo
	 * @return
	 */
	public int updateSerial(SeriInfo seriInfo){
		try {
			hibernateTemplate.update(seriInfo);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int insertBatchSerial() throws Exception{
		int size = 0; 
		int oldSize = 0;//记录上一次执行到多少
		final List<SeriInfo>seriInfos = new ReadFile().readFile();
		String hql = "insert into seriinfo(id,description,serial,quality) values(?,?,?,?)";
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Connection connection = jdbcTemplate.getDataSource().getConnection();
		connection.setAutoCommit(false);
		PreparedStatement ps = connection.prepareStatement(hql);
		for(int i=0;i<seriInfos.size();i++){
			ps.setString(1, seriInfos.get(i).getId());
			ps.setString(2, seriInfos.get(i).getDescription());
			ps.setString(3, seriInfos.get(i).getSerial());
			ps.setInt(4, seriInfos.get(i).getQuality());
			ps.addBatch();
			size++;
			if(size%1000==0){
				System.out.println(size);
				ps.executeBatch();
				connection.commit();
				ps.clearBatch();
				oldSize = size;
			}
			/**
			 * 将后面的零头执行完毕
			 */
			if(size>oldSize&&(size>(seriInfos.size()-1000))){
				ps.executeBatch();
				connection.commit();
				ps.clearBatch();
				System.out.println(size);
			}
			
		}
		connection.close();
		session.close();
		ps.close();
		return 1;

	}
	
	
	
	/** 
	 * 分页精确查找所有符合条件的字符串
	 * */
	@SuppressWarnings("unchecked")
	public List<SeriInfo>exactSelectSeriInfos(int currentPage,final String str){
		long timeStart = new Date().getTime();
		final int currPage = currentPage;
		final String hql = "from SeriInfo where serial like '%"+ str +"%'";
		Constant.totalPage = hibernateTemplate.find(hql).size();
		List<SeriInfo> seriInfos = null;
		seriInfos = new ArrayList<SeriInfo>();
		seriInfos = hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
			SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((currPage-1)*pageSize);
				query.setMaxResults(pageSize);
				List<SeriInfo>result  = query.list();
				return result;
			}
			
		});
		Constant.time = new Date().getTime() - timeStart;
		return seriInfos;
	}
	
	
	/** 
	 * 分页模糊查找所有符合条件的字符串
	 * */
	@SuppressWarnings("unchecked")
	public List<SeriInfo>inexactSelectSeriInfos(int currentPage,final String str){
		long timeStart = new Date().getTime();
		final int currPage = currentPage;
		final String hql = "from SeriInfo where serial like '%"+ str +"%'";
		Constant.totalPage = hibernateTemplate.find(hql).size();
		List<SeriInfo> seriInfos = null;
		seriInfos = new ArrayList<SeriInfo>();
		seriInfos = hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
			SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((currPage-1)*pageSize);
				query.setMaxResults(pageSize);
				List<SeriInfo>result  = query.list();
				return result;
			}
		});
		Constant.time = new Date().getTime() - timeStart;
		return seriInfos;
	}
	
	
	
	
	/** 
	 * 分页质量查找所有符合条件的字符串
	 * */
	@SuppressWarnings("unchecked")
	public List<SeriInfo>qualitySelectSeriInfos(int currentPage,final int m,final int e){
		long timeStart = new Date().getTime();
		final int currPage = currentPage;
		int max = m+e;
		int min = m-e;
		final String hql = "from SeriInfo where quality>"+min+" and quality<"+max;
		Constant.totalPage = hibernateTemplate.find(hql).size();
		List<SeriInfo> seriInfos = null;
		seriInfos = new ArrayList<SeriInfo>();
		seriInfos = hibernateTemplate.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
			SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult((currPage-1)*pageSize);
				query.setMaxResults(pageSize);
				List<SeriInfo>result  = query.list();
				return result;
			}
		});
		Constant.time = new Date().getTime() - timeStart;
		return seriInfos;
	}
	
	
	/**
	 * 统计质量的分布
	 * @return
	 * 返回一个list的列表
	 */
	public List<Long> countQuality(){
		List<Long>qualityCounts = new ArrayList<Long>();
		int []range = {0,5000,10000,15000,20000,25000,30000,35000,
				40000,45000,50000,55000,60000,65000,70000,200000};
		for(int i = 0;i<range.length-1;i++){
			List<Long> count = new ArrayList<Long>();
			String hql = "select count(id) from SeriInfo where quality > "+range[i]+
			" and quality<="+range[i+1];
			count = hibernateTemplate.find(hql);
			qualityCounts.add(count.size()>0?count.get(0):0L);
				}
		return qualityCounts;
	}
	
	
	
	
}
