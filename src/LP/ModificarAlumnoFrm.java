package LP;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import LN.clsAlumno;
import LN.clsGestor;

public class ModificarAlumnoFrm extends JFrame implements ActionListener, InternalFrameListener{
	
	private static final long serialVersionUID = 1L;
	private JLabel lblSeleccionaElAlumno;
	private JList<clsAlumno> listAlum;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private clsGestor ges=new clsGestor();
	
	public ModificarAlumnoFrm() {
		setTitle("Modificar alumno");
		getContentPane().setLayout(null);
		
		lblSeleccionaElAlumno = new JLabel("Selecciona el alumno cuyos datos deseas modificar");
		lblSeleccionaElAlumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeleccionaElAlumno.setBounds(10, 0, 275, 34);
		getContentPane().add(lblSeleccionaElAlumno);
		
		listAlum = new JList<clsAlumno>();
		LinkedList<clsAlumno> alumnos=new LinkedList<clsAlumno>();
		try {
			alumnos=ges.ListaAlumnos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ListaAlumnoMdl modelAlm=new ListaAlumnoMdl(alumnos);
		listAlum.setModel(modelAlm);
		listAlum.setBounds(20, 34, 200, 283);
		getContentPane().add(listAlum);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(30, 328, 89, 23);
		btnAceptar.addActionListener(this);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(131, 328, 89, 23);
		getContentPane().add(btnCancelar);
		
		this.setSize(580, 400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		clsAlumno alumno=(clsAlumno)listAlum.getSelectedValue();
		ModificarAlumnoInternFrm internalFrame = new ModificarAlumnoInternFrm(alumno.getNombre(), alumno.getAp1(), alumno.getAp2(), alumno.getId_alumno(), ""+alumno.getAno_matricula());
		internalFrame.setBounds(288, 11, 238, 292);
		getContentPane().add(internalFrame);
		internalFrame.setSize(new Dimension(252, 323));
		internalFrame.addInternalFrameListener(this);
		internalFrame.setVisible(true);
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		listAlum=null;
		this.revalidate();
		this.repaint();
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}
}
