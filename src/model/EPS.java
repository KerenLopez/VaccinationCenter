package model;

public class EPS extends Patient{

	//Atributes
	private String nameEPS;
	private String numServiceOrder;

	public EPS(String name, String lastName, int age, String id, String nameEPS, String numServiceOrder){
		super(name,lastName,age,id);
		this.nameEPS = nameEPS;
		this.numServiceOrder = numServiceOrder;
	}

	//Getters & Setters

	public String getNameEPS(){
		return nameEPS;
	}

	public void setNameEPS(String nameEPS){
		this.nameEPS = nameEPS;
	}

	public String getNumServiceOrder(){
		return numServiceOrder;
	}

	public void setNumServiceOrder(String numServiceOrder){
		this.numServiceOrder = numServiceOrder;
	}

	public String toString(){
		return super.toString()+"\nTipo de paciente: EPS"+"\nNombre de la EPS: "+nameEPS+"\nOrden de servicio # "+numServiceOrder;
	}
}