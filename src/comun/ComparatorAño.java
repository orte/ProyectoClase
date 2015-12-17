package comun;
import java.util.Comparator;
import LN.clsAlumno;

/**
 * Clase comparator que sirve para comparar dos alumnos en base a sus a�os de matriculaci�n
 * @author jon.orte
 *
 */
public class ComparatorA�o implements Comparator<clsAlumno>{

	/**
	 * M�todo compare sobreescrito de la interfaz comparator que devuelve
	 * @author jon.orte
	 * @param o1, o2. Los dos alumnos cuyos a�os se quieren comparar
	 * @return comp. Int que valdr� 1, -1 o 0 seg�n el a�o de matriculaci�n de los alumnos que sea anterior
	 */
	@Override
	public int compare(clsAlumno o1, clsAlumno o2) {
		// TODO Auto-generated method stub
		int comp=0;
		int ano1=o1.getAno_matricula();
		int ano2=o2.getAno_matricula();
		if(ano1<ano2){
			comp=-1;
		}
		if(ano1>ano2){
			comp=1;
		}
		return comp;
	}

}
