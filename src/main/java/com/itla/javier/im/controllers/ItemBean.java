package com.itla.javier.im.controllers;

import com.itla.javier.im.dto.ItemEntity;
import com.itla.javier.im.dto.LocalidadEntity;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by Javier on 12/1/2015.
 */
@ManagedBean(name = "itemBean")
@ViewScoped
public class ItemBean extends BasicBean<ItemEntity> implements Serializable {

    @Override
    public ItemEntity getInstanceItem() {
        return new ItemEntity();
    }

    @PostConstruct
    public void init(){//Here I initialize everything I need
        initialize(ItemEntity.class, "FROM ItemEntity");
    }

}
