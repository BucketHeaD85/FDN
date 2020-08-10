package com.fdn.aplicacion.rest_api.Servicios;


import com.fdn.aplicacion.rest_api.Entity.Salasdequimio;
import com.fdn.aplicacion.rest_api.Repositorios.SalasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServicioSalasdequimio")
public class SalasService {
    @Autowired
    @Qualifier("RepositorySalasdequimio")
    private SalasRepository repositorio;

    public List<Salasdequimio> findAll(){
        return repositorio.findAll();
    }
}
