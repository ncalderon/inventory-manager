package com.itla.javier.im.controllers;

import com.itla.javier.im.dao.BasicDao;
import com.itla.javier.im.dto.TipoLocalidadEntity;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javier on 11/29/2015.
 */
@ManagedBean(name = "tipoLocalidadBean")
@ViewScoped
/*extends BasicBean<TipoLocalidadEntity>*/
public class TipoLocalidadBean implements Serializable {
/*
    @Override
    public TipoLocalidadEntity getInstanceItem() {
        return new TipoLocalidadEntity();
    }

    @PostConstruct
    public void init(){//Here I initialize everything I need
        initialize(TipoLocalidadEntity.class, "FROM TipoLocalidadEntity");
    }*/

    private List<TipoLocalidadEntity> tipoLocalidadList;
    private TipoLocalidadEntity tipoLocalidadItem;
    private BasicDao<TipoLocalidadEntity> basicDao;
    private boolean updateItem;

    @PostConstruct
    public void init(){//Here I initialize everything I need
        tipoLocalidadItem = new TipoLocalidadEntity();
        basicDao = new BasicDao(TipoLocalidadEntity.class);//This goes here to  avoid NullPointerException
        tipoLocalidadList = basicDao.get("from TipoLocalidadEntity");

    }

    public void add(){
        tipoLocalidadItem = basicDao.add(tipoLocalidadItem);
        tipoLocalidadList.add(tipoLocalidadItem);
        tipoLocalidadItem = new TipoLocalidadEntity();
        setUpdateItem(false);
    }

    public void save(){
        tipoLocalidadItem = basicDao.update(tipoLocalidadItem);
        tipoLocalidadItem = new TipoLocalidadEntity();
        setUpdateItem(false);
    }

    public void delete(TipoLocalidadEntity tipoLocalidadItem){
        basicDao.delete(tipoLocalidadItem.getTipoLocalidadId());
        tipoLocalidadList.remove(tipoLocalidadItem);
        setUpdateItem(false);
    }

    public void edit(TipoLocalidadEntity tipoLocalidadItem) {
        this.tipoLocalidadItem = tipoLocalidadItem;
        setUpdateItem(true);

    }

    //Getters and Setters
    public List<TipoLocalidadEntity> getTipoLocalidadList() {

        if (tipoLocalidadList == null){
            tipoLocalidadList = new ArrayList<TipoLocalidadEntity>(basicDao.get("from TipoLocalidadEntity"));
        }
        return tipoLocalidadList;
    }

    public void setTipoLocalidadList (List<TipoLocalidadEntity> tipoLocalidadList) {
        this.tipoLocalidadList = tipoLocalidadList;
    }

    public TipoLocalidadEntity getTipoLocalidadItem() {
        return tipoLocalidadItem;
    }

    public void setTipoLocalidadItem(TipoLocalidadEntity tipoLocalidadItem) {
        this.tipoLocalidadItem = tipoLocalidadItem;
    }

    public boolean isUpdateItem() {
        return updateItem;
    }

    public void setUpdateItem(boolean isEditable) {
        this.updateItem = isEditable;
    }

}
