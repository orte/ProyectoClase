package LN;

import java.io.Serializable;

/**
 * Objeto de la clase asignatura que implementa la interfaz serializable. Tiene atributos que indican nombre
 * descripción, el ID y el número de créditos que tiene
 * @author jon.orte
 *
 */
public class clsAsignatura implements Serializable{

	private static final long serialVersionUID = -5527528323499604832L;
	private String nombre;
	private String descripcion;
	private String id_asinatura;
	private int num_creditos;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getId_asinatura() {
		return id_asinatura;
	}
	public void setId_asinatura(String id_asinatura) {
		this.id_asinatura = id_asinatura;
	}
	public int getNum_creditos() {
		return num_creditos;
	}
	public void setNum_creditos(int num_creditos) {
		this.num_creditos = num_creditos;
	}
	
	/**
	 * HashCode generado usando el ID único de cada asignatura
	 * @author jon.orte
	 * @return result, Int con el hashcode
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_asinatura == null) ? 0 : id_asinatura.hashCode());
		return result;
	}
	/**
	 * Método equals usado para comprobar si dos asignaturas son iguales usando como criterio su ID
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
		clsAsignatura other = (clsAsignatura) obj;
		if (id_asinatura == null) {
			if (other.id_asinatura != null)
				return false;
		} else if (!id_asinatura.equals(other.id_asinatura))
			return false;
		return true;
	}
	/**
	 * Método toString que crea un string con el nombre, descripción e ID de la asignatura
	 * @author jon.orte
	 * @return string con los atributos
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String string;
		string = nombre+". "+descripcion+". ID: "+id_asinatura;
		return string;
	}
	
	
}
