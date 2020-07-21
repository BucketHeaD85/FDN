package com.fdn.aplicacion.rest_api.Servicios;

import com.fdn.aplicacion.rest_api.Entity.Sillonesdequimio;
import com.fdn.aplicacion.rest_api.Converter.ConvertidorSillones;
import com.fdn.aplicacion.rest_api.Repositorios.SillonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServicioSillonesdequimio")
public class SillonesService {

    @Autowired
    @Qualifier("RepositorySillonesdequimio")
    private SillonesRepository repositorio;

    @Autowired
    @Qualifier("ConSillonesdequimio")
    private ConvertidorSillones convertidor;

    public List<Sillonesdequimio> findByOcupado(boolean ocupado){
        return repositorio.findByOcupado(ocupado);
    }

    public Sillonesdequimio findById(int id){

        return repositorio.findById(id);
    }
    public boolean actualizar(Sillonesdequimio sillon){
        try{
            repositorio.save(sillon);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
