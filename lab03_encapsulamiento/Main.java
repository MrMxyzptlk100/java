public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Transporte Multimodal ===\n");

        // Creación de instancias iniciales
        Automovil auto = new Automovil("Toyota", "Corolla", 2022, 180.0, 4, false);
        Avion avion = new Avion("Boeing", "737", 2019, 850.0, 2, 12500.0);
        Barco barco = new Barco("Ferretti", "550", 2020, 45.0, "Fibra de vidrio", 30.0);

        // Mostrar información de los vehículos
        System.out.println("-- Automovil --");
        System.out.println(auto);
        System.out.println();

        // Pruebas de validación con valores inválidos
        auto.setAnio(1800);
        auto.setNumPuertas(10);
        System.out.println();

        // Corrección de valores con datos válidos
        auto.setAnio(2023);
        auto.setNumPuertas(5);

        System.out.println("-- Automovil Actualizado --");
        System.out.println(auto);
        System.out.println();

        System.out.println("-- Avion --");
        System.out.println(avion);
        System.out.println();

        // Prueba de validación en Avion
        avion.setAltitudMaxima(-500);
        System.out.println();

        System.out.println("-- Barco --");
        System.out.println(barco);
        System.out.println();

        // Prueba de validación en Barco
        barco.setTonelajeMaximo(-10);
    }
}
