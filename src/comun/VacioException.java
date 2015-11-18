package comun;

public class VacioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2249713511925804110L;

	public String getMessage(){
		String string;
		string="Este fichero está vacío";
		return string;
	}
}
