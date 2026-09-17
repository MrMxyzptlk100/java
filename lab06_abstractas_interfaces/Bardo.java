public class Bardo extends Personaje implements Sanador {

    private int poderCuracion;
    private String instrumento;

    public Bardo(String nombre, int nivel, int puntosVida, int poderCuracion, String instrumento) {
        super(nombre, nivel, puntosVida);
        this.poderCuracion = poderCuracion;
        this.instrumento = instrumento;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] aturde con su " + instrumento + ". Daño: " + calcularDanio());
    }

    @Override
    public int calcularDanio() {
        return (nivel * 15) + (poderCuracion / 6);
    }

    @Override
    public void curarAliado(Personaje aliado) {
        aliado.puntosVida += poderCuracion;
        if (aliado.puntosVida > 0) {
            aliado.estaVivo = true;
        }
        System.out.println(nombre + " entona una melodía y cura a " + aliado.getNombre() +
                           " +" + poderCuracion + ". Vida: " + aliado.getPuntosVida());
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }
}
