package LD;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

import comun.clsConstantes.enFicDatos;

public class clsDatos implements itfDatos{
	
	private final String RUTA_ALUMNOS="src\\dat\\alumnos.dat";
	private final String RUTA_PROFESORES="src\\dat\\profesores.dat";
	private final String RUTA_ASIGNATURAS="src\\dat\\asignaturas.dat";
	private final String RUTA_MATRICULAS="src\\dat\\matriculas.dat";
	private final String RUTA_IMPARTICIONES="src\\dat\\imparticiones.dat";
	
	
	ObjectOutputStream oos;
	AppendableObjectOutputStream aoos;
	ObjectInputStream ois;
	FileOutputStream fos;
	FileInputStream fis;

	public String setFichero(enFicDatos fic){
		String ruta=null;
		switch (fic){
		case DAT_ALUMNOS: ruta = RUTA_ALUMNOS; break;
		case DAT_PROFESORES: ruta = RUTA_PROFESORES; break;
		case DAT_ASIGNATURAS: ruta = RUTA_ASIGNATURAS; break;
		case DAT_MATRICULAS: ruta = RUTA_MATRICULAS; break;
		case DAT_IMPARTICIONES: ruta = RUTA_IMPARTICIONES; break;
		}
		return ruta;
	}
	
	@Override
	public void ComenzarSave(enFicDatos fichero) {
		// TODO Auto-generated method stub
		String ruta=setFichero(fichero);
		File archivo=new File(ruta);
		
		if(archivo.exists()){
			try {
				fos = new FileOutputStream(ruta, true);
				aoos=new AppendableObjectOutputStream(fos);	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try{
				fos=new FileOutputStream(ruta);	
				oos=new ObjectOutputStream(fos);
			} catch (IOException e){
				e.printStackTrace();
			}			
		}
	}
	@Override
	public void TerminarSave() {
		// TODO Auto-generated method stub
		try {
			if (oos==null){
				aoos.close();
				fos.close();
				aoos=null;
			}
			else if(aoos==null){
				oos.close();
				fos.close();
				oos=null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Save(Serializable o) {
		// TODO Auto-generated method stub
		try{
			if (aoos!=null){
				aoos.writeObject(o);
			}
			else if(oos!=null){
				oos.writeObject(o);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	@Override
	public void ComenzarRead(enFicDatos fichero) throws IOException {
		String ruta=setFichero(fichero);
		try{
			fis=new FileInputStream(ruta);
			ois=new ObjectInputStream(fis);
		} catch (FileNotFoundException e){
			ComenzarSave(fichero);
			TerminarSave();
			try {
				fis=new FileInputStream(ruta);
				ois=new ObjectInputStream(fis);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (IOException e){
			e.printStackTrace();
			
		}			
	}

	@Override
	public void TerminarRead() {
		try {
			ois.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public LinkedList<Serializable> Read() {
		LinkedList<Serializable> lista=new LinkedList<Serializable>();
		try {
			boolean ver=true;
			while(ver==true){
				try{
					Serializable obj=(Serializable) ois.readObject();
					lista.add(obj);
				} catch (EOFException e){
					ver=false;
				}
			} 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return lista;
	}

	@Override
	public void ResetFile(enFicDatos fichero) {
		String ruta=setFichero(fichero);
		File fich=new File(ruta);
		fich.delete();
		
	}

}