package LN;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * clase matrícula, que relaciona un alumno con una asignatura. Para ello tiene dos atributos, el id del alumno y el de 
 * la asignatura a la que está matriculado
 * @author jon.orte
 *
 */
public class clsMatricula implements Serializable {

	
	private static final long serialVersionUID = 1593349573317461860L;
	private String id_asignatura;
	private String id_alumno;
	public String getId_asignatura() {
		return id_asignatura;
	}
	public void setId_asignatura(String id_asignatura) {
		this.id_asignatura = id_asignatura;
	}
	public String getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(String id_alumno) {
		this.id_alumno = id_alumno;
	}
	/**
	 * HashCode generado usando el ID único de la asignatura y del alumno
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
		result = prime * result
				+ ((id_asignatura == null) ? 0 : id_asignatura.hashCode());
		return result;
	}
	/**
	 * Método equals usado para comprobar si dos matrículas son iguales usando como criterio los ID de su asignatura
	 * y de su alumno
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
		clsMatricula other = (clsMatricula) obj;
		if (id_alumno == null) {
			if (other.id_alumno != null)
				return false;
		} else if (!id_alumno.equals(other.id_alumno))
			return false;
		if (id_asignatura == null) {
			if (other.id_asignatura != null)
				return false;
		} else if (!id_asignatura.equals(other.id_asignatura))
			return false;
		return true;
	}
	/**
	 * Método toString que devuelve un string formado con los métodos toString del alumno y la asignatura relacionados.
	 * @author jon.orte
	 * @return string con los métodos toString del alumnos y de la asignatura
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		clsGestor ges=new clsGestor();
		String string=null;
		try{
			LinkedList<clsAsignatura> asign=ges.ListaAsignaturas();
			clsAsignatura asig=asign.get(ges.BuscarAsignatura(id_asignatura));
			LinkedList<clsAlumno> alumn=ges.ListaAlumnos();
			clsAlumno alum=alumn.get(ges.BuscarAlumno(id_alumno));
			string="Alumno: "+alum.toString()+". Asignatura: "+asig.toString();
		} catch (IOException e){
			e.printStackTrace();
		}
		return string;
	}
	
}
