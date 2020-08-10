package com.fdn.aplicacion.rest_api.Repositorios;

import com.fdn.aplicacion.rest_api.Entity.Salasdequimio;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;

@Repository("RepositorySalasdequimio")
public interface SalasRepository extends JpaRepository<Salasdequimio, Serializable>,
        PagingAndSortingRepository<Salasdequimio,Serializable>{
    public abstract List<Salasdequimio> findAll();
}
