import java.math.BigDecimal;
import java.util.List;

public class Docente extends Empleado implements ImpartirClase {
    private final List<String> areasConocimiento;

    public Docente(
            String nombre,
            String apellidos,
            String dni,
            BigDecimal salarioBase,
            List<String> areasConocimiento) {
        super(nombre, apellidos, dni, salarioBase);
        if (areasConocimiento == null || areasConocimiento.isEmpty()) {
            throw new IllegalArgumentException("Debe especificar al menos un área de conocimiento.");
        }
        this.areasConocimiento = areasConocimiento.stream()
                .map(area -> {
                    if (area == null || area.isBlank()) {
                        throw new IllegalArgumentException("Las áreas de conocimiento no pueden estar vacías.");
                    }
                    return area.trim();
                })
                .toList();
    }

    public List<String> getAreasConocimiento() {
        return areasConocimiento;
    }

    @Override
    public void impartirClase(String curso) {
        if (curso == null || curso.isBlank()) {
            throw new IllegalArgumentException("El nombre del curso no puede estar vacío.");
        }
        System.out.println(getNombre() + " " + getApellidos() + " imparte: " + curso.trim());
    }

    @Override
    protected String obtenerDetalleEspecifico() {
        return "Cargo: Docente"
                + System.lineSeparator()
                + "Áreas de conocimiento: " + String.join(", ", areasConocimiento)
                + System.lineSeparator()
                + super.obtenerDetalleEspecifico();
    }
}
