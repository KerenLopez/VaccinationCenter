package model;

public class Coomeva extends PrepaidMedicine{

	//Atributes 
	private Category patientCategory;

	public Coomeva(String name, String lastName, int age, String id, String numMembership, int patientCategory){
		super(name,lastName,age,id,numMembership);
		switch(patientCategory){
			case 1:
				this.patientCategory = Category.PLATINO;
				break;
			case 2:
				this.patientCategory = Category.ORO;
				break;
			case 3:
				this.patientCategory = Category.OROPLUS;
				break;	
		}
	}

	//Getters & Setters

	public Category getPatientCategory(){
		return patientCategory;
	}

	public void setPatientCategory(Category patientCategory){
		this.patientCategory = patientCategory;
	}

	public String toString(){
		return super.toString()+"\nNombre de la entidad prestadora del servicio de salud: Coomeva"+"\nCategoria: "+getPatientCategory();
	}

}