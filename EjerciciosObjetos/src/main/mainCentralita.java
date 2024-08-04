package main;
import helpers.CommonHelpers;
import model.Centralita;

public class mainCentralita {
    public static void main(String[] args) {
        CommonHelpers ayudaHelpers = new CommonHelpers();

        
        ayudaHelpers.imprimirContinuo("Introduce el consumo medio (litros/100km):");
        double consumoMedio = ayudaHelpers.leerTecladoDouble();

        ayudaHelpers.imprimirContinuo("Introduce el consumo instantáneo (litros/hora):");
        double consumoInstantaneo = ayudaHelpers.leerTecladoDouble();

        ayudaHelpers.imprimirContinuo("Introduce el tiempo de aceleración (segundos 0-100 km/h):");
        double tiempoAceleracion = ayudaHelpers.leerTecladoDouble();

        ayudaHelpers.imprimirContinuo("Introduce la velocidad instantánea (km/h):");
        double velocidadInstantanea = ayudaHelpers.leerTecladoDouble();

        Centralita centralita = new Centralita(consumoMedio, consumoInstantaneo, tiempoAceleracion, velocidadInstantanea);

    
        centralita.mostrarDatos();
        try {
            ayudaHelpers.imprimirSalto("\nIntroduce el nuevo consumo medio (litros/100km):");
            centralita.setConsumoMedio(ayudaHelpers.leerTecladoDouble());
        } catch (IllegalArgumentException e) {
            ayudaHelpers.imprimirSalto("Error: " + e.getMessage());
        }
        ayudaHelpers.imprimirSalto("Introduce la nueva velocidad instantánea (km/h):");
        centralita.setVelocidadInstantanea(ayudaHelpers.leerTecladoDouble());
       
        ayudaHelpers.imprimirSalto("\nDatos actualizados:");
        centralita.mostrarDatos();
    }
}
