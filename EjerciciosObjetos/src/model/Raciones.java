package model;

import helpers.CommonHelpers;

public class Raciones {
    private static final int GramosAdulto = 800;
    private static final int GramosNiño = 400;

    private CarneMenu[] carnesDisponibles;
    private int racionesAdultos;
    private int racionesNinos;

    public Raciones() {
        carnesDisponibles = new CarneMenu[] {
            new CarneMenu("Costillas", 200),
            new CarneMenu("Chorizo", 150),
            new CarneMenu("Morcilla", 80)
        };
    }

    public void setRaciones(int racionesAdultos, int racionesNinos) {
        this.racionesAdultos = racionesAdultos;
        this.racionesNinos = racionesNinos;
    }
    public void mostrarMenu() {
    	CommonHelpers ayudaHelpers = new CommonHelpers();
    	ayudaHelpers.imprimirSalto("*******************************************");
    	ayudaHelpers.imprimirSalto("*                                         *");
        ayudaHelpers.imprimirSalto("*"+"\tMenú de Carnes Disponibles:"+"       *");
        ayudaHelpers.imprimirSalto("*                                         *");
        ayudaHelpers.imprimirSalto("*******************************************");
        for (int i = 0; i < carnesDisponibles.length; i++) {
            CarneMenu carne = carnesDisponibles[i];
           
            ayudaHelpers.imprimirSalto((i + 1) + "...... " + carne.getNombre() + " (" + carne.getGramosPorRacion() + " gramos por ración)");
            
        }
    }

    public void calcularRaciones() {
        int totalGramosAdultos = racionesAdultos * GramosAdulto;
        int totalGramosNinos = racionesNinos * GramosNiño;
        int totalGramos = totalGramosAdultos + totalGramosNinos;

        CommonHelpers ayudaHelpers = new CommonHelpers();

        ayudaHelpers.imprimirSalto("Total gramos para adultos: " + totalGramosAdultos);
        ayudaHelpers.imprimirSalto("Total gramos para niños: " + totalGramosNinos);
        ayudaHelpers.imprimirSalto("Total gramos disponibles para consumir: " + totalGramos);
        int gramosConsumidos=0;
        boolean excedeLimite=true;
        do {        
        mostrarMenu();
         
        int[] racionesSeleccionadas = new int[carnesDisponibles.length];

        for (int i = 0; i < carnesDisponibles.length; i++) {
            CarneMenu carne = carnesDisponibles[i];
            ayudaHelpers.imprimirSalto("Cuanta raciones necesita de  " + carne.getNombre() + ": ");
            int raciones = ayudaHelpers.leerTecladoInt();
            racionesSeleccionadas[i] = raciones;
            int gramosPorRacion = carne.getGramosPorRacion();
             gramosConsumidos += gramosPorRacion * raciones;
        }
        if (gramosConsumidos > totalGramos) {
        	ayudaHelpers.imprimirSalto("¡Alerta! Los gramos consumidos exceden el límite disponible.");
        	ayudaHelpers.imprimirSalto("Por favor, ajuste la cantidad de raciones.");
        }else {
        	ayudaHelpers.imprimirSalto("Raciones seleccionadas:");
        	  for (int i = 0; i < carnesDisponibles.length; i++) {
        		  CarneMenu carne = carnesDisponibles[i];
        		  int raciones = racionesSeleccionadas[i];
        		  ayudaHelpers.imprimirSalto("Se sirven un total de:  "+raciones+ " racion de  "+ carne.getNombre()  );
                  ayudaHelpers.imprimirSalto("Que suponen un gasto de "+carne.getGramosPorRacion() * raciones+" gramos de "+ carne.getNombre() +"\n");
        	  }
        }
        ayudaHelpers.imprimirSalto(" \nTotal gramos consumidos: " + gramosConsumidos);
        ayudaHelpers.imprimirContinuo("Gramos restantes: " + (totalGramos - gramosConsumidos)+"\n");
        excedeLimite = false;
     
        
    }while (gramosConsumidos > totalGramos);

       
       
    
}
}


