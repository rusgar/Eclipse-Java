package main;

// 	Realiza un programa que calcule el área del círculo comprendida en una circunferencia de radio 4,5
public class mainCuadrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double radio =4.5;	
		
		// Calculamos el área del círculo usando la fórmula: Área de un círculo = π r²
        double circulo = Math.PI * Math.pow(radio, 2);
		
        System.out.println("El area del un ciruclo cuyo radio de  " +  radio + " es: " +"\n"+ "***"+circulo+"***");
	}

}
