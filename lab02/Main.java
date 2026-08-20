public class Main {
    public static void main(String[] args) {
        System.out.println("=== Clínica Veterinaria ===");
        System.out.println();

        // 1. Instancia de Perro
        Perro perro = new Perro("Max", 3, 12.5, "Labrador", true);
        System.out.println("-- Perro --");
        System.out.println(perro); // Llama automáticamente a toString()
        perro.comer();             // Método heredado de Animal
        perro.ladrar();            // Método propio de Perro
        perro.buscarPelota();      // Método propio de Perro
        System.out.println();

        // 2. Instancia de Gato
        Gato gato = new Gato("Misi", 2, 3.8, "Gris", true);
        System.out.println("-- Gato --");
        System.out.println(gato);  // Llama automáticamente a toString()
        gato.dormir();             // Método heredado de Animal
        gato.maullar();            // Método propio de Gato
        gato.ronronear();          // Método propio de Gato
        System.out.println();

        // 3. Instancia de Canario
        Canario canario = new Canario("Pico", 1, 0.03, "Amarillo", true);
        System.out.println("-- Canario --");
        System.out.println(canario); // Llama automáticamente a toString()
        canario.comer();             // Método heredado de Animal
        canario.cantar();            // Método propio de Canario
        canario.volar();             // Método propio de Canario
    }
}
