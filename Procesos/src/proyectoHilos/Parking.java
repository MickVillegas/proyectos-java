package proyectoHilos;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Parking {

	Semaphore sm = new Semaphore(10);
	int arr [] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	int diez = 0;
	
	public void ocupar(String n, int num) throws InterruptedException {
		
		sm.acquire();
		
		synchronized(this) {	
			diez++;
			System.out.println(n +" a ocupado un aparcamiento libre");
			
			for (int i = 0; i < arr.length; i++) {

				if(arr[i] == 0) {
					arr[i] = num;
					break;
				}
			}
			
			if(diez % 10 == 0) {
				mostrar(n);
			}
		}
		
		int tiempo = ThreadLocalRandom.current().nextInt(0, 10000);
		Thread.sleep(tiempo);
		
		sm.release();
		synchronized(this) {	
			int indice = -1;

			for (int i = 0; i < arr.length; i++) {
			    if (arr[i] == num) {
			        indice = i;
			        break;
			    }
			}
			arr[indice] = 0; 
		}
		
		System.out.println(n +" a dejado un aparcamiento libre");
	}
	
	public synchronized void mostrar(String n){
		System.out.println(n + ":");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
}