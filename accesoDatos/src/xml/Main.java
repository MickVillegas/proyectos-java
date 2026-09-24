package xml;

import java.io.File;

// Importaciones correctas de W3C para DOM XML
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Importaciones del parser
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Main {

	public static void main(String[] args) {
		
		
		File f = new File("C:\\Users\\godzi\\Desktop\\personas.xml");
		
		try {
			
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  Document doc = dBuilder.parse(f);
			  
			  doc.getDocumentElement().normalize();
			  
			  NodeList listaPersonas = doc.getElementsByTagName("persona");
			  
			  for (int i = 0; i < listaPersonas.getLength(); i++) {
				
				  Node nodo = listaPersonas.item(i);
				  Element el = (Element) nodo;
				  
				  System.out.println(el.getElementsByTagName("nombre").item(0).getTextContent());
				  System.out.println(el.getElementsByTagName("edad").item(0).getTextContent());
				  
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}	
		
		
		
		try {
			
			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			  Document document = dBuilder.newDocument();
			  
			  Element raiz = document.createElement("mascotas");
			  document.appendChild(raiz);
			  
			  Element mascota = document.createElement("mascota");
			  raiz.appendChild(mascota);
			  
			  Element raza = document.createElement("raza");
			  raza.appendChild(document.createTextNode("Canina"));
			  
			  Element nombre = document.createElement("nombre");
			  nombre.appendChild(document.createTextNode("Salchicha"));
			  
			  mascota.appendChild(raza);
			  mascota.appendChild(nombre);
			  
			  Element mascota2 = document.createElement("mascota");
			  raiz.appendChild(mascota2);
			  
			  Element raza2 = document.createElement("raza");
			  raza2.appendChild(document.createTextNode("Felina"));
			  
			  Element nombre2 = document.createElement("nombre");
			  nombre2.appendChild(document.createTextNode("Atun"));
			  
			  mascota2.appendChild(raza2);
			  mascota2.appendChild(nombre2);
			  
			  TransformerFactory transformerFactory = TransformerFactory.newInstance();
			  Transformer transformer = transformerFactory.newTransformer();
			  DOMSource source = new DOMSource(document);
			  StreamResult result = new StreamResult(new File("C:\\Users\\godzi\\Desktop\\mascotas.xml"));
			  
			  transformer.transform(source, result);
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		
		

	}
}