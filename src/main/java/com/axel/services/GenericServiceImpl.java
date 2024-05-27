package com.axel.services;

import com.axel.dao.GenericDAOImpl;
import com.axel.dao.IGenericDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Map;

public class GenericServiceImpl<T> implements IGenericService<T> {

    private IGenericDAO<T> dao;
    private Class<T> cl;
    SessionFactory session;

    public GenericServiceImpl(Class<T> cl, SessionFactory sessionFactory){
        this.cl = cl;
        this.session= sessionFactory;
        dao = new GenericDAOImpl<>(cl, sessionFactory);

    }

    @Override
    public void deleteALl() {

    }

    @Override
    public T getById(int i) {
        return dao.get(cl,i);
    }

    @Override
    public T getId(Long id) {
        return dao.get(cl,id);
    }

    @Override
    public T getByName(String name) {
        return null;
    }

    @Override
    public T get(Class<T> cl, Integer id) {
        return (T) dao.get(cl, id);
    }

    @Override
    public T get(Class<T> cl, Long id) {
        return null;
    }

    @Override
    public T save(T object) {
        return (T) dao.save(object);
    }
    @Override
    public List<T> getAll() {
        return dao.query("FROM "+ cl.getSimpleName(),null)==null ?null :dao.query("FROM "+cl.getSimpleName(),null);
    }

    @Override
    public void update(T object) {
        dao.update(object);

    }

    @Override
    public void delete(T object) {

        dao.delete(object);
    }

    @Override
    public List<T> query(String hsql, Map<String, Object> params) {
        return (List <T>) dao.query(hsql,params);
    }
}
