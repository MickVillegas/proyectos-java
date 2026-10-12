package trma1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class procesosLinux {

    ProcessBuilder pb = new ProcessBuilder();
    
    public void carpetaPorDefecto() {
        File directorio = new File("/home/tarde/Escritorio/Mistxt");

        if (!directorio.exists()) {
            pb.command("mkdir", "-p", "/home/tarde/Escritorio/Mistxt");
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
        pb.command("ls", "-la");
        
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
        
        pb.directory(new File(pb.directory().getAbsolutePath() + "/" + directorio));
        
        // NOTA: Java no puede ejecutar el comando 'cd' como un proceso independiente 
        // porque 'cd' es un comando interno de la Shell y no un ejecutable del sistema.
        // La navegación se gestiona cambiando el directorio con pb.directory(...).
        System.out.println("Has entrado en " + directorio);
    }
    
    public void volverAtras() {
        File directorioActual = pb.directory();
        if (directorioActual != null) {
            pb.directory(new File(directorioActual, ".."));
        }
    }
    
    public void crearCarpeta(String nombreCarpeta) {
        pb.command("mkdir", "-p", pb.directory().getAbsolutePath() + "/" + nombreCarpeta);
        try {
            Process p = pb.start();
            System.out.println("Carpeta " + nombreCarpeta + " creada con éxito");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Hubo un problema al crear la carpeta");
        }
    }
    
    public void crearArchivoTxT(String nombreArchivo) {
        pb.command("touch", pb.directory().getAbsolutePath() + "/" + nombreArchivo + ".txt");
        try {
            Process p = pb.start();
            System.out.println("Archivo " + nombreArchivo + " creado con éxito");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Hubo un problema al crear el archivo");
        }
    }
    
    public void escribirEnTXT(String NombreTXT, String texto) {
        pb.command("sh", "-c", "echo " + texto + " >> " + pb.directory().getAbsolutePath() + "/" + NombreTXT + ".txt");
        try {
            Process p = pb.start();
            System.out.println("Texto añadido con éxito");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Hubo un problema al añadir texto");
        }
    }
    
    public void borrarArchivo(String nombreArchivo) {
        pb.command("rm", pb.directory().getAbsolutePath() + "/" + nombreArchivo + ".txt");
        try {
            Process p = pb.start();
            System.out.println("Archivo " + nombreArchivo + " borrado con éxito");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Hubo un problema al borrar el archivo");
        }
    }
    
    public void borrarCarpeta(String nombreCarpeta) {
        pb.command("rm", "-rf", pb.directory().getAbsolutePath() + "/" + nombreCarpeta);
        try {
            Process p = pb.start();
            System.out.println("Carpeta " + nombreCarpeta + " borrada con éxito");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Hubo un problema al borrar la carpeta");
        }
    }
    
    public void abrirEdge() {
        // En Linux, para abrir una URL o app por defecto o navegadores instalados
        pb.command("microsoft-edge"); 
        try {
            pb.start();
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
            System.out.println(" 8. Borrar archivo");
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