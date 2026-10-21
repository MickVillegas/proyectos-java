package hilos;

public class Crono {
    /** Tiempo inicial en nanosegundos */
    private static long tini;

    /** Tiempo total transcurrido en nanosegundos */
    private static long ttot;

    /**
     * Inicia la medición de tiempo.
     */
    public static void start() {
        tini = System.nanoTime();
    }

    /**
     * Detiene la medición y devuelve el tiempo transcurrido
     * en formato legible (nanosegundos, milisegundos o segundos).
     * 
     * @return Cadena con el tiempo transcurrido y la unidad correspondiente.
     */
    public static String stop() {
        ttot = System.nanoTime() - tini;
        String msg = "";

        if (ttot > 1_000_000) { // Más de 1 ms
            if ((ttot / 1_000_000) > 1000) {
                // Más de 1 segundo
                msg += ((ttot / 1_000_000.0) / 1000) + " segundos.";
            } else {
                // Entre 1 ms y 1000 ms
                msg += (ttot / 1_000_000.0) + " milisegundos.";
            }
        } else {
            // Menos de 1 ms
            msg += ttot + " nanosegundos.";
        }

        return msg;
    }
}
