package com.fdn.aplicacion.rest_api.Repositorios;

import com.fdn.aplicacion.rest_api.Entity.Sillonesdequimio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("RepositorySillonesdequimio")
public interface SillonesRepository extends JpaRepository<Sillonesdequimio, Serializable>,
        PagingAndSortingRepository<Sillonesdequimio,Serializable> {
    public abstract List<Sillonesdequimio> findByOcupado(boolean ocupado);
    public abstract List<Sillonesdequimio> findAll();
    public abstract Sillonesdequimio findById(int id);
}
