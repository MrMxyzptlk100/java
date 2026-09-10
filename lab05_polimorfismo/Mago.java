public class Mago extends Personaje {
    private int mana;
    private String tipoMagia;

    public Mago(String nombre, int nivel, int puntosVida, int mana, String tipoMagia) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.tipoMagia = tipoMagia;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getTipoMagia() {
        return tipoMagia;
    }

    public void setTipoMagia(String tipoMagia) {
        this.tipoMagia = tipoMagia;
    }

    @Override
    public int calcularDanio() {
        return mana * getNivel();
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("¡" + getNombre() + " lanza una bola de fuego causando " + mana + " de daño mágico!");
    }

    @Override
    public void defender() {
        if (getPuntosVida() > 0) {
            System.out.println(getNombre() + " conjura una barrera mágica protectora de " + tipoMagia + ".");
        }
    }

    // Métodos sobrecargados de meditar
    public void meditar() {
        this.mana += 10;
        System.out.println(getNombre() + " medita en silencio. Maná recuperado en 10 (Maná actual: " + this.mana + ").");
    }

    public void meditar(int minutos) {
        int recuperado = minutos * 5;
        this.mana += recuperado;
        System.out.println(getNombre() + " medita durante " + minutos + " minutos. Maná recuperado en " + recuperado + " (Maná actual: " + this.mana + ").");
    }

    @Override
    public String toString() {
        return super.toString() + " | Clase: Mago | Maná: " + mana + " | Magia: " + tipoMagia;
    }
}
