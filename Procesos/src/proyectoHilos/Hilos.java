package proyectoHilos;

public class Hilos extends Thread{

	private String nombre;
	private Parking p; 
	private int espacio;
	
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
	
	@Override
	public void run() {
		
		try {
			this.p.ocupar(getNombre(), getEspacio());
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}