package LN;

import java.util.Comparator;
import java.io.Serializable;

public class clsAlumno extends clsPersona implements Serializable, Comparator<clsAlumno>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6963406561558035634L;

	private int ano_matricula;
	private String id_alumno;
	
	public int getAno_matricula() {
		return ano_matricula;
	}

	public void setAno_matricula(int ano_matricula) {
		this.ano_matricula = ano_matricula;
	}

	public String getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(String id_alumno) {
		this.id_alumno = id_alumno;
	}

	@Override
	public String toString() {
		String string;
		string = nombre+" "+ap1+" "+ap2+". ID del alumno: "+id_alumno;
		return string;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_alumno == null) ? 0 : id_alumno.hashCode());
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
		clsAlumno other = (clsAlumno) obj;
		if (id_alumno == null) {
			if (other.id_alumno != null)
				return false;
		} else if (!id_alumno.equals(other.id_alumno))
			return false;
		return true;
	}

	@Override
	public int compare(clsAlumno o1, clsAlumno o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
