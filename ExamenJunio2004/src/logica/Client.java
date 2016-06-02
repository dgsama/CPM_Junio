package logica;

public class Client {
	private String name;
	private String surname1;
	private String surname2;
	private String DNI;

	public Client(String name, String surname1, String surname2, String dNI) {
		this.name = name;
		this.surname1 = surname1;
		this.surname2 = surname2;
		DNI = dNI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname1() {
		return surname1;
	}

	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	public String getSurname2() {
		return surname2;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

}
