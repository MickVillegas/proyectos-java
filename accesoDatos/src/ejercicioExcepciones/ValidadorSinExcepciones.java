package ejercicioExcepciones;

public class ValidadorSinExcepciones {
	public static void validarEdad(int edad){
        if (edad > 0 && edad < 120) {
        	System.out.println("Edad correcta " + edad);
        }
        else {
        	System.out.println("Edad " + edad + " fuera de rango");
        }
    }
	
	public static void validarPeso(double peso){
        if (peso > 0 && peso <300.0) {
        	System.out.println("Peso válido " + peso + " kg");
        } 
        else {
        	System.out.println("Peso " + peso + "Kg no valido");
        }
    }
	
	public static void validarAnio(int anio){
        if (anio > 1900 && anio < 2027) { 
            System.out.println("Año " + anio + " está dentro del rango");
        } 
        else {
        	System.out.println("Año " + anio + " fuera del rango (1900-2026)");
        }
    }
	
	public static void validarMes(int mes){
        if (mes > 1 && mes < 13) {
            System.out.println("Mes " + mes + " correcto");
        } 
        else {
        	System.out.println("El mes " + mes + " no existe (debe ser 1-12)");
        }
    }
	
	public static void validarDniNumerico(int dni){
        if (dni > 9999999 && dni < 100000000) {
        	System.out.println("DNI numérico válido " + dni);
        } 
        else {
        	System.out.println("DNI numérico erroneo " + dni);
        }
    }
}
