package Main;
import java.util.Scanner;
public class MainCalculadoraArray {

	public static void main(String[] args) {
		

		        Scanner scanner = new Scanner(System.in);

		        // Continuar calculando hasta que el usuario lo desee
		        boolean continuar = true;
		        String operacion="";
		        int operando1=0;
		        int operando2=0;
		        int resultado=0;
		        String signo="";
		        while (continuar) {

		            // Solicitar la operación 
		            System.out.println("Ingrese la operación matemática (por ejemplo, 12 + 5): ");
		            operacion = leerTeclado();

		            // Validar el formato de la operación con el modelo split
		            String[] partes = operacion.split(" ");
		            if (partes.length == 2) {
		                System.out.println("Error: La expresión debe tener dos números y un operador.");
		                continue;
		            }

		            // Convertir los operandos y el operador a sus tipos correspondientes, comprabamos con un try catch
		           		           
		            try {
		            	operando1= Integer.parseInt(partes[0]);
		                signo= partes[1];
		                operando2 = Integer.parseInt(partes[2]);
		            } catch (NumberFormatException e) {
		                System.out.println("Error: Los números enteros válidos.");
		                continue;
		            }

		            // Calcular el resultado según el operador necesario
		            
		            switch (signo) {
		                case "+":
		                    resultado =operando1 + operando2;
		                    break;
		                case "-":
		                    resultado =operando1 - operando2;
		                    break;
		                case "*":
		                    resultado =operando1 * operando2;
		                    break;
		                case "/":
		                    if (operando2 == 0) {
		                        System.out.println("Error: División por cero no está permitida.");
		                        continue;
		                    } else {
		                        resultado =operando1 / operando2;
		                    }
		                    break;
		                default:
		                    System.out.println("Error: Operador no válido. Los operadores válidos son +, -, *, /.");
		                    continue;
		            }

		            // Mostrar el resultado
		            System.out.println("Resultado: " + operando1+ signo+operando2+"="+resultado);

		            // Preguntar al usuario si desea continuar calculando
		            System.out.print("¿Desea realizar otra operación? (s/n): ");
		            String continuarRespuesta = leerTeclado().toUpperCase();
		            if (!continuarRespuesta.equals("s")) {
		                continuar = false;
		            }
		        }

		        System.out.println("Gracias por usar la calculadora😎😎😎.");
		    }
		


	   private static String leerTeclado() {
			String retorno="";
			Scanner sca= new Scanner(System.in);
			retorno=sca.nextLine();
			return retorno;
			}
	}

/* System.out.println(operacion);
for(int i=0;i<partes.length;i++) {
	 System.out.print(partes[i]);
}*/