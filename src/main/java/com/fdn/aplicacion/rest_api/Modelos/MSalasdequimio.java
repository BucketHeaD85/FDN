package com.fdn.aplicacion.rest_api.Modelos;

import com.fdn.aplicacion.rest_api.Entity.Salasdequimio;

import java.io.Serializable;
import java.util.Set;

public class MSalasdequimio implements Serializable {


    private int id_sala;
    private int vacantes;
    private Set<MSillonesdequimio> sillones;

    public MSalasdequimio(int id_sala, int vacantes, Set<MSillonesdequimio> sillones){
        this.id_sala = id_sala;
        this.vacantes = vacantes;
        this.sillones = sillones;
    }

    public MSalasdequimio(Salasdequimio sala){
        this.id_sala = sala.getId();
        this.vacantes = sala.getVacantes();
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public int getVacantes() {
        return vacantes;
    }

    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }

    public Set<MSillonesdequimio> getSillones(){ return sillones; }

    public void setSillones(Set<MSillonesdequimio> sillones){ this.sillones = sillones;}
}

