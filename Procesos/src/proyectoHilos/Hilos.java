package proyectoHilos;

public class Hilos extends Thread{

	private String nombre;
	private Prueba p; 
	
	Hilos(String n, Prueba p){
		this.nombre = n;
		this.p = p;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	@Override
	public void run() {
		
		try {
			this.p.ocupar(getNombre());
			//this.p.mostrar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
