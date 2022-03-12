package app;

import dto.DatosAlumnosDTO;
import service.LectorXmlService;

public class Main {

	public static void main(String[] args) {
		System.out.println("*** Se procede a la lectura y procesamiento del fichero ***");
		
		LectorXmlService lectorXmlService = new LectorXmlService();
		DatosAlumnosDTO datosAlumnosDTO = lectorXmlService.obtenerDatosFicheroXML();
	
		System.out.println("*** Fichero procesado ***");
		System.out.println("Contenido del fichero: ");
		System.out.println(datosAlumnosDTO.toString());
		
	}
	
}
