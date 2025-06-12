public class SimuladorCombate {
            public static void main(String[] args) {
                Heroe aragorn = new Heroe("Aragorn");
                Villano sauron = new Villano("Sauron");

                System.out.println("=== Estado Inicial ===");
                System.out.println(aragorn);
                System.out.println(sauron);

                int turno = 1;
                while (!aragorn.estaDerrotado() && !sauron.estaDerrotado()) {
                    System.out.println("\n=== Turno " + turno + " ===");

                    // Turno del Héroe
                    aragorn.atacar(sauron);
                    if (aragorn.getMana() >= 20) {
                        aragorn.usarHabilidadEspecial();
                    }

                    // Turno del Villano
                    sauron.atacar(aragorn);
                    sauron.usarHabilidadEspecial();

                    // Aplicar efectos de veneno
                    aragorn.actualizarEstado();
                    sauron.actualizarEstado();

                    // Regenerar mana
                    aragorn.pasarTurno();
                    sauron.pasarTurno();

                    turno++;
                }

                System.out.println("\n=== Combate Terminado ===");
                if (aragorn.estaDerrotado()) {
                    System.out.println(sauron.getNombre() + " ha ganado!");
                } else {
                    System.out.println(aragorn.getNombre() + " ha ganado!");
                }
            }
}
