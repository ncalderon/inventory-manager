package com.itla.javier.im.dto;

import javax.persistence.*;

/**
 * Created by Javier on 11/28/2015.
 */
@Entity
@Table(name = "tipo_localidad", schema = "", catalog = "cdb_315fe4b3b3")
public class TipoLocalidadEntity {
    private int tipoLocalidadId;
    private String nombre;

    @Id
    @Column(name = "TIPO_LOCALIDAD_ID", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getTipoLocalidadId() {
        return tipoLocalidadId;
    }

    public void setTipoLocalidadId(int tipoLocalidadId) {
        this.tipoLocalidadId = tipoLocalidadId;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = true, insertable = true, updatable = true, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoLocalidadEntity that = (TipoLocalidadEntity) o;

        if (tipoLocalidadId != that.tipoLocalidadId) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tipoLocalidadId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
