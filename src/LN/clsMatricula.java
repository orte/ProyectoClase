package LN;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

import comun.NoEncontradoException;

public class clsMatricula implements Serializable {

	/**
	 * 
	 */
	
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
		} catch (NoEncontradoException e){
			e.getMessage();
		} catch (IOException e){
			e.printStackTrace();
		}
		return string;
	}
	
}
