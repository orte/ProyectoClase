package LP;

import java.util.Map;

import javax.swing.table.AbstractTableModel;

import LN.clsAlumno;

public class AlumnosYearMdl extends AbstractTableModel{

	private String[] columnNames={"Nombre", "Primer apellido", "Segundo apellido", "ID", "Año de matriculación"};
	Object[][] data;
	
	public AlumnosYearMdl(Map<Integer, clsAlumno> m){
		
		
		int filas = m.size();
		int cont;
		data=new Object[filas][];
		cont=0;
		
		for (Map.Entry<Integer, clsAlumno> entry : m.entrySet()){
			Object[]a={
					   new String(entry.getValue().getNombre()),
					   new String(entry.getValue().getAp1()),
					   new String(entry.getValue().getAp2()),
					   new String(entry.getValue().getId_alumno()),
					   new Integer(entry.getValue().getAno_matricula())
			};		
			data[cont]=a;
			cont++;
		}
	}
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
}
