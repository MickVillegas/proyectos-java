package trma1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainProcesos {

	public static void main(String[] args) {
		
		boolean salir = false;
		int elegirOpcion;
		String nombre;
		
		Scanner sc = new Scanner(System.in);
		probandoProcesos pp = new probandoProcesos();
		
		pp.carpetaPorDefecto();
		
		while(salir != true) {
			
			System.out.println("\n==========================================");
            System.out.println("            GESTIÓN DE ARCHIVOS           ");
            System.out.println("==========================================");
            System.out.println(" 1. Ver posición actual (Listar contenido)");
            System.out.println(" 2. Entrar en una carpeta");
            System.out.println(" 3. Volver a la carpeta anterior (cd ..)");
            System.out.println("------------------------------------------");
            System.out.println(" 4. Crear carpeta");
            System.out.println(" 5. Borrar carpeta");
            System.out.println("------------------------------------------");
            System.out.println(" 6. Crear archivo .txt");
            System.out.println(" 7. Editar/Escribir en archivo .txt");
            System.out.println(" 8. Borrar archivo");
            System.out.println("------------------------------------------");
            System.out.println(" 0. Salir");
            System.out.println("==========================================");
            System.out.print("Selecciona una opción: ");
			
            System.out.println();
            
			elegirOpcion = sc.nextInt();
			
			switch(elegirOpcion) {
			
			case 1:
                pp.verPosicionActual();
                break;

            case 2:
            	sc.nextLine();
                pp.verPosicionActual();
                System.out.print("¿En qué carpeta quieres entrar?: ");
                String elegir = sc.nextLine();
                pp.entrarEn(elegir);
                break;

            case 3:
                pp.volverAtras();
                break;

            case 4:
            	sc.nextLine();
                System.out.print("Nombre de la carpeta a crear: ");
                nombre = sc.nextLine();
                pp.crearCarpeta(nombre);
                break;

            case 5:
            	sc.nextLine();
                System.out.print("Nombre de la carpeta a borrar: ");
                nombre = sc.nextLine();
                pp.borrarCarpeta(nombre);
                break;

            case 6:
            	sc.nextLine();
                System.out.print("Nombre del archivo a crear (sin .txt): ");
                nombre = sc.nextLine();
                pp.crearArchivoTxT(nombre);
                break;

            case 7:
            	sc.nextLine();
                System.out.print("Nombre del archivo a editar: ");
                nombre = sc.nextLine();
                System.out.print("Escribe el contenido que deseas guardar: ");
                String escribe = sc.nextLine();
                pp.escribirEnTXT(nombre, escribe);
                break;

            case 8:
            	sc.nextLine();
                System.out.print("Nombre del archivo a borrar: ");
                nombre = sc.nextLine();
                pp.borrarArchivo(nombre);
                break;

            case 0:
                salir = true;
                System.out.println("¡Programa finalizado con éxito!");
                break;

            default:
                System.out.println(" pción no reconocida. Elige un número del 0 al 8.");
                break;
			}
			
		}
	}

}
