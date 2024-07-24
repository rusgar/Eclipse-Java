package main;


import helpers.CommonHelpers;
import modelo.Aleatorio1;

public class MainSorteo {

    public static void main(String[] args) {	
        CommonHelpers ayudaHelpers = new CommonHelpers();
        double costoPorLinea = 0.5;
        double apuestaTotal = 0.0;
        
        ayudaHelpers.imprimirSalto("Ingrese la cantidad que desea apostar en euros: ");
        apuestaTotal = ayudaHelpers.leerTecladoDouble();
        int numeroLineas = (int) Math.floor(apuestaTotal / costoPorLinea);
        
        ayudaHelpers.imprimirSalto("\nSu apuesta total es de " + apuestaTotal + " euros.");
        ayudaHelpers.imprimirSalto("Puede generar " + numeroLineas + " líneas de números.");
        ayudaHelpers.imprimirSalto("\n"+"******************************");
        
        for (int i = 0; i < numeroLineas; i++) {
            Aleatorio1 aleatorio = new Aleatorio1(); // CREAR UNA NUEVA INSTANCIA DE ALEATORIO PARA CADA LÍNEA
            aleatorio.generarNumerosSet(); // GENERAR NÚMEROS SIN USAR ARRAYS
            aleatorio.getNumerosSet();
            System.out.print("\nLínea " + (i + 1) + ":");
            for (int numero : aleatorio.getNumerosSet()) {
                ayudaHelpers.imprimirContinuo(" " + numero + " ");
            }
                        
        }
        Aleatorio1 aleatorio1 = new Aleatorio1();
        aleatorio1.generarNumeroComplementario();// GENERAR EL NÚMERO COMPLEMENTARIO
        aleatorio1.generarNumeroReintegro(); // GENERAR EL NÚMERO DE REINTEGRO
        ayudaHelpers.imprimirSalto("\n"+"******************************");
        ayudaHelpers.imprimirSalto("\nNúmero complementario: " + aleatorio1.getNumeroComplementario());
        ayudaHelpers.imprimirSalto("Número de reintegro: " + aleatorio1.getReintegro());
    }
}
