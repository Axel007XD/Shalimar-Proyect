package com.axel.services;

import com.axel.dao.IGenericDAO;

import java.util.List;

public interface IGenericService<T> extends IGenericDAO<T> {
    List<T> getAll();
    void deleteALl();
    T getById(int i);
    T getId(Long id);
    T getByName(String name);
}
