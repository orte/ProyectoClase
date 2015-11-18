package LP;
import LN.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;

import comun.DuplicadoException;
import comun.NoEncontradoException;
import comun.VacioException;

public class clsMenu {
	
	static clsGestor ges=new clsGestor();
	
	public void MenuPrincipal (){
		MenuPrincipalWdw principal=new MenuPrincipalWdw();
		principal.createAndShowGUI();
		
		
		/*System.out.println("Bienvenido! Introduzca una opción");
		System.out.println("1.- Alta de alumno");
		System.out.println("2.- Modificar datos de alumno");
		System.out.println("3.- Eliminar alumno");
		System.out.println("4.- Alta de profesor");
		System.out.println("5.- Modificar datos de profesor");
		System.out.println("6.- Eliminar profesor");
		System.out.println("7.- Nueva asignatura");
		System.out.println("8.- Matriculación de alumno en una asignatura");
		System.out.println("9.- Asociar un profesor a una asignatura");
		System.out.println("10.- Eliminar matrícula de alumno");
		System.out.println("11.- Eliminar asociación entre profesor y asginatura");
		System.out.println("12.- Lista de alumnos ordenados por orden alfabético");
		System.out.println("13.- Lista de profesores ordenados por orden alfabético");
		System.out.println("14.- Lista de alumnos ordenador por fecha de matriculación");
		System.out.println("15.- Lista de profesores ordenados por departamento");
		System.out.println("16.- Salir");*/
	}

