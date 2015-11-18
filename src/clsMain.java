
import LP.*;
public class clsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		clsMenu menu=new clsMenu();
		do{
			menu.MenuPrincipal();
			opcion=Utilidades.leerEntero();
			switch(opcion){
			case 1: menu.AltaAlumno(); break;
			case 2: menu.ModificarAlumno(); break;
			case 3: menu.EliminarAlumno(); break;
			case 4: menu.AltaProfesor(); break;
			case 5: menu.ModificarProfesor(); break;
			case 6: menu.EliminarProfesor(); break;
			case 7: menu.AltaAsignatura(); break;
			case 8: menu.Matricular(); break;
			case 9: menu.Impartir(); break;
			case 10: menu.EliminarMatricula(); break;
			case 11: menu.BorrarImparticion(); break;
			case 12: menu.AlumnosAlf(); break;
			case 13: menu.ProfesoresAlf(); break;
			case 14: menu.AlumnosFecha(); break;
			case 15: menu.ProfDepart(); break;
			case 16: System.out.println("Has elegido salir, hasta pronto!"); break;
			default: System.out.println("Elige una opción válida");
			
			}
		}
		while (opcion!=16);
		
		
	}

}
