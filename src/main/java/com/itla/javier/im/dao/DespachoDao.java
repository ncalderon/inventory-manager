package com.itla.javier.im.dao;

import com.itla.javier.im.dto.DespachoEntity;
import com.itla.javier.im.dto.ItemEntity;
import com.itla.javier.im.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Nathaniel on 12/1/2015.
 */
public class DespachoDao extends BasicDao<DespachoEntity> {


    public DespachoDao(Class entityClass) {
        super(entityClass);
    }

    @Override
    public DespachoEntity add(DespachoEntity entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            ItemEntity itemEntity = (ItemEntity)session.get(ItemEntity.class, entity.getItemId());
            if (itemEntity.getCantidadTotal() == 0) {
                throw new Exception("Cantidad total de item es igual 0, no se puede prestar ni reparar por que no existen items.");
            }
            if(entity.getTipoLocalidad() == 1) {

                itemEntity.setCantidadPrestada(itemEntity.getCantidadPrestada() + 1);
                session.update(itemEntity);
            }else {

                itemEntity.setCantidadReparacion(itemEntity.getCantidadReparacion() + 1);
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
