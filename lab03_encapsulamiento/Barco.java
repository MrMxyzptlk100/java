public class Barco extends Vehiculo {
    private String tipoCasco;
    private double tonelajeMaximo;

    public Barco(String marca, String modelo, int anio, double velocidadMax, String tipoCasco, double tonelajeMaximo) {
        super(marca, modelo, anio, velocidadMax);
        this.tipoCasco = tipoCasco;
        setTonelajeMaximo(tonelajeMaximo);
    }

    public String getTipoCasco() {
        return tipoCasco;
    }

    public double getTonelajeMaximo() {
        return tonelajeMaximo;
    }

    public void setTipoCasco(String tipoCasco) {
        this.tipoCasco = tipoCasco;
    }

    public void setTonelajeMaximo(double tonelajeMaximo) {
        if (tonelajeMaximo > 0) {
            this.tonelajeMaximo = tonelajeMaximo;
        } else {
            System.out.println("Error: el tonelaje máximo debe ser mayor a 0.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de Casco: " + tipoCasco + " | Tonelaje Máx: " + tonelajeMaximo + " toneladas";
    }
}
