package com.fdn.aplicacion.rest_api.Servicios;

import java.util.List;

import com.fdn.aplicacion.rest_api.Modelos.MHoradequimio;
import com.fdn.aplicacion.rest_api.Repositorios.HoraRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("serviciohora")
public class HoraServicio{

    @Autowired
    @Qualifier("repositoriohora")
    private HoraRepositorio repositorio;
    
    public boolean crear(MHoradequimio hora){
        try{
            repositorio.save(hora);
            return true;
        } catch (Exception e){
            return false;
        }
    }


}