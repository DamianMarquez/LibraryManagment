package librarymanagment.exceptions;

public class LibroNoEncontradoException extends RuntimeException {
    public LibroNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}