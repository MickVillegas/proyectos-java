package trma1;

import java.io.File;
import java.io.IOException;

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
		
		pb.directory(new File("C:\\Users\\godzi\\Desktop\\Mistxt\\" + directorio));
		
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
	
	public void abrirEdge() {

		pb.command("cmd.exe", "/c", "start msedge");
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
