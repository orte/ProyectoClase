package LN;

import java.io.Serializable;

/**
 * Objeto de la clase Alumno, que hereda de la clase persona y que implementa la interfaz serializable. Además
 * de los atributus heredados de clsPersona, tiene atributos que indican su ID y el año en el que se matricularon
 * @author jon.orte
 *
 */
public class clsAlumno extends clsPersona implements Serializable{

	
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
	/**
	 * Método toString que crea un string con el nombre, apellidos e ID del alumno
	 * @author jon.orte
	 * @return string con los atributos
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String string;
		string = nombre+" "+ap1+" "+ap2+". ID del alumno: "+id_alumno;
		return string;
	}

	/**
	 * HashCode generado usando el ID único de cada alumno
	 * @author jon.orte
	 * @return result, Int con el hashcode
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_alumno == null) ? 0 : id_alumno.hashCode());
		return result;
	}

	/**
	 * Método equals usado para comprobar si dos alumnos son iguales usando como criterio su ID
	 * @author jon.orte
	 * @return booleano que indica si la comparacion da true o false
	 * @param obj objeto a comparar
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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

}
