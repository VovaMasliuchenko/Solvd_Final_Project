package DAO.Base;

import java.util.List;

public interface IBaseDAO<T> {

    //create
    void addEntity(T entity);

    //read by id
    T getEntityById(int id);

    List<T> getAll();

    //update
    void updateEntity(T entity);

    //delete
    void deleteEntity(T entity);
}
