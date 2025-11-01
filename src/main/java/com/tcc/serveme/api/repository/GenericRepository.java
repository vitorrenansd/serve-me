package com.tcc.serveme.api.repository;

import java.util.List;

public interface GenericRepository<T, ID> {

    T findById(ID id);

    List<T> findAll();

    int save(T entity);

    int update(T entity);

    int softDelete(ID id);
}