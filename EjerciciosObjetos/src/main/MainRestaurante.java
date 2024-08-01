package main;

import model.MenuCarne;
import helpers.CommonHelpers;

public class MainRestaurante {
    public static void main(String[] args) {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        MenuCarne restaurante = new MenuCarne();
        int numAdultos=0;
        int numNinos=0;

        ayudaHelpers.imprimirContinuo("Ingrese el número de adultos en la reserva: ");
         numAdultos = ayudaHelpers.leerTecladoInt();

        ayudaHelpers.imprimirContinuo("Ingrese el número de niños en la reserva: ");
         numNinos = ayudaHelpers.leerTecladoInt();

         boolean ejecutar = true;
         double[] totales = new double[6];
         
         while (ejecutar) {
        ayudaHelpers.imprimirSalto("\t****Menu de Carne:****");
        ayudaHelpers.imprimirSalto("1. \tCostillas");
        ayudaHelpers.imprimirSalto("2. \tPanceta");
        ayudaHelpers.imprimirSalto("3. \tSalchichas");
        ayudaHelpers.imprimirSalto("4. \tChorizo");
        ayudaHelpers.imprimirSalto("5. \tMorcilla");
        ayudaHelpers.imprimirSalto("6. \tSecreto");
        ayudaHelpers.imprimirSalto("7. \tFin del Pedido");

        ayudaHelpers.imprimirContinuo("Ingrese el número del menú seleccionado: ");
        String seleccion = ayudaHelpers.leerTeclado();
        String[] opciones = seleccion.split(",");

        for (String opcionStr : opciones) {
            int opcion = ayudaHelpers.obtenerEntero(opcionStr.trim());

            if (opcion >= 1 && opcion <= 6) {
                double cantidadPorPlato =restaurante.obtenerCantidadPorPlato(opcion, restaurante);
                double racionAdulto = restaurante.calcularRacionIndividual(cantidadPorPlato, MenuCarne.adultoGr);
                double racionNino = restaurante.calcularRacionIndividual(cantidadPorPlato, MenuCarne.niñoGR);
                double cantidadTotal = numAdultos * racionAdulto + numNinos * racionNino;
                totales[opcion - 1] += cantidadTotal;

                ayudaHelpers.imprimirSalto(restaurante.obtenerNombrePlato(opcion) + ": Adulto: " + String.format("%.2f", racionAdulto) + " Kilos, Niño: " + String.format("%.2f", racionNino) + " Kilos");
            } else if (opcion == 7) {
                ejecutar = false;
                break;
            } else {
                ayudaHelpers.imprimirSalto("Opción no válida.");
            }
        }
    }


}  
         

         
}
    
 

