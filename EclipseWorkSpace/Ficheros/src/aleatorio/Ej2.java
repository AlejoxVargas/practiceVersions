package aleatorio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ej2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RandomAccessFile raf = null;
		int numero;

		try {
			raf = new RandomAccessFile("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\1.txt", "rw");
			long tamanno = raf.length();
			tamanno = tamanno / 4;
			System.out.println("Tamanoo: " + tamanno);
			System.out.println("Introducir nº para modificar entre 1 y " + tamanno + ":");
			int posicion = sc.nextInt();
			posicion--;
			raf.seek(posicion*4);

			System.out.println("Valor: " + raf.readInt());
			
			System.out.println("Introducir nuevo valor: ");
			numero = sc.nextInt();
			raf.seek(posicion*4);
			raf.writeInt(numero);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(raf != null ) {
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
