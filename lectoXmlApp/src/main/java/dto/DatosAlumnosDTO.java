package dto;

import java.time.LocalDate;
import java.util.List;

public class DatosAlumnosDTO {

	private String nombreDocumento;
	private LocalDate fecha;
	private List<AlumnoDTO> alumnoDTOs;
	
	public DatosAlumnosDTO() {
		
	}
	
	public DatosAlumnosDTO(String nombreDocumento, LocalDate fecha, List<AlumnoDTO> alumnoDTOs) {
		super();
		this.nombreDocumento = nombreDocumento;
		this.fecha = fecha;
		this.alumnoDTOs = alumnoDTOs;
	}

	public String getNombreDocumento() {
		return nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<AlumnoDTO> getAlumnoDTOs() {
		return alumnoDTOs;
	}

	public void setAlumnoDTOs(List<AlumnoDTO> alumnoDTOs) {
		this.alumnoDTOs = alumnoDTOs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumnoDTOs == null) ? 0 : alumnoDTOs.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((nombreDocumento == null) ? 0 : nombreDocumento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DatosAlumnosDTO other = (DatosAlumnosDTO) obj;
		if (alumnoDTOs == null) {
			if (other.alumnoDTOs != null)
				return false;
		} else if (!alumnoDTOs.equals(other.alumnoDTOs))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (nombreDocumento == null) {
			if (other.nombreDocumento != null)
				return false;
		} else if (!nombreDocumento.equals(other.nombreDocumento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatosAlumnosDTO [nombreDocumento=" + nombreDocumento + ", fecha=" + fecha + ", alumnoDTOs=" + alumnoDTOs
				+ "]";
	}
	
	
}
