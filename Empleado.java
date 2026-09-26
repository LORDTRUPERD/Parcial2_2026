import java.math.BigDecimal;

public abstract class Empleado extends Persona {
    private final BigDecimal salarioBase;

    protected Empleado(String nombre, String apellidos, String dni, BigDecimal salarioBase) {
        super(nombre, apellidos, dni);
        if (salarioBase == null || salarioBase.signum() < 0) {
            throw new IllegalArgumentException("El salario base debe ser mayor o igual a cero.");
        }
        this.salarioBase = salarioBase;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    protected BigDecimal calcularBonificaciones() {
        return BigDecimal.ZERO;
    }

    public BigDecimal calcularSueldoLiquido() {
        return salarioBase.add(calcularBonificaciones());
    }

    protected String obtenerDetalleEspecifico() {
        return "Salario líquido: Q" + calcularSueldoLiquido().toPlainString();
    }
}
