package i190548_assignment2_exception_handling_A;

public class passengers {
	private int passport_number;
	private String name;
	private String address;
	private int  age;
	private String gender;

	passengers() {
		passport_number = 0;
		name = null;
		address = null;
		age = 0;
		gender = null;
	}

	public int getPassport_number() {
		return passport_number;
	}

	public void setPassport_number(int passport_number) {
		this.passport_number = passport_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String toString() {
		return passport_number + " " + name + " " + address + " " + age + " " + gender;
	}


	
}