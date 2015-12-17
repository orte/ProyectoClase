package LN;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * clase imparte, que relaciona un profesor con una asignatura. Para ello tiene dos atributos, el id del profesor y el de 
 * la asignatura que imparte
 * @author jon.orte
 *
 */
public class clsImparte implements Serializable{
	
	private static final long serialVersionUID = -5551703067557383422L;
	private String id_asignatura;
	private String id_profesor;
	
	public String getId_asignatura() {
		return id_asignatura;
	}
	public void setId_asignatura(String id_asignatura) {
		this.id_asignatura = id_asignatura;
	}
	public String getId_profesor() {
		return id_profesor;
	}
	public void setId_profesor(String id_profesor) {
		this.id_profesor = id_profesor;
	}
	@Override
	/**
	 * HashCode generado usando el ID único de la asignatura y del profesor
	 * @author jon.orte
	 * @return result, Int con el hashcode
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_asignatura == null) ? 0 : id_asignatura.hashCode());
		result = prime * result
				+ ((id_profesor == null) ? 0 : id_profesor.hashCode());
		return result;
	}
	/**
	 * Método equals usado para comprobar si dos imparticiones son iguales usando como criterio los ID de su asignatura
	 * y de su profesor
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
		clsImparte other = (clsImparte) obj;
		if (id_asignatura == null) {
			if (other.id_asignatura != null)
				return false;
		} else if (!id_asignatura.equals(other.id_asignatura))
			return false;
		if (id_profesor == null) {
			if (other.id_profesor != null)
				return false;
		} else if (!id_profesor.equals(other.id_profesor))
			return false;
		return true;
	}
	/**
	 * Método toString que devuelve un string formado con los métodos toString del profesor y la asignatura relacionados.
	 * @author jon.orte
	 * @return string con los métodos toString del profesor y de la asignatura
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		clsGestor ges=new clsGestor();
		String string=null;
		try{
			LinkedList<clsAsignatura> asign=ges.ListaAsignaturas();
			clsAsignatura asig=asign.get(ges.BuscarAsignatura(id_asignatura));
			LinkedList<clsProfesor> profe=ges.ListaProfesores();
			clsProfesor prof=profe.get(ges.BuscarProfesor(id_profesor));
			string="Profesor: "+prof.toString()+". Asignatura: "+asig.toString();
		} catch (IOException e){
			e.printStackTrace();
		}
		return string;
	}
	
}
