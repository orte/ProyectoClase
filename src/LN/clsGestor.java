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

public class clsGestor {
	
	clsDatos dat=new clsDatos();
	
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
	public int BuscarAlumno(String id) throws IOException, NoEncontradoException{
		int indx=-1;
		LinkedList<clsAlumno> lista=ListaAlumnos();
		for(clsAlumno aux:lista){
			if(aux.getId_alumno().equals(id)){
				indx=lista.indexOf(aux);
				break;
			}
		}
		if (indx==-1){
			throw new NoEncontradoException();
		}
		return indx;
	}
	public void ModificarAlumno(clsAlumno alumno, String nom, String ap1, String ap2, String id, int fecha) throws ParseException, IOException, DuplicadoException{
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
	public int BuscarProfesor(String id) throws IOException, NoEncontradoException{
		int indx=-1;
		LinkedList<clsProfesor> lista=ListaProfesores();
		for(clsProfesor aux:lista){
			if(aux.getId_profesor().equals(id)){
				indx=lista.indexOf(aux);
				break;
			}
		}
		if(indx==-1){
			throw new NoEncontradoException();
		}
		return indx;
	}
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
	public int BuscarAsignatura(String id) throws IOException, NoEncontradoException{
		int indx=-1;
		LinkedList<clsAsignatura> lista=ListaAsignaturas();
		for(clsAsignatura aux:lista){
			if(aux.getId_asinatura().equals(id)){
				indx=lista.indexOf(aux);
				break;
			}
		}
		if(indx==-1){
			throw new NoEncontradoException();
		}
		return indx;
	}
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
			try {
				indx=BuscarAsignatura(aux);
				lista.add(asig.get(indx));
			} catch (NoEncontradoException e) {
				
			}
		}
		return lista;
	}
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
	public int BuscarMatricula(String id, clsAlumno alm) throws IOException, NoEncontradoException{
		int indx=-1;
		LinkedList<clsAsignatura> lista=MatriculasAlumno(alm);
		for(clsAsignatura aux:lista){
			if(aux.getId_asinatura().equals(id)){
				indx=lista.indexOf(aux);
			}
		}
		if(indx==-1){
			throw new NoEncontradoException();
		}
		return indx;
	}
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
	public clsImparte NuevaImparticion(clsProfesor prof, clsAsignatura asig) throws IOException, DuplicadoException{
		clsImparte nuevo=new clsImparte();
		nuevo.setId_profesor(prof.getId_profesor());
		nuevo.setId_asignatura(asig.getId_asinatura());
		LinkedList<clsImparte> lista=ListaImparticiones();
		HashSet<clsImparte> set=new HashSet<clsImparte>();
		set.addAll(lista);
		if(set.add(nuevo)==false){
			throw new DuplicadoException();
		}
		else{
			enFicDatos f=enFicDatos.DAT_IMPARTICIONES;
			dat.ComenzarSave(f);
			dat.Save(nuevo);
			dat.TerminarSave();
		}
		return nuevo;
	}
	public clsProfesor BuscarImpartidor(clsAsignatura asig) throws IOException, NoEncontradoException{
		clsProfesor prof=new clsProfesor();
		String id=null;
		LinkedList<clsImparte> lista=ListaImparticiones();
		for(clsImparte aux:lista){
			if(aux.getId_asignatura().equals(asig.getId_asinatura())){
				id=aux.getId_profesor();
			}
		}
		if(id==null){
			throw new NoEncontradoException();
		}
		LinkedList<clsProfesor> profes=ListaProfesores();
		try {
			prof=profes.get(BuscarProfesor(id));
		} catch (NoEncontradoException e) {
			
		}
		return prof;
	}
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
	public LinkedList<clsAlumno> OrdenarPorFecha() throws IOException{
		LinkedList<clsAlumno> lista=ListaAlumnos();
		Collections.sort(lista, new ComparatorAño());
		return lista;
	}
	public LinkedList<clsProfesor> OrdenarPorDepart() throws IOException{
		LinkedList<clsProfesor> lista=ListaProfesores();
		Collections.sort(lista, new ComparatorDepart());
		return lista;
	}
	public void ComprobarVacio(LinkedList<?> lista) throws VacioException{
		if (lista.isEmpty()){
			throw new VacioException();
			
		}
	}
	
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
