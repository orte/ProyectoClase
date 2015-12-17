package LN;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import LD.clsDatos;
import comun.*;
import comun.clsConstantes.enFicDatos;

/**
 * clase gestor que har� todas las operaciones, haciendo de intermediario entre la LD y la LP
 * @author jon.orte
 *
 */
public class clsGestor {
	
	clsDatos dat=new clsDatos();
	
	/**
	 * M�todo que llama a la l�gica de datos para recibir una lista con los alumnos guardados en ficheros
	 * @author jon.orte
	 * @return LinkedList<clsAlumnos> con los alumnos guardados
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public LinkedList<clsAlumno> ListaAlumnos() throws IOException{
		LinkedList<clsAlumno> lista=new LinkedList<clsAlumno>();
		enFicDatos f=enFicDatos.DAT_ALUMNOS;
		dat.ComenzarRead(f);
		LinkedList<Serializable> temp=dat.Read();
		dat.TerminarRead();
		for(Serializable aux:temp){
			lista.add((clsAlumno)aux);
		}
		return lista;
	}
	/**
	 * M�todo que recibe una serie de atributos con los que crear� un nuevo objeto de la clase Alumno y 
	 * despu�s de comprobar si est� duplicado lo guardar� en un fichero
	 * @author jon.orte
	 * @param nom: nombre	
	 * @param ap1: primer apellido
	 * @param ap2: segundo apellido
	 * @param DNI: ID del alumno
	 * @param fecha: a�o de matriculaci�n
	 * @return clsAlumno creado con los atributos recibidos
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 * @throws DuplicadoException excepci�n lanzada en el caso de que el alumno creado est� duplicado
	 */
	public clsAlumno nuevoAlumno(String nom, String ap1, String ap2, String DNI, int fecha) throws IOException, DuplicadoException{
		clsAlumno nuevo=new clsAlumno();
		nuevo.setNombre(nom);
		nuevo.setAp1(ap1);
		nuevo.setAp2(ap2);
		nuevo.setId_alumno(DNI);
		nuevo.setAno_matricula(fecha);
		LinkedList<clsAlumno> temp=ListaAlumnos();
		HashSet<clsAlumno> set=new HashSet<clsAlumno>();
		set.addAll(temp);
		if (set.add(nuevo)==false){
			DuplicadoException e=new DuplicadoException();
			throw e;
		}
		else{
			enFicDatos f=enFicDatos.DAT_ALUMNOS;
			dat.ComenzarSave(f);
			dat.Save(nuevo);
			dat.TerminarSave();
			return nuevo;
		}
	}
	/**
	 * M�todo que recibe un ID de un alumno, lo busca entre los que est�n guardados en el fichero de alumnos
	 * y devuelve un int indicando el �ndice de la lista de alumnos donde se encuentra el alumno con ese ID
	 * @author jon.orte
	 * @param ID: id del alumno buscado
	 * @return int con el �ndice de la lista donde est� el alumno
	 * @throws IOException
	 */
	public int BuscarAlumno(String id) throws IOException{
		int indx=-1;
		LinkedList<clsAlumno> lista=ListaAlumnos();
		for(clsAlumno aux:lista){
			if(aux.getId_alumno().equals(id)){
				indx=lista.indexOf(aux);
				break;
			}
		}
		return indx;
	}
	/**
	 * M�todo que recibe un alumno que va a ser modificado y una serie de atributos, que son 
	 * asignados a ese alumno y guardados en el fichero correspondiente
	 * @author jon.orte
	 * @param alumno: objeto de la clase alumno que se desea modificar
	 * @param nom: nombre modificado
	 * @param ap1: primer apellido modificado
	 * @param ap2: segundo apellido modificado
	 * @param id: ID del alumno modificado
	 * @param fecha: fecha de matriculaci�n modificada
	 * @throws IOException: excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 * @throws DuplicadoException: excepci�n lanzada si el ID modificado coincide con el de alg�n alumno guardado anteriormente
	 */
	public void ModificarAlumno(clsAlumno alumno, String nom, String ap1, String ap2, String id, int fecha) throws IOException, DuplicadoException{
		LinkedList<clsAlumno> lista=ListaAlumnos();
		HashSet<clsAlumno> set=new HashSet<clsAlumno>();
		set.addAll(lista);
		set.remove(alumno);
		int indx=lista.indexOf(alumno);
		alumno.setNombre(nom);
		alumno.setAp1(ap1);
		alumno.setAp2(ap2);
		alumno.setId_alumno(id);
		alumno.setAno_matricula(fecha);
		if(set.add(alumno)==false){
			throw new DuplicadoException();
		} else{
			lista.set(indx, alumno);
			enFicDatos f=enFicDatos.DAT_ALUMNOS;
			dat.ResetFile(f);
			dat.ComenzarSave(f);
			for(clsAlumno aux:lista){
				dat.Save(aux);
			}
			dat.TerminarSave();
		}
		
	}
	/**
	 * M�todo que recibe un alumno y lo elimina del fichero de alumnos
	 * @author jon.orte
	 * @param alumno: alumno que se desea eliminar
	 * @throws IOException: excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public void BorrarAlumno(clsAlumno alumno) throws IOException{
		LinkedList<clsAlumno> lista=ListaAlumnos();
		lista.remove(alumno);
		enFicDatos f=enFicDatos.DAT_ALUMNOS;
		dat.ResetFile(f);
		dat.ComenzarSave(f);
		for(clsAlumno aux:lista){
			dat.Save(aux);
		}
		dat.TerminarSave();
	}
	/**
	 * M�todo que llama a la l�gica de datos para recibir una lista con los profesores guardados en ficheros
	 * @author jon.orte
	 * @return LinkedList<clsProfesor> con los profesores guardados
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public LinkedList<clsProfesor> ListaProfesores() throws IOException{
		LinkedList<clsProfesor> lista=new LinkedList<clsProfesor>();
		enFicDatos f=enFicDatos.DAT_PROFESORES;
		dat.ComenzarRead(f);
		LinkedList<Serializable> temp=dat.Read();
		dat.TerminarRead();
		for(Serializable aux:temp){
			lista.add((clsProfesor)aux);
		}
		return lista;
	}
	
	/**
	 * M�todo que recibe una serie de atributos con los que crear� un nuevo objeto de la clase Profesor y 
	 * despu�s de comprobar si est� duplicado lo guardar� en un fichero
	 * @author jon.orte
	 * @param nom: nombre	
	 * @param ap1: primer apellido
	 * @param ap2: segundo apellido
	 * @param DNI: ID del profesor
	 * @param depart: departamento del profesor
	 * @return clsProfesor creado con los atributos recibidos
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 * @throws DuplicadoException excepci�n lanzada en el caso de que el profesor creado est� duplicado
	 */
	public clsProfesor nuevoProfesor(String nom, String ap1, String ap2, String DNI, String depart) throws IOException, DuplicadoException{
		clsProfesor nuevo=new clsProfesor();
		nuevo.setNombre(nom);
		nuevo.setAp1(ap1);
		nuevo.setAp2(ap2);
		nuevo.setId_profesor(DNI);
		nuevo.setDepartamento(depart);
		LinkedList<clsProfesor> temp=ListaProfesores();
		HashSet<clsProfesor> set=new HashSet<clsProfesor>();
		set.addAll(temp);
		if (set.add(nuevo)==false){
			DuplicadoException e=new DuplicadoException();
			throw e;
		}
		else{
			enFicDatos f=enFicDatos.DAT_PROFESORES;
			dat.ComenzarSave(f);
			dat.Save(nuevo);
			dat.TerminarSave();
			return nuevo;
		}
	}
	/**
	 * M�todo que recibe un ID de un profesor, lo busca entre los que est�n guardados en el fichero de profesores
	 * y devuelve un int indicando el �ndice de la lista de profesore donde se encuentra el profesor con ese ID
	 * @author jon.orte
	 * @param ID: id del profesor buscado
	 * @return int con el �ndice de la lista donde est� el profesor
	 * @throws IOException
	 */
	public int BuscarProfesor(String id) throws IOException{
		int indx=-1;
		LinkedList<clsProfesor> lista=ListaProfesores();
		for(clsProfesor aux:lista){
			if(aux.getId_profesor().equals(id)){
				indx=lista.indexOf(aux);
				break;
			}
		}
		return indx;
	}
	/**
	 * M�todo que recibe un profesor que va a ser modificado y una serie de atributos, que son 
	 * asignados a ese profesor y guardados en el fichero correspondiente
	 * @author jon.orte
	 * @param prof: objeto de la clase profesor que se desea modificar
	 * @param nom: nombre modificado
	 * @param ap1: primer apellido modificado
	 * @param ap2: segundo apellido modificado
	 * @param id: ID del profesor modificado
	 * @param depart: departamento modificado
	 * @throws IOException: excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 * @throws DuplicadoException: excepci�n lanzada si el ID modificado coincide con el de alg�n profesor 
	 * guardado anteriormente
	 */
	public void ModificarProfesor(clsProfesor prof, String nom, String ap1, String ap2, String id, String depart) throws IOException, DuplicadoException{
		LinkedList<clsProfesor> lista=ListaProfesores();
		HashSet<clsProfesor> set=new HashSet<clsProfesor>();
		set.addAll(lista);
		set.remove(prof);
		int indx=lista.indexOf(prof);
		prof.setNombre(nom);
		prof.setAp1(ap1);
		prof.setAp2(ap2);
		prof.setId_profesor(id);
		prof.setDepartamento(depart);
		if(set.add(prof)==false){
			throw new DuplicadoException();
		} else{
			lista.set(indx, prof);
			enFicDatos f=enFicDatos.DAT_PROFESORES;
			dat.ResetFile(f);
			dat.ComenzarSave(f);
			for(clsProfesor aux:lista){
				dat.Save(aux);
			}
			dat.TerminarSave();
		}
	}
	/**
	 * M�todo que recibe un profesor y lo elimina del fichero de profesores
	 * @author jon.orte
	 * @param prof: profesor que se desea eliminar
	 * @throws IOException: excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public void BorrarProfesor(clsProfesor prof) throws IOException{
		LinkedList<clsProfesor> lista=ListaProfesores();
		lista.remove(prof);
		enFicDatos f=enFicDatos.DAT_PROFESORES;
		dat.ResetFile(f);
		dat.ComenzarSave(f);
		for(clsProfesor aux:lista){
			dat.Save(aux);
		}
		dat.TerminarSave();
	}
	/**
	 * M�todo que llama a la l�gica de datos para recibir una lista con las asignaturas guardadas en ficheros
	 * @author jon.orte
	 * @return LinkedList<clsAsignatura> con las asignaturas guardadas
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public LinkedList<clsAsignatura> ListaAsignaturas() throws IOException{
		LinkedList<clsAsignatura> lista=new LinkedList<clsAsignatura>();
		enFicDatos f=enFicDatos.DAT_ASIGNATURAS;
		dat.ComenzarRead(f);
		LinkedList<Serializable> temp=dat.Read();
		dat.TerminarRead();
		for(Serializable aux:temp){
			lista.add((clsAsignatura)aux);
		}
		return lista;
	}
	/**
	 * M�todo que recibe una serie de atributos con los que crear� un nuevo objeto de la clase asignatura y 
	 * despu�s de comprobar si est� duplicado lo guardar� en un fichero
	 * @author jon.orte
	 * @param nombre: nombre	
	 * @param desc: descripci�n
	 * @param id: id de la asignatura
	 * @param num_cred: n�mero de cr�ditos
	 * @return clsAsignatura creado con los atributos recibidos
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 * @throws DuplicadoException excepci�n lanzada en el caso de que la asignatura creada est� duplicada
	 */
	public clsAsignatura NuevaAsignatura(String nombre, String desc, String id, int num_cred) throws IOException, DuplicadoException{
		clsAsignatura nueva=new clsAsignatura();
		nueva.setNombre(nombre);
		nueva.setDescripcion(desc);
		nueva.setId_asinatura(id);
		nueva.setNum_creditos(num_cred);
		LinkedList<clsAsignatura> lista=ListaAsignaturas();
		HashSet<clsAsignatura> set=new HashSet<clsAsignatura>();
		set.addAll(lista);
		if(set.add(nueva)==false){
			throw new DuplicadoException();
		}
		else{
			enFicDatos f=enFicDatos.DAT_ASIGNATURAS;
			dat.ComenzarSave(f);
			dat.Save(nueva);
			dat.TerminarSave();
		}
		return nueva;
	}
	/**
	 * M�todo que recibe un ID de una asignatura, la busca entre las que est�n guardados en el fichero de asignaturas
	 * y devuelve un int indicando el �ndice de la lista de asignaturas donde se encuentra la asignatura con ese ID
	 * @author jon.orte
	 * @param id: id de la asignatura
	 * @return int con el �ndice de la lista donde se encuentra la asignatura buscada
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public int BuscarAsignatura(String id) throws IOException{
		int indx=-1;
		LinkedList<clsAsignatura> lista=ListaAsignaturas();
		for(clsAsignatura aux:lista){
			if(aux.getId_asinatura().equals(id)){
				indx=lista.indexOf(aux);
				break;
			}
		}
		return indx;
	}
	/**
	 * M�todo que llama a la l�gica de datos para recibir una lista con las matr�culas guardadas en ficheros
	 * @author jon.orte
	 * @return LinkedList<clsMatricula> con las matr�culas guardadas
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public LinkedList<clsMatricula> ListaMatriculas() throws IOException{
		LinkedList<clsMatricula> lista=new LinkedList<clsMatricula>();
		enFicDatos f=enFicDatos.DAT_MATRICULAS;
		dat.ComenzarRead(f);
		LinkedList<Serializable> temp=dat.Read();
		dat.TerminarRead();
		for(Serializable aux:temp){
			lista.add((clsMatricula)aux);
		}
		return lista;
	}
	/**
	 * M�todo que recibe un objeto de clase alumno y que devuelve una lista con todas las as�gnaturas
	 * en las que est� matriculado
	 *
	 * @author jon.orte
	 * @param alm: alumno del que se quieren obtener las matr�culas
	 * @return: LinkedList<clsAsignatura> con las asignaturas en las que est� matriculado
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public LinkedList<clsAsignatura> MatriculasAlumno(clsAlumno alm) throws IOException{
		LinkedList<clsAsignatura> lista=new LinkedList<clsAsignatura>();
		LinkedList<clsMatricula> matr=ListaMatriculas();
		LinkedList<String> IDs=new LinkedList<String>();
		for(clsMatricula aux:matr){
			if(aux.getId_alumno().equals(alm.getId_alumno())){
				IDs.add(aux.getId_asignatura());
			}
		}
		LinkedList<clsAsignatura> asig=ListaAsignaturas();
		int indx;
		for(String aux:IDs){
				indx=BuscarAsignatura(aux);
				lista.add(asig.get(indx));
		}
		return lista;
	}
	/**
	 * Se recibe un alumno y una asignatura y con el ID de ambos se crea un nuevo objeto de la clase matr�cula
	 * que relaciona ambos y se guarda en el fichero correspondiente
	 *
	 * @author jon.orte
	 * @param alum: alumno que va a ser matriculado
	 * @param asig: asignatura en la que se va a hacer la matr�cula
	 * @return: clsMatricula con la nueva matr�cula creada
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 * @throws DuplicadoException excepci�n lanzada en caso de que la matr�cula creada ya exista
	 */
	public clsMatricula NuevaMatricula(clsAlumno alum, clsAsignatura asig) throws IOException, DuplicadoException{
		clsMatricula nueva=new clsMatricula();
		nueva.setId_alumno(alum.getId_alumno());
		nueva.setId_asignatura(asig.getId_asinatura());
		LinkedList<clsMatricula> lista=ListaMatriculas();
		HashSet<clsMatricula> set=new HashSet<clsMatricula>();
		set.addAll(lista);
		if(set.add(nueva)==false){
			throw new DuplicadoException();
		}
		else{
			enFicDatos f=enFicDatos.DAT_MATRICULAS;
			dat.ComenzarSave(f);
			dat.Save(nueva);
			dat.TerminarSave();
		}
		return nueva;
	}
	/**
	 * M�todo que recibe un ID de una asignatura y un alumno, llama al m�todo MatriculasAlumno para recibir la lista
	 * de asignaturas a la que est� matriculado y busca el id recibido con los de la lista para, si coincide con alguno
	 * devolver el �ndice de la lista donde est� la asignatura
	 * @author jon.orte
	 * @param id: id de la asignatura
	 * @param alm: alumno cuyas matr�culas se van a buscar
	 * @return int con el �ndice de la lista donde se encuentra la asignatura buscada
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public int BuscarMatricula(String id, clsAlumno alm) throws IOException{
		int indx=-1;
		LinkedList<clsAsignatura> lista=MatriculasAlumno(alm);
		for(clsAsignatura aux:lista){
			if(aux.getId_asinatura().equals(id)){
				indx=lista.indexOf(aux);
			}
		}
		return indx;
	}
	/**
	 * Se recibe una matr�cula por parametro y se borra del fichero correspondiente
	 * @author jon.orte
	 * @param borr: matr�cula que se quiere borrar
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public void BorrarMatricula(clsMatricula borr) throws IOException{
		LinkedList<clsMatricula> lista=ListaMatriculas();
		lista.remove(borr);
		enFicDatos f=enFicDatos.DAT_MATRICULAS;
		dat.ResetFile(f);
		dat.ComenzarSave(f);
		for(clsMatricula aux:lista){
			dat.Save(aux);
		}
		dat.TerminarSave();
	}
	/**
	 M�todo que llama a la l�gica de datos para recibir una lista con las imparticiones guardadas en ficheros
	 * @author jon.orte
	 * @return LinkedList<clsImparte> con las imparticiones guardadas
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public LinkedList<clsImparte> ListaImparticiones() throws IOException{
		LinkedList<clsImparte> lista=new LinkedList<clsImparte>();
		enFicDatos f=enFicDatos.DAT_IMPARTICIONES;
		dat.ComenzarRead(f);
		LinkedList<Serializable> temp=dat.Read();
		dat.TerminarRead();
		for(Serializable aux:temp){
			lista.add((clsImparte)aux);
		}
		return lista;
	}
	/**
	 * Se recibe un profesor y una asignatura y con el ID de ambos se crea un nuevo objeto de la clase imparte
	 * que relaciona ambos y se guarda en el fichero correspondiente
	 *
	 * @author jon.orte
	 * @param prof: profesor que va a impartir la asignatura
	 * @param asig: asignatura que va a ser impartida
	 * @return: clsImparte con la nueva impartici�n creada
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public clsImparte NuevaImparticion(clsProfesor prof, clsAsignatura asig) throws IOException{
		clsImparte nuevo=new clsImparte();
		nuevo.setId_profesor(prof.getId_profesor());
		nuevo.setId_asignatura(asig.getId_asinatura());
		enFicDatos f=enFicDatos.DAT_IMPARTICIONES;
		dat.ComenzarSave(f);
		dat.Save(nuevo);
		dat.TerminarSave();
		
		return nuevo;
	}
	/**
	 * M�todo que recibe una asignatura y busca en los ficheros al profesor que la imparte
	 *
	 * @author jon.orte
	 * @param asig: asignatura cuyo profesor se quiere buscar
	 * @return clsProfesor con el profesor que imparte dicha asignatura
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public clsProfesor BuscarImpartidor(clsAsignatura asig) throws IOException{
		clsProfesor prof=new clsProfesor();
		String id=null;
		LinkedList<clsImparte> lista=ListaImparticiones();
		for(clsImparte aux:lista){
			if(aux.getId_asignatura().equals(asig.getId_asinatura())){
				id=aux.getId_profesor();
			}
		}
		LinkedList<clsProfesor> profes=ListaProfesores();		
		prof=profes.get(BuscarProfesor(id));
		return prof;
	}
	/**
	 * M�todo que recibe un objeto de la clase imparte y lo borra de su respectivo fichero
	 *
	 * @author jon.orte
	 * @param borr: Impartici�n que se desea borrar
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public void EliminarImparticion(clsImparte borr) throws IOException{
		LinkedList<clsImparte> lista=ListaImparticiones();
		lista.remove(borr);
		enFicDatos f=enFicDatos.DAT_IMPARTICIONES;
		dat.ResetFile(f);
		dat.ComenzarSave(f);
		for(clsImparte aux:lista){
			dat.Save(aux);
		}
		dat.TerminarSave();
	}
	/**
	 * m�todo que devuelve la lista de alumnos guardados en ficheros ordenada alfab�ticamente por apellido
	 *
	 * @author jon.orte
	 * @return LinkedList<clsAlumno> ordenada alfab�ticamente
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public LinkedList<clsAlumno> OrdenarAlm() throws IOException{
		LinkedList<clsAlumno> lista=ListaAlumnos();
		for(int i=0; i<lista.size(); i++){
			for(int j=0; j<lista.size()-1; j++){
				clsAlumno temp=null;
				if(lista.get(i).compareTo(lista.get(j))<0){
					temp=lista.get(i);
					lista.set(i, lista.get(j));
					lista.set(j, temp);
				}
			}
		}
		return lista;
	}
	/**
	 * M�todo que devuelve la lista de los profesores guardados en ficheros ordenada alfab�ticamente por apellido
	 *
	 * @author jon.orte
	 * @return LinkedList<clsProfesor> de los profesores ordenada alfab�ticamente
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public LinkedList<clsProfesor> OrdenarProf() throws IOException{
		LinkedList<clsProfesor> temp=ListaProfesores();
		TreeSet<clsProfesor> tree=new TreeSet<clsProfesor>();
		tree.addAll(temp);
		LinkedList<clsProfesor> lista=new LinkedList<clsProfesor>();
		for(clsProfesor aux:tree){
			lista.add(aux);
		}
		return lista;
	}
	/**
	 * m�todo que devuelve la lista de alumnos guardados en ficheros ordenada por fecha de matriculaci�n
	 *
	 * @author jon.orte
	 * @return LinkedList<clsAlumno> ordenada por fecha de matriculaci�n
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public LinkedList<clsAlumno> OrdenarPorFecha() throws IOException{
		LinkedList<clsAlumno> lista=ListaAlumnos();
		Collections.sort(lista, new ComparatorA�o());
		return lista;
	}
	/**
	 * m�todo que devuelve la lista de profesores guardados en ficheros ordenada por departamento
	 *
	 * @author jon.orte
	 * @return LinkedList<clsProfesor> ordenada por departamento
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public LinkedList<clsProfesor> OrdenarPorDepart() throws IOException{
		LinkedList<clsProfesor> lista=ListaProfesores();
		Collections.sort(lista, new ComparatorDepart());
		return lista;
	}
	/**
	 * M�todo que recibe una lista y comprueba si est� vac�a. Si lo est� lanza una excepci�n
	 *
	 * @author jon.orte
	 * @param lista: lista que se quiere comprobar si est� vac�a
	 * @throws VacioException excepci�n lanzada si la lista est� vac�a
	 */
	public void ComprobarVacio(LinkedList<?> lista) throws VacioException{
		if (lista.isEmpty()){
			throw new VacioException();
			
		}
	}
	/**
	 * m�todo que devuelve un mapa de los alumnos guardados en ficheros ordenado alfab�ticamente por apellido
	 * @author jon.orte
	 * @return Map<Integer, clsAlumno> ordenada alfab�ticamente
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public Map<Integer, clsAlumno> MapaAlmAlf() throws IOException{
		LinkedList<clsAlumno> l;
		l=OrdenarAlm();
		Map<Integer, clsAlumno> mapa=new TreeMap<Integer, clsAlumno>();
		for (int i=0; i<l.size(); i++){
			clsAlumno c=l.get(i);
			mapa.put(i, c);
		}
		return mapa;
	}
	/**
	 * M�todo que devuelve un mapa de los alumnos guardados en ficheros ordenado por a�o de matriculaci�n
	 *
	 * @author jon.orte
	 * @return Map<Integer, clsAlumno> ordenado
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public Map<Integer, clsAlumno> MapaAlmYear() throws IOException{
		LinkedList<clsAlumno> l;
		l=OrdenarPorFecha();
		Map<Integer, clsAlumno> mapa=new TreeMap<Integer, clsAlumno>();
		for (int i=0; i<l.size(); i++){
			clsAlumno c=l.get(i);
			mapa.put(i, c);
		}
		return mapa;
	}
	/**
	 * m�todo que devuelve un mapa de los profesores guardados en ficheros ordenado alfab�ticamente por apellido
	 * @author jon.orte
	 * @return Map<Integer, clsProfesor> ordenado alfab�ticamente
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public Map<Integer, clsProfesor> MapaProfAlf() throws IOException{
		LinkedList<clsProfesor> l;
		l=OrdenarProf();
		Map<Integer, clsProfesor> mapa=new TreeMap<Integer, clsProfesor>();
		for (int i=0; i<l.size(); i++){
			clsProfesor c=l.get(i);
			mapa.put(i, c);
		}
		return mapa;
	}
	/**
	 * m�todo que devuelve un mapa de los profesores guardados en ficheros ordenado por departamento
	 * @author jon.orte
	 * @return Map<Integer, clsProfesor> ordenado
	 * @throws IOException excepci�n lanzada en caso de que se d� un error de lectura/escritura en fichero
	 */
	public Map<Integer, clsProfesor> MapaProfDept() throws IOException{
		LinkedList<clsProfesor> l;
		l=OrdenarPorDepart();
		Map<Integer, clsProfesor> mapa=new TreeMap<Integer, clsProfesor>();
		for (int i=0; i<l.size(); i++){
			clsProfesor c=l.get(i);
			mapa.put(i, c);
		}
		return mapa;
	}
}
