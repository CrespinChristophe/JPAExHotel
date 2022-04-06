package technifutur.crespin.JPAhotel.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import technifutur.crespin.JPAhotel.data.exceptions.ElementNotFoundException;
import technifutur.crespin.JPAhotel.model.dto.ErrorDTO;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    //ResponseEntityExceptionHandler définit un comportement de base
    //code qu'on veut centralisé, va s'appliquer sur tous les controller sauf si on spécifie autrement
    //ce code était précédemment dans HotelController
    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleElementNotFound(ElementNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)//code 404
                .body(
                        ErrorDTO.builder()
                                .message(ex.getMessage())
                                .method(HttpMethod.resolve(request.getMethod()))
                                .status(404)
                                .uri(request.getRequestURI())
                                .build()
                );
    }





    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("salut" + "");
        return super.handleNoHandlerFoundException(ex, headers, status, request);
    }
    //    @Override
//    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//
//
//
//        return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
//    }

}
