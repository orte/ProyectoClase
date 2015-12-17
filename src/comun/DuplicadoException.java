package comun;

/**
 * Excepción que se lanzará cuando dos elementos estén duplicados
 * @author jon.orte
 *
 */
public class DuplicadoException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Ha introducido un elemento duplicado, inténtelo de nuevo.";
	}

	
}
