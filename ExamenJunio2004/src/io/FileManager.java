package io;

import java.util.ArrayList;
import java.util.List;

import logica.Travel;

public class FileManager {
	public String file;

	public FileManager(String file) {
		this.file = file;
	}

	public List<Travel> getTrips() {
		List<Travel> travels = new ArrayList<Travel>();
		for (int i = 0; i < 10; i++) {
			travels.add(new Travel("viaje", "assdaf", i + " dias", 20, 30, i + " Junio"));
		}
		return travels;
	}

}
