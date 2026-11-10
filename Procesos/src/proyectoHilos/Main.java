package proyectoHilos;

public class Main {

	public static void main(String[] args) {
		
		Prueba p = new Prueba();

		Hilos h = new Hilos("hilo 1", p);
		Hilos h2 = new Hilos("hilo 2", p);
		Hilos h3 = new Hilos("hilo 3", p);
		
		h.start();
		h2.start();
		h3.start();

		try {
			h.join();
			h2.join();
			h3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	//	p.mostrar();
		
	}

}
