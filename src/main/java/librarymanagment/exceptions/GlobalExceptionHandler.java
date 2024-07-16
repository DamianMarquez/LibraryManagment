package librarymanagment.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LibroNoEncontradoException.class)
    public ResponseEntity<String> manejarLibroNoEncontrado(LibroNoEncontradoException ex) {
        return ResponseEntity.notFound().build();
    }

}