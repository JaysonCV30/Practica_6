package com.mycompany.practica_6;

import java.util.ArrayList;
import java.util.HashSet;

public class JuegoAhorcado {

    private ArrayList<Jugador> jugadores;
    private String frase;
    private int puntosPorGanador;
    private int puntosParaGanar;
    private int rondaActual;
    private FrasesRepository frasesRepository;
    private HashSet<Character> letrasIndicadas; // Para rastrear letras adivinadas
    private JuegoAhorcado_grafico juegoGrafico;

    public JuegoAhorcado(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
        frasesRepository = new FrasesRepository();
        frase = frasesRepository.obtenerFraseAleatoria().toLowerCase();
        puntosParaGanar = 0;
        puntosPorGanador = 5;
        rondaActual = 0;
        letrasIndicadas = new HashSet<>(); // Inicializa el conjunto
        juegoGrafico = new JuegoAhorcado_grafico();
    }

    public void jugarRonda() {
        HashSet<Character> letrasEnFrase = new HashSet<>();
        for (char c : frase.toCharArray()) {
            if (Character.isLetter(c)) {
                letrasEnFrase.add(c);
            }
        }

        boolean fraseAdivinada = false;

        while (!letrasEnFrase.isEmpty()) {
            for (Jugador jugador : jugadores) {
                boolean sigueAdivinando = true;

                while (sigueAdivinando) {
                    juegoGrafico.inicializarPanelFrase(frase);
                    juegoGrafico.setVisible(true);
                    System.out.println("Turno de " + jugador.getNombre() + ":");
                    juegoGrafico.mostrarTurnoYPuntosDelJugador(jugador);
                    System.out.println("Puntos actuales: " + jugador.getPuntos());
                    juegoGrafico.mostrarHistorial(jugadores);
                    System.out.println("Frase actual: " + mostrarFrase());

                    System.out.print("Indique una letra: ");
                    char letra = juegoGrafico.getLetraElegida();
                    // Verificar que sea una letra
                    while (letra == '\0') {
                        letra = juegoGrafico.getLetraElegida();
                    }

                    // Verifica si la letra ya fue indicada por el jugador
                    if (letrasIndicadas.contains(letra)) {
                        jugador.añadirPuntos(-3);
                        System.out.println("Letra ya indicada. -3 puntos.");
                        sigueAdivinando = false;
                    } else {
                        // Marca la letra como indicada
                        letrasIndicadas.add(letra);

                        // Aquí estamos contando las apariciones de la letra en la frase sin usar lambda
                        int apariciones = 0;
                        for (char c : frase.toCharArray()) {
                            if (c == letra) {
                                apariciones++;
                            }
                        }

                        if (apariciones > 0) {
                            jugador.añadirPuntos(3 * apariciones);
                            letrasEnFrase.remove(letra);
                            System.out.println("¡Correcto! + " + (3 * apariciones) + " puntos.");
                        } else {
                            jugador.añadirPuntos(-1);
                            System.out.println("Incorrecto. -1 punto.");
                            sigueAdivinando = false; // Si falla, el jugador pasa al siguiente
                        }
                    }

                    juegoGrafico.mostrarFrase(frase, letrasIndicadas);

                    // Verifica si la frase ha sido adivinada
                    if (letrasEnFrase.isEmpty()) {
                        fraseAdivinada = true;
                        jugador.añadirPuntos(puntosPorGanador);
                        juegoGrafico.mostrarTurnoYPuntosDelJugador(jugador);
                        System.out.println(jugador.getNombre() + " ha ganado la ronda! " + "con " + jugador.getPuntos() + " puntos!!");
                        System.out.println("La frase completa es: " + frase);
                        juegoGrafico.mostrarFraseAdivinada(frase);
                        break;
                    }
                    juegoGrafico.setletraSeleccionada('\0');
                }

                if (fraseAdivinada) {
                    break; // Sale del bucle de jugadores si alguien ganó
                }
            }
        }

        // Mostrar la puntuación final de todos los jugadores
        System.out.println("Puntuaciones finales de la ronda:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }

        // Verifica si algún jugador ha alcanzado la puntuación máxima
        boolean puntuacionMaximaAlcanzada = jugadores.stream().anyMatch(jugador -> jugador.getPuntos() >= puntosParaGanar);

        if (!puntuacionMaximaAlcanzada) {
            // Si nadie ha alcanzado la puntuación máxima, se elige una nueva frase
            this.frase = frasesRepository.obtenerFraseAleatoria().toLowerCase();
            letrasIndicadas.clear(); // Limpia las letras indicadas para la nueva ronda
            System.out.println("Nuevas frase para adivinar: " + mostrarFrase());
        } else {
            System.out.println("Fin del juego, un jugador ha alcanzado la puntuación máxima!");
        }
    }

    public void setPuntosParaGanar(int puntosParaGanar) {
        this.puntosParaGanar = puntosParaGanar;
        juegoGrafico.mostrarPuntajeMaximo(puntosParaGanar);
    }

    private String mostrarFrase() {
        StringBuilder fraseMostrada = new StringBuilder();
        for (char c : frase.toCharArray()) {
            if (Character.isWhitespace(c) || letrasIndicadas.contains(Character.toLowerCase(c))) {
                fraseMostrada.append(c); // Mostrar letra si es un espacio o ha sido adivinada
            } else {
                fraseMostrada.append('_'); // Ocultar letra
            }
        }
        juegoGrafico.mostrarFrase(fraseMostrada.toString(), letrasIndicadas);
        return fraseMostrada.toString();
    }

    public boolean haGanado(Jugador jugador) {
        return jugador.getPuntos() >= puntosParaGanar;
    }
}