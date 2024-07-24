package Main;

import java.util.Scanner;

public class MainBilletesMonedasArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cantidad=0;
		int auxCantidad=0;
		int [] numeroBilletesMonedas= new int[9];
		int [] valorBilletesMonedas = {500,200,100,50,20,10,5,2,1};
		
		for (int i=0; i < numeroBilletesMonedas.length; i++) {
			numeroBilletesMonedas[i]=0;
			
	    }
		
		// pido el dato de entrada
		System.out.println("Introduce Cantidad");
		cantidad= Integer.parseInt(leerTeclado());
		// duplicar la  variable cantidad, conservar valor inicial
		auxCantidad= cantidad;
		
		for (int i=0;i<valorBilletesMonedas.length; i++) {
			if (auxCantidad>=valorBilletesMonedas[i]) {
				numeroBilletesMonedas[i]=  auxCantidad/valorBilletesMonedas[i];
				auxCantidad %= valorBilletesMonedas[i];
			                                          }
		
		 }
		for(int i=0; i<numeroBilletesMonedas.length; i++) {
			if(numeroBilletesMonedas[i]>0) {
				if(numeroBilletesMonedas[i]==1) {
					if(i<(numeroBilletesMonedas.length-2)) {
						System.out.println("Contiene "+numeroBilletesMonedas[i]
								+" billete de "+ valorBilletesMonedas[i] );	
					}else {
						System.out.println("Contiene "+numeroBilletesMonedas[i]
								+" moneda de "+ valorBilletesMonedas[i] );	
						
					}
				}else {
					if (i<numeroBilletesMonedas.length-2) {
						// comprobar si son billetes
						System.out.println("Contiene "+ numeroBilletesMonedas[i] + " billetes de " + valorBilletesMonedas[i]);
					} 
					else {
						//son monedas
						System.out.println("Contiene "+ numeroBilletesMonedas[i] + " monedas de " + valorBilletesMonedas[i]);
					} 
				} 
			} 
			
		} 
					
					
				}
				
				
			
			
		
	

	private static String leerTeclado() {
		String retorno="";
		Scanner scanner= new Scanner(System.in);
		retorno=scanner.nextLine();
		return retorno;
	}
}
