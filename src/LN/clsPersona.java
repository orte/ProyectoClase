package LN;

import java.io.Serializable;

public class clsPersona implements Serializable, Comparable<clsPersona> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6325254086933776663L;
	protected String nombre;
	protected String ap1;
	protected String ap2;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAp1() {
		return ap1;
	}
	public void setAp1(String ap1) {
		this.ap1 = ap1;
	}
	public String getAp2() {
		return ap2;
	}
	public void setAp2(String ap2) {
		this.ap2 = ap2;
	}
	@Override
	public int compareTo(clsPersona arg0) {
		// TODO Auto-generated method stub
		int ultimaCmp = ap1.compareTo(arg0.ap1);
		return (ultimaCmp != 0 ? ultimaCmp :
		nombre.compareTo(arg0.nombre));
	}
}
