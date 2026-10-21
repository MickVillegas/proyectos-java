package hilos;

public class Main extends Thread{

	private String nombre;
    private int tiempoAlimentacion;

    public Main (String nombre, int tiempoAlimentacion) {
        super();
        this.nombre = nombre;
        this.tiempoAlimentacion=tiempoAlimentacion;
    }
    
    @Override
    public void run() {
    	
    	try {
            System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre) ;
            Thread.sleep(tiempoAlimentacion*1000);
            System.out.printf ("El ratón %s ha terminado de alimentarse%n",nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    }
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Main fievel = new Main ("Fievel",4) ;
		Main jerry = new Main ( "Jerry", 5);
        Main pinky = new Main ( "Pinky", 3);
        Main mickey = new Main ("Mickey", 6) ;
        
        Crono.start();
        
        fievel.start();
        jerry.start();
        pinky.start();
        mickey.start();
        
        
        fievel.join();
        jerry.join();
        pinky.join();
        mickey.join();
        
        System.out.println(Crono.stop());
		
	}

}
