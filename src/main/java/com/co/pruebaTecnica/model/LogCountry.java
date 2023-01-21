package com.co.pruebaTecnica.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "LogCountrys",schema = "pruebatecnica")
public class LogCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String descripcion;

    private Date fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
