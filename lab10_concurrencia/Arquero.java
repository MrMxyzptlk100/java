public class Arquero extends Personaje {
    private String tipoArco;
    private int flechasDisponibles;
    private int precision;

    public Arquero(String nombre, int nivel, int puntosVida, String tipoArco, int flechasDisponibles, int precision) {
        super(nombre, nivel, puntosVida);
        this.tipoArco = tipoArco;
        this.flechasDisponibles = flechasDisponibles;
        this.precision = precision;
    }

    public String getTipoArco() {
        return tipoArco;
    }

    public void setTipoArco(String tipoArco) {
        this.tipoArco = tipoArco;
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }

    public void setFlechasDisponibles(int flechasDisponibles) {
        this.flechasDisponibles = Math.max(0, flechasDisponibles);
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    @Override
    public int calcularDanio() {
        return precision * flechasDisponibles;
    }

    @Override
    public void atacar() throws RpgException {
        if (!isEstaVivo()) {
            throw new PersonajeDerrotadoException(getNombre());
        }

        if (flechasDisponibles <= 0) {
            throw new RecursoInsuficienteException("flechas", flechasDisponibles);
        }

        flechasDisponibles--;
        System.out.println("[" + getNombre() + "] dispara una flecha. " +
                           "Flechas restantes: " + flechasDisponibles);
    }

    public void defender() {
        if (isEstaVivo()) {
            System.out.println(getNombre() + " esquiva con agilidad y se pone a cubierto.");
        }
    }

    public void recargarFlechas() {
        this.flechasDisponibles += 10;
        System.out.println(getNombre() + " recargó 10 flechas (Total: " + this.flechasDisponibles + ").");
    }

    public void recargarFlechas(int cantidad) {
        this.flechasDisponibles += cantidad;
        System.out.println(getNombre() + " recargó " + cantidad + " flechas (Total: " + this.flechasDisponibles + ").");
    }

    @Override
    public String toString() {
        return super.toString() + " | Clase: Arquero | Arco: " + tipoArco + " | Flechas: " + flechasDisponibles + " | Precisión: " + precision;
    }
}
