package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dto.AlumnoDTO;
import dto.DatosAlumnosDTO;

public class LectorXmlService {
	
	public DatosAlumnosDTO obtenerDatosFicheroXML() {
		DatosAlumnosDTO datosAlumnosDTO = new DatosAlumnosDTO();
		Document ficheroXml = leerDatosXML();
		if (ficheroXml != null) {
			datosAlumnosDTO = procesarDatosXML(ficheroXml);
		}
		return datosAlumnosDTO;
	}
	
	private Document leerDatosXML() {
		Document ficheroXml = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbFactory.newDocumentBuilder();
			ficheroXml = builder.parse("D:\\Java\\cursoXML\\workLecturaXML\\lectoXmlApp\\src\\main\\resources\\ficherodepruebas.xml");
			if (ficheroXml != null) {
				ficheroXml.getDocumentElement().normalize();
			}
		} catch (Exception e) {
			System.err.println("Error al leer datos del fichero -> " + e.getMessage());
		}
		return ficheroXml;
	}
	
	private DatosAlumnosDTO procesarDatosXML(Document ficheroXml) {
		DatosAlumnosDTO datosAlumnosDTO = new DatosAlumnosDTO();
		List<AlumnoDTO> alumnoDTOs = new ArrayList();
		
		String nombreDocumento = ficheroXml.getElementsByTagName("nombreDocumento").item(0).getTextContent();
		String fechaDocumento = ficheroXml.getElementsByTagName("fecha").item(0).getTextContent();
		
		NodeList nodoAlumnos = ficheroXml.getElementsByTagName("alumnos");
		
		for (int temp = 0; temp < nodoAlumnos.getLength(); temp++) {
			
			Node nodoAlumno = nodoAlumnos.item(temp);		
			Element elementoAlumno = (Element) nodoAlumno;
			
			String nif = elementoAlumno.getElementsByTagName("nif").item(0).getTextContent();
			String nombre = elementoAlumno.getElementsByTagName("nombre").item(0).getTextContent();
			String apellidos = elementoAlumno.getElementsByTagName("apellidos").item(0).getTextContent();
			String fechaNacimiento = elementoAlumno.getElementsByTagName("fechaNacimiento").item(0).getTextContent();
			String curso = elementoAlumno.getElementsByTagName("curso").item(0).getTextContent();
			
			AlumnoDTO alumnoDTO = new AlumnoDTO(nif, nombre, apellidos, LocalDate.parse(fechaNacimiento), curso);
			if (alumnoDTO != null) {
				alumnoDTOs.add(alumnoDTO);
			}
		}
		
		datosAlumnosDTO.setNombreDocumento(nombreDocumento);
		datosAlumnosDTO.setFecha(LocalDate.parse(fechaDocumento));
		datosAlumnosDTO.setAlumnoDTOs(alumnoDTOs);
		
		return datosAlumnosDTO; 
	}

}
