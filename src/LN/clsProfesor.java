package LN;

/**
 * Objeto de la clase profesor, que hereda de la clase persona y que implementa la interfaz serializable. Además
 * de los atributos heredados de clsPersona, tiene atributos que indican su ID y el departamento en el que trabaja
 * @author jon.orte
 *
 */
public class clsProfesor extends clsPersona implements java.io.Serializable{
	
	private static final long serialVersionUID = -5264759352002835871L;
	private String departamento;
	private String id_profesor;
	
	
	public String getId_profesor() {
		return id_profesor;
	}
	public void setId_profesor(String id_profesor) {
		this.id_profesor = id_profesor;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	/**
	 * HashCode generado usando el ID único de cada profesor
	 * @author jon.orte
	 * @return result, Int con el hashcode
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_profesor == null) ? 0 : id_profesor.hashCode());
		return result;
	}
	/**
	 * Método equals usado para comprobar si dos profesores son iguales usando como criterio su ID
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
		clsProfesor other = (clsProfesor) obj;
		if (id_profesor == null) {
			if (other.id_profesor != null)
				return false;
		} else if (!id_profesor.equals(other.id_profesor))
			return false;
		return true;
	}
	/**
	 * Método toString que crea un string con el nombre, apellidos e ID del profesor
	 * @author jon.orte
	 * @return string con los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string;
		string = nombre+" "+ap1+" "+ap2+". ID de profesor: "+id_profesor;
		return string;
	}
	
}
