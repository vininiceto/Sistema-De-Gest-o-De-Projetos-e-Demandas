package br.com.vininiceto.sistemadegestaodeprojetosedemandas.Exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@ControllerAdvice
@RestController
public class ExceptionsHandler {

    private final DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @ExceptionHandler(ObjectEmptyException.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
        LocalDateTime ldt = new Date().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        ExceptionResponse response = new ExceptionResponse(ldt.format(dtm), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ObjectNullException.class)
    public final ResponseEntity<ExceptionResponse> handleNullExceptions(Exception ex, WebRequest request) {
        LocalDateTime ldt = new Date().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        ExceptionResponse response = new ExceptionResponse(ldt.format(dtm), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<ExceptionResponse> handleDataExceptions(Exception ex, WebRequest request) {
        LocalDateTime ldt = new Date().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        ExceptionResponse response = new ExceptionResponse(ldt.format(dtm), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DateInvalidException.class)
    public final ResponseEntity<ExceptionResponse> handleDataInvalidExceptions(Exception ex, WebRequest request) {
        LocalDateTime ldt = new Date().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        ExceptionResponse response = new ExceptionResponse(ldt.format(dtm), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}

