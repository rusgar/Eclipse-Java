package main;

public class intercambioValores {

    public static void main(String[] args) {
        // Declaramos las variables
        double n1 = 5.5;
        double n2 = 7.1;

        System.out.println("Antes del intercambio:");
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);

        // Intercambiar valores sin variable temporal
        n1 = n1 + n2;
        n2 = n1 - n2;
        n1 = n1 - n2;

        System.out.println("Después del Intercambio:");
        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
    }
    
    

}
