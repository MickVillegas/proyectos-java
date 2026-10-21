package PrePro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparadoProcedimientos {

	
	public static void consulta(Connection x) {
		
		try {
			
			String consula = "SELECT * FROM Personas WHERE id_persona = ? ";
			
			PreparedStatement ps = x.prepareStatement(consula);
			ps.setString(1, "2");
			ResultSet rs = ps.executeQuery(); 
			
			System.out.println(rs.getInt("id_persona"));
			System.out.println(rs.getString("nombre"));
			System.out.println(rs.getString("apellido"));
			System.out.println(rs.getInt("edad"));
			
		}
		catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		}
		
	}
	
	public static void actualizar(Connection x) {
		
		try {
			
			String actualizar = "UPDATE Personas SET apellido = 'Megatron' WHERE id_persona = ? ";
			
			PreparedStatement ps2 = x.prepareStatement(actualizar);
			ps2.setString(1, "2");
			ps2.executeUpdate(); 
			System.out.println("Actualización realizada");
		}
		catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		}
		
	}
	
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
			
			consulta(con);
			System.out.println();
			actualizar(con);
			System.out.println();
			consulta(con);
			
		}
		catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		}

	}

}
