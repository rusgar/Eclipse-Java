package main;

import java.util.Scanner;

// DESARROLLA UN CONVERSOR DE TEMPERATURAS (C, F, K)

public class mainConversorTemperatura {

    public static void main(String[] args) {
        // DEFINIMOS LAS VARIABLES
        int unidadEntrada = 0;
        int unidadSalida = 0;
        double temperatura = 0.0;
        boolean ejecutar = true;
<<<<<<< HEAD
        double resultado = convertirTemperatura(unidadEntrada, unidadSalida, temperatura);
        String parametroEntrada = "";
        String parametroSalida= "";;
=======
>>>>>>> main
        // boolean respuestaValida = false;

        while (ejecutar) {
            mostrarMenu();
            System.out.print("\nIntroduzca la opción de unidad de entrada: ");
            unidadEntrada = leerTeclado();

            System.out.print("\nIntroduzca la opción de unidad de salida: ");
            unidadSalida = leerTeclado();

            System.out.print("\nIntroduzca el valor de la temperatura: ");
            temperatura = leerTecladoDouble();

<<<<<<< HEAD
       
            switch (unidadEntrada) {
            case 1:
            	parametroEntrada = "Celsius";
                break;
            case 2:
            	parametroEntrada = "Fahrenheit";
                break;
            case 3:
            	parametroEntrada = "Kelvin";
                break;
            default:
            	parametroEntrada = "Unidad desconocida";
                break;
        }
            switch (unidadEntrada) {
            case 1:
            	parametroSalida = "Celsius";
                break;
            case 2:
            	parametroSalida = "Fahrenheit";
                break;
            case 3:
            	parametroSalida = "Kelvin";
                break;
            default:
            	parametroSalida = "Unidad desconocida";
                break;
        }
            
            
            // %2.F PARA SACAR DOS DECIMALES DEL FLOAT %S PARA INSERTAR UN VALOR EN LA CADENA(ESPICIFICADOR DE FORMATO) Y PRINTTF PARA DAR FORMATOS DE SALIDA
            System.out.printf("Resultado: %.2f %s equivalen a %.2f %s\n", temperatura,parametroEntrada,resultado, parametroSalida);
=======
            double resultado = convertirTemperatura(unidadEntrada, unidadSalida, temperatura);
            // %2.F PARA SACAR DOS DECIMALES DEL FLOAT %S PARA INSERTAR UN VALOR EN LA CADENA(ESPICIFICADOR DE FORMATO) Y PRINTTF PARA DAR FORMATOS DE SALIDA
            System.out.printf("Resultado: %.2f %s equivalen a %.2f %s\n", temperatura, getUnidadNombre(unidadEntrada), resultado, getUnidadNombre(unidadSalida));
>>>>>>> main

            System.out.print("\n¿Desea realizar otra conversión? (S/N): ");
            String respuesta = leerTecladoString().toLowerCase(); 

            if (respuesta.isEmpty()) { 
            	System.out.println("Entrada no válida. Ingrese solo el caracter de  'S ' para sí o ' N ' para no.");
            }  else if(respuesta.charAt(0) == 's') {
                 ejecutar = true; 
            } else if (respuesta.charAt(0) == 'n') {
                ejecutar = false; 
            } else {
                System.out.println("Entrada no válida. Ingrese 'S' para sí o 'N' para no.");
            }
            System.out.println("\nSaliendo de la Conversion.");
        }

        
    }

    private static int leerTeclado() {
    	int retorno= 0;
        Scanner sca = new Scanner(System.in);
        retorno= sca.nextInt();
        return retorno;
    }
	private static String leerTecladoString() {
		String retorno="";
		Scanner sca= new Scanner(System.in);
		retorno=sca.nextLine();
		return retorno;
	}

    private static double leerTecladoDouble() {
    	double retorno =0.0;
        Scanner sca = new Scanner(System.in);
        retorno = sca.nextDouble();
        return retorno;
    }

    private static void mostrarMenu() {
        System.out.println("\n----------------------------------------");
        System.out.println("\tCONVERSOR DE TEMPERATURA");
        System.out.println("----------------------------------------");
        System.out.println("****Opciones de unidad de entrada:****");
<<<<<<< HEAD
        System.out.println("\n\t1. \tCelsius");
        System.out.println("\t2. \tFahrenheit");
        System.out.println("\t3. \tKelvin");
        System.out.println("\n****Opciones de unidad de salida:****");
        System.out.println("\n\t1. \tCelsius");
        System.out.println("\t2. \tFahrenheit");
        System.out.println("\t3. \tKelvin");
=======
        System.out.println("\n1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");
        System.out.println("\n****Opciones de unidad de salida:****");
        System.out.println("\n1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");
>>>>>>> main
    }

    private static double convertirTemperatura(int unidadEntrada, int unidadSalida, double temperatura) {
        double resultadoConversion = 0.0;

        switch (unidadEntrada) {
            case 1: // Celsius
                switch (unidadSalida) {
                    case 1: // Celsius
                        resultadoConversion = temperatura;
                        break;
                    case 2: // Fahrenheit
                        resultadoConversion = (temperatura * 9.0 / 5.0) + 32.0;
                        break;
                    case 3: // Kelvin
                        resultadoConversion = temperatura + 273.15;
                        break;
                    default:
                        System.out.println("Error: Unidad de salida no válida.");
                }
                break;
            case 2: // Fahrenheit
                switch (unidadSalida) {
                    case 1: // Celsius
                        resultadoConversion = (temperatura - 32.0) * 5.0 / 9.0;
                        break;
                    case 2: // Fahrenheit
                        resultadoConversion = temperatura;
                        break;
                    case 3: // Kelvin
                        resultadoConversion = (temperatura - 32.0) * 5.0 / 9.0 + 273.15;
                        break;
                    default:
                        System.out.println("Error: Unidad de salida no válida.");
                }
                break;
            case 3: // Kelvin
                switch (unidadSalida) {
                    case 1: // Celsius
                        resultadoConversion = temperatura - 273.15;
                        break;
                    case 2: // Fahrenheit
                        resultadoConversion = (temperatura - 273.15) * 9.0 / 5.0 + 32.0;
                        break;
                    case 3: // Kelvin
                        resultadoConversion = temperatura;
                        break;
                    default:
                        System.out.println("Error: Unidad de salida no válida.");
                }
                break;
            default:
                System.out.println("Error: Unidad de entrada no válida.");
        }

        return resultadoConversion;
    }

<<<<<<< HEAD

=======
    private static String getUnidadNombre(int unidad) {
        switch (unidad) {
            case 1:
                return "Celsius";
            case 2:
                return "Fahrenheit";
            case 3:
                return "Kelvin";
            default:
                return "Unidad desconocida";
        }
    }
>>>>>>> main
}

