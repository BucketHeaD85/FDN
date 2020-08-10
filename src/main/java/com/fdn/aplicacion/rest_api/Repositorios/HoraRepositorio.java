package com.fdn.aplicacion.rest_api.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.fdn.aplicacion.rest_api.Modelos.MHoradequimio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("repositoriohora")
public interface HoraRepositorio extends JpaRepository<MHoradequimio, Serializable>{
    public abstract void deleteByIdHora(long id);
}
