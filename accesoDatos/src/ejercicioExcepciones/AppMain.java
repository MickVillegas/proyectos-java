package ejercicioExcepciones;

import java.io.File;

public class AppMain {

    public static void main (String[] args){
    	
    	System.out.println("===============Validacion con Excepciones===============");
    	System.out.println();
    	ValidadorExcepciones v = new ValidadorExcepciones();
    	
    	try {
			v.validarEdad(1);
			v.validarPeso(1);
			v.validarAnio(2014);
			v.validarMes(3);
			v.validarDniNumerico(123456789);
		} catch (MiExcepcion e) {
			System.out.println(e.getMessage());

		}
    	System.out.println();
    	System.out.println("===============Validacion sin Excepciones===============");
    	System.out.println();
    	
    	ValidadorSinExcepciones vs = new ValidadorSinExcepciones();
    	
		vs.validarEdad(0);
		vs.validarPeso(650.5);
		vs.validarAnio(2019);
		vs.validarMes(12);
		vs.validarDniNumerico(5245);
    	
    }
    
}