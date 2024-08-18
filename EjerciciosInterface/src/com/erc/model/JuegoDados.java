package com.erc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JuegoDados {

    private int numeroJugadores;
    private int cantidadDados;
    private int tipoDado;
    private List<Integer> puntuaciones;
    private List<List<Integer>> combinaciones;
    private int jugadorGanador;

    public JuegoDados(int numeroJugadores, int cantidadDados, int tipoDado) {
        this.numeroJugadores = numeroJugadores;
        this.cantidadDados = cantidadDados;
        this.tipoDado = tipoDado;
        this.puntuaciones = new ArrayList<>();
        this.combinaciones = new ArrayList<>();
    }

    public void lanzarDados() {
        Random random = new Random();
        puntuaciones.clear();
        combinaciones.clear();
        
        for (int i = 1; i <= numeroJugadores; i++) {
            int totalScore = 0;
            List<Integer> combinacionActual = new ArrayList<>();
            for (int j = 0; j < cantidadDados; j++) {
                int tirada = random.nextInt(tipoDado) + 1;
                combinacionActual.add(tirada);
                totalScore += tirada;
            }
            puntuaciones.add(totalScore);
            combinaciones.add(combinacionActual);
        }
        
        // Determinar el jugador ganador
        jugadorGanador = 1;
        int maximaPuntuacion = puntuaciones.get(0);
        for (int i = 1; i < puntuaciones.size(); i++) {
            if (puntuaciones.get(i) > maximaPuntuacion) {
                maximaPuntuacion = puntuaciones.get(i);
                jugadorGanador = i + 1;
            }
        }
    }

    public int getPuntuacionMaxima() {
        return puntuaciones.stream().max(Integer::compare).orElse(0);
    }

    public List<Integer> getCombinacionGanadora() {
        int maxPuntuacion = getPuntuacionMaxima();
        int index = puntuaciones.indexOf(maxPuntuacion);
        return combinaciones.get(index);
    }

    public int getJugadorGanador() {
        return jugadorGanador;
    }

    public int getPuntuacionMaximaPosible() {
        return tipoDado * cantidadDados;
    }
}
