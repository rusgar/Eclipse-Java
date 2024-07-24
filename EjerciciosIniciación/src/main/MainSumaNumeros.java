package main;
import java.util.Scanner;
//Realiza un programa que haga la suma de 3 números enteros y lo muestre por pantalla.

public class MainSumaNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner Sumatorio = new Scanner(System.in);
        int numero1, numero2, numero3, suma;
        
        System.out.println("Introduzca el primer numero:");
        numero1 = Sumatorio.nextInt();

        System.out.println("Introduzca el segundo numero");
        numero2 = Sumatorio.nextInt();

        System.out.println("Introduzca el tercer numero:");
        numero3 = Sumatorio.nextInt();

        suma = numero1 + numero2 + numero3;

        System.out.println("******************"+"\n"+"La suma de los tres números es: " + suma+"\n"+"******************");
     // con argumentos
        
        if(args.length<3) {
        	System.out.println("Numero de argumentos no validos");
        }
        else {
        	int resultado=0;
        	int number1=Integer.parseInt(args[0]);
        	int number2=Integer.parseInt(args[1]);
        	int number3=Integer.parseInt(args[2]);
        	resultado = number1+number2+number3;
         System.out.println("******************"+"\n"+"La suma de los tres números es: " + resultado+"\n"+"******************");	
        }
        
        
        if(args.length<3) {
        	System.out.println("Numero de argumentos no validos");
        }
        else {
        	int resul=0;
        	System.out.println("Introduzca el primer numero1:");
        	int num1=Integer.parseInt(leerTeclado());
        	System.out.println("Introduzca el primer numero2:");
        	int num2=Integer.parseInt(leerTeclado());
        	System.out.println("Introduzca el primer numero3:");
        	int num3=Integer.parseInt(leerTeclado());
        	resul = num1+num2+num3;
         System.out.println("******************"+"\n"+ "La suma de los tres números es: "+num1+"+"+num2+"+"+num3+"+" + resul+"\n"+"******************");	
        }
       
    }
	private static String leerTeclado() {
		
		Scanner scanner=new Scanner(System.in);
		return scanner.nextLine();
	}

      
	
}
