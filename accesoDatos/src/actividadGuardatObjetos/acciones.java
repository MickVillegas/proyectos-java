package actividadGuardatObjetos;
import java.io.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class acciones {

	String nombreP = "";
	ArrayList<String> nombresPeliculas = new ArrayList<String>(); 
	Scanner sc = new Scanner(System.in);
	
	File f;
	FileOutputStream fo ;
	ObjectOutputStream oos;
	FileInputStream fi;
	ObjectInputStream ois;
	
	public void guardarEnArray() {
		
		try{
			
			f = new File("/home/cibertard/Escritorio/peliculas.txt");
			
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
		
		if(nombresPeliculas.size() == 0) {
			System.out.println("Aun no hay peliculas guardadas");
		}
		else {
		
			try{
			
				f = new File("/home/cibertard/Escritorio/peliculas.txt");
			
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
	}
	
	
	public void crear(String x) {
		
		try {
			fo = new FileOutputStream("/home/cibertard/Escritorio/peliculas.txt");
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
			System.out.println("Pelicula creada con éxito");
		}
		
		catch (IOException e) { 
			System.out.println("Hubo un error a la hora de crear la pelicula");
			e.printStackTrace(); 
		}
	}

	
	public void borrar() {
			
		boolean malEscrito = true;
		
		while(malEscrito == true) {
		
			System.out.println("Ingrese el nombre de la pelicula que quiera borrar (cuidado con las yayusculas y minusculas)");
			String x = sc.nextLine();
			
			if(nombresPeliculas.indexOf(x) == -1) {
				System.out.println("No existe ninguna pelicula con el nombre " + x);
			}
			else {
			
				malEscrito = false;
				nombresPeliculas.remove(nombresPeliculas.indexOf(x));
	
				try {
					fo = new FileOutputStream("/home/cibertard/Escritorio/peliculas.txt");
					oos = new ObjectOutputStream(fo);
		
					for(int i = 0; i < nombresPeliculas.size(); i++) {
						peliculas p = new peliculas(nombresPeliculas.get(i)); 
						oos.writeObject(p);
					}
		
					if (oos != null){
						oos.close();
						fo.close();
					}
					System.out.println("Pelicula borrada con éxito");
				}
		
				catch (IOException e) { 
					System.out.println("Ha habido un problema al intentar borrar la pelicula");
					e.printStackTrace(); 
				}
			}
		}
	}
	
	
	public void actualizar() {
		
		boolean malEscrito = true;
		
		while(malEscrito == true) {
		
			System.out.println("Ingrese el nombre de la pelicula que quiera actualizar (cuidado con las yayusculas y minusculas)");
			String x = sc.nextLine();
		
			if(nombresPeliculas.indexOf(x) == -1) {
				System.out.println("No existe ninguna pelicula con el nombre " + x);
			}
		
			else {
			
				malEscrito = false;
				System.out.println("Ingrese el nombre nuevo");
				String y = sc.nextLine();
			
				nombresPeliculas.set(nombresPeliculas.indexOf(x), y);
		
				try {
					fo = new FileOutputStream("/home/cibertard/Escritorio/peliculas.txt");
					oos = new ObjectOutputStream(fo);
				
					for(int i = 0; i < nombresPeliculas.size(); i++) {
						peliculas p = new peliculas(nombresPeliculas.get(i)); 
						oos.writeObject(p);
					}
		
					if (oos != null){
						oos.close();
						fo.close();
					}
					System.out.println("NOmbre de la pelicula actualizada con éxito");
				}
		
				catch (IOException e) { 
					System.out.println("Hubo un problema a la hora de actualizar el nombre de la pelicula");
					e.printStackTrace(); 
				}
			}
		}
	}	
	
	
	
	
}

