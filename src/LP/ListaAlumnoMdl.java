package LP;

import java.util.LinkedList;

import javax.swing.DefaultListModel;

import LN.clsAlumno;

/**
 * Modelo para las JList de alumnos, que extiende de DefaultListModel
 * @author jon.orte
 *
 */
public class ListaAlumnoMdl extends DefaultListModel<clsAlumno>{
	
	private static final long serialVersionUID = 1L;
	protected LinkedList<clsAlumno> alumnos;
	
	public ListaAlumnoMdl(LinkedList<clsAlumno> lista){
		alumnos=lista;
	}
	public clsAlumno getElementAt(int index)
	  {
	    return alumnos.get(index);
	  }
	
	  public int getSize()
	  {
	    return alumnos.size();
	  }

	  @Override
	  public void addElement(clsAlumno element)
	  {
		  alumnos.add(element);
		  this.fireContentsChanged(this, alumnos.size(), alumnos.size());
	  }
}
