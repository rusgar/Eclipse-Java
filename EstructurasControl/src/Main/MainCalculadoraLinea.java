package Main;


import java.util.Scanner;

public class MainCalculadoraLinea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//definimos las variables
		String operacion="";// aqui recibo la operacion
		int operando1=0,operando2=0,resultado=0;
		String signo="";
		boolean ejecutar=true;
		
		while(ejecutar){
		System.out.println("introduzca la"
				+ " operacion(4 + 6)"
				+ "para salir (esc)");
		operacion=leerTeclado();
		//voy a dividir la operacion en cada una de
		// sus partes con un split
		if(operacion.equalsIgnoreCase("esc")) {
			ejecutar=false;
			System.out.println("Que pase un buen día!!");
		}else {
		String [] partes=operacion.split(" ");
		
		if(partes.length>2) {
			// comprobacion para saber que tengo bien el 
			//número de elmentos
		operando1=Integer.parseInt(partes[0]);
		signo=partes[1];
		operando2= Integer.parseInt(partes[2]);
		
		switch (signo) {
		case "+": {
			resultado=operando1+operando2;
			System.out.println(operando1+" + "
			+operando2+" = "+resultado);
			break;
		}
		case "-": {
			resultado=operando1-operando2;
			System.out.println(operando1+" - "
			+operando2+" = "+resultado);
			break;
		}
		case "*": {
			resultado=operando1*operando2;
			System.out.println(operando1+" * "
			+operando2+" = "+resultado);
			break;
		}
		case "/": {
			resultado=operando1/operando2;
			System.out.println(operando1+" / "
			+operando2+" = "+resultado);
			break;
		}
		case ":": {
			resultado=operando1/operando2;
			System.out.println(operando1+" : "
			+operando2+" = "+resultado);
			break;
		}
		default:
			System.out.println("Opcion no disponible");
		}
		}else {
			System.out.println("Número de "
					+ "elementos inválido");
		}
		}
		}
		
	}
	private static String leerTeclado() {
		String retorno="";	
		Scanner escaner	= new Scanner(System.in);
		retorno=escaner.nextLine();	
		return retorno;
		}
}
