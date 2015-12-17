package LP;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import LN.clsAlumno;
import LN.clsGestor;
import LN.clsProfesor;
import LP.ListasAlumnosFrm.TablaAlumnosMdl;

/**
 * Clase ventana que hereda de JFrame y que muestra una tabla con los profesores dados de alta en el sistema. Tiene un botón
 * para configurar el orden en el que se quieren ver los elementos de la tabla, si ordenados alfabéticamente o por departamento
 * @author jon.orte
 *
 */
public class ListasProfesoresFrm extends JFrame implements ActionListener{
	private Map<Integer, clsProfesor> profes;
	private JTable table;
	private JButton btnOrden;
	private boolean modo=false;
	
	public ListasProfesoresFrm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Lista de profesores");
		getContentPane().setLayout(null);
		
		clsGestor ges=new clsGestor();
		try {
			profes=ges.MapaProfAlf();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TablaProfesoresMdl model=new TablaProfesoresMdl(profes);
		table = new JTable(model.data, model.columnNames);
		table.setFillsViewportHeight(true);
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);
		model.fireTableDataChanged();
		JScrollPane scrl=new JScrollPane(table);
		scrl.setBounds(20, 11, 624, 351);
		table.setVisible(true);
		getContentPane().add(scrl);
		
		btnOrden = new JButton("Ordenar por departamento");
		btnOrden.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOrden.setBounds(214, 373, 200, 23);
		btnOrden.addActionListener(this);
		getContentPane().add(btnOrden);
		this.setSize(667, 433);
	}
	/**
	 * Clase interna usada de modelo de tabla para la tabla de profesores que extiende de AbstractTableModel. Tiene dos arrays 
	 * como atributos, uno de Strings con los nombres de las columnas y otro bidimensional de la clase Object para los datos. 
	 * Para rellenar ese array se usan los datos de un Map.
	 * @author jon.orte
	 */
	class TablaProfesoresMdl extends AbstractTableModel{

		private String[] columnNames={"Departamento", "Nombre", "Primer apellido", "Segundo apellido", "ID"};
		Object[][] data;
		boolean tipo=false;
		
		public TablaProfesoresMdl(Map<Integer, clsProfesor> m){
			
			
			int filas = m.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
			
			for (Map.Entry<Integer, clsProfesor> entry : m.entrySet()){
    			Object[]a={
    					   new String(entry.getValue().getDepartamento()),
    					   new String(entry.getValue().getNombre()),
    					   new String(entry.getValue().getAp1()),
    					   new String(entry.getValue().getAp2()),
    					   new String(entry.getValue().getId_profesor()),
    			};		
    			data[cont]=a;
    			cont++;
    		}
		}
		public void setData(Map<Integer, clsProfesor> m){
			
			int filas = m.size();
    		int cont;
    		data=new Object[filas][];
    		cont=0;
			
			for (Map.Entry<Integer, clsProfesor> entry : m.entrySet()){
    			Object[]a={
    					   new String(entry.getValue().getDepartamento()),
    					   new String(entry.getValue().getNombre()),
    					   new String(entry.getValue().getAp1()),
    					   new String(entry.getValue().getAp2()),
    					   new String(entry.getValue().getId_profesor()),
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
	 * Al pulsar el botón que determina el orden de los elementos de la tabla, se cargará el mapa de profesores con el órden
	 * que corresponda y se actualizará la tabla, además de cambiar el título del botón
	 * @author jon.orte
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		clsGestor ges=new clsGestor();
		try {
			if(modo==false){
				profes=ges.MapaProfDept();
				modo=true;
				btnOrden.setText("Ordenar alfabéticamente");
				btnOrden.repaint();
				this.getContentPane().revalidate();
			}
			else{
				profes=ges.MapaProfAlf();
				modo=false;
				btnOrden.setText("Ordenar por departamento");
				btnOrden.repaint();
				this.getContentPane().revalidate();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TablaProfesoresMdl model=new TablaProfesoresMdl(profes);
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
