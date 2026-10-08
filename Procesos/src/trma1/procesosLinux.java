package trma1;

import java.io.File;
import java.io.IOException;

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
}