package LP;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import LN.clsAlumno;
import LN.clsGestor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
import java.awt.Font;

/**
 * Clase ventana que hereda de JFrame y que muestra una tabla con los alumnos dados de alta en el sistema. Tiene un bot�n
 * para configurar el orden en el que se quieren ver los elementos de la tabla, si ordenados alfab�ticamente o por a�o 
 * de matriculaci�n
 * @author jon.orte
 *
 */
public class ListasAlumnosFrm extends JFrame implements ActionListener{
	private Map<Integer, clsAlumno> alumnos;
	private JTable table;
	private JButton btnOrden;
	private boolean modo=false;
	
	public ListasAlumnosFrm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Lista de alumnos");
		getContentPane().setLayout(null);
		
		clsGestor ges=new clsGestor();
		try {
			alumnos=ges.MapaAlmAlf();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TablaAlumnosMdl model=new TablaAlumnosMdl(alumnos);
		table = new JTable(model.data, model.columnNames);
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);
		model.fireTableDataChanged();
		JScrollPane scrl=new JScrollPane(table);
		scrl.setBounds(20, 11, 624, 351);
		table.setVisible(true);
		getContentPane().add(scrl);
		
		btnOrden = new JButton("Ordenar por a�o de matriculaci�n");
		btnOrden.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOrden.setBounds(214, 373, 200, 23);
		btnOrden.addActionListener(this);
		getContentPane().add(btnOrden);
		this.setSize(667, 433);
	}
	/**
	 * Clase interna usada de modelo de tabla para la tabla de alumnos que extiende de AbstractTableModel. Tiene dos arrays 
	 * como atributos, uno de Strings con los nombres de las columnas y otro bidimensional de la clase Object para los datos. 
	 * Para rellenar ese array se usan los datos de un Map.
	 * @author jon.orte
	 */
	class TablaAlumnosMdl extends AbstractTableModel{

		private String[] columnNames={"Nombre", "Primer apellido", "Segundo apellido", "ID", "A�o de matriculaci�n"};
		Object[][] data;
		
		public TablaAlumnosMdl(Map<Integer, clsAlumno> m){
			
			
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
		public void setData(Map<Integer, clsAlumno> m){
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
	/**
	 * Al pulsar el bot�n que determina el orden de los elementos de la tabla, se cargar� el mapa de alumnos con el �rden
	 * que corresponda y se actualizar� la tabla, adem�s de cambiar el t�tulo del bot�n
	 * @author jon.orte
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		clsGestor ges=new clsGestor();
		try {
			if(modo==false){
				alumnos=ges.MapaAlmYear();
				modo=true;
				btnOrden.setText("Ordenar alfab�ticamente");
				btnOrden.repaint();
				this.getContentPane().revalidate();
			}
			else{
				alumnos=ges.MapaAlmAlf();
				modo=false;
				btnOrden.setText("Ordenar por a�o de matriculaci�n");
				btnOrden.repaint();
				this.getContentPane().revalidate();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TablaAlumnosMdl model=new TablaAlumnosMdl(alumnos);
		table=new JTable(model.data,model.columnNames);
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);
		model.fireTableDataChanged();
		JScrollPane scrl=new JScrollPane(table);
		scrl.setBounds(20, 11, 624, 351);
		table.setVisible(true);
		getContentPane().add(scrl);
	}
}
