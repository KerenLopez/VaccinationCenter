package model;

public class Other extends PrepaidMedicine{

	//Atributes 
	private String nameEntity;
	private String phoneNumConfirm;

	public Other(String name, String lastName, int age, String id, String numMembership, String nameEntity, String phoneNumConfirm){
		super(name,lastName,age,id,numMembership);
		this.nameEntity = nameEntity;
		this.phoneNumConfirm = phoneNumConfirm;
	}

	//Getters & Setters

	public String getNameEntity(){
		return nameEntity;
	}

	public void setNameEntity(String nameEntity){
		this.nameEntity = nameEntity;
	}

	public String getPhoneNumConfirm(){
		return phoneNumConfirm;
	}

	public void setPhoneNumConfirm(String phoneNumConfirm){
		this.phoneNumConfirm = phoneNumConfirm;
	}

	public String toString(){
		return super.toString()+"\nNombre de la entidad prestadora del servicio de salud: "+nameEntity+"\nNumero telefonico donde se puede confirmar el servicio: "+phoneNumConfirm;
	}
}