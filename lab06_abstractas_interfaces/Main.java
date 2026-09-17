public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG — Expansión: Nuevas Clases ===\n");

        System.out.println("-- Error esperado (línea comentada) --");
        // Personaje p = new Personaje("Desconocido", 1, 100); 
        // Error de compilación: Personaje is abstract; cannot be instantiated
        System.out.println("// new Personaje(...) → cannot instantiate abstract class\n");

        // Instanciación de personajes específicos
        Druida sylva = new Druida("Sylva", 7, 200, 180, 120, "Lobo Ancestral");
        Nigromante malachar = new Nigromante("Malachar", 6, 350, 220, 10);
        Bardo finnian = new Bardo("Finnian", 5, 150, 60, "laúd");

        // Demostración de polimorfismo con arreglo de Personaje
        Personaje[] equipo = { sylva, malachar, finnian };

        System.out.println("-- Ataques y daño --");
        for (Personaje p : equipo) {
            p.atacar();
        }

        System.out.println("\n-- Solo los Hechiceros lanzan hechizos --");
        for (Personaje p : equipo) {
            if (p instanceof Hechicero h) {
                h.lanzarHechizo();
            }
        }

        System.out.println("\n-- Solo los Sanadores curan --");
        malachar.recibirDanio(300);
        for (Personaje p : equipo) {
            if (p instanceof Sanador s) {
                s.curarAliado(malachar);
            }
        }

        System.out.println("\n-- Estado final --");
        for (Personaje p : equipo) {
            System.out.println(p);
        }
    }
}
