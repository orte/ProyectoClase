package comun;
import java.util.Comparator;
import LN.clsAlumno;
public class ComparatorAño implements Comparator<clsAlumno>{

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
