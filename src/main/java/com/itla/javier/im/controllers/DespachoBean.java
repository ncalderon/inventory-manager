package com.itla.javier.im.controllers;

import com.itla.javier.im.dao.DespachoDao;
import com.itla.javier.im.dto.DespachoEntity;
import com.itla.javier.im.dto.DevolucionEntity;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by Javier on 12/1/2015.
 */

@ManagedBean(name = "despachoBean")
@ViewScoped
public class DespachoBean extends BasicBean<DespachoEntity> implements Serializable {
    @Override
    public DespachoEntity getInstanceItem() {
        return new DespachoEntity();
    }

    @PostConstruct
    public void init(){//Here I initialize everything I need
        initialize(DespachoEntity.class, "FROM DespachoEntity", new DespachoDao(DespachoEntity.class));
    }


}
