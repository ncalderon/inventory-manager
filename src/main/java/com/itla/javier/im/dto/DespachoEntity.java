package com.itla.javier.im.dto;

import javax.persistence.*;

/**
 * Created by Javier on 12/1/2015.
 */
@Entity
@Table(name = "despacho", schema = "", catalog = "cdb_315fe4b3b3")
public class DespachoEntity {
    private int despachoId;
    private Integer itemId;
    private String entregadoPor;
    private String entregadoA;
    private Integer tipoLocalidad;
    private String descripcion;

    @Id
    @Column(name = "DESPACHO_ID", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getDespachoId() {
        return despachoId;
    }

    public void setDespachoId(int despachoId) {
        this.despachoId = despachoId;
    }

    @Basic
    @Column(name = "ITEM_ID", nullable = true, insertable = true, updatable = true)
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "ENTREGADO_POR", nullable = true, insertable = true, updatable = true, length = 50)
    public String getEntregadoPor() {
        return entregadoPor;
    }

    public void setEntregadoPor(String entregadoPor) {
        this.entregadoPor = entregadoPor;
    }

    @Basic
    @Column(name = "ENTREGADO_A", nullable = true, insertable = true, updatable = true, length = 50)
    public String getEntregadoA() {
        return entregadoA;
    }

    public void setEntregadoA(String entregadoA) {
        this.entregadoA = entregadoA;
    }

    @Basic
    @Column(name = "TIPO_LOCALIDAD", nullable = true, insertable = true, updatable = true)
    public Integer getTipoLocalidad() {
        return tipoLocalidad;
    }

    public void setTipoLocalidad(Integer tipoLocalidad) {
        this.tipoLocalidad = tipoLocalidad;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = true, insertable = true, updatable = true, length = 100)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DespachoEntity that = (DespachoEntity) o;

        if (despachoId != that.despachoId) return false;
        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (entregadoPor != null ? !entregadoPor.equals(that.entregadoPor) : that.entregadoPor != null) return false;
        if (entregadoA != null ? !entregadoA.equals(that.entregadoA) : that.entregadoA != null) return false;
        if (tipoLocalidad != null ? !tipoLocalidad.equals(that.tipoLocalidad) : that.tipoLocalidad != null)
            return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = despachoId;
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + (entregadoPor != null ? entregadoPor.hashCode() : 0);
        result = 31 * result + (entregadoA != null ? entregadoA.hashCode() : 0);
        result = 31 * result + (tipoLocalidad != null ? tipoLocalidad.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }
}
