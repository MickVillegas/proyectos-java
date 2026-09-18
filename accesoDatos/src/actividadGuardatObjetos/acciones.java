package actividadGuardatObjetos;
import java.io.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class acciones {

	String nombreP = "";
	ArrayList<String> nombresPeliculas = new ArrayList<String>(); 
	
	File f;
	FileOutputStream fo ;
	ObjectOutputStream oos;
	FileInputStream fi;
	ObjectInputStream ois;
	
	public void guardarEnArray() {
		
		try{
			
			f = new File("C:\\Users\\godzi\\Desktop\\peliculas.txt");
			
			if (f.exists()){
				
				fi = new FileInputStream(f);
				ois = new ObjectInputStream(fi);
				peliculas p = null;
		
				while (fi.available() > 0){
					p = (peliculas)ois.readObject();
					nombresPeliculas.add(p.getGuardarNombres());
				}
			}
		}
		
		catch (IOException e) { 
			e.printStackTrace(); 
		}
		
		catch (ClassNotFoundException cnf) { 
			cnf.printStackTrace(); 
		}
	}
	
	
	public void ver() {
		
		try{
			
			f = new File("C:\\Users\\godzi\\Desktop\\peliculas.txt");
			
			if (f.exists()){
				
				fi = new FileInputStream(f);
				ois = new ObjectInputStream(fi);
				peliculas p = null;
		
				while (fi.available() > 0){
					p = (peliculas)ois.readObject();
					nombreP += p.getGuardarNombres();
					nombreP += "\n";
					
				}
			}
			
			System.out.println("Peliculas guardadas");
			System.out.println("");
			System.out.println(nombreP);
			nombreP = "";
				
		}
		
		catch (IOException e) { 
			e.printStackTrace(); 
		}
		
		catch (ClassNotFoundException cnf) { 
			cnf.printStackTrace(); 
		}
	}
	
	
	public void crear(String x) {
		
		try {
			fo = new FileOutputStream("C:\\Users\\godzi\\Desktop\\peliculas.txt");
			oos = new ObjectOutputStream(fo);
		
			nombresPeliculas.add(x);
			
			for(int i = 0; i < nombresPeliculas.size(); i++) {
				peliculas p = new peliculas(nombresPeliculas.get(i)); 
				oos.writeObject(p);
			}
		
			if (oos != null){
				oos.close();
				fo.close();
			}
		}
		
		catch (IOException e) { 
			e.printStackTrace(); 
		}
	}

	
	public void borrar(String x) {
		
		nombresPeliculas.remove(nombresPeliculas.indexOf(x));
	
		try {
			fo = new FileOutputStream("C:\\Users\\godzi\\Desktop\\peliculas.txt");
			oos = new ObjectOutputStream(fo);
		
			for(int i = 0; i < nombresPeliculas.size(); i++) {
				peliculas p = new peliculas(nombresPeliculas.get(i)); 
				oos.writeObject(p);
			}
		
			if (oos != null){
				oos.close();
				fo.close();
			}
		}
		
		catch (IOException e) { 
			e.printStackTrace(); 
		}
	}
	
	
	public void actualizar(String x, String y) {
		
		nombresPeliculas.set(nombresPeliculas.indexOf(x), y);
		
		try {
			fo = new FileOutputStream("C:\\Users\\godzi\\Desktop\\peliculas.txt");
			oos = new ObjectOutputStream(fo);
			for(int i = 0; i < nombresPeliculas.size(); i++) {
				peliculas p = new peliculas(nombresPeliculas.get(i)); 
				oos.writeObject(p);
			}
		
			if (oos != null){
				oos.close();
				fo.close();
			}
		}
		
		catch (IOException e) { 
			e.printStackTrace(); 
		}
	}
		
			
}

