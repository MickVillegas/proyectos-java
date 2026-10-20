package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetadatosREsultset {

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
					
			ResultSet rs = st.executeQuery("SELECT * FROM Personas;");
					
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("Número de columnas totales " + rsmd.getColumnCount());
			System.out.println();
			
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				
				System.out.println("Nombre de columna " + i + " " + rsmd.getColumnName(i));
				System.out.println("Tipo de dato " + rsmd.getColumnTypeName(i));
				System.out.println();
				
			}

			
			
			
			String col1 = rsmd.getColumnName(1);
			String col2 = rsmd.getColumnName(2);
			
			Statement st2 = con.createStatement();
			
			ResultSet rs2 = st2.executeQuery("SELECT " + col1 + " FROM Personas;");
			

			
			System.out.println("Cosulta a " + col1);
			
			while(rs2.next()) {
			
				System.out.println(rs2.getInt(col1));
				
			}
					
			System.out.println();
			
			ResultSet rs3 = st2.executeQuery("SELECT " + col2 + " FROM Personas;");
			
			System.out.println("Cosulta a " + col2);
			
			while(rs3.next()) {
			
				System.out.println(rs3.getString(col2));
				
			}
		
		} 
		
		catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		}

	}

}
