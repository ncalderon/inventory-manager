package com.itla.javier.im.dao;

import com.itla.javier.im.dto.DespachoEntity;
import com.itla.javier.im.dto.DevolucionEntity;
import com.itla.javier.im.dto.ItemEntity;
import com.itla.javier.im.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Nathaniel on 12/1/2015.
 */
public class DevolucionDao extends BasicDao<DevolucionEntity> {


    public DevolucionDao(Class entityClass) {
        super(entityClass);
    }

    @Override
    public DevolucionEntity add(DevolucionEntity entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            ItemEntity itemEntity = (ItemEntity)session.get(ItemEntity.class, entity.getItemId());
            if (itemEntity.getCantidadTotal() == 0) {
                throw new Exception("Cantidad total de item es igual 0");
            }

            if(entity.getTipoLocalidad() == 1) {
                if (itemEntity.getCantidadPrestada() == 0) {
                    throw new Exception("Cantidad Prestadad de item es igual 0, no existen prestados");
                }
                itemEntity.setCantidadPrestada(itemEntity.getCantidadPrestada() - 1);
                session.update(itemEntity);
            }else {
                itemEntity.setCantidadReparacion(itemEntity.getCantidadReparacion() - 1);
                if (itemEntity.getCantidadReparacion() == 0) {
                    throw new Exception("Cantidad Prestadad de item es igual 0, no existen en repaccion");
                }
                session.update(itemEntity);
            }
            session.save(entity);
            tx.commit();
        }catch (Exception ex) {
            if (tx!=null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return entity;
    }
}
