package com.itla.javier.im.dto;

import javax.persistence.*;

/**
 * Created by Javier on 11/28/2015.
 */
@Entity
@Table(name = "item", schema = "", catalog = "cdb_315fe4b3b3")
public class ItemEntity {
    private int itemId;
    private String nombre;
    private String descripcion;
    private Integer cantidadTotal;
    private Integer cantidadReparacion;
    private Integer cantidadPrestada;
    private Integer suplidorId;
private Integer lineaId;

    @Id
    @Column(name = "ITEM_ID", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = true, insertable = true, updatable = true, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = true, insertable = true, updatable = true, length = 100)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "CANTIDAD_TOTAL", nullable = true, insertable = true, updatable = true)
    public Integer getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Integer cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    @Basic
    @Column(name = "CANTIDAD_REPARACION", nullable = true, insertable = true, updatable = true)
    public Integer getCantidadReparacion() {
        return cantidadReparacion;
    }

    public void setCantidadReparacion(Integer cantidadReparacion) {
        this.cantidadReparacion = cantidadReparacion;
    }

    @Basic
    @Column(name = "CANTIDAD_PRESTADA", nullable = true, insertable = true, updatable = true)
    public Integer getCantidadPrestada() {
        return cantidadPrestada;
    }

    public void setCantidadPrestada(Integer cantidadPrestada) {
        this.cantidadPrestada = cantidadPrestada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemEntity that = (ItemEntity) o;

        if (itemId != that.itemId) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (cantidadTotal != null ? !cantidadTotal.equals(that.cantidadTotal) : that.cantidadTotal != null)
            return false;
        if (cantidadReparacion != null ? !cantidadReparacion.equals(that.cantidadReparacion) : that.cantidadReparacion != null)
            return false;
        if (cantidadPrestada != null ? !cantidadPrestada.equals(that.cantidadPrestada) : that.cantidadPrestada != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (cantidadTotal != null ? cantidadTotal.hashCode() : 0);
        result = 31 * result + (cantidadReparacion != null ? cantidadReparacion.hashCode() : 0);
        result = 31 * result + (cantidadPrestada != null ? cantidadPrestada.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "SUPLIDOR_ID", nullable = true, insertable = true, updatable = true)
    public Integer getSuplidorId() {
        return suplidorId;
    }
public void setSuplidorId(Integer suplidorId) {
        this.suplidorId = suplidorId;
    }

    @Basic
    @Column(name = "LINEA_ID", nullable = true, insertable = true, updatable = true)
    public Integer getLineaId() {
        return lineaId;
    }

    public void setLineaId(Integer lineaId) {
        this.lineaId = lineaId;
    }
}
