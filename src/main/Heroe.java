public class Heroe extends Personaje {
    private final int curacionBase;
    private final int defensaExtra;

    public Heroe(String nombre) {
        super(nombre,
            100,   // Puntos de Vida (nivel 1)
            50,    // Mana (nivel 1)
            20,    // Poder (nivel 1)
            15,    // Defensa (nivel 1)
            0.10,  // Esquivar (10%)
            0.05   // Crítico (5%)
        );
        this.curacionBase = 30;
        this.defensaExtra = 5;
    }

    @Override
    public void usarHabilidadEspecial() {
        if (this.mana < 20) {
            System.out.println("Mana insuficiente para usar habilidad especial.");
            return;
        }

        // Simulación de elección: 1 para curar, 2 para reforzar defensa
        int opcion = (this.puntosVida < this.puntosVidaMax / 2) ? 1 : 2;

        if (opcion == 1) {
            curar();
        } else {
            reforzarDefensa();
        }
        this.mana -= 20;
    }

    private void curar() {
        int curacion = Math.min(this.curacionBase, this.puntosVidaMax - this.puntosVida);
        this.puntosVida += curacion;
        System.out.println(this.nombre + " ha curado " + curacion + " puntos de vida. Vida actual: " + this.puntosVida);
    }

    private void reforzarDefensa() {
        this.defensaTemporal += this.defensaExtra;
        System.out.println(this.nombre + " ha reforzado su defensa a " + this.defensaTemporal);
    }
}
