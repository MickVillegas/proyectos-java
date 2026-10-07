package xml;

import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class EjemploXLT {
    public static void main(String[] args) {

        //File archivoXML = new File("/home/tarde/Escritorio/ejemploXML.xml");
    	//File archivoXSL = new File("/home/tarde/Escritorio/ejemploXSL.xsl");
    	//File archivoHTML = new File("/home/tarde/Escritorio/resultado.html");
        
        File archivoXML = new File("C:\\Users\\godzi\\Desktop\\buhos.xml");
        File archivoXSL = new File("C:\\Users\\godzi\\Desktop\\buhosEstilos.xsl");
        File archivoHTML = new File("C:\\Users\\godzi\\Desktop\\buhos.html");

        try {
            TransformerFactory fabrica = TransformerFactory.newInstance();

            StreamSource origenXSL = new StreamSource(archivoXSL);

            Transformer transformador = fabrica.newTransformer(origenXSL);

            StreamSource origenXML = new StreamSource(archivoXML);
            StreamResult destinoHTML = new StreamResult(archivoHTML);

            transformador.transform(origenXML, destinoHTML);

            System.out.println("¡Transformación completada con éxito!");
            System.out.println("Se ha generado el archivo: " + archivoHTML.getAbsolutePath());

        } 
        catch (TransformerException e) {
            System.err.println("Error durante la transformación XSLT: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
