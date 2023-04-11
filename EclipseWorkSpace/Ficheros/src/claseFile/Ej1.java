package claseFile;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Ej1 implements FilenameFilter {

	public static void main(String[] args) {

		File miFich = new File("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\Ficheros");
		File miFich2 = new File("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\Ficheros\\f2-renombrado.txt");
		File miDir = new File("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\Ficheros\\Ficheros1");
		File miDir2 = new File("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\Ficheros\\Programacion\\POO1\\POO2\\POO3");

		// De esta manera puedo crear varios directios dentro de otro

		File miDir_varios = new File("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\Ficheros2");
		File miDir_varios2 = new File(miDir_varios, "d1");
		File miDir_varios3 = new File(miDir_varios, "d2");
		File miDir_varios4 = new File(miDir_varios, "d3");

		miDir_varios.mkdir();
		miDir_varios2.mkdir();
		miDir_varios3.mkdir();
		miDir_varios4.mkdir();

		try {
			if (miFich.createNewFile()) {
				System.out.println("Creado: " + miFich.getName());
			} else {
				System.err.println("No se puede crear");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (miFich.renameTo(miFich2)) {
			System.out.println("Renombrado fichero a: " + miFich2.getAbsolutePath());
		}

		if (!miDir2.exists()) { // preguntar si no existe
			if (miDir2.mkdirs()) { // si no existe el directorio crealo
				System.out.println("Directorio: " + miDir2.getName() + " creado");
			} else {
				System.out.println("No se ha creado");
			}
		} else

		{
			System.out.println("ya existe");
		}

		if (miDir2.delete()) {
			System.out.println("Fichero: " + miFich.getName() + " eliminado");
		} else {
			System.out.println("No se ha podido eliminar el fichero");
		}

		File[] ficheros;

		ficheros = miDir_varios.listFiles(); //buscar mas de esto que no me ha salido
		for (File f : ficheros) {
			if (f.isFile()) {
			System.out.println("Fichero: ");
			}
			System.out.println(f.getAbsolutePath());
		}		
		
		/*Filtrar*/
		
		System.out.println("Listar con filtro: ");
		String [] nomFicheros;
		nomFicheros = miDir.list(new Ej1(".txt")); //llamar a list pero pasandole ya una extension
		for(String f : nomFicheros) {
			System.out.println(f);
		}
	}
	
	String extension;
	
	@Override //aqui le vamos a pasar es la extension del filtro, retorna verdadero si el nombre acaba con esa extension
	public boolean accept(File dir, String name) {
		return name.endsWith(extension);
	}
	
	Ej1(String extension){
		this.extension = extension;
	}
}
