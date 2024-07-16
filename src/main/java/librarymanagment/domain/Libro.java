package librarymanagment.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Libro {
    private String titulo;
    private String isbn;
    private int año;
    private Autor autor;
    private boolean prestado;

    // Constructor, getters y setters

    public boolean prestar() {
        if (!prestado) {
            prestado = true;
            return true;
        }
        return false;
    }

    public void devolver() {
        prestado = false;
    }
}