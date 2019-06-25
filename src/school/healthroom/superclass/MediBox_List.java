package school.healthroom.superclass;

public class MediBox_List {
	private String symptom;
	private String medicine1;
	private String medicine2;
	private String medicine3;
	
	public MediBox_List(String symptom, String medicine1, String medicine2, String medicine3) {
		this.symptom = symptom;
		this.medicine1 = medicine1;
		this.medicine2 = medicine2;
		this.medicine3 = medicine3;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getMedicine1() {
		return medicine1;
	}

	public void setMedicine1(String medicine1) {
		this.medicine1 = medicine1;
	}

	public String getMedicine2() {
		return medicine2;
	}

	public void setMedicine2(String medicine2) {
		this.medicine2 = medicine2;
	}

	public String getMedicine3() {
		return medicine3;
	}

	public void setMedicine3(String medicine3) {
		this.medicine3 = medicine3;
	}
	
}
