package model;

public class SURA extends PrepaidMedicine{

	//Atributes 
	private int minimumValuePolicy;
	private int maximumValuePolicy;

	public SURA(String name, String lastName, int age, String id, String numMembership, int minimumValuePolicy, int maximumValuePolicy){
		super(name,lastName,age,id,numMembership);
		this.minimumValuePolicy = minimumValuePolicy;
		this.maximumValuePolicy = maximumValuePolicy;
	}

	//Getters & Setters

	public int getMinimumValuePolicy(){
		return minimumValuePolicy;
	}

	public void setPhoneNumber(int minimumValuePolicy){
		this.minimumValuePolicy = minimumValuePolicy;
	}

	public int getMaximumValuePolicy(){
		return maximumValuePolicy;
	}

	public void setMaximumValuePolicy(int maximumValuePolicy){
		this.maximumValuePolicy = maximumValuePolicy;
	}

	public String toString(){
		return super.toString()+"\nNombre de la entidad prestadora del servicio de salud: SURA"+"\nValor minimo de cubrimiento que tiene la poliza del paciente: "+minimumValuePolicy+"\nValor maximo de cubrimiento que tiene la poliza del paciente: "+maximumValuePolicy;
	}
}