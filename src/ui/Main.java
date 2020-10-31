package ui;
import model.VaccinationCenter;
import java.util.Scanner;

public class Main{

	public Scanner lector;

	//Atributes
	private VaccinationCenter mainVaccinationCenter;

	//Builder Method
	public Main(){
		lector = new Scanner(System.in);
		mainVaccinationCenter = new VaccinationCenter();
	}
	//End Builder	

	public static void main(String[] args){
		System.out.println(
			"\n**********************************************************************************\n"+
			"             Bienvenido al sistema del Centro de Vacunacion de la ciudad"
		);
		Main objMain = new Main();
		int option = 0;
		do{
			option = objMain.menu();
		} while(option!= 5);
	}

	public int menu(){
		int option = 0;
		boolean menu = true;
		while(menu){
			System.out.println(
				"\n**********************************************************************************\n"+
				"                         Seleccione una opcion para continuar"+
				"\n**********************************************************************************\n"+
				"      1. Registrar un nuevo paciente\n"+
				"      2. Conocer la cantidad de pacientes que atiende el centro de vacunacion\n"+
				"      3. Conocer la informacion de un paciente\n"+
				"      4. Conocer toda la informacion del centro de vacunacion\n"+
				"      5. Finalizar la aplicacion\n"
			);
			option = lector.nextInt(); lector.nextLine();
			switch(option){
				case 1:
					if(mainVaccinationCenter.getPatients()[(VaccinationCenter.NUM_PATIENTS)-1]==null){
						registerPatient();
					} else {
						System.out.println("\n**********************************************************************************"+"\nYa se han registrado la maxima cantidad de pacientes posibles, no puede agregar otro");
					}
					menu = false;
					break;
				case 2:
					displayNumPatients();
					menu = false;
					break;
				case 3:
					displayInfoPatients();
					menu = false;
					break;
				case 4:
					displayInfoCenter();
					menu = false;
					break;
				case 5:
					System.out.println("\n**********************************************************************************\n"+"Gracias por utilizar nuestra aplicacion"+"\n**********************************************************************************\n");
					menu = false;
					break;
				default:
					System.out.println("Ingrese una opcion valida");
					menu = false;
					break;	
			}		
		} return option;
	}

