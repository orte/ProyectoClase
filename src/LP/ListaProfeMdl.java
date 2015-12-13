package LP;

import java.util.LinkedList;

import javax.swing.DefaultListModel;

import LN.clsProfesor;

public class ListaProfeMdl  extends DefaultListModel<clsProfesor>{
	
	private static final long serialVersionUID = 1L;
	protected LinkedList<clsProfesor> profes;
	
	public ListaProfeMdl(LinkedList<clsProfesor> lista){
		profes=lista;
	}
	public clsProfesor getElementAt(int index)
	  {
	    return profes.get(index);
	  }
	
	  public int getSize()
	  {
	    return profes.size();
	  }

	  @Override
	  public void addElement(clsProfesor element)
	  {
		  profes.add(element);
		  this.fireContentsChanged(this, profes.size(), profes.size());
	  }
}
