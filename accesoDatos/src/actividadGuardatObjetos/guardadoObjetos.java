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
		
		System.out.println("¡¡¡Bienvenido a Random Play!!!");
		System.out.println("Añade, borra, consulta o actualiza peliculas");
		System.out.println("");
		
		while(salir != true) {
			
			System.out.println("Escriba una accion");
			System.out.println("- ver");
			System.out.println("- crear");
			System.out.println("- borrar");
			System.out.println("- actualizar");
			System.out.println("- salir");
			seleccion = sc.nextLine();
			
			switch(seleccion.toLowerCase()){
				case "ver":
					ac.ver();
					break;
			
				case "crear":
					System.out.println("Ingrese el nombre de la pelicula (cuidado con las yayusculas y minusculas)");
					seleccion = sc.nextLine();
					ac.crear(seleccion);
					break;
			
				case "borrar":
					ac.borrar();
					break;
					
				case "actualizar":
					ac.actualizar();
					break;
					
				case "salir":
					salir = true;
					System.out.println("¡Ados!");
					break;
			}
		}
	}		
}


