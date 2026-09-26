public class Estudiante extends Persona {
    private final String numeroMatricula;

    public Estudiante(String nombre, String apellidos, String dni, String numeroMatricula) {
        super(nombre, apellidos, dni);
        if (numeroMatricula == null || numeroMatricula.isBlank()) {
            throw new IllegalArgumentException("El número de matrícula no puede estar vacío.");
        }
        this.numeroMatricula = numeroMatricula.trim();
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    @Override
    protected String obtenerDetalleEspecifico() {
        return "Número de matrícula: " + numeroMatricula;
    }
}
