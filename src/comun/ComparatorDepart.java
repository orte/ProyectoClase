package comun;
import java.util.Comparator;
import LN.clsProfesor;

/**
 * Clase comparator que sirve para comparar dos profesores en base a sus departamentos
 * @author jon.orte
 *
 */
public class ComparatorDepart implements Comparator<clsProfesor>{

	/**
	 * Método compare sobreescrito de la interfaz comparator.
	 * @author jon.orte
	 * @param o1, o2. Los dos profesores cuyos años se quieren comparar
	 * @return comp. Int que valdrá 1, -1 o 0 según lo que resulte de comparar los departamentos de o1 y o2.
	 */
	@Override
	public int compare(clsProfesor o1, clsProfesor o2) {
		// TODO Auto-generated method stub
		int comp;
		String dep1=o1.getDepartamento();
		String dep2=o2.getDepartamento();
		comp=dep1.compareTo(dep2);
		return comp;
	}

}
