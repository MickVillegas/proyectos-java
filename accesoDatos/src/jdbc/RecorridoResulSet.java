package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class RecorridoResulSet {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.sqlite.JDBC");
		} 
		
		catch (ClassNotFoundException e) {
					e.printStackTrace();
		}
				
		String url = "jdbc:sqlite:/home/tarde/miBaseDeDatos.db";
				
		try {
			
			Connection con = DriverManager.getConnection(url);
					
					Statement st = con.createStatement();
						
			System.out.println("Registros totales " + st.executeQuery("SELECT COUNT(*) FROM Personas;").getInt(1));
					
			System.out.println();
					
			ResultSet rs = st.executeQuery("SELECT * FROM Personas;");
					
			while(rs.next()) {
						
				System.out.println("FILA: " + rs.getRow());
						
				System.out.println();
						
				System.out.println("ID: " + rs.getInt("id_persona"));
				System.out.println("Nombre: " + rs.getString("Nombre"));
				System.out.println("Apellido: " + rs.getString("Apellido"));
				System.out.println("Edad: " + rs.getInt("Edad"));
				System.out.println();
			}
					
		} 
				
		catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		}
	}
}


