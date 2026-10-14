package trma1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class probandoProcesos {

	ProcessBuilder pb = new ProcessBuilder();
	
	public void carpetaPorDefecto() {
		File directorio = new File("C:\\Users\\godzi\\Desktop\\Mistxt");

	    if (!directorio.exists()) {
	        pb.command("cmd.exe", "/c", "mkdir", "C:\\Users\\godzi\\Desktop\\Mistxt");
	        try {
	            Process p = pb.start();
	            p.waitFor();
	        } catch (IOException | InterruptedException e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("La carpeta ya existe. Se omitió la creación.");
	    }
	    pb.directory(directorio);
	}
	
	public void verPosicionActual() {
		pb.command("cmd.exe", "/c", "dir");
		
		try {
			pb.inheritIO();
        	Process process = pb.start();
        	process.waitFor();
		}
		catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	public void entrarEn(String directorio) {
		
		pb.directory(new File(pb.directory().getAbsolutePath() + "\\" + directorio));
		
		try {
			Process p = pb.start();
			System.out.println("Has entrado en " + directorio);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No se pudo entrar en " + directorio);
		}
	}
	
	public void volverAtras() {
	    File directorioActual = pb.directory();
	    if (directorioActual != null) {
	        pb.directory(new File(directorioActual, ".."));
	    }
	}
	
	public void crearCarpeta(String nombreCarpeta) {
		
		pb.command("cmd.exe", "/c", "mkdir " + pb.directory().getAbsolutePath() + "\\" + nombreCarpeta);
		try {
			Process p = pb.start();
			System.out.println("Carpeta " + nombreCarpeta + " creada con éxito");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Hubo un problema al crear la carpeta");
		}
	}
	
	public void crearArchivoTxT(String nombreArchivo) {
		pb.command("cmd.exe", "/c", "type nul > " + pb.directory().getAbsolutePath() + "\\" +nombreArchivo + ".txt\r\n");
		try {
			Process p = pb.start();
			System.out.println("Archivo " + nombreArchivo + " creado con éxito");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Hubo un problema al crear el archivo");
		}
	}
	
	public void escribirEnTXT(String NombreTXT,String texto) {
		pb.command("cmd.exe", "/c", "echo " + texto + " >> " + pb.directory().getAbsolutePath() + "\\" + NombreTXT + ".txt");
		try {
			Process p = pb.start();
			System.out.println("Texto añadido con éxito");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Hubo un problema al añadir texto");
		}
	}
	
	public void borrarArchivo(String nombreArchivo) {
		pb.command("cmd.exe", "/c", "del " + pb.directory().getAbsolutePath() + "\\" + nombreArchivo + ".txt");
		try {
			Process p = pb.start();
			System.out.println("Archivo " + nombreArchivo + " borrado con éxito");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Hubo un problema al borrar el archivo");
		}
	}
	
	public void borrarCarpeta(String nombreCarpeta) {
		pb.command("cmd.exe", "/c", "rmdir /s /q " + pb.directory().getAbsolutePath() + "\\" + nombreCarpeta);
		try {
			Process p = pb.start();
			System.out.println("Carpeta " + nombreCarpeta + " borrado con éxito");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Hubo un problema al borrar la carpeta");
		}
		
	}
	
	public void leerTXT(String nombreTXT) {
		pb.command("cmd.exe", "/c", "type " + pb.directory().getAbsolutePath() + "\\" + nombreTXT + ".txt");
		
		try {
			Process p = pb.start();
			
			Scanner sr = new Scanner(p.getInputStream());
			
			while(sr.hasNextLine()) {
				System.out.println(sr.nextLine());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void aplicacion() {
		boolean salir = false;
		int elegirOpcion;
		String nombre;
		
		Scanner sc = new Scanner(System.in);
		
		carpetaPorDefecto();
		
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
            System.out.println(" 8. Leer archivo");
            System.out.println(" 9. Borrar archivo");
            System.out.println("------------------------------------------");
            System.out.println(" 0. Salir");
            System.out.println("==========================================");
            System.out.print("Selecciona una opción: ");
			
            System.out.println();
            
			elegirOpcion = sc.nextInt();
			
			switch(elegirOpcion) {
			
			case 1:
                verPosicionActual();
                break;

            case 2:
            	sc.nextLine();
                verPosicionActual();
                System.out.print("¿En qué carpeta quieres entrar?: ");
                String elegir = sc.nextLine();
                entrarEn(elegir);
                break;

            case 3:
                volverAtras();
                break;

            case 4:
            	sc.nextLine();
                System.out.print("Nombre de la carpeta a crear: ");
                nombre = sc.nextLine();
                crearCarpeta(nombre);
                break;

            case 5:
            	sc.nextLine();
                System.out.print("Nombre de la carpeta a borrar: ");
                nombre = sc.nextLine();
                borrarCarpeta(nombre);
                break;

            case 6:
            	sc.nextLine();
                System.out.print("Nombre del archivo a crear (sin .txt): ");
                nombre = sc.nextLine();
                crearArchivoTxT(nombre);
                break;

            case 7:
            	sc.nextLine();
                System.out.print("Nombre del archivo a editar: ");
                nombre = sc.nextLine();
                System.out.print("Escribe el contenido que deseas guardar: ");
                String escribe = sc.nextLine();
                escribirEnTXT(nombre, escribe);
                break;
                
            case 8:
            	sc.nextLine();
                System.out.print("Nombre del archivo que quiere leer: ");
                nombre = sc.nextLine();
                System.out.println("Contenido de " + nombre + ".txt");
                leerTXT(nombre);
                break;
                
            case 9:
            	sc.nextLine();
                System.out.print("Nombre del archivo a borrar: ");
                nombre = sc.nextLine();
                borrarArchivo(nombre);
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
