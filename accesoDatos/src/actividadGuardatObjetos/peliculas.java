package actividadGuardatObjetos;
import java.io.Serializable;

public class peliculas implements Serializable {

	private static final long serialVersionUID = 1L; // Recomendado en Java
	public String nombrePelicula;
	
	public peliculas() {
		
	}
	
	public peliculas(String nomPe) {
		this.nombrePelicula = nomPe;
	}
	
	public void mostrar(){
		System.out.println("Nombre " + nombrePelicula);
	}
	
	public String getGuardarNombres() {
		return this.nombrePelicula;
	}
	
}
