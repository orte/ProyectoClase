package comun;

/**
 * Excepci�n que se lanzar� cuando una lista de cualquier elemento est� vac�a.
 * @author jon.orte
 *
 */
public class VacioException extends Exception {

	private static final long serialVersionUID = -2249713511925804110L;

	public String getMessage(){
		String string;
		string="Este fichero est� vac�o";
		return string;
	}
}
