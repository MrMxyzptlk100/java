public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    protected double velocidadMax;

    public Vehiculo(String marca, String modelo, int anio, double velocidadMax) {
        this.marca = marca;
        this.modelo = modelo;
        setAnio(anio);
        setVelocidadMax(velocidadMax);
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getVelocidadMax() {
        return velocidadMax;
    }

    public void setAnio(int anio) {
        if (anio >= 1885 && anio <= 2100) {
            this.anio = anio;
        } else {
            System.out.println("Error: año no válido.");
        }
    }

    public void setVelocidadMax(double vel) {
        if (vel > 0) {
            this.velocidadMax = vel;
        } else {
            System.out.println("Error: la velocidad máxima debe ser mayor a 0.");
        }
    }

    public void describir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Marca: " + marca + " | Modelo: " + modelo + " | Año: " + anio + " | Vel. Máx: " + velocidadMax + " km/h";
    }
}
