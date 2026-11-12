package proyectoHilos;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Parking {

	Semaphore sm = new Semaphore(10);
	int arr [] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	int diez = 0;
	
	public void ocupar(String n, int num, boolean dis) throws InterruptedException {
		
		sm.acquire();
		
		synchronized(this) {	
			//diez++;
			
			for (int i = 0; i < arr.length; i++) {

				if(arr[i] == 0) {
					if(i == 8 && dis == true || i == 9 && dis == true) {
						arr[i] = num;
						break;
					}
					else {
						if(i < 8) {
							arr[i] = num;
							break;
						}

					}
				}
			}	
			System.out.println(n +" a ocupado un aparcamiento libre");
			mostrar();
		}
		
		int tiempo = ThreadLocalRandom.current().nextInt(1000, 60000);
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
			if (indice != -1) {
                arr[indice] = 0;    
            }
			System.out.println(n + " ha dejado libre su aparcamiento:");
			mostrar();
		}
	}
	
	public synchronized void mostrar(){
	    System.out.print("[ ");
	    for (int i = 0; i < arr.length; i++) {
	        if (arr[i] == 0) {
	            if (i >= 8) {
	                System.out.print("♿ "); 
	            } else {
	                System.out.print("🅿️ "); 
	            }
	        } else {
	            if (i >= 8) {
	                System.out.print("🚙[" + arr[i] + "] ");
	            } else {
	                System.out.print("🚗[" + arr[i] + "] ");
	            }
	        }
	    }
	    System.out.println("]");
	    System.out.println("--------------------------------------------------");
	}
	
	/*
	 public synchronized void mostrar(){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	*/
	
}