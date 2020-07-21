package com.fdn.aplicacion.rest_api.Modelos;

import com.fdn.aplicacion.rest_api.Entity.Sillonesdequimio;

import java.io.Serializable;

public class MSillonesdequimio implements Serializable {
    private int id_sillon;
    private int id_sala;
    private boolean ocupado;

    public MSillonesdequimio(int id_sillon, int id_sala, boolean ocupado){
        this.id_sala = id_sala;
        this.id_sillon = id_sillon;
        this.ocupado = ocupado;
    }
    public MSillonesdequimio(Sillonesdequimio sillon){
        this.ocupado = sillon.isOcupado();
        this.id_sillon = sillon.getId_sillon();
        this.id_sala = sillon.getId_sala();

    }

    public int getId_sillon() {
        return id_sillon;
    }

    public void setId_sillon(int id_sillon) {
        this.id_sillon = id_sillon;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

}