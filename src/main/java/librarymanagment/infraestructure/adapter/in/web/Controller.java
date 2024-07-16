package librarymanagment.infraestructure.adapter.in.web;

import librarymanagment.domain.Biblioteca;
import librarymanagment.domain.Libro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biblioteca")
public class Controller {
    private Biblioteca biblioteca = new Biblioteca();

    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> obtenerLibros() {
        return ResponseEntity.ok(biblioteca.getLibros());
    }

    @PostMapping("/libros")
    public ResponseEntity<Libro> agregarLibro(@RequestBody Libro libro) {
        biblioteca.agregarLibro(libro);
        return ResponseEntity.ok(libro);
    }

    @PostMapping("/prestamos")
    public ResponseEntity<String> prestarLibro(@RequestParam String isbn, @RequestParam String usuarioId) {
        boolean prestado = biblioteca.prestarLibro(isbn, usuarioId);
        if (prestado) {
            return ResponseEntity.ok("Libro prestado con éxito");
        } else {
            return ResponseEntity.badRequest().body("No se pudo prestar el libro");
        }
    }

    @PostMapping("/devoluciones")
    public ResponseEntity<String> devolverLibro(@RequestParam String isbn) {
        boolean devuelto = biblioteca.devolverLibro(isbn);
        if (devuelto) {
            return ResponseEntity.ok("Libro devuelto con éxito");
        } else {
            return ResponseEntity.badRequest().body("No se pudo devolver el libro");
        }
    }

    // Otros endpoints según sea necesario
}