package main;


import helpers.CommonHelpers;
import model.Circulo;
import model.Rectangulo;
import model.Triangulo;
import model.PoligonoRegular;


public class mainGeometria {

    public static void main(String[] args) {
        CommonHelpers ayudaHelpers = new CommonHelpers();
        boolean ejecutar = true;
        int opcion;

        while (ejecutar) {
        	ayudaHelpers.imprimirSalto("|********************************************|");
            ayudaHelpers.imprimirSalto("| \tSELECCIONE UNA FIGURA GEOMETRICA     |");
            ayudaHelpers.imprimirSalto("| \t1.   Triángulo                       |");
            ayudaHelpers.imprimirSalto("| \t2.   Rectángulo                      |");
            ayudaHelpers.imprimirSalto("| \t3.   Círculo                         |");
            ayudaHelpers.imprimirSalto("| \t4.   Polígonos regulares             |");            
            ayudaHelpers.imprimirSalto("| \t5.   Salir                           |");
            ayudaHelpers.imprimirSalto("|       Ingrese una opción:                  |");
            ayudaHelpers.imprimirSalto("|********************************************|\n");
            opcion = ayudaHelpers.leerTecladoInt();

            switch (opcion) {
            case 1:
                Triangulo.menuTriangulo(ayudaHelpers);
                break;
            case 2:
                Rectangulo.menuRectangulo(ayudaHelpers);
                break;
            case 3:
                Circulo.menuCirculo(ayudaHelpers);
                break;
            case 4:
            	 PoligonoRegular.menuPoligonoRegular(ayudaHelpers);
                 break;                
            case 5: 
            	ejecutar=false;
                ayudaHelpers.imprimirSalto("Saliendo del programa...");
                continue;
             default:
                ayudaHelpers.imprimirSalto("Opción no válida. Por favor, seleccione una opción entre 1 y 4.");
                continue;
            }
            if (opcion != 5) {
                ayudaHelpers.imprimirSalto("¿Desea calcular otra figura? (S/N):");
                String respuesta = ayudaHelpers.leerTeclado();
                if (!respuesta.equalsIgnoreCase("S")) {
                    ejecutar = false;
                    ayudaHelpers.imprimirSalto("Programa terminado.Reinicie el boton verde de run para empezar");
            }
            }
        }
        
    }
    }


