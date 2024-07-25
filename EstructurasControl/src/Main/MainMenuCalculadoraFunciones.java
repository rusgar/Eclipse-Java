package Main;

import java.util.Scanner;

public class MainMenuCalculadoraFunciones {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// definimos las variables
				int operando1=0, operando2=0;// operadores
				int resultado=0;
				int opcion=0;// para recibir las opciones
				boolean ejecutar=true;
				while(ejecutar) {
				// del menú
				publicarMenu();
				opcion=Integer.parseInt(leerTeclado());
				
				/*System.out.println("Dame operando 1");
				operando1=Double.parseDouble(leerTeclado());
				System.out.println("Dame operando 2");
				operando2=Double.parseDouble(leerTeclado());*/
				
				switch(opcion) {
				
				case 1:{
					System.out.println("Dame operando 1");
					operando1=Integer.parseInt(leerTeclado());
					System.out.println("Dame operando 2");
					operando2=Integer.parseInt(leerTeclado());
					System.out.println(calculaOperacion(operando1,
							operando2, "+"));
					
					break;
				}
				case 2:{
					System.out.println("Dame operando 1");
					operando1=Integer.parseInt(leerTeclado());
					System.out.println("Dame operando 2");
					operando2=Integer.parseInt(leerTeclado());
					System.out.println(calculaOperacion(operando1,
							operando2, "-"));
					break;
				}
				case 3:{
					System.out.println("Dame operando 1");
					operando1=Integer.parseInt(leerTeclado());
					System.out.println("Dame operando 2");
					operando2=Integer.parseInt(leerTeclado());
					System.out.println(calculaOperacion(operando1,
							operando2, "*"));
					
					break;
				}
				case 4:{
					System.out.println("Dame operando 1");
					operando1=Integer.parseInt(leerTeclado());
					System.out.println("Dame operando 2");
					operando2=Integer.parseInt(leerTeclado());
					System.out.println(calculaOperacion(operando1,
							operando2, "/"));
					
					break;
				}
				case 0:{
					// paro la ejcucion pasando la
					// variable de control a false
					ejecutar=false;
					break;
				}
				
				default:
					System.out.println("Opcion no disponible");
				}
				}

		
	}
	
	private static String leerTeclado() {
		String retorno="";
		Scanner escaner= new Scanner(System.in);
		retorno=escaner.nextLine();
		return retorno;
	}
	
	private static int leerTecladoEntero() {
		
		int retorno=0;
		Scanner escaner= new Scanner(System.in);
		retorno=escaner.nextInt();
		return retorno;
		
	}
	
	private static int sumaEnteros(int operador1,
			int operador2) {
		int retorno=0;
		
		retorno= operador1+operador2;
		
		return retorno;
	}
	
	
private static void publicarMenu() {
	System.out.println("\tMenú calculadora");
	System.out.println("\t****************");
	System.out.println("1.Sumar");
	System.out.println("2.Restar");
	System.out.println("3.Multiplicar");
	System.out.println("4.Dividir");
	System.out.println("0.Salir");
	System.out.println("Seleccione una opción");
}


private static String sumarEnteros(
 int numero1,
 int numero2) {
	String retorno="";
	int resultado=numero1+numero2;
	retorno=numero1+" + "+numero2+" = "+resultado;
	return retorno;
}

private static String restarEnteros(
		 int numero1,
		 int numero2) {
			String retorno="";
			int resultado=numero1-numero2;
			retorno=numero1+" - "+numero2+" = "+resultado;
			return retorno;
		}

private static String multiplicarEnteros(
		 int numero1,
		 int numero2) {
			String retorno="";
			int resultado=numero1*numero2;
			retorno=numero1+" * "+numero2+" = "+resultado;
			return retorno;
		}
private static String dividirEnteros(
		 int numero1,
		 int numero2) {
			String retorno="";
			int resultado=numero1/numero2;
			retorno=numero1+" / "+numero2+" = "+resultado;
			return retorno;
		}

private static String calculaOperacion(
		int numero1, int numero2, String signo
		) {
	String retorno="";
	int resultado=0;
	switch(signo) {
	case "+":{
		
		resultado=numero1+numero2;
		break;
	}
	case "-":{
		
		resultado=numero1-numero2;
		break;
	}
	case "*":{
		
		resultado=numero1*numero2;
		break;
	}
	case "/":{
		
		resultado=numero1/numero2;
		break;
	}
	
	}
	
	retorno=numero1+" "+signo+" "+numero2+" = "+resultado;
	return retorno;
}

}
