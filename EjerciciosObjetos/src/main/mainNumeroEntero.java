package main;

import model.NumeroEntero;
import helpers.CommonHelpers;

public class mainNumeroEntero {
    public static void main(String[] args) {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        int numberOne = 0;
        int numberTwo = 0;

        ayudaHelpers.imprimirContinuo("Ingrese el primer número: ");
        numberOne = ayudaHelpers.obtenerEntero(ayudaHelpers.leerTeclado());
        ayudaHelpers.imprimirContinuo("Ingrese el segundo número: ");
        numberTwo = ayudaHelpers.obtenerEntero(ayudaHelpers.leerTeclado());

     

        NumeroEntero primerValor = new NumeroEntero(numberOne);
        NumeroEntero segundoValor = new NumeroEntero(numberTwo);

        ayudaHelpers.imprimirSalto("NumeroOne es:  =>" + primerValor.getValor());
        ayudaHelpers.imprimirSalto("NumeroTwo es:  => " + segundoValor.getValor());

        ayudaHelpers.imprimirSalto("\nValores que mostramos del primer numero introducido:");
        ayudaHelpers.imprimirSalto("Valor de NumeroOne es :  =>" + primerValor.getValor());
        ayudaHelpers.imprimirSalto("Valor Doble de NumeroOne es :  => " + primerValor.getDoble());
        ayudaHelpers.imprimirSalto("Valor Triple de NumeroOne es :  =>" + primerValor.getTriple());

        ayudaHelpers.imprimirSalto("\nValores que mostramos del segundo numero introducido:");
        ayudaHelpers.imprimirSalto("Valor de NumeroTwo es :  =>" + segundoValor.getValor());
        ayudaHelpers.imprimirSalto("Valor Doble de NumeroTwo es :  =>" + segundoValor.getDoble());
        ayudaHelpers.imprimirSalto("Valor Triple de NumeroTwo es :  =>" + segundoValor.getTriple());

        primerValor.sumar(segundoValor.getValor());
        ayudaHelpers.imprimirSalto("\nEl resultado de NumberOne+NumberTwo es => " + primerValor.getValor());

        segundoValor.restar(primerValor.getValor());
        ayudaHelpers.imprimirSalto("El resultado de NumberTwo-NumberOne es => " + segundoValor.getValor());
        
        NumeroEntero resultadoResta = new NumeroEntero(numberTwo);
        resultadoResta.restar(numberOne);
        ayudaHelpers.imprimirSalto("El resultado de NumberTwo-NumberOne es => " + resultadoResta.getValor());
    }
}
