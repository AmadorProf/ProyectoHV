import java.util.Random;

public abstract class Personaje {
    protected String nombre;
    protected int nivel;
    protected int experiencia;
    protected int puntosVida;
    protected int puntosVidaMax;
    protected int mana;
    protected int manaMax;
    protected int poderBase;
    protected int defensaBase;
    protected double esquivarProbabilidad;
    protected double criticoProbabilidad;
    protected int poderTemporal;
    protected int defensaTemporal;
    protected int venenoDamage;
    protected boolean envenenado;

    public Personaje(String nombre, int puntosVida, int mana, int poder, int defensa,
                    double esquivarProbabilidad, double criticoProbabilidad) {
        this.nombre = nombre;
        this.nivel = 1;
        this.experiencia = 0;
        this.puntosVidaMax = puntosVida;
        this.puntosVida = puntosVida;
        this.manaMax = mana;
        this.mana = mana;
        this.poderBase = poder;
        this.defensaBase = defensa;
        this.esquivarProbabilidad = esquivarProbabilidad;
        this.criticoProbabilidad = criticoProbabilidad;
        this.poderTemporal = poder;
        this.defensaTemporal = defensa;
        this.venenoDamage = 0;
        this.envenenado = false;
    }

    public void atacar(Personaje objetivo) {
        if (objetivo.estaDerrotado()) return;

        System.out.println(this.nombre + " ataca a " + objetivo.nombre);

        if (objetivo.esquivarAtaque()) {
            System.out.println(objetivo.nombre + " ha esquivado el ataque!");
            return;
        }

        int danio = this.poderTemporal;
        if (new Random().nextDouble() < this.criticoProbabilidad) {
            danio *= 2;
            System.out.println(this.nombre + " ha realizado un ataque crítico!");
        }

        objetivo.recibirDanio(danio);
    }

    public boolean esquivarAtaque() {
        return new Random().nextDouble() < this.esquivarProbabilidad;
    }

    public void recibirDanio(int danio) {
        int danioFinal = danio - (danio * this.defensaTemporal / 100);
        this.puntosVida = Math.max(this.puntosVida - danioFinal, 0);
        System.out.println(this.nombre + " ha recibido " + danioFinal + " de daño. Vida restante: " + this.puntosVida);
    }

    public abstract void usarHabilidadEspecial();

    public void subirNivel() {
        if (this.experiencia >= 100) {
            this.nivel++;
            this.experiencia -= 100;

            this.puntosVidaMax = (int) (this.puntosVidaMax * 1.1);
            this.puntosVida = this.puntosVidaMax;

            this.manaMax = (int) (this.manaMax * 1.1);
            this.mana = this.manaMax;

            this.poderBase = (int) (this.poderBase * 1.1);
            this.defensaBase = (int) (this.defensaBase * 1.1);

            this.resetearAtributosTemporales();
            System.out.println(this.nombre + " ha subido al nivel " + this.nivel + "!");
        }
    }

    public void pasarTurno() {
        this.mana = Math.min(this.mana + 10, this.manaMax);
        System.out.println(this.nombre + " ha recuperado 10 de mana. Mana actual: " + this.mana);
    }

    public void resetearAtributosTemporales() {
        this.poderTemporal = this.poderBase;
        this.defensaTemporal = this.defensaBase;
        this.envenenado = false;
        this.venenoDamage = 0;
    }

    public void aplicarVeneno(int danio) {
        this.envenenado = true;
        this.venenoDamage = danio;
        System.out.println(this.nombre + " ha sido envenenado!");
    }

    public void actualizarEstado() {
        if (envenenado) {
            this.puntosVida = Math.max(this.puntosVida - venenoDamage, 0);
            System.out.println(this.nombre + " sufre " + venenoDamage + " de daño por veneno. Vida restante: " + this.puntosVida);
        }
    }

    public boolean estaDerrotado() {
        return this.puntosVida <= 0;
    }

    public int getMana() {
        return this.mana;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return String.format("%s (Nivel %d) - Vida: %d/%d, Mana: %d/%d, Poder: %d, Defensa: %d",
                nombre, nivel, puntosVida, puntosVidaMax, mana, manaMax, poderTemporal, defensaTemporal);
    }
}
