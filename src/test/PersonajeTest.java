
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    @Test
    void personajeSeCreaCorrectamente() {
        Personaje p = new Personaje("Goku", 100, 20, 10);
        assertEquals("Goku", p.getNombre());
        assertEquals(100, p.getVida());
        assertEquals(20, p.getAtaque());
        assertEquals(10, p.getDefensa());
    }

    @Test
    void personajeRecibeDanioCorrectamente() {
        Personaje p = new Personaje("Goku", 100, 20, 10);
        p.recibirDanio(30); // Asumimos que aplica defensa
        assertTrue(p.getVida() < 100);
    }

    @Test
    void personajeVidaNoNegativa() {
        Personaje p = new Personaje("Goku", 50, 10, 5);
        p.recibirDanio(200);
        assertEquals(0, p.getVida());
    }
}
