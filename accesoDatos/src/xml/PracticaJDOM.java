package xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class PracticaJDOM {

	public static void main(String[] args) {
		
		File f = new File ("C:\\Users\\godzi\\Desktop\\tiburones.xml");
		
		try {
			
	         SAXBuilder saxBuilder = new SAXBuilder();
	         Document document = saxBuilder.build(f);
	         Element raiz = document.getRootElement();
	         
	         List<Element> listaTiburones = raiz.getChildren();
	         
	         System.out.println("-------------LISTA DE TIBURONES-------------");
	         System.out.println();
	         
	         for (int i = 0; i < listaTiburones.size(); i++) {
	        	 
	        	 Element tiburon = listaTiburones.get(i);
	        	 
	        	 System.out.println("- Nombre: " + tiburon.getChild("nombre").getText());
	        	 System.out.println("- Tipo: " + tiburon.getChild("tipo").getText());
	        	 System.out.println("- Número de dientes: " + tiburon.getChild("numerodedientes").getText());
	        	 System.out.println("- Distribución marina: " + tiburon.getChild("distribucion_maritima").getText());
	        	 System.out.println();
	        	 System.out.println("----------------------------------------------------------");
	        	 System.out.println();
	        	 
	         }
		} 
		
		catch(JDOMException e) {
	          e.printStackTrace();
		}
		
		catch(IOException ioe) {
	          ioe.printStackTrace();
		}
	}
}
