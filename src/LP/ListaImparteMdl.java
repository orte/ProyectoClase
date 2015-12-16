package LP;

import java.util.LinkedList;

import javax.swing.DefaultListModel;

import LN.clsImparte;
import LN.clsMatricula;

public class ListaImparteMdl extends DefaultListModel<clsImparte>{
	
	private static final long serialVersionUID = 1L;
	protected LinkedList<clsImparte> impart;
	
	public ListaImparteMdl(LinkedList<clsImparte> lista){
		impart=lista;
	}
	public clsImparte getElementAt(int index)
	  {
	    return impart.get(index);
	  }
	
	  public int getSize()
	  {
	    return impart.size();
	  }

	  @Override
	  public void addElement(clsImparte element)
	  {
		  impart.add(element);
		  this.fireContentsChanged(this, impart.size(), impart.size());
	  }
}
