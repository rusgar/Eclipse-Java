package Main;


import java.util.Scanner;

 

//Realiza un programa que pida 3 números por pantalla e indique el mayor  y el menor de ellos.
public class MainNumeroMayor {

	public static void main(String[] args) {
		// definimos las variables, poniendolas a cero
		int primerNumero=0;
		int segundoNumero=0;
		int tercerNumero=0;
		int medio = 0;
		int mayor=0;
		int menor=0;
		int intermedio=0;
		
		System.out.print("Dame el primer número: ");
        primerNumero = Integer.parseInt(leerTeclado());

        System.out.print("Dame el segundo número: ");
        segundoNumero = Integer.parseInt(leerTeclado());
        
        System.out.print("Dame el tercer número: ");
        tercerNumero = Integer.parseInt(leerTeclado());
        
        
        mayor = primerNumero;
        if (segundoNumero > mayor) {
            mayor = segundoNumero;
        }
        if ( tercerNumero> mayor) {
            mayor =  tercerNumero;
        }
        
        menor = primerNumero;
        if (segundoNumero < menor) {
            menor = segundoNumero;
        }
        if (tercerNumero < menor) {
            menor = tercerNumero;
        }

        System.out.println("***************"+"\n"+"El número mayor es: " + mayor+ " y el numero menor es:  "+ menor);
       
        
        
        
        // mostrando el resultado como en una tabla
        
        mayor = primerNumero;
        menor = primerNumero;
        medio = primerNumero;
        
        
        if (segundoNumero > mayor) {
            mayor = segundoNumero;
        }
        if (tercerNumero > mayor) {
            mayor = tercerNumero;
        }

        if (segundoNumero < menor) {
            menor = segundoNumero;
        }
        if (tercerNumero < menor) {
            menor = tercerNumero;
        }
        
     // Si el primer número no es ni el mayor ni el menor, es el medio
        if (primerNumero != mayor && primerNumero != menor) {
            medio = primerNumero;
        }

        // Si el segundo número no es ni el mayor ni el menor, es el medio
        if (segundoNumero != mayor && segundoNumero != menor) {
            medio = segundoNumero;
        }
        // Si el segundo número no es ni el mayor ni el menor, es el medio
        if (tercerNumero != mayor && tercerNumero != menor) {
            medio = tercerNumero;
        }

        // Mostrar resultados
        System.out.println("***************"+"\n"+"El número mayor es: " + mayor + " y el numero menor es:  " + menor+"\n");

        System.out.println(menor + " => Menor");
        System.out.println(medio); // Imprimir el número medio
        System.out.println(mayor + " => Mayor");
        
        
        // con if multiples o anidados
        
        if (primerNumero >= segundoNumero && primerNumero >= tercerNumero) {
            mayor = primerNumero;
            if (segundoNumero >= tercerNumero) {
                intermedio = segundoNumero;
                menor = tercerNumero;
            } else {
                intermedio = tercerNumero;
                menor = segundoNumero;
            }
        } else if (segundoNumero >= primerNumero && segundoNumero >= tercerNumero) {
            mayor = segundoNumero;
            if (primerNumero >= tercerNumero) {
                intermedio = primerNumero;
                menor = tercerNumero;
            } else {
                intermedio = tercerNumero;
                menor = primerNumero;
            }
        } else {
            mayor = tercerNumero;
            if (primerNumero >= segundoNumero) {
                intermedio = primerNumero;
                menor = segundoNumero;
            } else {
                intermedio = segundoNumero;
                menor = primerNumero;
            }
        }
        System.out.println("***************"+"\n"+"El número mayor es: " + mayor + " y el numero menor es:  " + menor+" ademas el numero medio es: "+intermedio);

        System.out.println(menor + " => Menor");
        System.out.println(intermedio); // Imprimir el número intermedio
        System.out.println(mayor + " => Mayor");
        
        // Resolucion por Arrays*******************************************************
        
        int [] numeros = new int[3];
        numeros [0]=primerNumero;
        numeros [1]=segundoNumero;
        numeros [2]=tercerNumero;
        //calculamos el maximo
        mayor=primerNumero;
        menor=primerNumero;
        for( int i=0; i < numeros.length;i++) {
        	if(mayor < numeros[i]) {
        		mayor =numeros[i];
        	}
        	if(menor < numeros[i]) {
        		menor =numeros[i];
        	}
        	
        }
        System.out.println("***************"+"\n"+" Resolucion por Arrays: El número mayor es: " + mayor + " y el numero menor es:  " + menor+"\n");
        
	}

	private static String leerTeclado() {
		String retorno="";
		Scanner scn= new Scanner(System.in);
		retorno=scn.nextLine();
		return retorno;
	}
}