	public void AltaAlumno (){
		AltaAlumnoWdw a=new AltaAlumnoWdw();
		a.setVisible(true);
		a.pack();
		
		/*int t=0;
		do{
			System.out.println("Introduzca los datos del alumno: ");
			System.out.println("Nombre:");
			String nombre=Utilidades.leerCadena();
			System.out.println("Primer apellido:");
			String ap1=Utilidades.leerCadena();
			System.out.println("Segundo apellido:");
			String ap2=Utilidades.leerCadena();
			System.out.println("DNI: ");
			String DNI=Utilidades.leerCadena();
			System.out.println("Año de matriculación:");
			int fecha=Utilidades.leerEntero();
			clsAlumno nuevo;
			try{
				nuevo=ges.nuevoAlumno(nombre, ap1, ap2, DNI, fecha);
				System.out.println(nuevo.toString()+" ha sido dado de alta con éxito");
				t=1;
			}
			catch(IOException e){
				e.printStackTrace();
			}
			catch(DuplicadoException e){
				System.out.println(e.getMessage());
				t=-1;
			}
		}
		while(t==-1);*/
	}
	public void ModificarAlumno(){
		try {
			ListaWdw lista=new ListaWdw(ges.ListaAlumnos());
			lista.pack();
			lista.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*clsAlumno mod=null;
		String id;
		int indx=-1;
		LinkedList<clsAlumno> lista=new LinkedList<clsAlumno>();
		try{
			lista=ges.ListaAlumnos();
			ges.ComprobarVacio(lista);
			do{
				System.out.println("Introduzca el ID del alumno que desea modificar");
				for(clsAlumno aux:lista){
					System.out.println(aux.toString());
				}
				id=Utilidades.leerCadena();
				try{
					indx=ges.BuscarAlumno(id);
					mod=lista.get(indx);
				} catch (IOException e){
					e.printStackTrace();
				} catch (NoEncontradoException e){
					System.out.println(e.getMessage());
				}
			} while (indx==-1);
			System.out.println("Ha decidido modificar el alumno "+mod.toString());
			System.out.println("Introduzca ahora los nuevos datos del alumno: ");
			System.out.println("Nombre:");
			String nom=Utilidades.leerCadena();
			System.out.println("Primer apellido:");
			String ap1=Utilidades.leerCadena();
			System.out.println("Segundo apellido:");
			String ap2=Utilidades.leerCadena();
			System.out.println("ID del alumno:");
			String ID=Utilidades.leerCadena();
			System.out.println("Año de matriculación:");
			int fecha=Utilidades.leerEntero();
			try {
				ges.ModificarAlumno(mod, nom, ap1, ap2, ID, fecha);
				System.out.println("La modificación del alumno se ha realizado con éxito");
			} catch (ParseException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicadoException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		} catch (IOException e){
			e.printStackTrace();
		} catch (VacioException e){
			System.out.println(e.getMessage());
		}
		*/
	}
	public void EliminarAlumno(){
		LinkedList<clsAlumno> lista=new LinkedList<clsAlumno>();
		try {
			lista=ges.ListaAlumnos();
			ges.ComprobarVacio(lista);
			System.out.println("Seleccione el alumno que desea dar de baja del sistema");
			String id;
			int indx=-1;
			do{
				for(clsAlumno aux:lista){
					System.out.println(aux.toString());
				}
				id=Utilidades.leerCadena();
				try {
					indx=ges.BuscarAlumno(id);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoEncontradoException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			while(indx==-1);
			clsAlumno alum=lista.get(indx);
			try {
				ges.BorrarAlumno(alum);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(alum.toString()+" ha sido eliminado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VacioException e){
			System.out.println(e.getMessage());
		}
		
	}
	public void AltaProfesor(){
		int t=0;
		do{
			System.out.println("Introduzca los datos del profesor: ");
			System.out.println("Nombre:");
			String nombre=Utilidades.leerCadena();
			System.out.println("Primer apellido:");
			String ap1=Utilidades.leerCadena();
			System.out.println("Segundo apellido:");
			String ap2=Utilidades.leerCadena();
			System.out.println("DNI: ");
			String DNI=Utilidades.leerCadena();
			System.out.println("Departamento:");
			String depart=Utilidades.leerCadena();
			clsProfesor nuevo;
			try{
				nuevo=ges.nuevoProfesor(nombre, ap1, ap2, DNI, depart);
				System.out.println(nuevo.toString()+" ha sido dado de alta con éxito");
				t=1;
			}
			catch(IOException e){
				e.printStackTrace();
			}
			catch(DuplicadoException e){
				System.out.println(e.getMessage());
				t=-1;
			}
		}
		while(t==-1);
	}
	public void ModificarProfesor(){
		clsProfesor mod=null;
		String id;
		int indx=-1;
		LinkedList<clsProfesor> lista=new LinkedList<clsProfesor>();
		try{
			lista=ges.ListaProfesores();
			ges.ComprobarVacio(lista);
			do{
				System.out.println("Introduzca el ID del profesor que desea modificar");
				for(clsProfesor aux:lista){
					System.out.println(aux.toString());
				}
				id=Utilidades.leerCadena();
				try{
					indx=ges.BuscarProfesor(id);
					mod=lista.get(indx);
				} catch (NoEncontradoException e){
					System.out.println(e.getMessage());
				} catch (IOException e){
					e.printStackTrace();
				}
			} while(indx==-1);
			System.out.println("Ha decidido modificar el profesor "+mod.toString());
			System.out.println("Introduzca ahora los nuevos datos del profesor: ");
			System.out.println("Nombre:");
			String nom=Utilidades.leerCadena();
			System.out.println("Primer apellido:");
			String ap1=Utilidades.leerCadena();
			System.out.println("Segundo apellido:");
			String ap2=Utilidades.leerCadena();
			System.out.println("ID del profesor:");
			String ID=Utilidades.leerCadena();
			System.out.println("Departamento:");
			String depart=Utilidades.leerCadena();
			try {
				ges.ModificarProfesor(mod, nom, ap1, ap2, ID, depart);
				System.out.println("La modificación del profesor se ha realizado con éxito");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicadoException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		} catch (VacioException e){
			System.out.println(e.getMessage());
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
	public void EliminarProfesor(){
		LinkedList<clsProfesor> lista=new LinkedList<clsProfesor>();
		try {
			lista=ges.ListaProfesores();
			ges.ComprobarVacio(lista);
			System.out.println("Seleccione el profesor que desea dar de baja del sistema");
			String id;
			int indx=-1;
			do{
				for(clsProfesor aux:lista){
					System.out.println(aux.toString());
				}
				id=Utilidades.leerCadena();
				try {
					indx=ges.BuscarProfesor(id);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoEncontradoException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			while(indx==-1);
			clsProfesor alum=lista.get(indx);
			try {
				ges.BorrarProfesor(alum);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(alum.toString()+" ha sido eliminado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(VacioException e){
			System.out.println(e.getMessage());
		}
		
	}
	public void AltaAsignatura(){
		int t=0;
		do{
			System.out.println("Introduzca los datos de la asignatura: ");
			System.out.println("Nombre:");
			String nombre=Utilidades.leerCadena();
			System.out.println("Descripción:");
			String desc=Utilidades.leerCadena();
			System.out.println("ID de la asignatura:");
			String id=Utilidades.leerCadena();
			System.out.println("Número de créditos: ");
			int cred=Utilidades.leerEntero();
			clsAsignatura nuevo;
			try{
				nuevo=ges.NuevaAsignatura(nombre, desc, id, cred);
				System.out.println("La Asignatura "+nuevo.toString()+" ha sido dado de alta con éxito");
				t=1;
			}
			catch(IOException e){
				e.printStackTrace();
			}
			catch(DuplicadoException e){
				System.out.println(e.getMessage());
				t=-1;
			}
		}
		while(t==-1);
	}
	public void Matricular(){
		LinkedList<clsAsignatura> listAs=new LinkedList<clsAsignatura>();
		String idAs;
		int indxAs=-1;
		try{
			listAs=ges.ListaAsignaturas();
			ges.ComprobarVacio(listAs);
			System.out.println("Seleccione el ID de la asignatura para la que desea realizar la matrícula");
			do{
				for(clsAsignatura aux:listAs){
					System.out.println(aux.toString());
				}
				idAs=Utilidades.leerCadena();
				try{
					indxAs=ges.BuscarAsignatura(idAs);
				} catch (NoEncontradoException e){
					System.out.println(e.getMessage());
				} catch (IOException e){
					e.printStackTrace();
				}
			}
			while(indxAs==-1);
			clsAsignatura asig=listAs.get(indxAs);
			System.out.println("Ha seleccionado "+asig.toString());
			LinkedList<clsAlumno> listAl=new LinkedList<clsAlumno>();
			try{
				listAl=ges.ListaAlumnos();
				ges.ComprobarVacio(listAl);
				System.out.println("Ahora seleccione el alumno que desea matricular en dicha asignatura");
				String idAl;
				int indxAl=-1;
				do{
					for(clsAlumno aux:listAl){
						System.out.println(aux.toString());
					}
					idAl=Utilidades.leerCadena();
					try{
						indxAl=ges.BuscarAlumno(idAl);
					} catch (NoEncontradoException e){
						System.out.println(e.getMessage());
					} catch (IOException e){
						e.printStackTrace();
					}
				}
				while(indxAl==-1);
				clsAlumno alum=listAl.get(indxAl);
				clsMatricula nueva;
				try {
					nueva = ges.NuevaMatricula(alum, asig);
					System.out.println("Nueva matrícula creada: "+nueva.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DuplicadoException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			} catch(VacioException e){
				System.out.println(e.getMessage()+" (no hay alumnos dados de alta en el sistema)");
			} catch(IOException e){
				e.printStackTrace();
			}
			
		} catch (VacioException e){
			System.out.println(e.getMessage()+" (no hay asignaturas dadas de alta en el sistema)");
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
	public void Impartir(){
		LinkedList<clsAsignatura> listAs=new LinkedList<clsAsignatura>();
		try{
			String idAs;
			int indxAs=-1;
			listAs=ges.ListaAsignaturas();
			ges.ComprobarVacio(listAs);
			System.out.println("Seleccione el ID de la asignatura para la que desea realizar la asociación");
			do{
				for(clsAsignatura aux:listAs){
					System.out.println(aux.toString());
				}
				idAs=Utilidades.leerCadena();
				try{
					indxAs=ges.BuscarAsignatura(idAs);
				} catch (NoEncontradoException e){
					System.out.println(e.getMessage());
				} 
			}
			while(indxAs==-1);
			clsAsignatura asig=listAs.get(indxAs);
			System.out.println("Ha seleccionado "+asig.toString());
			LinkedList<clsProfesor> listPr=ges.ListaProfesores();
			try{
				ges.ComprobarVacio(listPr);
				System.out.println("Ahora seleccione el profesor que desea asociar a dicha asignatura");
				String idPr;
				int indxPr=-1;
				do{
					for(clsProfesor aux:listPr){
						System.out.println(aux.toString());
					}
					idPr=Utilidades.leerCadena();
					try{
						indxPr=ges.BuscarProfesor(idPr);
					} catch (NoEncontradoException e){
						System.out.println(e.getMessage());
					}
				}
				while(indxPr==-1);
				clsProfesor prof=listPr.get(indxPr);
				clsImparte nueva=ges.NuevaImparticion(prof, asig);
				System.out.println("Nueva matrícula creada: "+nueva.toString());
			} catch(VacioException e){
				System.out.println(e.getMessage()+" (no hay profesores dados de alta en el sistema)");
			}	
		} catch (DuplicadoException e){
			System.out.println(e.getMessage());
		} catch (IOException e){
			e.printStackTrace();
		} catch (VacioException e){
			System.out.println(e.getMessage()+" (no hay asignaturas dadas de alta en el sistema)");
		}
	}
	public void EliminarMatricula(){
		LinkedList<clsAlumno> lista=new LinkedList<clsAlumno>();
		try {
			lista=ges.ListaAlumnos();
			ges.ComprobarVacio(lista);
			System.out.println("Seleccione el ID del alumno cuya matrícula desea dar de baja del sistema");
			String idAl;
			int indxAl=-1;
			do{
				for(clsAlumno aux:lista){
					System.out.println(aux.toString());
				}
				idAl=Utilidades.leerCadena();
				try {
					indxAl=ges.BuscarAlumno(idAl);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoEncontradoException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			while(indxAl==-1);
			clsAlumno alum=lista.get(indxAl);
			LinkedList<clsAsignatura> asign=new LinkedList<clsAsignatura>();
			try {
				asign=ges.MatriculasAlumno(alum);
				ges.ComprobarVacio(asign);
				System.out.println("Introduzca el ID de la asignatura de la que quiere desmatricular a "+alum.toString());
				String idAs;
				int indxAs=-1;
				do{
					for(clsAsignatura aux:asign){
						System.out.println(aux.toString());
					}
					idAs=Utilidades.leerCadena();
					try {
						indxAs=ges.BuscarMatricula(idAs, alum);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoEncontradoException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				while(indxAs==-1);
				clsAsignatura asignatura=asign.get(indxAs);
				System.out.println("Ha decidido desmatricular a "+alum.toString()+" de la asignatura "+asignatura.toString());
				try {
					ges.BorrarMatricula(alum, asignatura);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (VacioException e){
				System.out.println(e.getMessage()+" (no hay asignaturas dadas de alta en el sistema)");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VacioException e){
			System.out.println(e.getMessage()+" (no hay alumnos dados de alta en el sistema)");
		}
		
	}
	public void BorrarImparticion(){
		LinkedList<clsAsignatura> asign=new LinkedList<clsAsignatura>();
		try {
			asign=ges.ListaAsignaturas();
			ges.ComprobarVacio(asign);
			System.out.println("Introduzca el ID de la asignatura a cuyo profesor quiere relevar");
			String idAs;
			int indxAs=-1;
			do{
				for(clsAsignatura aux:asign){
					System.out.println(aux.toString());
				}
				idAs=Utilidades.leerCadena();
				try {
					indxAs=ges.BuscarAsignatura(idAs);
				} catch (NoEncontradoException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				
			} while(indxAs==-1);
			clsAsignatura asignatura=asign.get(indxAs);
			try{
			clsProfesor prof=ges.BuscarImpartidor(asignatura);
			System.out.println("El profesor que imparte esta asignatura es "+prof.toString());
			ges.EliminarImparticion(asignatura, prof);
			System.out.println(prof.toString()+" ya no impartirá "+asignatura.toString());
			} catch (NoEncontradoException e){
				System.out.println("Esta asignatura no tiene ningún profesor que la imparta");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VacioException e) {
			System.out.println(e.getMessage()+"(no hay asignaturas dadas de alta en el sistema)");
		}
		
	}
	public void AlumnosAlf(){
		LinkedList<clsAlumno> lista;
		try {
			lista = ges.OrdenarAlm();
			ges.ComprobarVacio(lista);
			for(clsAlumno aux:lista){
				System.out.println(aux.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VacioException e){
			System.out.println(e.getMessage()+" (no hay alumnos dados de alta en el sistema)");
		}
	}
	public void ProfesoresAlf(){
		LinkedList<clsProfesor> lista;
		try{
			lista = ges.OrdenarProf();
			ges.ComprobarVacio(lista);
			for(clsProfesor aux:lista){
				System.out.println(aux.toString());
			}
		} catch (IOException e){
			e.printStackTrace();
		} catch (VacioException e){
			System.out.println(e.getMessage()+" (no hay profesores dados de alta en el sistema)");
		}
	}
	public void AlumnosFecha(){
		LinkedList<clsAlumno> lista;
		try{
			lista = ges.OrdenarPorFecha();
			ges.ComprobarVacio(lista);
			for(clsAlumno aux:lista){
				System.out.println(aux.toString()+". Año de matriculación: "+aux.getAno_matricula());
			}
		} catch (IOException e){
			e.printStackTrace();
		} catch (VacioException e){
			System.out.println(e.getMessage()+" (no hay alumnos dados de alta en el sistema)");
		}
	}
	public void ProfDepart(){
		LinkedList<clsProfesor> lista;
		try{
			lista = ges.OrdenarPorDepart();
			ges.ComprobarVacio(lista);
			for(clsProfesor aux:lista){
				System.out.println(aux.toString()+". Departamento: "+aux.getDepartamento());
			}
		} catch (IOException e){
			e.printStackTrace();
		} catch (VacioException e){
			System.out.println(e.getMessage()+" (no hay profesores dados de alta en el sistema)");
		}
	}
	/*public void ListaAlumnos(){
		LinkedList<clsAlumno> lista;
		try {
			lista = ges.ListaAlumnos();
			for(clsAlumno aux:lista){
				System.out.println(aux.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ListaProfesores(){
		LinkedList<clsProfesor> lista;
		try {
			lista = ges.ListaProfesores();
			for(clsProfesor aux:lista){
				System.out.println(aux.toString());
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	public void ListaMatriculas(){
		LinkedList<clsMatricula> lista;
		try {
			lista = ges.ListaMatriculas();
			for(clsMatricula aux:lista){
				System.out.println(aux.toString());
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	public void ListaImparte(){
		LinkedList<clsImparte> lista;
		try{
			lista = ges.ListaImparticiones();
			for(clsImparte aux: lista){
				System.out.println(aux.toString());
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}*/
}
