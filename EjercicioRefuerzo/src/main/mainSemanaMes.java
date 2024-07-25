package main;

/* REALIZA UN PROGAMA EN EL CUAL INTRODUCIDO UN DÍA DE LA SEMANA Y MES EN FORMATO NÚMERICO LO DEVUELVA EN FORMATO TEXTO POR EJEMPLO:
DÍA DE LA SEMANA 1 -> LUNES
MES 2 -> FEBRERO*/

import java.util.Scanner;

public class mainSemanaMes {

    public static void main(String[] args) {
      
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
    	// DELARACION DE LAS VARIABLES
    	boolean datosValidos = false;
>>>>>>> main
>>>>>>> main
    	int numeroDiaSemana = 0;
    	int numeroMes = 0;
    	String diaSemanaTexto ="";
    	String mesTexto = "";
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> main

        System.out.print("Introduce el número de día de la semana (1-7): ");
         numeroDiaSemana = Integer.parseInt(leerTeclado());

        System.out.print("Introduce el número de mes (1-12): ");
         numeroMes = Integer.parseInt(leerTeclado());

        diaSemanaTexto = obtenerDiaSemana(numeroDiaSemana);
        mesTexto = obtenerMes(numeroMes);

<<<<<<< HEAD
        if (!diaSemanaTexto.equals("") && !mesTexto.equals("")) {
=======
        if (!diaSemanaTexto.equals("") && !mesTexto.equalsIgnoreCase("")) {
>>>>>>> main
            System.out.println("Día de la semana  "+ numeroDiaSemana+" -> "+ diaSemanaTexto);
            System.out.println("Mes  "+ numeroMes+" -> "+ mesTexto);
        } else {
            System.out.println("Error: Datos introducidos no válidos.");
        }
<<<<<<< HEAD
=======
=======
       
    	
    	// CREAMOS UN BUCLE PARA SI LOS DATOS SON INCORRECTOS ME LOS VUELVA A PEDIR
    	while (true) {
    		try {
    	            System.out.print("Introduce el número de día de la semana (1-7): "); // NO ADMITE NI CERO NI INTROS EN LAS PREGUNTAS
                    numeroDiaSemana = Integer.parseInt(leerTeclado());

                    System.out.print("Introduce el número de mes (1-12): ");
                     numeroMes = Integer.parseInt(leerTeclado());

    

        if (numeroDiaSemana >= 1 && numeroDiaSemana <= 7 && numeroMes >= 1 && numeroMes <= 12 ) {
        	  
        	diaSemanaTexto = obtenerDiaSemana(numeroDiaSemana);
              mesTexto = obtenerMes(numeroMes);
        	
        	System.out.println("Día de la semana  "+ numeroDiaSemana+" -> "+ diaSemanaTexto);
            System.out.println("Mes  "+ numeroMes+" -> "+ mesTexto);
            datosValidos=true;
            break;
        } else {
            System.out.println("Error: Datos introducidos no válidos.");
        }
    }  catch (NumberFormatException e) {
        System.out.println("Error: El formato del dato introducido no es válido. Debe ser un número entero.");
    }
    	}
>>>>>>> main
>>>>>>> main
    }

	private static String leerTeclado() {
		String retorno="";
		Scanner sca= new Scanner(System.in);
		retorno=sca.nextLine();
		return retorno;
	}
<<<<<<< HEAD
 
=======

>>>>>>> main
    private static String obtenerDiaSemana(int numeroDiaSemana) {
        switch (numeroDiaSemana) {
            case 1:
                return "LUNES";
            case 2:
                return "MARTES";
            case 3:
                return "MIÉRCOLES";
            case 4:
                return "JUEVES";
            case 5:
                return "VIERNES";
            case 6:
                return "SÁBADO";
            case 7:
                return "DOMINGO";
            default:
<<<<<<< HEAD
            	return "Día de la semana inválido tiene que ser dentro de los parametros 1 al 7";
               
=======
                return null;
>>>>>>> main
        }
    }

    private static String obtenerMes(int numeroMes) {
        if (numeroMes >= 1 && numeroMes <= 12) {
<<<<<<< HEAD
            return meses[numeroMes - 1].toLowerCase();
        } else {
            return "Dia de mes incorrecto solo entre 1 al 12 ";
=======
            return meses[numeroMes - 1];
        } else {
            return null;
>>>>>>> main
        }
    }

    private static  String[] meses = {
            "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO",
            "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"
    };
}
