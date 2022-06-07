package com.solvd.mybatis.mapper;

import java.util.List;

public interface BaseMapper<T> {

    //create
    int addEntity(T entity);

    //read by id
    T getEntityById(int id);

    List<T> getAll();

    //update
    int updateEntity(T entity);

    //delete
    int deleteEntity(T entity);
}
