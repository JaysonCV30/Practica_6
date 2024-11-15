package com.mycompany.practica_6;

import java.util.ArrayList;
//import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Practica_6 {

    public static void main(String[] args) {
        // Crear el dialogo para seleccionar el número de jugadores
        SeleccionJugadoresDialog dialog = new SeleccionJugadoresDialog(new JFrame());
        dialog.setVisible(true);
        
        // Obtener la cantidad de jugadores seleccionados en el diálogo
        int cantidadJugadores = dialog.getCantidadJugadores();
        System.out.println(cantidadJugadores);

        // Crear la lista de jugadores
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < cantidadJugadores; i++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador " + (i + 1) + ":");
            jugadores.add(new Jugador(nombre));
        }

        // Usar un diálogo gráfico para pedir los puntos para ganar
        String input = JOptionPane.showInputDialog("Ingrese el puntaje máximo para ganar?");
        
        // Convertir el input a entero
        int puntosParaGanar = 0;
        try {
            puntosParaGanar = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // Si no es un número válido, mostrar un error y terminar
            JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido de puntos.");
            return;
        }

        // Crear el juego con los jugadores
        JuegoAhorcado juego = new JuegoAhorcado(jugadores);
        
        
        // Establecer los puntos para ganar
        juego.setPuntosParaGanar(puntosParaGanar);

        // Iniciar el juego
        while (true) {
            juego.jugarRonda();
            for (Jugador jugador : jugadores) {
                if (juego.haGanado(jugador)) {
                    JOptionPane.showMessageDialog(null, jugador.getNombre() + " ha ganado el juego!");
                    return;
                }
            }
        }
    }
}