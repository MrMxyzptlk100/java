public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG — Demostración de Polimorfismo ===");
        System.out.println();

        // 3a — Variable de tipo padre apunta a objeto hijo
        Personaje p1 = new Guerrero("Thorin", 5, 200, 85, "Cota de Malla");
        Personaje p2 = new Mago("Gandalf", 8, 120, 150, "Fuego");
        Personaje p3 = new Arquero("Legolas", 6, 150, "Arco Largo", 30, 95);

        System.out.println("-- calcularDanio() por tipo --");
        System.out.printf("%-7s (Guerrero) daño: %-6d ← fuerza(85) * nivel(5)%n", p1.getNombre(), p1.calcularDanio());
        System.out.printf("%-7s (Mago)     daño: %-6d ← mana(150)  * nivel(8)%n", p2.getNombre(), p2.calcularDanio());
        System.out.printf("%-7s (Arquero)  daño: %-6d ← precision(95) * flechas(30)%n", p3.getNombre(), p3.calcularDanio());
        System.out.println();

        // 3b — Arreglo polimórfico
        System.out.println("-- Arreglo polimórfico --");
        Personaje[] equipo = { p1, p2, p3 };
        for (Personaje p : equipo) {
            p.atacar();
        }
        System.out.println();

        // 3c — Usar GestorBatalla con las tres sobrecargas
        System.out.println("-- GestorBatalla --");
        GestorBatalla gestor = new GestorBatalla();

        gestor.ejecutarAtaque(p1);            // versión 1 persona
        gestor.ejecutarAtaque(p2, p3);        // versión atacante vs defensor
        gestor.ejecutarAtaque(equipo);        // versión equipo completo
        System.out.println();

        gestor.mostrarHistorial();
        System.out.println();

        // 3d — Identificar tipo real con instanceof
        System.out.println("-- instanceof --");
        for (Personaje p : equipo) {
            if (p instanceof Guerrero) {
                System.out.println(p.getNombre() + " es un Guerrero.");
            } else if (p instanceof Mago) {
                System.out.println(p.getNombre() + " es un Mago.");
            } else if (p instanceof Arquero) {
                System.out.println(p.getNombre() + " es un Arquero.");
            }
        }
        System.out.println();

        // Parte 4 — Demostración de sobrecarga adicional
        System.out.println("-- Sobrecarga adicional (Parte 4) --");
        System.out.println("Demostración de sobrecarga en Personaje (mostrarEstado):");
        p1.mostrarEstado();
        p1.mostrarEstado(true);
        p1.mostrarEstado("[INFO]");

        System.out.println("\nDemostración de sobrecarga en Guerrero (entrenar):");
        Guerrero thorin = (Guerrero) p1;
        thorin.entrenar();
        thorin.entrenar(3);
        thorin.entrenar(2, true);
    }
}
