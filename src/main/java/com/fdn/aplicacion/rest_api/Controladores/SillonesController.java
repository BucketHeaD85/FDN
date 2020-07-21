package com.fdn.aplicacion.rest_api.Controladores;

import com.fdn.aplicacion.rest_api.Entity.Sillonesdequimio;
import com.fdn.aplicacion.rest_api.Exceptions.SillonException;
import com.fdn.aplicacion.rest_api.Servicios.SillonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/GestionSillones")
@RestController
@Validated
public class SillonesController {
    @Autowired
    @Qualifier("ServicioSillonesdequimio")
    SillonesService servicioSillon;
    

    @GetMapping(path="/{estado}",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public List<Sillonesdequimio> getSillon(@PathVariable boolean estado ){
        List<Sillonesdequimio> sillones = servicioSillon.findByOcupado(estado);
        return sillones;
    }

    @PutMapping(path="/{id_sillon}",
            produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
            },
            consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<Object> actualizarSillon(@PathVariable @Pattern(regexp = "[^0-9]") int id_sillon){
        Sillonesdequimio nuevo = servicioSillon.findById(id_sillon);
        if(nuevo == null){throw new SillonException("Sillón no existe");}
        else {
            nuevo.setOcupado(false);
            servicioSillon.actualizar(nuevo);
            String mensaje = "Sillón modificado";
            return new ResponseEntity<>(
                    mensaje,
                    new HttpHeaders(),
                    HttpStatus.OK);
            }
        }

}
