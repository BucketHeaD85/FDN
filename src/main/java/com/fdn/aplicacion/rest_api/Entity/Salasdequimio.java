package com.fdn.aplicacion.rest_api.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Salasdequimio")
public class Salasdequimio implements Serializable {

    public Salasdequimio(){

    }

    public Salasdequimio(int id, int vacantes, Set<Sillonesdequimio> sillones){
        this.id = id;
        this.vacantes = vacantes;
        this.sillones = sillones;
    }
    @Id
    @GenericGenerator(name="incrementsala", strategy="increment")
    @GeneratedValue(generator="incrementsala")
    @Column(name="id_sala")
    private int id;
    @Column(name = "vacantes")
    private int vacantes;
    @OneToMany(mappedBy = "sala")
    private Set<Sillonesdequimio> sillones;

    public Set<Sillonesdequimio> getSillones() {
        return sillones;
    }

    public void setSillones(Set<Sillonesdequimio> sillones) {
        this.sillones = sillones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id= id;
    }

    public int getVacantes() {
        return vacantes;
    }

    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }

}
