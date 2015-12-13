package LP;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import LN.clsAlumno;


public class ListaFrm extends JFrame implements ActionListener {

	private JPanel pane;
	private JLabel titulo;
	private JPanel centro;
	private JList<String> lista;
	private JButton seleccionar;
	private JPanel panel;
	private JButton btnCancelar;
	
	public ListaFrm(LinkedList<Serializable> list){
		pane=(JPanel)this.getContentPane();
		pane.setLayout(new BorderLayout());
		titulo=new JLabel("Seleccione el alumno que desea modificar");
		pane.add(titulo, BorderLayout.PAGE_START);
		String [] str=new String [list.size()];
		for(int i=0; i<str.length; i++){
			str[i]=list.get(i).toString();
		}
		lista=new JList();
		pane.add(lista, BorderLayout.CENTER);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		seleccionar=new JButton("Seleccionar");
		panel.add(seleccionar);
		
		btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
