package com.wenyue.blog.home.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

public abstract class ABasicDao<T> {
	
	public List<T> listAll() {
		DetachedCriteria dc = this.getCriteria();
		return findList(dc);
	}

	protected HibernateTemplate hibernateTemplate;

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public abstract DetachedCriteria getCriteria();

	public void add(T obj) {
		hibernateTemplate.save(obj);
	}

	public void modify(T obj) {
		hibernateTemplate.setCheckWriteOperations(false);
//		hibernateTemplate.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.FLUSH_EAGER);
		hibernateTemplate.update(obj);
	}

	public void remove(T obj) {
		hibernateTemplate.delete(obj);
	}
	
	

	public T findObjectByCriteria(DetachedCriteria dc) {
		List<?> list = hibernateTemplate.findByCriteria(dc);
		if (list != null && list.size() > 0) {
			return (T)list.get(0);
		}
		return null;
	}

	public List<T> findList(DetachedCriteria dc) {
		return (List<T>)hibernateTemplate.findByCriteria(dc);
	}
	
	public List<T> findList(DetachedCriteria dc, int start, int limit) {
		return (List<T>)hibernateTemplate.findByCriteria(dc, start, limit);
	}

	public int executeSQL(final String str) {
		return hibernateTemplate.execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session) throws HibernateException {
				SQLQuery query = session.createSQLQuery(str);
				return query.executeUpdate();
			}

		});
	}
	
	public SQLQuery createSqlQuery(String sql) {
		return hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery(sql);
	}
	
	public Query createQuery(String hql) {
		return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
	}
	
}