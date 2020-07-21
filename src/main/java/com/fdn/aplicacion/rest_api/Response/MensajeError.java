package com.fdn.aplicacion.rest_api.Response;

import java.util.Date;

public class MensajeError {
    private Date timestamp;
    private String mensaje;

    public MensajeError(){}

    public MensajeError(Date timestamp,String mensaje){
        this.timestamp = timestamp;
        this.mensaje = mensaje;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
