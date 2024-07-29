package model;

import java.util.Random;

public class Aleatorio1 {
    // DEFINO LOS ATRIBUTOS DE LA CLASE
    private int elemento;
    private int numeroComplementario;
    private int[] numerosSet;
    private int reintegro;

    // CONSTRUCTORES
    public Aleatorio1() {
        this.elemento = 0;
        this.numeroComplementario = 0;
        this.numerosSet = new int[6];
        this.reintegro = 0;
    }

    public Aleatorio1(int elemento, int numeroComplementario, int[] numerosSet, int reintegro) {
        this.elemento = elemento;
        this.numeroComplementario = numeroComplementario;
        this.numerosSet = numerosSet;
        this.reintegro = reintegro;
    }

    // GETTERS Y SETTERS
    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public int getNumeroComplementario() {
        return numeroComplementario;
    }

    public void setNumeroComplementario(int numeroComplementario) {
        this.numeroComplementario = numeroComplementario;
    }

    public int[] getNumerosSet() {
        return numerosSet;
    }

    public void setNumerosSet(int[] numerosSet) {
        this.numerosSet = numerosSet;
    }

    public int getReintegro() {
        return reintegro;
    }

    public void setReintegro(int reintegro) {
        this.reintegro = reintegro;
    }

    // MÉTODO TO STRING
    @Override
    public String toString() {
          
        return "Aleatorio [elemento=" + elemento + ", numeroComplementario=" + numeroComplementario + ", numerosSet="
                + "numerosSet="+(numerosSet) + ", reintegro=" + reintegro + "]";
    }

    // MÉTODO PARA COMPROBAR SI UN NÚMERO YA EXISTE EN EL ARRAY (SIN USAR ARRAYS)
    private boolean yaExiste(int numeroGenerado) {
        for (int numero : numerosSet) {
            if (numero == numeroGenerado) {
                return true;
            }
        }
        return false;
    }

    // MÉTODO PARA GENERAR NÚMEROS SET SIN USAR ARRAYS
    public void generarNumerosSet() {
        Random random = new Random();
        int numeroGenerado;

        for (int i = 0; i < numerosSet.length; i++) {
            do {
                numeroGenerado = random.nextInt(49) + 1; // GENERAR NUMEROS ALETORIOS
            } while (yaExiste(numeroGenerado)); // COMPROBAR SI YA EXISTE

            numerosSet[i] = numeroGenerado; 
            
        }// ORDENACION DE MENOR A MAYOR
        for (int i = 0; i < numerosSet.length - 1; i++) {
            for (int j = i + 1; j < numerosSet.length; j++) {
                if (numerosSet[i] > numerosSet[j]) {
                    int temp = numerosSet[i];
                    numerosSet[i] = numerosSet[j];
                    numerosSet[j] = temp;
                }
            }
        }
    }

    // MÉTODO PARA GENERAR NÚMERO COMPLEMENTARIO
    public void generarNumeroComplementario() {
        Random random = new Random();
        int numeroComplementario;
        do {
            numeroComplementario = random.nextInt(49) + 1;
        } while (yaExiste(numeroComplementario));
        setNumeroComplementario(numeroComplementario);
    }

    // MÉTODO PARA GENERAR NÚMERO DE REINTEGRO
    public void generarNumeroReintegro() {
        Random random = new Random();
        setReintegro(random.nextInt(10));
    }
}

