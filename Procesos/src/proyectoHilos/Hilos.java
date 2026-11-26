package proyectoHilos;

import java.util.concurrent.ThreadLocalRandom;

public class Hilos extends Thread{

	private String nombre;
	private Parking p; 
	private int id;
	private boolean minusValido = false;
	
	Hilos(String n, Parking p, int es){
		this.nombre = n;
		this.p = p;
		this.id = es;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getIde() {
		return this.id;
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
			this.p.ocupar(getNombre(), getIde(), getminusValido());
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}