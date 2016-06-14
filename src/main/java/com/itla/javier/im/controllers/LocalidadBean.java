package com.itla.javier.im.controllers;

import com.itla.javier.im.dto.LocalidadEntity;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by Javier on 11/29/2015.
 */

@ManagedBean(name = "localidadBean")
@ViewScoped
public class LocalidadBean extends BasicBean<LocalidadEntity> implements Serializable {


    @Override
    public LocalidadEntity getInstanceItem() {
        return new LocalidadEntity();
    }

    @PostConstruct
    public void init(){//Here I initialize everything I need
        initialize(LocalidadEntity.class, "FROM LocalidadEntity");
    }
}
