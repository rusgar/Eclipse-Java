package main;

import java.text.DecimalFormat;

// 	Realiza un programa que calcule el área del círculo comprendida en una circunferencia de radio 4,5
public class mainCuadrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double radio =4.5;	
		
		// Calculamos el área del círculo usando la fórmula: Área de un círculo = π r²
        double circulo = Math.PI * Math.pow(radio, 2);
        
     // Formateamos el área del círculo con dos decimales
        String areaFormateada = String.format("%.2f", circulo); // Utiliza String.format()
        DecimalFormat newcirculo = new DecimalFormat("#.00");
        String circuloDecimalFormat = newcirculo.format(circulo);
        
		
        System.out.println("El area del un ciruclo cuyo radio de  " +  radio + " es: " +"\n"+ "***"+circulo+"***");
        System.out.println("El area del un ciruclo cuyo radio de  " +  radio + " es: " +"\n"+ "***"+areaFormateada+"***");
        System.out.println("El area del un ciruclo cuyo radio de  " +  radio + " es: " +"\n"+ "***"+circuloDecimalFormat+"***"); 
	}

}
