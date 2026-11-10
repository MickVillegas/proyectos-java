package proyectoHilos;

import java.util.concurrent.Semaphore;

public class Prueba {

	Semaphore sm = new Semaphore(2);
	int arr [] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

	public void ocupar(String n) throws InterruptedException {
		
		sm.acquire();
		
		synchronized(this) {	
		
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == 0) {
					arr[i] = 1;
					break;
				}
			}
			
			mostrar(n);
			System.out.println();
			System.out.println();
			
		}
		
		Thread.sleep(1000);
		
		sm.release();
	}
	
	public synchronized void mostrar(String n){
		//sm.acquire();
		System.out.println(n + ":");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	
		//sm.release();
	}
	
}


