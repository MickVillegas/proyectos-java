package hilos;

public class MiHilo extends Thread{
	
	MiHilo(){
		
	}
	
	@Override
	public void run() {
		System.out.println("Soy un hilo");
	}
	
	
}
