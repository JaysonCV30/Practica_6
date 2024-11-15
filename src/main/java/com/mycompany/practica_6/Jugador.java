package com.mycompany.practica_6;

import java.util.HashSet;

/**
 *
 * @author Jayson
 */
public class Jugador {
    private String nombre;
    private int puntos;
    HashSet<Character> letrasIndicadas;
    
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.letrasIndicadas = new HashSet<>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void añadirPuntos(int puntos) {
        this.puntos += puntos;
    }

    public boolean indicarLetra(char letra) {
        return letrasIndicadas.add(letra);
    }

    public boolean yaIndicada(char letra) {
        return letrasIndicadas.contains(letra);
    }

    @Override
    public String toString() {
        return nombre + " - Puntos: " + puntos;
    }
}