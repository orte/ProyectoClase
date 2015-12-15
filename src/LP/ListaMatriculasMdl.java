package LP;

import java.util.LinkedList;

import javax.swing.DefaultListModel;

import LN.clsMatricula;

public class ListaMatriculasMdl extends DefaultListModel<clsMatricula>{
	
	private static final long serialVersionUID = 1L;
	protected LinkedList<clsMatricula> matr;
	
	public ListaMatriculasMdl(LinkedList<clsMatricula> lista){
		matr=lista;
	}
	public clsMatricula getElementAt(int index)
	  {
	    return matr.get(index);
	  }
	
	  public int getSize()
	  {
	    return matr.size();
	  }

	  @Override
	  public void addElement(clsMatricula element)
	  {
		  matr.add(element);
		  this.fireContentsChanged(this, matr.size(), matr.size());
	  }
}
