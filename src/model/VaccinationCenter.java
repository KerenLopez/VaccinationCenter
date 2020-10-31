package model;

public class VaccinationCenter{

	//Constant
	public final static int NUM_PATIENTS = 300;

	//Relationships
	private Patient[] patients;

	public VaccinationCenter(){
		patients = new Patient[NUM_PATIENTS];
	}

	public Patient findPatient(String id){
		Patient objPatient = null;
		boolean find =false;
		for(int k=0;k<patients.length && !find;k++){
			if(patients[k]!=null && patients[k].getId().equalsIgnoreCase(id)){
				find=true;
				objPatient = patients[k];
			}
		} return objPatient;
	}

	public String addPatient(String name, String lastName, int age, String id, String phoneNumber, String doctorName, String doctorPhoneNum, String numLicence){
		Patient objPatient = findPatient(id);
		String message = "El paciente ha sido agregado exitosamente";
		boolean stop = true;
		if(objPatient==null){
			for(int k=0;k<patients.length && stop;k++){
				if(patients[k]==null){
					stop = false;
					patients[k]= new Particular(name,lastName,age,id,phoneNumber,doctorName,doctorPhoneNum,numLicence);
				}
			}	
		} else{
			message = "El paciente ya se encuentra registrado, intentelo nuevamente";
		}
		return message;
	}

	public String addPatient(String name, String lastName, int age, String id, String numMerbership, int patientCategory){
		Patient objPatient = findPatient(id);
		String message = "El paciente ha sido agregado exitosamente";
		boolean stop = true;
		if(objPatient==null){
			for(int k=0;k<patients.length && stop;k++){
				if(patients[k]==null){
					stop = false;
					patients[k]= new Coomeva(name,lastName,age,id,numMerbership,patientCategory);
				}
			}	
		} else{
			message = "El paciente ya se encuentra registrado, intentelo nuevamente";
		}
		return message;
	}

	public String addPatient(String name,String lastName, int age, String id, String numMerbership, int minValuePolicy, int maxValuePolicy){
		Patient objPatient = findPatient(id);
		String message = "El paciente ha sido agregado exitosamente";
		boolean stop = true;
		if(objPatient==null){
			for(int k=0;k<patients.length && stop;k++){
				if(patients[k]==null){
					stop = false;
					patients[k]= new SURA(name,lastName,age,id,numMerbership,minValuePolicy,maxValuePolicy);
				}
			}	
		} else{
			message = "El paciente ya se encuentra registrado, intentelo nuevamente";
		}
		return message;
	}

	public String addPatient(String name, String lastName, int age, String id, String numMerbership, String nameEntity, String phoneNumConfirm){
		Patient objPatient = findPatient(id);
		String message = "El paciente ha sido agregado exitosamente";
		boolean stop = true;
		if(objPatient==null){
			for(int k=0;k<patients.length && stop;k++){
				if(patients[k]==null){
					stop = false;
					patients[k]= new Other(name,lastName,age,id,numMerbership,nameEntity,phoneNumConfirm);
				}
			}	
		} else{
			message = "El paciente ya se encuentra registrado, intentelo nuevamente";
		}
		return message;
	}

	public String addPatient(String name, String lastName, int age, String id, String nameEPS, String numOrder){
		Patient objPatient = findPatient(id);
		String message = "El paciente ha sido agregado exitosamente";
		boolean stop = true;
		if(objPatient==null){
			for(int k=0;k<patients.length && stop;k++){
				if(patients[k]==null){
					stop = false;
					patients[k]= new EPS(name,lastName,age,id,nameEPS,numOrder);
				}
			}	
		} else{
			message = "El paciente ya se encuentra registrado, intentelo nuevamente";
		}
		return message;
	}

	public String showNumPatients(){
		String message = "";
		int totalPatients = 0, numParticularPatients = 0, numPrepaidMedicinePatients = 0, numEPSpatients = 0, numCoomevaPatients = 0, numSURAPatients = 0, numOtherPatients = 0;
		for(int k=0;k<patients.length;k++){
			if(patients[k]!=null && patients[k] instanceof Particular){
				numParticularPatients += 1;
				totalPatients +=1; 
			} 
			if(patients[k]!=null && patients[k] instanceof PrepaidMedicine){
				numPrepaidMedicinePatients += 1; 
			} 
			if(patients[k]!=null && patients[k] instanceof EPS){
				numEPSpatients += 1;
				totalPatients +=1; 
			}
			if(patients[k]!=null && patients[k] instanceof Coomeva){
				numCoomevaPatients += 1;
				totalPatients +=1; 
			}
			if(patients[k]!=null && patients[k] instanceof SURA){
				numSURAPatients += 1;
				totalPatients +=1; 
			}
			if(patients[k]!=null && patients[k] instanceof Other){
				numOtherPatients += 1;
				totalPatients +=1; 
			}
		}
		message += "\nLa cantidad total de pacientes que atiende el centro de vacunacion es: "+totalPatients+
		"\nEl numero total de pacientes particulares atendidos es: "+numParticularPatients+
		"\nEl numero total de pacientes de EPS atendidos es: "+numEPSpatients+
		"\nEl numero total de pacientes de medicina prepagada atentidos es: "+numPrepaidMedicinePatients+
		"\nEl numero de pacientes de medicina prepagada que pertenecen a Coomeva es: "+numCoomevaPatients+
		"\nEl numero de pacientes de medicina prepagada que pertenecen a SURA es: "+numSURAPatients+
		"\nEl numero de pacientes de medicina prepagada que pertenecen a otra entidad es: "+numOtherPatients;
		return message;
	}

	public String showInfoPatients(String id){
		String message = "";
		Patient objPatient = findPatient(id);
		if(objPatient!=null){
			if(objPatient instanceof Particular){
				message = objPatient.toString();
			}
			if(objPatient instanceof EPS){
				message = objPatient.toString();
			}
			if(objPatient instanceof Coomeva){
				message = objPatient.toString();
			}
			if(objPatient instanceof Other){
				message = objPatient.toString();
			}
			if(objPatient instanceof SURA){
				message = objPatient.toString();
			}
		} else{
			message = "\nEl paciente no se encuentra registrado, intentelo nuevamente";
		} return message;
	}

	public String showAllInfo(){
		String message = showNumPatients();
		message += "\n**********************************************************************************\n"+"\nLista de pacientes atendidos por el centro de vacunacion";;
		for(int k=0; k<patients.length;k++){
			if(patients[k]!=null){
				message += patients[k].toString();
			}	
		}
		return message;
	}

	//Getters & Setters

	public Patient[] getPatients(){
		return patients;
	}

	public void setPatients(Patient[] patients){
		this.patients = patients;
	}
}