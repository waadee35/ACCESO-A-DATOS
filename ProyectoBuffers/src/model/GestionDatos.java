package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionDatos {

	public GestionDatos() {}

	//TODO: Implementa una función para abrir ficheros
	
	public static BufferedReader abrirFicheros (String fichero1) throws FileNotFoundException {
		FileReader fr1 = new FileReader(fichero1);
		BufferedReader br1 = new BufferedReader(fr1);
		return br1;
	}
	
	//TODO: Implementa una función para cerrar ficheros
	
	public static void cerrarFicheros (BufferedReader br1) throws IOException {
		br1.close();
	}
	

	
	public boolean compararContenido (String fichero1, String fichero2) throws IOException  {
		
		BufferedReader[] br = new BufferedReader[2];
		br[0] = abrirFicheros(fichero1);				
		br[1] = abrirFicheros(fichero2);
		
		String texto1 = br[0].readLine();				
		String texto2 = br[1].readLine();
		
		while (texto1 != null || texto2 != null) {
			if (!texto1.equals(texto2)) {			
				return false;
			}else {
				texto1 = br[0].readLine();			
				texto2 = br[1].readLine();
			}
		}
		cerrarFicheros(br[0]);		
		
		cerrarFicheros(br[1]);
		
		return true;
		

	
	}
	
	public static int buscarPalabra (String fichero1, String palabra, boolean primera_aparicion) throws IOException{
		//TODO: Implementa la función
		
		BufferedReader[] br = new BufferedReader[1];	
		br[0] = abrirFicheros(fichero1);
		String texto1 = br[0].readLine();
		int linea = 1, lineafinal = -1;
		return -1;
	
		
	
	}	

}
