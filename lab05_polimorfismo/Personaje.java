public class Personaje implements Combatiente {
    private String nombre;
    private int nivel;
    private int puntosVida;

    public Personaje(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = Math.max(0, puntosVida);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = Math.max(0, puntosVida);
    }

    public boolean isVivo() {
        return puntosVida > 0;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "]  ataca con un golpe básico.");
    }

    @Override
    public void defender() {
        if (puntosVida > 0) {
            System.out.println(nombre + " adopta una postura defensiva.");
        }
    }

    @Override
    public int calcularDanio() {
        return getNivel() * 10;
    }

    @Override
    public void recibirDanio(int danio) {
        this.puntosVida -= danio;
        if (this.puntosVida < 0) {
            this.puntosVida = 0;
        }
        System.out.println(nombre + " recibe " + danio + " puntos de daño. Vida restante: " + puntosVida);
        if (this.puntosVida == 0) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    // Parte 4: Métodos sobrecargados de mostrarEstado
    public void mostrarEstado() {
        System.out.println(toString());
    }

    public void mostrarEstado(boolean detallado) {
        if (detallado) {
            System.out.println("=== Detalle de Personaje ===");
            System.out.println("Nombre: " + nombre);
            System.out.println("Nivel: " + nivel);
            System.out.println("Puntos de Vida: " + puntosVida);
            System.out.println("Daño Base Estimado: " + calcularDanio());
            System.out.println("Estado: " + (isVivo() ? "Vivo" : "Derrotado"));
        } else {
            mostrarEstado();
        }
    }

    public void mostrarEstado(String prefijo) {
        System.out.println(prefijo + " " + toString());
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Nivel: " + nivel + " | Vida: " + puntosVida;
    }
}
