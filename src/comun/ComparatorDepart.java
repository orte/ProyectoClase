package comun;
import java.util.Comparator;
import LN.clsProfesor;
public class ComparatorDepart implements Comparator<clsProfesor>{

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
