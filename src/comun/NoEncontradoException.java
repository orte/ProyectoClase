package comun;

public class NoEncontradoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9170930272529054609L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No se ha encontrado el elemento buscado, inténtelo de nuevo";
	}
	

}
