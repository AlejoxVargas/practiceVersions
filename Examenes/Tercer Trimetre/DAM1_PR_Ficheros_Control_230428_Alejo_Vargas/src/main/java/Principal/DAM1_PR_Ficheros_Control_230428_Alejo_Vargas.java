package Principal;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DAM1_PR_Ficheros_Control_230428_Alejo_Vargas {
    static Scanner sc = new Scanner(System.in);
    static ObjectOutputStream escribiendo;
    static ObjectInputStream leyendo;

    //Instancias globales de ObjectStream para leer y escribir
    static {
        try {
            escribiendo = new ObjectOutputStream(new FileOutputStream("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\objetos.dat"));
            leyendo = new ObjectInputStream(new FileInputStream("C:\\Users\\ALUMNO CCC - TARDE\\Desktop\\objetos.dat"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        int menu;
        boolean llave = true;
        do {
            menu = opcionMenu();
            switch (menu) {
                case 1:
                    CrearExamen();
                case 2:
                    //TomarExamen(preguntas);
            }
        } while (menu != 0);
    }

    public static int opcionMenu() {
        int menu = 0;
        boolean valido = false;
        do {
            try {
                System.out.println("""
                         _____MENU_____
                        1. Crear Examen
                        2. Tomar Examen
                        0. Salir""");
                menu = sc.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Opcición no valida " + e.getMessage());
            }
        } while (!valido);
        return menu;
    }

    public static void Mostrar() {
        // Leer los datos de los examenes desde el fichero
        try {
            Preguntas[] preguntasLeidas = (Preguntas[]) leyendo.readObject();
            for (int i = 0; i < preguntasLeidas.length; i++) {
                System.out.println(preguntasLeidas[i].toString());
                preguntasLeidas[i].getRespuetas();
            }
        } catch (IOException | ClassNotFoundException e) {
            // Fin de fichero alcanzado, no hay más objetos
            System.err.println("Error al leer del fichero: " + e.getMessage());
        }
    }


    private static void CrearExamen() {
        //Se pide al usuario la cantidad de preguntas para el examen
        System.out.println("Cantidad de preguntas a crear: ");
        Preguntas[] preguntas = new Preguntas[sc.nextInt()];

        System.out.println("Nombre del examen: ");
        sc.nextLine();
        String nombreExamen = sc.nextLine();

        String[] respuestas;
        for (int i = 0; i < preguntas.length; i++) {
            //Se pide al usuario que indique las preguntas a crear, mediante la creación de objetos en bucle
            System.out.println("Texto de la pregunta: ");
            String textoPregunta = sc.nextLine();
            System.out.println("Cantidad de respuestas posibles: ");
            respuestas = new String[sc.nextInt()];
            sc.nextLine();
            int letraRespuesta = 97;
            for (int j = 0; j < respuestas.length; j++) {
                System.out.println("Escriba la respuesta: " + (char) letraRespuesta);
                respuestas[j] = sc.nextLine();
                letraRespuesta++;
            }
            System.out.println("Respuesta correcta: ");
            int respuestaCorrecta = sc.nextInt();

            for (int k = 0; k < preguntas.length; k++) {
                preguntas[k] = new Preguntas(nombreExamen, textoPregunta, respuestas, respuestaCorrecta);
            }
        }
        try {
            //Se escribe mediante el objeto global de ObjectOutputStream
            escribiendo.writeObject(preguntas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Información administrada: ");
        Mostrar();
    }

    private static void TomarExamen(Preguntas[] preguntas) {
        /*int notaFinal = 0;
        int j = 0;
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println(preguntas[i].getRespuetas());
            if(preguntas[i].getRespuetas[j]);
            j++;
        }*/
        /*
         * Se me ha hecho algo tedioso hacer este metodo por las siguientes razones:
         * 1. La lectura del array 'respuestas' de la clase Preguntas no funciona, he tratado de recorrer el array desde el metodo getRespuestas
         * pero tampoco servia al momento de llamarlo en el metodo mostrar()
         * debido a esto no puedo hacer la lectura en este metodo de Tomar(Examen) ya que no puedo ver la informacion contenida y no puedo respectivamente
         * mostrarla al usuario para poder escoger la respuesta correcta, hacer comparaciones y condiciones. El acceso al array hizo imposible por ahora esto.
         * 2. La estructura se encarga de escribir pero no de devolver la información completa ya que me muestra todos los datos menos el array de posiblesRespuestas
         * 3. Metodo crear, está en funcionamiento y excepciones */
    }

    public static class Preguntas implements Serializable {
        private String nombreExamen;
        private String pregunta;
        private String[] respuetas;
        int respuestaCorrecta;

        /*
         * Crear clase preguntas y sacar objetos como la cantidad de preguntas
         * arraylist de respuestas <3> a,b,c
         * variable con la correcta
         * que esto se repita 5 veces o sea crear 5 objetos para las 5 preguntas
         * en la parte de crear, le doy la respuesta correcta con la posicion al array o le pido la
         * respuesta correcta al usuario y la se la paso como parametro al constructor
         * */
        public Preguntas(String nombreExamen, String pregunta, String[] respuetas, int respuestaCorrecta) {
            this.nombreExamen = nombreExamen;
            this.pregunta = pregunta;
            this.respuetas = respuetas;
            this.respuestaCorrecta = respuestaCorrecta;
        }

        public String getNombreExamen() {
            return nombreExamen;
        }

        public String getPregunta() {
            return pregunta;
        }

        public void getRespuetas() {
            for (int i = 0; i < respuetas.length; i++) {
                System.out.println(i + ": " + respuetas[i]);
            }
        }

        public int getRespuestaCorrecta() {
            return respuestaCorrecta;
        }

        @Override
        public String toString() {
            return "Pregunta: " + pregunta + "\nRespuesta Correcta: " + respuestaCorrecta;
        }
    }
}
