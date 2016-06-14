package com.itla.javier.im.dto;

import javax.persistence.*;

/**
 * Created by Javier on 11/28/2015.
 */
@Entity
@Table(name = "localidad", schema = "", catalog = "cdb_315fe4b3b3")
public class LocalidadEntity {
    private int localidadId;
    private String nombre;
    private String direccion;
    private Integer tipoId;

    @Id
    @Column(name = "LOCALIDAD_ID", nullable = false, insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getLocalidadId() {
        return localidadId;
    }

    public void setLocalidadId(int localidadId) {
        this.localidadId = localidadId;
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
    @Column(name = "DIRECCION", nullable = true, insertable = true, updatable = true, length = 50)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocalidadEntity that = (LocalidadEntity) o;

        if (localidadId != that.localidadId) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = localidadId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "TIPO_ID", nullable = true, insertable = true, updatable = true)
    public Integer getTipoId() {
        return tipoId;
    }

    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }
}
