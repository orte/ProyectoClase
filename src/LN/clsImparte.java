package LN;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

import comun.NoEncontradoException;

public class clsImparte implements Serializable{
	
	/**
	 * 
	 */
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id_asignatura == null) ? 0 : id_asignatura.hashCode());
		result = prime * result
				+ ((id_profesor == null) ? 0 : id_profesor.hashCode());
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
		} catch (NoEncontradoException e){
			e.getMessage();
		} catch (IOException e){
			e.printStackTrace();
		}
		return string;
	}
	
}
