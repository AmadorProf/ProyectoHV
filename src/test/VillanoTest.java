
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VillanoTest {

    @Test
    void villanoSeCreaCorrectamente() {
        Villano v = new Villano("Freezer", 80, 25, 5);
        assertEquals("Freezer", v.getNombre());
        assertEquals(80, v.getVida());
    }

    @Test
    void villanoPuedeAtacar() {
        Personaje heroe = new Personaje("Vegeta", 100, 20, 10);
        Villano v = new Villano("Freezer", 80, 25, 5);
        v.atacar(heroe);
        assertTrue(heroe.getVida() < 100);
    }
}
