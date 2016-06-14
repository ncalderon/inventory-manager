package com.itla.javier.im.controllers;

import com.itla.javier.im.dao.BasicDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javier on 11/29/2015.
 */
public abstract class BasicBean <T> {

    protected List<T> entityList;
    protected T entityItem;
    protected BasicDao<T> basicDao;
    private boolean updateItem;
    private String entityGetAll;



    public void initialize (Class entityType, String entityGetAll) {
        this.entityGetAll = entityGetAll;
        instanceItem();
        basicDao = new BasicDao<T>(entityType);
        entityList = basicDao.get(entityGetAll);

    }

    public void initialize (Class entityType, String entityGetAll, BasicDao<T> basicDao) {
        this.entityGetAll = entityGetAll;
        instanceItem();
        this.basicDao = basicDao;
        entityList = basicDao.get(entityGetAll);

    }

    public abstract T getInstanceItem ();

    public void instanceItem () {
        entityItem = (T) getInstanceItem();
    }

    public void add(){
        basicDao.add(entityItem);
        entityList.add(entityItem);
        instanceItem();
        setUpdateItem(false);
    }

    public void save(){
        basicDao.add(entityItem);
        instanceItem();
        setUpdateItem(false);
    }

    public void delete(long id){
        basicDao.delete(id);
        entityList.remove(entityItem);
        setUpdateItem(false);
    }

    public void edit(T entityItem) {
        this.entityItem = entityItem;
        setUpdateItem(true);

    }

    //Getters and Setters
    public List<T> getEntityList () {
        if (entityList == null){
            entityList = new ArrayList<T>(basicDao.get(entityGetAll));
        }
        return entityList;
    }

    public void setList(List<T> entityList) {
        this.entityList = entityList;
    }

    public T getEntityItem() {
        return entityItem;
    }

    public void setEntityItem (T entityItem) {
        this.entityItem = entityItem;
    }

    public boolean isUpdateItem() {
        return updateItem;
    }

    public void setUpdateItem(boolean isEditable) {
        this.updateItem = isEditable;
    }

}
