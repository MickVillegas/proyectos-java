package xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PracticaSAX {

	public static void main(String[] args) {
		
		try {
		
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        SAXParser saxParser = factory.newSAXParser();
	        
	        DefaultHandler handler = new DefaultHandler() {
	        
	        	boolean nombreb = false;
	        	boolean tipob = false;
	        	boolean numerodedientesb = false;
	        	boolean distribucion_maritimab = false;
	        	
	        	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	        		
	        		if(qName.equalsIgnoreCase("nombre")) {
	        			nombreb = true;
	        		}
	        		
	        		if(qName.equalsIgnoreCase("tipo")) {
	        			tipob = true;
	        		}
	        		
	        		if(qName.equalsIgnoreCase("numerodedientes")) {
	        			numerodedientesb = true;
	        		}
	        		
	        		if(qName.equalsIgnoreCase("distribucion_maritima")) {
	        			distribucion_maritimab = true;
	        		}
	        	}
                
                public void characters(char ch[], int start, int length) throws SAXException {
                	if(nombreb) {
                		System.out.println("- Nombre: " + new String(ch, start, length));
                		nombreb = false;
                	}
                	
                	if(tipob) {
                		System.out.println("- Tipo: " + new String(ch, start, length));
                		tipob = false;
                	}
                	
                	if(numerodedientesb) {
                		System.out.println("- Número de dientes: " + new String(ch, start, length));
                		numerodedientesb = false;
                	}
                	
                	if(distribucion_maritimab) {
                		System.out.println("- Distribución marina: " + new String(ch, start, length));
                		distribucion_maritimab = false;
                	}
                }
                
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("tiburon")) {
                    	System.out.println();
                        System.out.println("--------------------------------------------------");
                        System.out.println();
                    }
                }
	        };
	        
	        System.out.println("-------------------------Lista de tiburones-------------------------");
	        System.out.println();
	        
            File f = new File("C:\\Users\\godzi\\Desktop\\tiburones.xml");
            InputStream inputStream = new FileInputStream(f);
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");
            saxParser.parse(is, handler);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
