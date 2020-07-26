package com.fdn.aplicacion.rest_api.Exceptions;

import com.fdn.aplicacion.rest_api.Response.MensajeError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
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

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    ResponseEntity<Object> handleTypeMismatch(MethodArgumentTypeMismatchException ex){
        /*String descripcionMensajeError = "El identificador ingresado debe ser un entero.";*/
        String name = ex.getName();
        String type = ex.getRequiredType().getSimpleName();
        Object value = ex.getValue();
        String descripcionMensajeError = String.format("El campo '%s' debe ser de tipo '%s'. El valor ingresado: '%s' no cumple la condición.",
                name, type, value);
        MensajeError mensaje = new MensajeError( new Date(),descripcionMensajeError);


        return new ResponseEntity<>(
                mensaje,
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
