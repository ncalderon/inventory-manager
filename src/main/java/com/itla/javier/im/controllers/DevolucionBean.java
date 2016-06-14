package com.itla.javier.im.controllers;

import com.itla.javier.im.dao.DespachoDao;
import com.itla.javier.im.dao.DevolucionDao;
import com.itla.javier.im.dto.DespachoEntity;
import com.itla.javier.im.dto.DevolucionEntity;
import com.itla.javier.im.dto.ItemEntity;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by Javier on 12/1/2015.
 */

@ManagedBean(name = "devolucionBean")
@ViewScoped
public class DevolucionBean extends BasicBean<DevolucionEntity> implements Serializable{
    @Override
    public DevolucionEntity getInstanceItem() {
        return new DevolucionEntity();
    }

    @PostConstruct
    public void init(){//Here I initialize everything I need
        initialize(DevolucionEntity.class, "FROM DespachoEntity", new DevolucionDao(DevolucionEntity.class));
    }
}
