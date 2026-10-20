package jdbc;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionSqlite {

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
			
			st.executeUpdate("INSERT INTO Personas (Nombre, Apellido, Edad) VALUES "
							+ "('Sonic', 'El Erizo', 15), "
							+ "('Tails', 'El Zorro', 8), "
							+ "('Knuckles', 'El Equidna', 16), "
							+ "('Amy', 'Rose', 12);");
							
					
			ResultSet rs = st.executeQuery("SELECT * FROM Personas;");
			
			while(rs.next()) {
				
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
