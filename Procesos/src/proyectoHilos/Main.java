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





package proyectoHilos;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Parking p = new Parking();
		ArrayList<Object> listaHilos = new ArrayList();
		Hilos h;
		
		for (int i = 1; i <= 30; i++) {
			p.acumular(i);
			listaHilos.add(h = new Hilos("hilo " + i, p, i));
		}
		
		for (int i = 0; i < listaHilos.size(); i++) {
			h = (Hilos) listaHilos.get(i);
			h.start();
		}	
	}
}
