public class Canario extends Animal {
    private String colorPlumaje;
    private boolean cantaEnJaula;

    public Canario(String nombre, int edad, double peso, String colorPlumaje, boolean cantaEnJaula) {
        super(nombre, edad, peso);
        this.colorPlumaje = colorPlumaje;
        this.cantaEnJaula = cantaEnJaula;
    }

    public String getColorPlumaje() {
        return colorPlumaje;
    }

    public void setColorPlumaje(String colorPlumaje) {
        this.colorPlumaje = colorPlumaje;
    }

    public boolean isCantaEnJaula() {
        return cantaEnJaula;
    }

    public void setCantaEnJaula(boolean cantaEnJaula) {
        this.cantaEnJaula = cantaEnJaula;
    }

    public void cantar() {
        System.out.println(getNombre() + " está cantando: ♪ pi pi pi ♪");
    }

    public void volar() {
        System.out.println(getNombre() + " está volando por la habitación.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Plumaje: " + colorPlumaje + " | Canta en jaula: " + (cantaEnJaula ? "Sí" : "No");
    }
}
