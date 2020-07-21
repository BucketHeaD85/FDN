package com.fdn.aplicacion.rest_api.Converter;

import com.fdn.aplicacion.rest_api.Entity.Sillonesdequimio;
import com.fdn.aplicacion.rest_api.Modelos.MSillonesdequimio;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("ConSillonesdequimio")
public class ConvertidorSillones {
    public List<MSillonesdequimio> convertirLista(List<Sillonesdequimio> lista){
        List<MSillonesdequimio> msillones = new ArrayList<>();
        for(Sillonesdequimio sillon : lista){
            msillones.add(new MSillonesdequimio(sillon));

        }
        return msillones;
    }

    public MSillonesdequimio convertir(Sillonesdequimio sillon){
        MSillonesdequimio msillon = new MSillonesdequimio(sillon);
        return msillon;
    }

    public Sillonesdequimio convertirmtoe(MSillonesdequimio msillon){
        Sillonesdequimio sillon = new Sillonesdequimio(msillon.getId_sillon(),msillon.getId_sala(),msillon.isOcupado());
        return sillon;
    }

}
