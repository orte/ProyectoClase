package LP;

import java.util.LinkedList;

import javax.swing.DefaultListModel;

import LN.clsAsignatura;

/**
 * Modelo para las JList de asignaturas, que extiende de DefaultListModel
 * @author jon.orte
 *
 */
public class ListaAsignMdl extends DefaultListModel<clsAsignatura>{
	
	private static final long serialVersionUID = 1L;
	protected LinkedList<clsAsignatura> asigns;
	
	public ListaAsignMdl(LinkedList<clsAsignatura> lista){
		asigns=lista;
	}
	public clsAsignatura getElementAt(int index)
	  {
	    return asigns.get(index);
	  }
	
	  public int getSize()
	  {
	    return asigns.size();
	  }

	  @Override
	  public void addElement(clsAsignatura element)
	  {
		  asigns.add(element);
		  this.fireContentsChanged(this, asigns.size(), asigns.size());
	  }
}

