public class Villano extends Personaje {
    private final int venenoBase;
    private boolean poderDuplicado;

    public Villano(String nombre) {
        super(nombre,
            120,   // Puntos de Vida (nivel 1)
            40,    // Mana (nivel 1)
            25,    // Poder (nivel 1)
            10,    // Defensa (nivel 1)
            0.08,  // Esquivar (8%)
            0.07   // Crítico (7%)
        );
        this.venenoBase = 15;
        this.poderDuplicado = false;
    }

    @Override
    public void usarHabilidadEspecial() {
        // Simulación de elección: 1 para duplicar poder, 2 para envenenar
        int opcion = (this.mana >= 25 && !poderDuplicado) ? 1 : 2;

        if (opcion == 1) {
            duplicarPoder();
        } else {
            if (this.mana >= 15) envenenar();
        }
    }

    private void duplicarPoder() {
        this.poderTemporal = this.poderBase * 2;
        this.poderDuplicado = true;
        this.mana -= 25;
        System.out.println(this.nombre + " ha duplicado su poder a " + this.poderTemporal);
    }

    private void envenenar() {
        this.mana -= 15;
        System.out.println(this.nombre + " ha preparado veneno. ¡Afectará al objetivo en el próximo turno!");
        // Implementación de veneno continuo se maneja en actualizarEstado()
    }

    @Override
    public void resetearAtributosTemporales() {
        super.resetearAtributosTemporales();
        this.poderDuplicado = false;
    }
}
