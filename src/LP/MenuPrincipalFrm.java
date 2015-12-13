package LP;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MenuPrincipalFrm extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel fondo;
	private ButtonGroup group;
	private JMenuBar menuBar;
	private JMenu mnNuevo;
	private JMenu mnModificar;
	private JMenu mnEliminar;
	private JMenu mnListas;
	private JMenuItem mntmNuevoAlumno;
	private JMenuItem mntmNuevoProfesor;
	private JMenuItem mntmNuevoAsignatura;
	private JMenuItem mntmModificarAlumno;
	private JMenuItem mntmModificarProfesor;
	private JMenuItem mntmNuevoMatricula;
	private JMenuItem mntmNuevaImparticion;
	private JMenuItem mntmEliminarAlumno;
	private JMenuItem mntmEliminarProfesor;
	private JMenuItem mntmEliminarMatricula;
	private JMenuItem mntmEliminarImparticion;
	private JMenuItem mntmAlumnosAlf;
	private JMenuItem mntmProfesoresAlf;
	private JMenuItem mntmAlumnosPorAno;
	private JMenuItem mntmProfesoresPorDepartamento;
	private JLabel lblDeLaUniversidad;
	private JPanel panel;
	
	public MenuPrincipalFrm(){
		setTitle("Bienvenido! Introduzca una opci\u00F3n");
		
		JPanel pane=(JPanel)this.getContentPane();
		pane.setLayout(new BorderLayout());
		try {
			fondo=new JPanelWithBackground("logo-vector-universidad-deusto.jpg");
			fondo.setPreferredSize(new Dimension(630,380));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setSize(fondo.getPreferredSize());
		//fondo=new JPanel();
		group=new ButtonGroup();
		pane.add(fondo, BorderLayout.CENTER);
		fondo.setLayout(null);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblGestorDeAlumnos = new JLabel("Gestor de alumnos, profesores y asignaturas");
		panel.add(lblGestorDeAlumnos);
		lblGestorDeAlumnos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblGestorDeAlumnos.setBounds(26, 0, 258, 31);
		
		lblDeLaUniversidad = new JLabel("de la Universidad de Deusto");
		panel.add(lblDeLaUniversidad);
		lblDeLaUniversidad.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDeLaUniversidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeLaUniversidad.setBounds(58, 31, 200, 31);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNuevo = new JMenu("Nuevo");
		menuBar.add(mnNuevo);
		
		mntmNuevoAlumno = new JMenuItem("Alumno");
		mntmNuevoAlumno.setActionCommand("nuevo alumno");
		mntmNuevoAlumno.addActionListener(this);
		mnNuevo.add(mntmNuevoAlumno);
		
		mntmNuevoProfesor = new JMenuItem("Profesor");
		mntmNuevoProfesor.setActionCommand("nuevo profesor");
		mntmNuevoProfesor.addActionListener(this);
		mnNuevo.add(mntmNuevoProfesor);
		
		mntmNuevoAsignatura = new JMenuItem("Asignatura");
		mntmNuevoAsignatura.setActionCommand("nueva asignatura");
		mntmNuevoAsignatura.addActionListener(this);
		mnNuevo.add(mntmNuevoAsignatura);
		
		mntmNuevoMatricula = new JMenuItem("Matr\u00EDcula");
		mntmNuevoMatricula.setActionCommand("nueva matricula");
		mntmNuevoMatricula.addActionListener(this);
		mnNuevo.add(mntmNuevoMatricula);
		
		mntmNuevaImparticion = new JMenuItem("Impartici\u00F3n");
		mntmNuevaImparticion.setActionCommand("nueva imparticion");
		mntmNuevaImparticion.addActionListener(this);
		mnNuevo.add(mntmNuevaImparticion);
		
		mnModificar = new JMenu("Modificar");
		menuBar.add(mnModificar);
		
		mntmModificarAlumno = new JMenuItem("Alumno");
		mntmModificarAlumno.setActionCommand("modificar alumno");
		mntmModificarAlumno.addActionListener(this);
		mnModificar.add(mntmModificarAlumno);
		
		mntmModificarProfesor = new JMenuItem("Profesor");
		mntmModificarProfesor.setActionCommand("modificar profesor");
		mntmModificarProfesor.addActionListener(this);
		mnModificar.add(mntmModificarProfesor);
		
		mnEliminar = new JMenu("Eliminar");
		menuBar.add(mnEliminar);
		
		mntmEliminarAlumno = new JMenuItem("Alumno");
		mntmEliminarAlumno.setActionCommand("eliminar alumno");
		mntmEliminarAlumno.addActionListener(this);
		mnEliminar.add(mntmEliminarAlumno);
		
		mntmEliminarProfesor = new JMenuItem("Profesor");
		mntmEliminarProfesor.setActionCommand("eliminar profesor");
		mntmEliminarProfesor.addActionListener(this);
		mnEliminar.add(mntmEliminarProfesor);
		
		mntmEliminarMatricula = new JMenuItem("Matr\u00EDcula");
		mntmEliminarMatricula.setActionCommand("eliminar matricula");
		mntmEliminarMatricula.addActionListener(this);
		mnEliminar.add(mntmEliminarMatricula);
		
		mntmEliminarImparticion = new JMenuItem("Impartici\u00F3n");
		mntmEliminarImparticion.setActionCommand("eliminar imparticion");
		mntmEliminarImparticion.addActionListener(this);
		mnEliminar.add(mntmEliminarImparticion);
		
		mnListas = new JMenu("Listas");
		menuBar.add(mnListas);
		
		mntmAlumnosAlf = new JMenuItem("Alumnos por orden alfab\u00E9tico");
		mntmAlumnosAlf.setActionCommand("alumnos alf");
		mntmAlumnosAlf.addActionListener(this);
		mnListas.add(mntmAlumnosAlf);
		
		mntmProfesoresAlf = new JMenuItem("Profesores por orden alfab\u00E9tico");
		mntmProfesoresAlf.setActionCommand("profes alf");
		mntmProfesoresAlf.addActionListener(this);
		mnListas.add(mntmProfesoresAlf);
		
		mntmAlumnosPorAno = new JMenuItem("Alumnos por a\u00F1o de matriculaci\u00F3n");
		mntmAlumnosPorAno.setActionCommand("alumnos por ano");
		mntmAlumnosPorAno.addActionListener(this);
		mnListas.add(mntmAlumnosPorAno);
		
		mntmProfesoresPorDepartamento = new JMenuItem("Profesores por departamento");
		mntmProfesoresPorDepartamento.setActionCommand("profesores dept");
		mntmProfesoresPorDepartamento.addActionListener(this);
		mnListas.add(mntmProfesoresPorDepartamento);
		
		group.add(mntmNuevoAlumno);
		group.add(mntmNuevoProfesor);
		group.add(mntmNuevoAsignatura);
		group.add(mntmNuevoMatricula);
		group.add(mntmNuevaImparticion);
		group.add(mntmModificarAlumno);
		group.add(mntmModificarProfesor);
		group.add(mntmEliminarAlumno);
		group.add(mntmEliminarProfesor);
		group.add(mntmEliminarMatricula);
		group.add(mntmEliminarImparticion);
		group.add(mntmAlumnosAlf);
		group.add(mntmProfesoresAlf);
		group.add(mntmAlumnosPorAno);
		group.add(mntmProfesoresPorDepartamento);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		clsMenu menu=new clsMenu();
		JMenuItem a=(JMenuItem) e.getSource();
		String command=a.getActionCommand();
		switch (command){
		case "nuevo alumno": menu.AltaAlumno(); break;
		case "nuevo profesor": menu.AltaProfesor(); break;
		case "nueva asignatura": menu.AltaAsignatura(); break;
		case "nueva matricula": menu.Matricular(); break;
		case "nueva imparticion": menu.Impartir(); break;
		case "modificar alumno": menu.ModificarAlumno(); break;
		case "modificar profesor": menu.ModificarProfesor(); break;
		case "eliminar alumno": menu.EliminarAlumno(); break;
		case "eliminar profesor": menu.EliminarProfesor(); break;
		case "eliminar matricula": menu.EliminarMatricula(); break;
		case "eliminar imparticion": menu.BorrarImparticion(); break;
		case "alummnos alf": menu.AlumnosAlf(); break;
		case "profesores alf": menu.ProfesoresAlf(); break;
		case "alumnos por ano": menu.AlumnosFecha(); break;
		case  "profesores dept": menu.ProfDepart(); break;
		
		}
	}
}
