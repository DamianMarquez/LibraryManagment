package librarymanagment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Biblioteca {

    private List<Libro> libros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private Map<String, String> prestamos = new HashMap<>(); // ISBN -> ID de Usuario

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public Libro buscarLibro(String isbn) {
        return libros.stream()
                .filter(libro -> libro.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public boolean prestarLibro(String isbn, String usuarioId) {
        Libro libro = buscarLibro(isbn);
        if (libro != null && libro.prestar()) {
            prestamos.put(isbn, usuarioId);
            return true;
        }
        return false;
    }

    public boolean devolverLibro(String isbn) {
        Libro libro = buscarLibro(isbn);
        if (libro != null && prestamos.containsKey(isbn)) {
            libro.devolver();
            prestamos.remove(isbn);
            return true;
        }
        return false;
    }

    // Métodos para gestionar usuarios
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Otros métodos según sea necesario
}
