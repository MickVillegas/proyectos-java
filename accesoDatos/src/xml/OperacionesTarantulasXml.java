package xml;

import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.transform.OutputKeys;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class OperacionesTarantulasXml {


	public void crearXmlTarantulas() {
		
		try {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.newDocument();
				  
			String [] nombreComun = {"Tarántula Goliat", "Tarántula Azul de Cobalto", "Tarántula Rodillas Doradas de Chaco", "Tarántula Patas Rosas de Avicularia"};
			String [] nombreCientifico = {"Theraphosa blondi", "Cyriopagopus lividus", "Grammostola pulchripes", "Avicularia avicularia"};
			String [] nivelAgresividad = {"Alta / Defensiva", "Muy alta", "Muy baja / Docil", "Baja"};
			String [] colorPiel = {"Marrón oscuro o castaño uniforme con tonos rojizos en los pelos de sus patas", "Azul cobalto brillante e intenso en las patas y patas traseras, con un cefalotórax gris plateado", "Negro/marrón oscuro con franjas amarillas o doradas muy marcadas en las articulaciones de las patas", "Cuerpo negro verdoso o metálico con la punta de los dedos de las patas en tonos rosa brillante o anaranjado"};
			String [] habitat = {"Bosques y selvas tropicales de alta humedad en América del Sur", "Selvas tropicales de Asia", "Pastizales, pampas y zonas semiáridas de Paraguay, Argentina y Brasil", "Selvas tropicales del norte de Sudamérica y el Caribe"};
				  
			Element raiz = document.createElement("tarantulas");
				  
			document.appendChild(raiz);
				  
			for (int i = 0; i < habitat.length; i++) {
					  
				Element tarantulaElement = document.createElement("tarantula");
					  
				Element nombrecom = document.createElement("NombreComun");
				nombrecom.appendChild(document.createTextNode(nombreComun[i]));
					  
				Element nomCie = document.createElement("NombreCientifico");
				nomCie.appendChild(document.createTextNode(nombreCientifico[i]));
					  
				Element nivAgr = document.createElement("NivelDeAgresividad");
				nivAgr.appendChild(document.createTextNode(nivelAgresividad[i]));
					  
				Element colPi = document.createElement("ColoresDePiel");
				colPi.appendChild(document.createTextNode(colorPiel[i]));
					  
				Element hab = document.createElement("Habitat");
				hab.appendChild(document.createTextNode(habitat[i]));
					  
				tarantulaElement.appendChild(nombrecom);
				tarantulaElement.appendChild(nomCie);
				tarantulaElement.appendChild(nivAgr);
				tarantulaElement.appendChild(colPi);
				tarantulaElement.appendChild(hab);
					  
				raiz.appendChild(tarantulaElement);
					  
			}
				  
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
				  
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
				  
			DOMSource source = new DOMSource(document);
			//StreamResult result = new StreamResult(new File("/home/cibertard/Escritorio/tarantulas.xml"));
			StreamResult result = new StreamResult(new File("C:\\Users\\godzi\\Desktop\\tarantulas.xml"));

			transformer.transform(source, result);
				  
		} 
		
		catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	
	public void leerXml() {
					
		//File f = new File("/home/cibertard/Escritorio/tarantulas.xml");
		File f = new File("C:\\Users\\godzi\\Desktop\\tarantulas.xml");
			
		try {
				
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(f);
				  
			doc.getDocumentElement().normalize();
			NodeList listaTarantulas = doc.getElementsByTagName("tarantula");
			  	  
			System.out.println("==========LISTA DE TARÁNTULAS==========");
			System.out.println();
			  	  
			for (int j = 0; j < listaTarantulas.getLength(); j++) {
				
				Node nodo = listaTarantulas.item(j);
				Element el = (Element) nodo;
					
				System.out.println("- Nombre común: " + el.getElementsByTagName("NombreComun").item(0).getTextContent());
				System.out.println("- Nombre científico: " + el.getElementsByTagName("NombreCientifico").item(0).getTextContent());
				System.out.println("- Nivel de agresividad: " + el.getElementsByTagName("NivelDeAgresividad").item(0).getTextContent());
				System.out.println("- Colores de la piel: " + el.getElementsByTagName("ColoresDePiel").item(0).getTextContent());
				System.out.println("- Hábitat: " + el.getElementsByTagName("Habitat").item(0).getTextContent());
				System.out.println();
				
			}	  
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

