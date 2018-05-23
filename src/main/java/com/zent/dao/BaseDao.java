package com.zent.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


public class BaseDao<T> implements IBaseDao<T> {
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public T findById(Class<T> t, Long id) {
		return (T) getSession().get(t, id);
	}

	@Override
	public void save(T t) {
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);

	}

	@Override
	public void deleteById(Long id) {
		getSession().delete(id);

	}

	@Override
	public List findAll(Class<T> t) {
		return getSession().createQuery("SELECT o FROM "+t.getSimpleName()+" o").list();
	}

}
