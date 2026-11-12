package proyectoHilos;

import java.util.concurrent.ThreadLocalRandom;

public class Hilos extends Thread{

	private String nombre;
	private Parking p; 
	private int espacio;
	private boolean minusValido = false;
	
	Hilos(String n, Parking p, int es){
		this.nombre = n;
		this.p = p;
		this.espacio = es;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getEspacio() {
		return this.espacio;
	}
	
	public void setEspacio(int e) {
		this.espacio = e;
	}
	
	public boolean getminusValido() {
		return this.minusValido;
	}
	
	public void setminusValidoAtrue() {
		this.minusValido = true;
	}
	
	@Override
	public void run() {
		
		int probabilidad = ThreadLocalRandom.current().nextInt(1, 101);
		if (probabilidad <= 20) { 
			setminusValidoAtrue();
		}
		
		try {
			this.p.ocupar(getNombre(), getEspacio(), getminusValido());
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}