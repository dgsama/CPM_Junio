package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import logica.Travel;

public class FileManager {
	public String file;

	public FileManager(String file) {
		this.file = file;
	}

	public String getFile() {
		return file;
	}

	public List<Travel> getTrips() {
		List<Travel> travels = new ArrayList<Travel>();
		String nombreFichero = getFile();
		String line = "";
		try {
			BufferedReader f = new BufferedReader(new FileReader(nombreFichero));

			while (f.ready()) {
				line = f.readLine();
				String[] l = line.split("@");
				Travel aux = new Travel(l[0], l[1], l[2], Float.parseFloat(l[3]), Float.parseFloat(l[4]), l[5]);
				travels.add(aux);

			}
			f.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
		return travels;
	}

}
