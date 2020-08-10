package com.fdn.aplicacion.rest_api.Controladores;

import com.fdn.aplicacion.rest_api.Entity.Salasdequimio;
import com.fdn.aplicacion.rest_api.Entity.Sillonesdequimio;
import com.fdn.aplicacion.rest_api.Modelos.MSalasdequimio;
import com.fdn.aplicacion.rest_api.Entity.Sillonesdequimio;

import com.fdn.aplicacion.rest_api.Exceptions.SillonException;
import com.fdn.aplicacion.rest_api.Servicios.SalasService;
import com.fdn.aplicacion.rest_api.Servicios.SillonesService;
import com.fdn.aplicacion.rest_api.Servicios.HoraServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/GestionSalasQuimio")
@RestController

public class SalasControlador {

    @Autowired
    @Qualifier("ServicioSillonesdequimio")
    SillonesService servicioSillon;

    @Autowired
    @Qualifier("ServicioSalasdequimio")
    SalasService servicioSalas;
    @GetMapping("/Salas")
    public List<Sillonesdequimio> getSillones( ){
        return servicioSillon.getAllSillones();
    }

    @GetMapping(path="/")
    public List<Salasdequimio> getSalas( ){
        return servicioSalas.findAll();
    }
}