	public void registerPatient(){
		String name, lastName, id, phoneNumber, doctorName, doctorPhoneNum, numLicence, nameEPS, numOrder, numMerbership, nameEntity, phoneNumConfirm, message = "";
		int age, patientType, patientEntity, patientCategory, minValuePolicy, maxValuePolicy;
		System.out.println(
			"\n**********************************************************************************\n"+
			"                                 Registrar un nuevo paciente"+
			"\n**********************************************************************************"
		);
		do{
			do{
				System.out.println(
					"\nSeleccione el tipo de paciente al que va a registrar: "+
						"\n    1. Particular"+
						"\n    2. Medicina prepagada"+
						"\n    3. EPS"
				);
				patientType = lector.nextInt();lector.nextLine();
				if(patientType!=1 && patientType!=2 && patientType!=3){
					System.out.println("\nIngrese una opcion correcta");
				}
			} while(patientType!=1 && patientType!=2 && patientType!=3);
			System.out.println("\nIngrese el nombre del paciente: ");
			name = lector.nextLine();
			System.out.println("Ingrese el apellido del paciente: ");
			lastName = lector.nextLine();
			System.out.println("Ingrese la edad del paciente: ");
			age = lector.nextInt();lector.nextLine();
			System.out.println("Ingrese el numero del documento de identidad del paciente: ");
			id = lector.nextLine();
			switch(patientType){
				case 1:
					System.out.println("Ingrese el telefono de contacto del paciente: ");
					phoneNumber = lector.nextLine();
					System.out.println("Ingrese el nombre del medico que trata al paciente: ");
					doctorName = lector.nextLine();
					System.out.println("Ingrese el numero telefonico del medico que trata al paciente: ");
					doctorPhoneNum = lector.nextLine(); 
					System.out.println("Ingrese el numero de licencia del medico que trata al paciente");
					numLicence = lector.nextLine();
					message = mainVaccinationCenter.addPatient(name,lastName,age,id,phoneNumber,doctorName,doctorPhoneNum,numLicence);
					System.out.println(message);
					break;
				case 2:
					System.out.println("Ingrese el numero de afiliacion del paciente: ");
					numMerbership = lector.nextLine();
					do{
						System.out.println(
							"\nSeleccione la entidad prestadora de salud del paciente: "+
							"\n    1. Coomeva"+
							"\n    2. SURA"+
							"\n    3. Otra"
						);
						patientEntity = lector.nextInt();lector.nextLine();
						if(patientEntity!=1 && patientEntity!=2 && patientEntity!=3){
							System.out.println("\nIngrese una opcion correcta");
						}
					} while(patientEntity!=1 && patientEntity!=2 && patientEntity!=3);
					switch(patientEntity){
						case 1:
							do{
								System.out.println(
									"\nSeleccione la categoria del paciente: "+
									"\n    1. Platino"+
									"\n    2. Oro"+
									"\n    3. Oro plus"
								);
								patientCategory = lector.nextInt();lector.nextLine();
								if(patientCategory!=1 && patientCategory!=2 && patientCategory!=3){
									System.out.println("\nIngrese una opcion correcta");
								}
							} while(patientCategory!=1 && patientCategory!=2 && patientCategory!=3);
							message = mainVaccinationCenter.addPatient(name,lastName,age,id,numMerbership,patientCategory);
							System.out.println(message);
							break;
						case 2:
							System.out.println("\nIngrese el valor minimo de cubrimiento que tiene la poliza del paciente: ");
							minValuePolicy = lector.nextInt();
							System.out.println("Ingrese el valor maximo de cubrimiento que tiene la poliza del paciente: ");
							maxValuePolicy = lector.nextInt(); lector.nextLine();
							message = mainVaccinationCenter.addPatient(name,lastName,age,id,numMerbership,minValuePolicy,maxValuePolicy);
							System.out.println(message);
							break;
						case 3:
							System.out.println("\nIngrese el nombre de la entidad a la que pertenece el paciente: ");
							nameEntity = lector.nextLine();
							System.out.println("Ingrese un numero telefonico donde se pueda confirmar el servicio del paciente: ");
							phoneNumConfirm = lector.nextLine();
							message = mainVaccinationCenter.addPatient(name,lastName,age,id,numMerbership,nameEntity,phoneNumConfirm);
							System.out.println(message);
							break;		
					}
					break;
				case 3:
					System.out.println("Ingrese el nombre de la EPS a la que pertenece el paciente: ");
					nameEPS = lector.nextLine();
					System.out.println("Ingrese un el numero de la orden de servicio del paciente: ");
					numOrder = lector.nextLine();
					message = mainVaccinationCenter.addPatient(name,lastName,age,id,nameEPS,numOrder);
					System.out.println(message);
					break;
			}	
		} while(message.equals("El paciente ya se encuentra registrado, intentelo nuevamente"));			
	}

	public void displayNumPatients(){
		String message = mainVaccinationCenter.showNumPatients();
		System.out.println(
			"\n**********************************************************************************\n"+
			"              Numero de pacientes que atiende el Centro de vacunacion"+
			"\n**********************************************************************************"
		);
		System.out.println(message);
	}

	public void displayInfoPatients(){
		String id, message;
		System.out.println(
			"\n**********************************************************************************\n"+
			"                             Informacion de un paciente"+
			"\n**********************************************************************************"
		);
		do{
			System.out.println("\nIngrese el numero de identificacion del paciente: ");
			id = lector.nextLine();
			message = mainVaccinationCenter.showInfoPatients(id);
			System.out.println(message);
		}while(message.equals("El paciente no se encuentra registrado, intentelo nuevamente"));	
	}

	public void displayInfoCenter(){
		String message = mainVaccinationCenter.showAllInfo();
		System.out.println(
			"\n**********************************************************************************\n"+
			"                     Informacion completa del centro de vacunacion"+
			"\n**********************************************************************************"
		);
		System.out.println(message);
	}		
}