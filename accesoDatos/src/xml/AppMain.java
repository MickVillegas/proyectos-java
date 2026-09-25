package xml;

import java.io.File;

public class AppMain {

	public static void main(String[] args) {
		
		OperacionesTarantulasXml ot = new OperacionesTarantulasXml();
		//File f = new File("/home/cibertard/Escritorio/tarantulas.xml");
		File f = new File("C:\\Users\\godzi\\Desktop\\tarantulas.xml");
		
		if(f.exists()) {
			ot.leerXml();
		}
		
		else {
			ot.crearXmlTarantulas();
			ot.leerXml();
		}
	}
}
