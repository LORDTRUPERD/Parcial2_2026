import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Administrativo administrativo = new Administrativo(
                "Ana", "López García", "1234567890101", new BigDecimal("6500"), "Recursos Humanos");
        Docente docente = new Docente(
                "Carlos", "Pérez Soto", "2345678901201", new BigDecimal("8500"),
                List.of("Matemáticas", "Estadística"));
        Investigador investigador = new Investigador(
                "María", "Gómez Ruiz", "3456789012301", new BigDecimal("10000"),
                List.of("Biología", "Genética"), 2);
        Estudiante estudiante = new Estudiante(
                "Luis", "Ramírez Díaz", "4567890123401", "2026-00125");

        Persona[] personalUniversitario = {administrativo, docente, investigador, estudiante};

        docente.impartirClase("Programación orientada a objetos");
        investigador.impartirClase("Metodología de investigación");
        investigador.publicarArticulo("Avances en genética aplicada");

        for (Persona persona : personalUniversitario) {
            System.out.println(System.lineSeparator() + "----- Perfil -----");
            persona.imprimirPerfil();
        }

        System.out.println(System.lineSeparator() + "Sueldos de empleados:");
        for (Persona persona : personalUniversitario) {
            if (persona instanceof Empleado empleado) {
                System.out.println(persona.getNombre() + ": Q" + empleado.calcularSueldoLiquido().toPlainString());
            }
        }
    }
}