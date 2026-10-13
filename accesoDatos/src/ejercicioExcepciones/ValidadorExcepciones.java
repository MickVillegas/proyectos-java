package ejercicioExcepciones;

public class ValidadorExcepciones {

	public static void validarEdad(int edad) throws MiExcepcion{
        if (edad > 0 && edad < 120) {
        	System.out.println("Edad correcta " + edad);
        }
        else {
        	throw new MiExcepcion("Edad " + edad + " fuera de rango");
        }
    }
	
	public static void validarPeso(double peso) throws MiExcepcion{
        if (peso > 0 && peso <300.0) {
        	System.out.println("Peso válido " + peso + " kg");
        } 
        else {
        	throw new MiExcepcion("Peso " + peso + "Kg no valido");
        }
    }
	
	public static void validarAnio(int anio) throws MiExcepcion{
        if (anio > 1900 && anio < 2027) { 
            System.out.println("Año " + anio + " está dentro del rango");
        } 
        else {
        	throw new MiExcepcion("Año " + anio + " fuera del rango (1900-2026)");
        }
    }
	
	public static void validarMes(int mes) throws MiExcepcion{
        if (mes > 1 && mes < 13) {
            System.out.println("Mes " + mes + " correcto");
        } 
        else {
        	throw new MiExcepcion("El mes " + mes + " no existe (debe ser 1-12)");
        }
    }
	
	public static void validarDniNumerico(int dni) throws MiExcepcion{
        if (dni > 9999999 && dni < 100000000) {
        	System.out.println("DNI numérico válido " + dni);
        } 
        else {
        	throw new MiExcepcion("DNI numérico erroneo " + dni);
        }
    }
}
	

