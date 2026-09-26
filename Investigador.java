import java.math.BigDecimal;
import java.util.List;

public class Investigador extends Docente implements PublicarArticulos {
    private static final BigDecimal BONO_POR_PUBLICACION = new BigDecimal("800");
    private int numPublicaciones;

    public Investigador(
            String nombre,
            String apellidos,
            String dni,
            BigDecimal salarioBase,
            List<String> areasConocimiento,
            int numPublicaciones) {
        super(nombre, apellidos, dni, salarioBase, areasConocimiento);
        if (numPublicaciones < 0) {
            throw new IllegalArgumentException("El número de publicaciones no puede ser negativo.");
        }
        this.numPublicaciones = numPublicaciones;
    }

    public int getNumPublicaciones() {
        return numPublicaciones;
    }

    @Override
    public void publicarArticulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título del artículo no puede estar vacío.");
        }
        numPublicaciones++;
        System.out.println(getNombre() + " " + getApellidos() + " publicó: " + titulo.trim());
    }

    @Override
    protected BigDecimal calcularBonificaciones() {
        return BONO_POR_PUBLICACION.multiply(BigDecimal.valueOf(numPublicaciones));
    }

    @Override
    protected String obtenerDetalleEspecifico() {
        return "Cargo: Docente e investigador"
                + System.lineSeparator()
                + "Áreas de conocimiento: " + String.join(", ", getAreasConocimiento())
                + System.lineSeparator()
                + "Número de publicaciones: " + numPublicaciones
                + System.lineSeparator()
                + "Bono por publicaciones: Q" + calcularBonificaciones().toPlainString()
                + System.lineSeparator()
                + "Salario líquido: Q" + calcularSueldoLiquido().toPlainString();
    }
}
