package proyectoHilos;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Parking {

	Semaphore sm = new Semaphore(10);
	int aparcamientos [] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	public void ocupar(String n, int num, boolean dis) throws InterruptedException {
		
		//acumular(num);
		
		sm.acquire();
		
		synchronized(this) {	
			
			for (int i = 0; i < aparcamientos.length; i++) {

				if(aparcamientos[i] == 0) {
					if(i == 8 && dis == true || i == 9 && dis == true) {
						aparcamientos[i] = num;
						break;
					}
					else {
						if(i < 8) {
							aparcamientos[i] = num;
							break;
						}

					}
				}
			}	
			System.out.println(n +" a ocupado un aparcamiento libre");
			mostrarEstadoParking();
		}
		
		int tiempo = ThreadLocalRandom.current().nextInt(1000, 6000);
		Thread.sleep(tiempo);
		
		sm.release();
		
		synchronized(this) {	
			int indice = -1;

			for (int i = 0; i < aparcamientos.length; i++) {
			    if (aparcamientos[i] == num) {
			        indice = i;
			        break;
			    }
			}
			if (indice != -1) {
				aparcamientos[indice] = 0;    
            }
			
			System.out.println(n + " ha dejado libre su aparcamiento:");
			mostrarEstadoParking();
		}
	}
	
	public synchronized void mostrarEstadoParking(){
		
	    System.out.print("[ ");
	    for (int i = 0; i < aparcamientos.length; i++) {
	        if (aparcamientos[i] == 0) {
	            if (i >= 8) {
	                System.out.print("♿ "); 
	            } else {
	                System.out.print("🅿️ "); 
	            }
	        } else {
	            if (i >= 8) {
	                System.out.print("🚙[" + aparcamientos[i] + "] ");
	            } else {
	                System.out.print("🚗[" + aparcamientos[i] + "] ");
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