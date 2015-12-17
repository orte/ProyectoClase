package LP;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;

import comun.DuplicadoException;
import LN.clsAlumno;
import LN.clsAsignatura;
import LN.clsGestor;
import LN.clsMatricula;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Clase de tipo ventana que muestra dos listas, una con Alumnos y otra con Asignaturas. El usuario selecciona un elemento de
 * casa una y con ellos se crea una nueva matrícula. Implementa ListSelectionListener y ActionListener
 * @author jon.orte
 *
 */
public class NuevaMatriculaFrm extends JFrame implements ListSelectionListener, ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private clsGestor ges=new clsGestor();
	private JLabel lblSeleccioneElAlumno;
	private JList<clsAlumno> listAlum;
	private JList<clsAsignatura> listAsign;
	private JLabel lblAlumnos;
	private JLabel lblAsignaturas;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public NuevaMatriculaFrm() {
		setResizable(false);
		setTitle("Nueva Matr\u00EDcula");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSeleccioneElAlumno = new JLabel("Seleccione el alumno y la asignatura a la que quiere matricularlo");
		lblSeleccioneElAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneElAlumno.setBounds(10, 11, 424, 14);
		contentPane.add(lblSeleccioneElAlumno);
		
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
		listAlum.setBounds(20, 76, 177, 151);
		listAlum.addListSelectionListener(this);
		contentPane.add(listAlum);
		
		listAsign = new JList<clsAsignatura>();
		LinkedList<clsAsignatura> asigns=new LinkedList<clsAsignatura>();
		try{
			asigns=ges.ListaAsignaturas();
		} catch (IOException e){
			e.printStackTrace();
		}
		ListaAsignMdl modelAsgn=new ListaAsignMdl(asigns);
		listAsign.setModel(modelAsgn);
		listAsign.setBounds(234, 76, 177, 151);
		listAsign.addListSelectionListener(this);
		contentPane.add(listAsign);
		
		lblAlumnos = new JLabel("Alumnos");
		lblAlumnos.setBounds(20, 62, 46, 14);
		contentPane.add(lblAlumnos);
		
		lblAsignaturas = new JLabel("Asignaturas");
		lblAsignaturas.setBounds(234, 62, 68, 14);
		contentPane.add(lblAsignaturas);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setActionCommand("aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(117, 253, 89, 23);
		btnAceptar.setEnabled(false);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setActionCommand("cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(222, 253, 89, 23);
		contentPane.add(btnCancelar);
	}

	/**
	 * El botón Aceptar está desactivado por defecto. Este método sirve para que, cuando haya un elemento seleccionado en ambas
	 * listas, el botón se active
	 * @author jon.orte
	 */
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		boolean a=false;
		boolean b=false;
		if (listAlum.isSelectionEmpty()==false){
			a=true;
		}
		if (listAsign.isSelectionEmpty()==false){
			b=true;
		}
		if(a&b==true){
			btnAceptar.setEnabled(true);
		}
	}

	/**
	 * Cuando se seleccionan un alumno y una asignatura de las listas, se cogen ambas selecciones y se pasan al método
	 * NuevaMatricula del gestor para que se cree con ellos un nuevo objeto clsMatricula. Si la matrícula está repetida,
	 * salta un cuadro de diálogo avisándolo. Si se pulsa Cancelar, se cierra la ventana
	 * @author jon.orte
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("aceptar")){
			try {
				clsMatricula nueva=ges.NuevaMatricula(listAlum.getSelectedValue(), listAsign.getSelectedValue());
				JOptionPane.showMessageDialog(this, "Enhorabuena!, has realizado una matrícula. "+nueva.toString());
				this.dispose();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicadoException e){
				JOptionPane.showMessageDialog(this, "Ha ocurrido un error, este alumno ya está matriculado en esta asignatura");
			}
		} else if(arg0.getActionCommand().equals("cancelar")){
			this.dispose();
		}
	}
}
