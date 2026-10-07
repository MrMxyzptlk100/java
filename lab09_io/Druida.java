public class Druida extends Personaje implements Hechicero, Sanador {

    private int mana;
    private int poderCuracion;
    private String vinculoAnimal;

    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion, String vinculoAnimal) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.vinculoAnimal = vinculoAnimal;
    }

    public Druida(String nombre, int nivel, int puntosVida, int mana) {
        this(nombre, nivel, puntosVida, mana, 50, "Lobo");
    }

    public String getVinculoAnimal() {
        return vinculoAnimal;
    }

    public void setVinculoAnimal(String vinculoAnimal) {
        this.vinculoAnimal = vinculoAnimal;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }
        if (mana < 10) {
            throw new RecursoInsuficienteException("mana", mana);
        }
        mana -= 10;
        System.out.println("[" + nombre + "] invoca raíces del bosque. Daño: " + calcularDanio());
    }

    @Override
    public int calcularDanio() {
        return (nivel * 20) + (mana / 2) + 10;
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza: ¡Tormenta de espinas! (maná: " + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void curarAliado(Personaje aliado) throws RpgException {
        if (aliado == null) {
            throw new PersonajeNuloException("curarAliado");
        }
        if (!aliado.isEstaVivo()) {
            throw new AccionInvalidaException("curarAliado", "No se puede curar a un personaje derrotado");
        }
        aliado.puntosVida += poderCuracion;
        System.out.println(nombre + " toca la tierra y cura a " + aliado.getNombre() +
                           " +" + poderCuracion + ". Vida: " + aliado.getPuntosVida());
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }
}
