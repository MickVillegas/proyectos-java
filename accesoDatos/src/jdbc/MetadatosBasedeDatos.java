package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetadatosBasedeDatos {

	public static void main(String[] args) {
		// visualizar datos genéricos de la BD, del driver, tablas, llaves primarias y columnas.
		
		try {
			Class.forName("org.sqlite.JDBC");
		} 
		
		catch (ClassNotFoundException e) {
					e.printStackTrace();
		}
				
		String url = "jdbc:sqlite:/home/tarde/miBaseDeDatos.db";
				
		try {
			
			Connection con = DriverManager.getConnection(url);
			
			DatabaseMetaData databaseMetaData = con.getMetaData();
			
			System.out.println("Nombre del producto " + databaseMetaData.getDatabaseProductName());
			System.out.println("Version del lproducto " + databaseMetaData.getDatabaseProductVersion());
			System.out.println();
			System.out.println("Ultima version del driver" + databaseMetaData.getDriverMajorVersion());
			System.out.println("Primera version del driver" + databaseMetaData.getDriverMinorVersion());
			System.out.println();
			
			String   catalog          = null;
			String   schemaPattern    = null;
			String   tableNamePattern = null;
			String[] types            = null;
			String schema = null;
			String tableName = null;
			String   columnNamePattern = null;

			ResultSet result = databaseMetaData.getTables(
			    catalog, schemaPattern, tableNamePattern, types );

			while(result.next()) {
			    tableName = result.getString(3);
			    System.out.println("Nombre de la tabla: " + tableName);
			}
			System.out.println();
			
			ResultSet result2 = databaseMetaData.getPrimaryKeys(
				    catalog, schema, tableName);
			
			while(result2.next()){
			    String columnName = result2.getString(4);
			    System.out.println("Clave primaria " + columnName);
			}
			
			System.out.println();
			
			ResultSet result3 = databaseMetaData.getColumns(
				    catalog, schemaPattern,  tableNamePattern, columnNamePattern);

				while(result3.next()){
				    String columnName = result3.getString(4);
				    int    columnType = result3.getInt(5);
				    
				    System.out.println("Nombre columna " + columnName);
				    System.out.println("TIpo de dato " + columnType);
				}

			
		}
		catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		}

	}

}
