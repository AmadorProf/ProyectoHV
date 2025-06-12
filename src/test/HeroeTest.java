
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeroeTest {

    private Heroe heroe;

    @BeforeEach
    void setup() {
        heroe = new Heroe("Link");
    }

    @Test
    void heroeSeInicializaCorrectamente() {
        assertEquals("Link", heroe.getNombre());
        assertEquals(100, heroe.getVida());
        assertEquals(50, heroe.getMana());
        assertEquals(20, heroe.getAtaque());
        assertEquals(15, heroe.getDefensaBase());
    }

    @Test
    void heroeUsaHabilidadEspecialParaCurarse() {
        heroe.recibirDanio(60); // baja la vida a 40
        int vidaAntes = heroe.getVida();
        heroe.usarHabilidadEspecial();
        assertTrue(heroe.getVida() > vidaAntes, "La vida debería aumentar al usar curación");
        assertEquals(30, heroe.getMana()); // Mana debería bajar en 20
    }

    @Test
    void heroeUsaHabilidadEspecialParaReforzarDefensa() {
        // No dañas al héroe, así que elegirá reforzar defensa
        int defensaAntes = heroe.getDefensaTemporal();
        heroe.usarHabilidadEspecial();
        assertTrue(heroe.getDefensaTemporal() > defensaAntes, "La defensa temporal debe aumentar");
        assertEquals(30, heroe.getMana());
    }

    @Test
    void heroeNoPuedeUsarHabilidadConManaInsuficiente() {
        // Baja el mana a menos de 20
        heroe.recibirDanio(99); // Asegura que quiera curarse
        heroe.setMana(10); // Simula mana insuficiente
        int vidaAntes = heroe.getVida();
        heroe.usarHabilidadEspecial();
        assertEquals(vidaAntes, heroe.getVida(), "No debe curarse sin suficiente mana");
        assertEquals(10, heroe.getMana());
    }
}
