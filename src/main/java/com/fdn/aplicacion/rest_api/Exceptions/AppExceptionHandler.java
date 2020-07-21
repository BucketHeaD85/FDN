package com.fdn.aplicacion.rest_api.Exceptions;

import com.fdn.aplicacion.rest_api.Response.MensajeError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Constraint;
import javax.validation.ConstraintViolationException;
import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){

        String descripcionMensajeError = ex.getLocalizedMessage();
        if(descripcionMensajeError == null)descripcionMensajeError = ex.toString();
        MensajeError mensaje = new MensajeError( new Date(),descripcionMensajeError);

        return new ResponseEntity<>(
                mensaje,
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value={NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request){

        String descripcionMensajeError = ex.getLocalizedMessage();
        if(descripcionMensajeError == null)descripcionMensajeError = ex.toString();
        MensajeError mensaje = new MensajeError( new Date(),descripcionMensajeError);

        return new ResponseEntity<>(
                mensaje,
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value={SillonException.class})
    public ResponseEntity<Object> handleSillonException(SillonException ex, WebRequest request){

        String descripcionMensajeError = ex.getLocalizedMessage();
        if(descripcionMensajeError == null)descripcionMensajeError = ex.toString();
        MensajeError mensaje = new MensajeError( new Date(),descripcionMensajeError);

        return new ResponseEntity<>(
                mensaje,
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e){
        return new ResponseEntity<>("Not valid meme",HttpStatus.BAD_REQUEST);
    }

}
