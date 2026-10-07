public class DatosNumericos {

    public void mensajeDatos(){

        try {
    
            throw new MiExcepcion("Chinga tu madre wey");
    
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }

    }
    
}