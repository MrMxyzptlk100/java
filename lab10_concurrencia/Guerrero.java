public class Guerrero extends Personaje {
    private int fuerza;
    private String armadura;

    public Guerrero(String nombre, int nivel, int puntosVida, int fuerza, String armadura) {
        super(nombre, nivel, puntosVida);
        this.fuerza = fuerza;
        this.armadura = armadura;
    }

    public Guerrero(String nombre, int nivel, int puntosVida, String armadura, int fuerza) {
        super(nombre, nivel, puntosVida);
        this.armadura = armadura;
        this.fuerza = fuerza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public String getArmadura() {
        return armadura;
    }

    public void setArmadura(String armadura) {
        this.armadura = armadura;
    }

    @Override
    public int calcularDanio() {
        return fuerza * getNivel();
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }
        System.out.println("¡" + getNombre() + " golpea con su arma causando " + fuerza + " de daño!");
    }

    public void defender() {
        if (isEstaVivo()) {
            System.out.println(getNombre() + " levanta su escudo y se defiende con " + armadura + ".");
        }
    }

    public void entrenar() {
        this.fuerza += 5;
        System.out.println(getNombre() + " entrenó por su cuenta. Fuerza aumentada en 5 (Fuerza actual: " + this.fuerza + ").");
    }

    public void entrenar(int sesiones) {
        int incremento = 5 * sesiones;
        this.fuerza += incremento;
        System.out.println(getNombre() + " completó " + sesiones + " sesiones de entrenamiento. Fuerza aumentada en " + incremento + " (Fuerza actual: " + this.fuerza + ").");
    }

    public void entrenar(int sesiones, boolean intensivo) {
        int factor = intensivo ? 2 : 1;
        int incremento = 5 * sesiones * factor;
        this.fuerza += incremento;
        String modo = intensivo ? "intensivo" : "estándar";
        System.out.println(getNombre() + " completó " + sesiones + " sesiones en modo " + modo + ". Fuerza aumentada en " + incremento + " (Fuerza actual: " + this.fuerza + ").");
    }

    @Override
    public String toString() {
        return super.toString() + " | Clase: Guerrero | Fuerza: " + fuerza + " | Armadura: " + armadura;
    }
}
