package main;

import helpers.CommonHelpers;
import model.MiNumero;


public class mainNumero {
    public static void main(String[] args) {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        
        ayudaHelpers.imprimirContinuo("Ingrese un número para el ejercicio: ");
        double numero = ayudaHelpers.leerTecladoDouble();

       MiNumero resultadoNumero = new MiNumero(numero); 
        
        resultadoNumero.DetallesMiNumero();
    }
}



