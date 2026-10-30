package proyectoProcesos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainProcesos {

	public static void main(String[] args) {
		
        String so = System.getProperty("os.name").toLowerCase();

        if (so.contains("win")) {
        	procesosWindows pp = new procesosWindows();
        	pp.aplicacion();
        }
        else {
        	procesosLinux pl = new procesosLinux();
        	pl.aplicacion();
        }
	}
}
