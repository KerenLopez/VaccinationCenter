package model;

public class Particular extends Patient{

	//Atributes
	private String phoneNumber;
	private String doctorName;
	private String doctorPhoneNumber;
	private String doctorNumLicence; 

	public Particular(String name, String lastName, int age, String id, String phoneNumber, String doctorName, String doctorPhoneNumber, String doctorNumLicence){
		super(name,lastName,age,id);
		this.phoneNumber = phoneNumber;
		this.doctorName = doctorName;
		this.doctorPhoneNumber = doctorPhoneNumber;
		this.doctorNumLicence = doctorNumLicence;
	}

	//Getters & Setters

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getDoctorName(){
		return doctorName;
	}

	public void setDoctorName(String doctorName){
		this.doctorName = doctorName;
	}

	public String getDoctorPhoneNumber(){
		return doctorPhoneNumber;
	}

	public void setDoctorPhoneNumber(String doctorPhoneNumber){
		doctorPhoneNumber = doctorPhoneNumber;
	}

	public String getDoctorNumLicence(){
		return doctorNumLicence;
	}

	public void setDoctorNumLicence(String doctorNumLicence){
		this.doctorNumLicence = doctorNumLicence;
	} 

	//Methods

	public String toString(){
		return super.toString()+"\nTipo de paciente: Particular"+"\nTelefono del paciente: "+phoneNumber+"\nDoctor: "+doctorName+"\nNumero de licencia: "+doctorNumLicence+"\nTelefono del doctor: "+doctorPhoneNumber;
	}
}