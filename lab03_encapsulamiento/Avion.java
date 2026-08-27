public class Avion extends Vehiculo {
    private int numMotores;
    private double altitudMaxima;

    public Avion(String marca, String modelo, int anio, double velocidadMax, int numMotores, double altitudMaxima) {
        super(marca, modelo, anio, velocidadMax);
        setNumMotores(numMotores);
        setAltitudMaxima(altitudMaxima);
    }

    public int getNumMotores() {
        return numMotores;
    }

    public double getAltitudMaxima() {
        return altitudMaxima;
    }

    public void setNumMotores(int numMotores) {
        if (numMotores > 0) {
            this.numMotores = numMotores;
        } else {
            System.out.println("Error: el número de motores debe ser mayor a 0.");
        }
    }

    public void setAltitudMaxima(double altitudMaxima) {
        if (altitudMaxima > 0) {
            this.altitudMaxima = altitudMaxima;
        } else {
            System.out.println("Error: la altitud máxima debe ser mayor a 0.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nMotores: " + numMotores + " | Altitud Máx: " + altitudMaxima + " m";
    }
}
