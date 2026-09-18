package actividadGuardatObjetos;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class guardadoObjetos {

	public static void main(String[] args) {
		
		String seleccion = ""; 
		Scanner sc = new Scanner(System.in);
		acciones ac = new acciones();
		boolean salir = false;
		
		ac.guardarEnArray();
		
		while(salir != true) {
			System.out.println("Escriba una accion");
			System.out.println("- ver");
			System.out.println("- crear");
			System.out.println("- borrar");
			System.out.println("- actualizar");
			System.out.println("- salir");
			seleccion = sc.nextLine();
			
			switch(seleccion){
				case "ver":
					ac.ver();
					break;
			
				case "crear":
					System.out.println("Ingrese el nombre de la pelicula");
					seleccion = sc.nextLine();
					ac.crear(seleccion);
					break;
			
				case "borrar":
					System.out.println("Ingrese el nombre de la pelicula que quiera borrar");
					seleccion = sc.nextLine();
					ac.borrar(seleccion);
					break;
					
				case "actualizar":
					System.out.println("Ingrese el nombre de la pelicula que quiera actualizar");
					String busca = sc.nextLine();
					System.out.println("Ingrese el nombre nuevo");
					seleccion = sc.nextLine();
					ac.actualizar(busca, seleccion);
					break;
					
				case "salir":
					salir = true;
					System.out.println("¡Ados!");
					break;
			}
		}
	}		
}


