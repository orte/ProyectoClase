package LN;

public class clsProfesor extends clsPersona implements java.io.Serializable{
	
	/**
	 * 
	 */
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		clsProfesor other = (clsProfesor) obj;
		if (id_profesor == null) {
			if (other.id_profesor != null)
				return false;
		} else if (!id_profesor.equals(other.id_profesor))
			return false;
		return true;
	}
	@Override
	public String toString() {
		String string;
		string = nombre+" "+ap1+" "+ap2+". ID de profesor: "+id_profesor;
		return string;
	}
	
}
