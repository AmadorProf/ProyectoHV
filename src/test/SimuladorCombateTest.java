
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimuladorCombateTest {

    @Test
    void simuladorEjecutaCombate() {
        Personaje p1 = new Personaje("Goku", 100, 20, 10);
        Villano v1 = new Villano("Freezer", 80, 25, 5);
        SimuladorCombate simulador = new SimuladorCombate();

        simulador.combatir(p1, v1);

        assertTrue(p1.getVida() < 100 || v1.getVida() < 80);
    }

    @Test
    void combateTerminaConUnMuerto() {
        Personaje p1 = new Personaje("Goku", 30, 5, 1);
        Villano v1 = new Villano("Freezer", 30, 5, 1);
        SimuladorCombate simulador = new SimuladorCombate();

        simulador.combatir(p1, v1);

        assertTrue(p1.getVida() == 0 || v1.getVida() == 0);
    }
}
