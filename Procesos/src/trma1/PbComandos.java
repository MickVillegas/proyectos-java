package trma1;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PbComandos {

	public static void main (String []args) {
		
		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "mkdir", "C:\\Users\\godzi\\Desktop\\Mick");
		
		List comando = pb.command(); 
		
		System.out.println(comando);
		
		pb.command(
	            "cmd.exe", 
	            "/c", 
	            "echo Hola Mick > C:\\Users\\godzi\\Desktop\\Mick\\notas.txt"
	        );
		
		try {
			Process p = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
