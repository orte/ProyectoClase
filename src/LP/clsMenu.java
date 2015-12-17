package LP;
import LN.*;

/**
 * Clase usada por la ventana del menú principal para crear las ventanas correspondientes a cada opción.
 * Cada método lo único que hace es crear el objeto ventana correspondiente y ponerla como visible.
 * @author jon.orte
 *
 */

public class clsMenu {
	
	public void MenuPrincipal (){
		MenuPrincipalFrm principal=new MenuPrincipalFrm();
		principal.setVisible(true);
	}

	public void AltaAlumno (){
		AltaAlumnoFrm a=new AltaAlumnoFrm();
		a.setVisible(true);
	}
	public void ModificarAlumno(){
		ModificarAlumnoFrm a=new ModificarAlumnoFrm();
		a.setVisible(true);
	}
	public void EliminarAlumno(){
		EliminarAlumnoFrm a=new EliminarAlumnoFrm();
		a.setVisible(true);
	}
	public void AltaProfesor(){
		AltaProfesorFrm a=new AltaProfesorFrm();
		a.setVisible(true);
	}
	public void ModificarProfesor(){
		ModificarProfesorFrm a=new ModificarProfesorFrm();
		a.setVisible(true);
	}
	public void EliminarProfesor(){
		EliminarProfesorFrm a=new EliminarProfesorFrm();
		a.setVisible(true);
	}
	public void AltaAsignatura(){
		AltaAsignaturaFrm a=new AltaAsignaturaFrm();
		a.setVisible(true);
	}
	public void Matricular(){
		NuevaMatriculaFrm a=new NuevaMatriculaFrm();
		a.setVisible(true);
	}
	public void Impartir(){
		NuevoImparteFrm a=new NuevoImparteFrm();
		a.setVisible(true);
	}
	public void EliminarMatricula(){
		EliminarMatriculaFrm a=new EliminarMatriculaFrm();
		a.setVisible(true);
	}
	public void BorrarImparticion(){
		EliminarImparteFrm a=new EliminarImparteFrm();
		a.setVisible(true);
	}
	public void AlumnosAlf(){
		ListasAlumnosFrm a=new ListasAlumnosFrm();
		a.setVisible(true);
	}
	public void ProfesoresAlf(){
		ListasProfesoresFrm a=new ListasProfesoresFrm();
		a.setVisible(true);
	}
}
