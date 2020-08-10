package com.fdn.aplicacion.rest_api.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Sillonesdequimio")
public class Sillonesdequimio implements Serializable {

    public Sillonesdequimio(){

    }

    public Sillonesdequimio(int id_sillon,int id_sala, boolean ocupado){
        this.id = id_sillon;
        this.sala = id_sala;
        this.ocupado = ocupado;
    }

    @Id
    @GenericGenerator(name="incrementsillon", strategy="increment")
    @GeneratedValue(generator="incrementsillon")
    @Column(name="id_sillon")
    private int id;
    @Column(name = "ocupado")
    private boolean ocupado;
    @Column(name = "id_sala")
    private int sala;
    @Column(name = "id_paciente")
    private int id_paciente;

    public int getId_sillon() {
        return id;
    }

    public void setId_sillon(int id_sillon) {
        this.id= id_sillon;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getId_sala() {
        return sala;
    }

    public void setId_sala(int id_sala) {
        this.sala = id_sala;
    }

    public int getId_paciente() {
        return this.id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }





}

