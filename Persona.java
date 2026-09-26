public abstract class Persona {
    private final String nombre;
    private final String apellidos;
    private final String dni;

    protected Persona(String nombre, String apellidos, String dni) {
        this.nombre = validarTexto(nombre, "nombre");
        this.apellidos = validarTexto(apellidos, "apellidos");
        this.dni = validarTexto(dni, "DNI");
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("El " + campo + " no puede estar vacío.");
        }
        return valor.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    protected String obtenerDetalleEspecifico() {
        return "";
    }

    public void imprimirPerfil() {
        System.out.println("Nombre: " + nombre + " " + apellidos);
        System.out.println("DNI: " + dni);
        String detalle = obtenerDetalleEspecifico();
        if (!detalle.isEmpty()) {
            System.out.println(detalle);
        }
    }
}
