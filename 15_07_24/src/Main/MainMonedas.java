package Main;
import java.util.Scanner;

public class MainMonedas {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
    	 
    	int cantidad = 0; 
        int billete500 = 0;
        int billete200 = 0;
        int billete100 = 0;
        int billete50 = 0;
        int billete20 = 0;
        int billete10 = 0;
        int billete5 = 0;
        int moneda2 = 0;
        int moneda1 = 0;
        
        int totalBilletes=0;
        int totalMonedas=0;
        
        System.out.print("Introduzca la cantidad en euros: ");       
        cantidad = scanner.nextInt();
        
        System.out.println("Cuantos Billetes o monedas hay en la cantidad:");
        while (cantidad > 0) {
            if (cantidad >= 500) {
                billete500 = cantidad / 500;
                cantidad %= 500;
                System.out.println(" - 500€: " + billete500+ (billete500 == 1 ? " billete" : " billetes"));
                
                totalBilletes += billete500;
            } else if (cantidad >= 200) {
                billete200 = cantidad / 200;
                cantidad %= 200;
                System.out.println(" - 200€: " + billete200+(billete200 == 1 ? " billete" : " billetes"));
                totalBilletes += billete200;
            } else if (cantidad >= 100) {
                billete100 = cantidad / 100;
                cantidad %= 100;
                System.out.println(" - 100€: " + billete100+(billete100 == 1 ? " billete" : " billetes"));
                totalBilletes += billete100;
            } else if (cantidad >= 50) {
                billete50 = cantidad / 50;
                System.out.println(" - 50€: " + billete50+(billete50 == 1 ? " billete" : " billetes"));
                cantidad %= 50;
                totalBilletes += billete50;
            } else if (cantidad >= 20) {
                billete20 = cantidad / 20;
                cantidad %= 20;
                System.out.println(" - 20€: " + billete20+(billete20 == 1 ? " billete" : " billetes"));
                totalBilletes += billete20;
            } else if (cantidad >= 10) {
                billete10 = cantidad / 10;
                cantidad %= 10;
                System.out.println(" - 10€: " + billete10+(billete10 == 1 ? " billete" : " billetes"));
                totalBilletes += billete10;
            } else if (cantidad >= 5) {
                billete5 = cantidad / 5;
                cantidad %= 5;
                System.out.println(" - 5€: " + billete5+(billete5 == 1 ? " billete" : " billetes"));
                totalBilletes += billete5;
            } else if (cantidad >= 2) {
                moneda2 = cantidad / 2;
                cantidad %= 2;
                System.out.println(" - 2€ monedas: " + moneda2+(moneda2 == 1 ? " moneda" : " monedas"));
                totalMonedas += moneda2;
            } else {
                moneda1 = cantidad;
                cantidad = 0;
                totalMonedas += moneda1;
                System.out.println(" - 1€ monedas: " + moneda1+(moneda1 == 1 ? " moneda" : " monedas"));
            }
        }

        System.out.println("\nTotal billetes: " + totalBilletes+(totalBilletes == 1 ? " moneda" : " monedas"));
        System.out.println("Total monedas:"+ totalMonedas +(totalMonedas == 1 ? " moneda" : " monedas"));
     
 
    }
}
        

/* if (moneda1 == 1) {
System.out.println(" - 1€ moneda: " + moneda1);
} else {
System.out.println(" - 1€ monedas: " + moneda1);
}*/