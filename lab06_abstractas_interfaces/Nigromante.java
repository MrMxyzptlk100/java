public class Nigromante extends Personaje implements Hechicero {

    private int mana;
    private int almasAbsorbidas;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana, int almasAbsorbidas) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
    }

    public int getAlmasAbsorbidas() {
        return almasAbsorbidas;
    }

    public void absorberAlma() {
        this.almasAbsorbidas++;
        System.out.println(nombre + " ha absorbido un alma. Almas totales: " + almasAbsorbidas);
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] drena la esencia vital. Daño: " + calcularDanio());
    }

    @Override
    public int calcularDanio() {
        return (nivel * 25) + mana + (almasAbsorbidas * 2);
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza: ¡Maldición de decadencia! (maná: " + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }
}
