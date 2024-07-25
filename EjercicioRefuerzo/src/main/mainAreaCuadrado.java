package main;

import java.util.Scanner;

public class mainAreaCuadrado {

    public static void main(String[] args) {
        int lado = 0;
        int area= 0;

        System.out.print("Introduce el lado del cuadrado: ");
        lado = leerTeclado();
        area = lado * lado;

        System.out.println("El área del cuadrado es: " + area);
    }

    private static int leerTeclado() {
    	int retorno=0;
        Scanner sca = new Scanner(System.in);
        retorno= sca.nextInt();
        return retorno;
    }
}

