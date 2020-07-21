package com.fdn.aplicacion.rest_api.Converter;

import com.fdn.aplicacion.rest_api.Entity.Salasdequimio;
import com.fdn.aplicacion.rest_api.Modelos.MSalasdequimio;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component("ConSalasdequimio")
public class ConvertidorSalas {
    private ConvertidorSillones convertidorSillones;
    public List<MSalasdequimio> convertirLista(List<Salasdequimio> lista){
        List<MSalasdequimio> msalas = new ArrayList<>();
        for(Salasdequimio sala : lista){
            msalas.add(new MSalasdequimio(sala));

        }
        return msalas;
    }

    public MSalasdequimio convertir(Salasdequimio sala){
        MSalasdequimio msala = new MSalasdequimio(sala);
        return msala;
    }
/*
    public Salasdequimio convertirmtoe(MSalasdequimio msala){
        Salasdequimio sala = new Salasdequimio(msala.getId_sala(),msala.getVacantes(),convertidorSillones.msala.getSillones());
        return sala;
    }
*/
}

