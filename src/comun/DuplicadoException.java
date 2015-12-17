package comun;

/**
 * Excepci�n que se lanzar� cuando dos elementos est�n duplicados
 * @author jon.orte
 *
 */
public class DuplicadoException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Ha introducido un elemento duplicado, int�ntelo de nuevo.";
	}

	
}
