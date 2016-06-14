package com.itla.javier.im.dto;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Nathaniel on 12/1/2015.
 */
@Entity
@Table(name = "devolucion", schema = "", catalog = "cdb_315fe4b3b3")
public class DevolucionEntity {
    private int devolucionId;
    private Integer itemId;
    private String devueltoPor;
    private String entregadoA;
    private Date fechaDevolucion;
    private int tipoLocalidad;

    @Id
    @Column(name = "DEVOLUCION_ID", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getDevolucionId() {
        return devolucionId;
    }

    public void setDevolucionId(int devolucionId) {
        this.devolucionId = devolucionId;
    }

    @Basic
    @Column(name = "ITEM_ID", nullable = false, insertable = true, updatable = true)
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "DEVUELTO_POR", nullable = true, insertable = true, updatable = true, length = 50)
    public String getDevueltoPor() {
        return devueltoPor;
    }

    public void setDevueltoPor(String devueltoPor) {
        this.devueltoPor = devueltoPor;
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
    @Column(name = "FECHA_DEVOLUCION", nullable = true, insertable = true, updatable = true)
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Basic
    @Column(name = "TIPO_LOCALIDAD", nullable = false, insertable = true, updatable = true)
    public int getTipoLocalidad() {
        return tipoLocalidad;
    }

    public void setTipoLocalidad(int tipoLocalidad) {
        this.tipoLocalidad = tipoLocalidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DevolucionEntity that = (DevolucionEntity) o;

        if (devolucionId != that.devolucionId) return false;
        if (tipoLocalidad != that.tipoLocalidad) return false;
        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (devueltoPor != null ? !devueltoPor.equals(that.devueltoPor) : that.devueltoPor != null) return false;
        if (entregadoA != null ? !entregadoA.equals(that.entregadoA) : that.entregadoA != null) return false;
        if (fechaDevolucion != null ? !fechaDevolucion.equals(that.fechaDevolucion) : that.fechaDevolucion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = devolucionId;
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + (devueltoPor != null ? devueltoPor.hashCode() : 0);
        result = 31 * result + (entregadoA != null ? entregadoA.hashCode() : 0);
        result = 31 * result + (fechaDevolucion != null ? fechaDevolucion.hashCode() : 0);
        result = 31 * result + tipoLocalidad;
        return result;
    }
}
