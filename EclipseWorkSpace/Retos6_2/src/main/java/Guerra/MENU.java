package Guerra;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MENU {
    static Scanner sc = new Scanner(System.in);
    static PERSONAJE[] bandoBlanco = new PERSONAJE[8];
    static PERSONAJE[] bandoNegro = new PERSONAJE[8];

    public static void main(String[] args) {

        bandoBlanco[0] = new MEDICO("Medico Bando Blanco");
        bandoBlanco[1] = new CIRUJANO("Cirujano Bando Blanco");
        bandoBlanco[2] = new GUERRERO("Guerrero Bando Blanco");
        bandoBlanco[3] = new SNIPER("Sniper Bando Blanco");
        bandoBlanco[4] = new CIVIL("Civil 1 Bando Blanco");
        bandoBlanco[5] = new CIVIL("Civil 2 Bando Blanco");
        bandoBlanco[6] = new CIVIL("Civil 3 Bando Blanco");
        bandoBlanco[7] = new CIVIL("Civil 4 Bando Blanco");

        bandoNegro[0] = new MEDICO("Medico Bando Negro");
        bandoNegro[1] = new CIRUJANO("Cirujano Bando Negro");
        bandoNegro[2] = new GUERRERO("Guerrero Bando Negro");
        bandoNegro[3] = new SNIPER("Sniper Bando Negro");
        bandoNegro[4] = new CIVIL("Civil 1 Bando Negro");
        bandoNegro[5] = new CIVIL("Civil 2 Bando Negro");
        bandoNegro[6] = new CIVIL("Civil 3 Bando Negro");
        bandoNegro[7] = new CIVIL("Civil 4 Bando Negro");

        Menu();
    }

    public static void Menu() {
        int contador = 0;
        int contadorMuertosBlancos = 0;
        int contadorMuertosNegros = 0;
        do {
            switch (OpcionMenu()) {
                case 1 -> {
                    if (contador % 2 == 0) {
                        Atacar(bandoBlanco, bandoNegro);
                    } else {
                        Atacar(bandoNegro, bandoBlanco);
                    }
                }
                case 2 -> {
                    if (contador % 2 == 0) {
                        Curar(bandoBlanco);
                    } else {
                        Curar(bandoNegro);
                    }
                }
                case 3 -> {
                    if (contador % 2 == 0) {
                        RobarMaterialSanitario(bandoBlanco);
                    } else {
                        RobarMaterialSanitario(bandoNegro);
                    }
                }
                case 4 -> {
                    if (contador % 2 == 0) {
                        RobarBalas(bandoBlanco);
                    } else {
                        RobarBalas(bandoNegro);
                    }
                }
                case 0 -> sc.close();
            }
            for (PERSONAJE personaje : bandoBlanco) {
                if (personaje.getVida() == 0) {
                    contadorMuertosBlancos++;
                }
            }
            for (PERSONAJE personaje : bandoBlanco) {
                if (personaje.getVida() == 0) {
                    contadorMuertosNegros++;
                }
            }
            contador++;
        } while (contadorMuertosBlancos != 8 && contadorMuertosNegros != 8);
    }

    public static int OpcionMenu() {
        int menu;
        do {
            try {  //checks code for exceptions
                System.out.println("""
                        \tMENU
                        1.Atacar
                        2.Curar
                        3.Robar Material Sanitario
                        4.Robar Balas
                        0.Salir""");
                menu = sc.nextInt();
                if (menu >= 0 && menu <= 4) {
                    break;
                }
            } catch (InputMismatchException e) { //if an exception appears prints message below
                System.err.println("Debe ingresar un número");
                sc.next(); //Clear scanner buffer of wrong input
            }
        } while (true); //loops forever until break
        return menu;
        //Echarle un ojo con el pana Migue
    }

    public static void ActualizarVida(ArrayList<PERSONAJE> bando) {
        for (PERSONAJE i : bando) {
            if (i.isAcuchillado() || i.isDisparado()) {
                LocalTime horaPosterior = i.getTiempo().plusMinutes(i.getMINUTOS());
                if (horaPosterior.isAfter(i.getTiempo().plusMinutes(i.getMINUTOS()))){
                    System.out.println("muerto");
                    i.setVida(0);
                }
            }
        }

    }

    public static void RecorrerBlanco() {
        for (PERSONAJE i : bandoBlanco) {
            System.out.println(i.toString());
        }
    }

    public static void RecorrerNegro() {
        for (PERSONAJE i : bandoNegro) {
            System.out.println(i.toString());
        }
    }


    public static void Atacar(PERSONAJE[] contrario, PERSONAJE[] aliado) {

        System.out.println("¿Quien va atacar?");
        for (int i = 0; i < aliado.length; i++) {
            System.out.println("En la posicion: " + i + " se encuentra: " + aliado[i].getNombre());
        }
        int ataca = sc.nextInt();

        if (aliado[ataca] instanceof GUERRERO || aliado[ataca] instanceof SNIPER) {
            System.out.println("¿A quien quiere atacar? ");
            for (int i = 0; i < contrario.length; i++) {
                System.out.println("En la posicion: " + i + " se encuentra: " + contrario[i].getNombre());
            }
            int atacado = sc.nextInt();
            ((COMBATE) aliado[ataca]).Ataca(contrario[atacado]);
        }
    }
}
