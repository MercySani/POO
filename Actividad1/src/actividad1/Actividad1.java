/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Core i5
 */
public class Actividad1 {

    public String nombreJugador;

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Actividad1(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public static void main(String[] args) {
        System.out.println("ADIVANDO EL NÚMERO");
        System.out.println("VEAMOS SI LOGRAS ADIVINARLO");
        Scanner input = new Scanner(System.in);
        Actividad1 obj = new Actividad1("Anibal Jara");
        //Inicialización del contructor
        System.out.println("Nombre jugador: " + obj.nombreJugador);
        //DEfinición de la lista con números erroneos
        ArrayList listaNumerosErroneos = new ArrayList();
        //Variables 
        int numeroConsola;
        int puntaje = 100;
        int numeroAdivinar = (int) Math.floor(Math.random() * (50 - 1 + 1) + 1);
        int i = 10;
        do {
            boolean continua;
            do {
                try {
                    continua = false;
                    i--;
                    System.out.println("Ingrese el número");
                    numeroConsola = input.nextInt();
                    if(numeroConsola < 1 || numeroConsola > 51){
                         System.out.println("el nùmero ingresado debe estar dentro del rango de 1 a 51");
                        break;
                    }else if (numeroAdivinar == numeroConsola) {
                        break;
                    } else if (numeroAdivinar > numeroConsola) {
                        listaNumerosErroneos.add(numeroConsola);
                        puntaje = puntaje - 10;
                        System.out.printf(intentofallido("mayor"), numeroConsola);
                    } else if (numeroAdivinar < numeroConsola) {
                        listaNumerosErroneos.add(numeroConsola);
                        puntaje = puntaje - 10;
                        System.out.printf(intentofallido("menor"), numeroConsola);
                    }
                } catch (InputMismatchException e) {
                    System.err.println("DEBE INGRESAR SOLO NÙMEROS");
                    input.next();
                    continua = true;
                }
            } while (continua);
        } while (i > 0);

        System.out.println(" Número de intentos: " + (10 - i));
        System.out.println(" Lista de números erróneos: " + listaNumerosErroneos.toString());
        System.out.println(" Puntaje: " + puntaje);

    }

    public static String intentofallido(String msj) {
        String s = "El número a adivinar es " + msj + " al número %d";
        return s;
    }

}
