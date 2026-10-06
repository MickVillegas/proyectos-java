import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class EjemploXLT {
    public static void main(String[] args) {
        // 1. Definir las rutas de los ficheros de entrada y salida
        File archivoXML = new File("/home/tarde/Escritorio/ejemploXML.xml");
        File archivoXSL = new File("/home/tarde/Escritorio/ejemploXSL.xsl");
        File archivoHTML = new File("/home/tarde/Escritorio/resultado.html");

        try {
            // 2. Crear una instancia de TransformerFactory.
            // Esta fábrica es la encargada de compilar el XSLT y crear el objeto Transformer.
            TransformerFactory fabrica = TransformerFactory.newInstance();

            // 3. Crear una fuente de entrada (StreamSource) con el fichero XSLT
            StreamSource origenXSL = new StreamSource(archivoXSL);

            // 4. Obtener el objeto Transformer especificando la plantilla XSL.
            // El transformer usará las reglas de este XSL para procesar cualquier XML.
            Transformer transformador = fabrica.newTransformer(origenXSL);

            // 5. Encapsular el fichero XML de entrada como origen de datos
            StreamSource origenXML = new StreamSource(archivoXML);

            // 6. Encapsular el fichero HTML de salida como destino del resultado
            StreamResult destinoHTML = new StreamResult(archivoHTML);

            // 7. Ejecutar la transformación
            transformador.transform(origenXML, destinoHTML);

            System.out.println("¡Transformación completada con éxito!");
            System.out.println("Se ha generado el archivo: " + archivoHTML.getAbsolutePath());

        } catch (TransformerException e) {
            // Capturar posibles errores en la sintaxis del XSLT o durante el proceso
            System.err.println("Error durante la transformación XSLT: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
