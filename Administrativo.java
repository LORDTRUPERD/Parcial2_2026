import java.math.BigDecimal;

public class Administrativo extends Empleado {
    private final String departamento;

    public Administrativo(
            String nombre,
            String apellidos,
            String dni,
            BigDecimal salarioBase,
            String departamento) {
        super(nombre, apellidos, dni, salarioBase);
        if (departamento == null || departamento.isBlank()) {
            throw new IllegalArgumentException("El departamento no puede estar vacío.");
        }
        this.departamento = departamento.trim();
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    protected String obtenerDetalleEspecifico() {
        return "Cargo: Administrativo"
                + System.lineSeparator()
                + "Departamento: " + departamento
                + System.lineSeparator()
                + super.obtenerDetalleEspecifico();
    }
}
