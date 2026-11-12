package proyectoHilos;

public class Main {

	public static void main(String[] args) {
		
		Parking p = new Parking();
		
		for (int i = 1; i <= 30; i++) {
			Hilos h = new Hilos("hilo " + i, p, i);
			h.start();
		}
		
	}

}