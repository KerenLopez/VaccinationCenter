package model;

public abstract class PrepaidMedicine extends Patient{

	//Atributes
	private String numMembership;

	public PrepaidMedicine(String name, String lastName, int age, String id, String numMembership){
		super(name,lastName,age,id);
		this.numMembership = numMembership;
	}

	//Getters & Setters

	public String getNumMembership(){
		return numMembership;
	}

	public void setNumMembership(String numMembership){
		this.numMembership = numMembership;
	}
	public String toString(){
		return super.toString()+"\nTipo de paciente: medicina prepagada"+"\nNumero de afiliacion: "+numMembership;
	}
}