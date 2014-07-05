package org.lei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
		
		/*try{
			
			hibernateTemplate.delete(id);
				return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}*/
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
		ps.close();
		return 1;
		
	/*	jdbcTemplate.batchUpdate(hql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
					
					ps.setString(1, seriInfos.get(i).getId());
					ps.setString(2, seriInfos.get(i).getDescription());
					ps.setString(3, seriInfos.get(i).getSerial());
					ps.setInt(4, seriInfos.get(i).getQuality());
					ps.addBatch();
					
			}
			
			@Override
			public int getBatchSize() {
				return seriInfos.size();
			}
		});
		return 0;*/
	}
}
