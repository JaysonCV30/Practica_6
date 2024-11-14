package com.mycompany.practica_6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JuegoAhorcado_grafico extends javax.swing.JFrame {

    private ArrayList<JLabel> nombresDeJugadores;
    private ArrayList<JLabel> puntosDeJugadores;
    private ArrayList<JLabel> letrasFrase;
    private FrasesRepository frases;
    private char letraElegida;

    public JuegoAhorcado_grafico() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        letrasFrase = new ArrayList<>();
        frases = new FrasesRepository();

        nombresDeJugadores = new ArrayList<>();
        nombresDeJugadores.add(nombreJugador1);
        nombresDeJugadores.add(nombreJugador2);
        nombresDeJugadores.add(nombreJugador3);
        nombresDeJugadores.add(nombreJugador4);

        puntosDeJugadores = new ArrayList<>();
        puntosDeJugadores.add(puntuacionJugador1);
        puntosDeJugadores.add(puntuacionJugador2);
        puntosDeJugadores.add(puntuacionJugador3);
        puntosDeJugadores.add(puntuacionJugador4);

        jLabel6.setVisible(false);
        FraseAdivinada.setVisible(false);
    }

    public void mostrarTurnoYPuntosDelJugador(Jugador jugador) {
        nombreDelJugador.setText(jugador.getNombre());
        puntuacionActual.setText(Integer.toString(jugador.getPuntos()));
    }

    public void mostrarPuntajeMaximo(int puntosParaGanar) {
        puntuacionMaxima.setText(Integer.toString(puntosParaGanar));
    }

    public void mostrarFraseAdivinada(String fraseAdivinada) {
        FraseAdivinada.setText(fraseAdivinada);
        jLabel6.setVisible(true);
        FraseAdivinada.setVisible(true);
    }

    public void mostrarHistorial(ArrayList<Jugador> jugadores) {
        nombresDeJugadores.forEach(label -> label.setVisible(false));
        puntosDeJugadores.forEach(label -> label.setVisible(false));

        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            JLabel nombreJugador = nombresDeJugadores.get(i);
            nombreJugador.setText(jugador.getNombre());
            nombreJugador.setVisible(true);

            JLabel puntuacionJugador = puntosDeJugadores.get(i);
            puntuacionJugador.setText(Integer.toString(jugador.getPuntos()));
            puntuacionJugador.setVisible(true);
        }
    }

    public void inicializarPanelFrase(String frase) {
        System.out.println("Inicializando panel con frase: " + frase);
        letrasFrase.clear(); // Limpiar las etiquetas anteriores si existiesen
        panelFrase.removeAll();

        // Crear un JLabel para cada letra en la frase
        for (int i = 0; i < frase.length(); i++) {
            JLabel letra = new JLabel("_");
            letra.setFont(new Font("Arial", Font.PLAIN, 35));
            letra.setPreferredSize(new Dimension(10, 80));
            letrasFrase.add(letra);
            panelFrase.add(letra); // Añadir cada letra al panel
        }

        panelFrase.revalidate();
        panelFrase.repaint();
        System.out.println("Panel inicializado con " + letrasFrase.size() + " letras.");
    }

    public void mostrarFrase(String frase, HashSet<Character> letrasIndicadas) {
        // Verifica que letrasFrase tenga el mismo tamaño que la frase
        if (letrasFrase.size() != frase.length()) {
            System.out.println("Error: el tamaño de letrasFrase no coincide con la longitud de la frase.");
            while (letrasFrase.size() < frase.length()) {
                letrasFrase.add(new JLabel("_"));  // Añadir etiquetas si faltan
            }
            while (letrasFrase.size() > frase.length()) {
                letrasFrase.remove(letrasFrase.size() - 1);  // Eliminar etiquetas si sobran
            }
        }

        // Agregar una línea para cada letra en la frase
        for (int i = 0; i < frase.length(); i++) {
            JLabel letra = letrasFrase.get(i);
            if (Character.isWhitespace(frase.charAt(i)) || letrasIndicadas.contains(Character.toLowerCase(frase.charAt(i)))) {
                letra.setText(String.valueOf(frase.charAt(i))); // Mostrar la letra si ya ha sido adivinada o es un espacio
            } else {
                letra.setText("_"); // Mantener la línea si no ha sido adivinada
            }
        }
        // Refrescar el panel para reflejar los cambios
        panelFrase.revalidate();
        panelFrase.repaint();
        //add(panelFrase, BorderLayout.CENTER);
    }

    public void setletraSeleccionada(char letraSeleccionada) {
        letraElegida = letraSeleccionada;
    }

    public char getLetraElegida() {
        return letraElegida;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LetraA = new javax.swing.JButton();
        LetraB = new javax.swing.JButton();
        LetraC = new javax.swing.JButton();
        LetraD = new javax.swing.JButton();
        LetraE = new javax.swing.JButton();
        LetraF = new javax.swing.JButton();
        LetraK = new javax.swing.JButton();
        LetraG = new javax.swing.JButton();
        LetraI = new javax.swing.JButton();
        LetraJ = new javax.swing.JButton();
        LetraH = new javax.swing.JButton();
        LetraR = new javax.swing.JButton();
        LetraQ = new javax.swing.JButton();
        LetraP = new javax.swing.JButton();
        LetraO = new javax.swing.JButton();
        LetraL = new javax.swing.JButton();
        LetraM = new javax.swing.JButton();
        LetraN = new javax.swing.JButton();
        LetraS = new javax.swing.JButton();
        LetraT = new javax.swing.JButton();
        LetraU = new javax.swing.JButton();
        LetraV = new javax.swing.JButton();
        LetraW = new javax.swing.JButton();
        LetraX = new javax.swing.JButton();
        LetraY = new javax.swing.JButton();
        LetraZ = new javax.swing.JButton();
        LetraÑ = new javax.swing.JButton();
        puntuacionActual = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nombreDelJugador = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreJugador1 = new javax.swing.JLabel();
        nombreJugador2 = new javax.swing.JLabel();
        nombreJugador3 = new javax.swing.JLabel();
        nombreJugador4 = new javax.swing.JLabel();
        puntuacionMaxima = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        puntuacionJugador1 = new javax.swing.JLabel();
        puntuacionJugador2 = new javax.swing.JLabel();
        puntuacionJugador3 = new javax.swing.JLabel();
        puntuacionJugador4 = new javax.swing.JLabel();
        panelFrase = new javax.swing.JPanel();
        FraseAdivinada = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1250, 650));

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1250, 650));

        LetraA.setBackground(new java.awt.Color(255, 51, 51));
        LetraA.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraA.setForeground(new java.awt.Color(0, 255, 204));
        LetraA.setText("A");
        LetraA.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraAActionPerformed(evt);
            }
        });

        LetraB.setBackground(new java.awt.Color(255, 51, 51));
        LetraB.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraB.setForeground(new java.awt.Color(0, 255, 204));
        LetraB.setText("B");
        LetraB.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraBActionPerformed(evt);
            }
        });

        LetraC.setBackground(new java.awt.Color(255, 51, 51));
        LetraC.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraC.setForeground(new java.awt.Color(0, 255, 204));
        LetraC.setText("C");
        LetraC.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraCActionPerformed(evt);
            }
        });

        LetraD.setBackground(new java.awt.Color(255, 51, 51));
        LetraD.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraD.setForeground(new java.awt.Color(0, 255, 204));
        LetraD.setText("D");
        LetraD.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraDActionPerformed(evt);
            }
        });

        LetraE.setBackground(new java.awt.Color(255, 51, 51));
        LetraE.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraE.setForeground(new java.awt.Color(0, 255, 204));
        LetraE.setText("E");
        LetraE.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraEActionPerformed(evt);
            }
        });

        LetraF.setBackground(new java.awt.Color(255, 51, 51));
        LetraF.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraF.setForeground(new java.awt.Color(0, 255, 204));
        LetraF.setText("F");
        LetraF.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraFActionPerformed(evt);
            }
        });

        LetraK.setBackground(new java.awt.Color(255, 51, 51));
        LetraK.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraK.setForeground(new java.awt.Color(0, 255, 204));
        LetraK.setText("K");
        LetraK.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraKActionPerformed(evt);
            }
        });

        LetraG.setBackground(new java.awt.Color(255, 51, 51));
        LetraG.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraG.setForeground(new java.awt.Color(0, 255, 204));
        LetraG.setText("G");
        LetraG.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraGActionPerformed(evt);
            }
        });

        LetraI.setBackground(new java.awt.Color(255, 51, 51));
        LetraI.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraI.setForeground(new java.awt.Color(0, 255, 204));
        LetraI.setText("I");
        LetraI.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraIActionPerformed(evt);
            }
        });

        LetraJ.setBackground(new java.awt.Color(255, 51, 51));
        LetraJ.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraJ.setForeground(new java.awt.Color(0, 255, 204));
        LetraJ.setText("J");
        LetraJ.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraJActionPerformed(evt);
            }
        });

        LetraH.setBackground(new java.awt.Color(255, 51, 51));
        LetraH.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraH.setForeground(new java.awt.Color(0, 255, 204));
        LetraH.setText("H");
        LetraH.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraHActionPerformed(evt);
            }
        });

        LetraR.setBackground(new java.awt.Color(255, 51, 51));
        LetraR.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraR.setForeground(new java.awt.Color(0, 255, 204));
        LetraR.setText("R");
        LetraR.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraRActionPerformed(evt);
            }
        });

        LetraQ.setBackground(new java.awt.Color(255, 51, 51));
        LetraQ.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraQ.setForeground(new java.awt.Color(0, 255, 204));
        LetraQ.setText("Q");
        LetraQ.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraQActionPerformed(evt);
            }
        });

        LetraP.setBackground(new java.awt.Color(255, 51, 51));
        LetraP.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraP.setForeground(new java.awt.Color(0, 255, 204));
        LetraP.setText("P");
        LetraP.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraPActionPerformed(evt);
            }
        });

        LetraO.setBackground(new java.awt.Color(255, 51, 51));
        LetraO.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraO.setForeground(new java.awt.Color(0, 255, 204));
        LetraO.setText("O");
        LetraO.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraOActionPerformed(evt);
            }
        });

        LetraL.setBackground(new java.awt.Color(255, 51, 51));
        LetraL.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraL.setForeground(new java.awt.Color(0, 255, 204));
        LetraL.setText("L");
        LetraL.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraLActionPerformed(evt);
            }
        });

        LetraM.setBackground(new java.awt.Color(255, 51, 51));
        LetraM.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraM.setForeground(new java.awt.Color(0, 255, 204));
        LetraM.setText("M");
        LetraM.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraMActionPerformed(evt);
            }
        });

        LetraN.setBackground(new java.awt.Color(255, 51, 51));
        LetraN.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraN.setForeground(new java.awt.Color(0, 255, 204));
        LetraN.setText("N");
        LetraN.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraNActionPerformed(evt);
            }
        });

        LetraS.setBackground(new java.awt.Color(255, 51, 51));
        LetraS.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraS.setForeground(new java.awt.Color(0, 255, 204));
        LetraS.setText("S");
        LetraS.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraSActionPerformed(evt);
            }
        });

        LetraT.setBackground(new java.awt.Color(255, 51, 51));
        LetraT.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraT.setForeground(new java.awt.Color(0, 255, 204));
        LetraT.setText("T");
        LetraT.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraTActionPerformed(evt);
            }
        });

        LetraU.setBackground(new java.awt.Color(255, 51, 51));
        LetraU.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraU.setForeground(new java.awt.Color(0, 255, 204));
        LetraU.setText("U");
        LetraU.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraUActionPerformed(evt);
            }
        });

        LetraV.setBackground(new java.awt.Color(255, 51, 51));
        LetraV.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraV.setForeground(new java.awt.Color(0, 255, 204));
        LetraV.setText("V");
        LetraV.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraVActionPerformed(evt);
            }
        });

        LetraW.setBackground(new java.awt.Color(255, 51, 51));
        LetraW.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraW.setForeground(new java.awt.Color(0, 255, 204));
        LetraW.setText("W");
        LetraW.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraWActionPerformed(evt);
            }
        });

        LetraX.setBackground(new java.awt.Color(255, 51, 51));
        LetraX.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraX.setForeground(new java.awt.Color(0, 255, 204));
        LetraX.setText("X");
        LetraX.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraXActionPerformed(evt);
            }
        });

        LetraY.setBackground(new java.awt.Color(255, 51, 51));
        LetraY.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraY.setForeground(new java.awt.Color(0, 255, 204));
        LetraY.setText("Y");
        LetraY.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraYActionPerformed(evt);
            }
        });

        LetraZ.setBackground(new java.awt.Color(255, 51, 51));
        LetraZ.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraZ.setForeground(new java.awt.Color(0, 255, 204));
        LetraZ.setText("Z");
        LetraZ.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraZActionPerformed(evt);
            }
        });

        LetraÑ.setBackground(new java.awt.Color(255, 51, 51));
        LetraÑ.setFont(new java.awt.Font("Cascadia Mono", 1, 40)); // NOI18N
        LetraÑ.setForeground(new java.awt.Color(0, 255, 204));
        LetraÑ.setText("Ñ");
        LetraÑ.setPreferredSize(new java.awt.Dimension(60, 60));
        LetraÑ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetraÑActionPerformed(evt);
            }
        });

        puntuacionActual.setFont(new java.awt.Font("Elephant", 0, 36)); // NOI18N
        puntuacionActual.setForeground(new java.awt.Color(255, 0, 0));
        puntuacionActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntuacionActual.setText("0");

        jLabel1.setFont(new java.awt.Font("Elephant", 0, 40)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Turno Actual");
        jLabel1.setPreferredSize(new java.awt.Dimension(300, 50));

        nombreDelJugador.setFont(new java.awt.Font("Elephant", 0, 36)); // NOI18N
        nombreDelJugador.setForeground(new java.awt.Color(255, 0, 0));
        nombreDelJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreDelJugador.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Elephant", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Puntos:");

        jLabel3.setFont(new java.awt.Font("Elephant", 0, 40)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Puntos para ganar");
        jLabel3.setPreferredSize(new java.awt.Dimension(300, 50));

        nombreJugador1.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        nombreJugador1.setForeground(new java.awt.Color(0, 0, 255));
        nombreJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador1.setText("jugador1:");

        nombreJugador2.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        nombreJugador2.setForeground(new java.awt.Color(0, 0, 255));
        nombreJugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador2.setText("jugador2:");

        nombreJugador3.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        nombreJugador3.setForeground(new java.awt.Color(0, 0, 255));
        nombreJugador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador3.setText("jugador3:");

        nombreJugador4.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        nombreJugador4.setForeground(new java.awt.Color(0, 0, 255));
        nombreJugador4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador4.setText("jugador4:");

        puntuacionMaxima.setFont(new java.awt.Font("Elephant", 0, 40)); // NOI18N
        puntuacionMaxima.setForeground(new java.awt.Color(0, 255, 255));
        puntuacionMaxima.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntuacionMaxima.setText("0");

        jLabel4.setFont(new java.awt.Font("Elephant", 0, 40)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Historial");
        jLabel4.setPreferredSize(new java.awt.Dimension(300, 50));

        puntuacionJugador1.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        puntuacionJugador1.setForeground(new java.awt.Color(0, 0, 255));
        puntuacionJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntuacionJugador1.setText("0");

        puntuacionJugador2.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        puntuacionJugador2.setForeground(new java.awt.Color(0, 0, 255));
        puntuacionJugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntuacionJugador2.setText("0");
        puntuacionJugador2.setPreferredSize(new java.awt.Dimension(40, 23));

        puntuacionJugador3.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        puntuacionJugador3.setForeground(new java.awt.Color(0, 0, 255));
        puntuacionJugador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntuacionJugador3.setText("0");

        puntuacionJugador4.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        puntuacionJugador4.setForeground(new java.awt.Color(0, 0, 255));
        puntuacionJugador4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntuacionJugador4.setText("0");

        panelFrase.setBackground(new java.awt.Color(0, 153, 204));
        panelFrase.setPreferredSize(new java.awt.Dimension(1250, 80));
        panelFrase.setLayout(new java.awt.GridLayout(1, 60));

        FraseAdivinada.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        FraseAdivinada.setForeground(new java.awt.Color(0, 255, 255));
        FraseAdivinada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FraseAdivinada.setText("jLabel5");

        jLabel6.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Frase que se adivino anteriormente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nombreDelJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(813, 813, 813))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(puntuacionActual, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(puntuacionMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(339, 339, 339))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(159, 159, 159)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreJugador3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombreJugador1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombreJugador2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombreJugador4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(puntuacionJugador3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(puntuacionJugador2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(puntuacionJugador1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(puntuacionJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(FraseAdivinada, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(354, 354, 354)))))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LetraA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LetraT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LetraU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LetraV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LetraW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LetraX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LetraY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LetraZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LetraL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LetraM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LetraN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LetraÑ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LetraO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LetraP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LetraQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LetraR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LetraS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LetraB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LetraC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LetraD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LetraE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LetraF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LetraG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LetraH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LetraI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LetraJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(LetraK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
            .addComponent(panelFrase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nombreDelJugador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(puntuacionActual)
                                    .addComponent(jLabel2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(puntuacionMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(puntuacionJugador1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(puntuacionJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(puntuacionJugador3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(puntuacionJugador4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nombreJugador1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreJugador2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreJugador3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreJugador4)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FraseAdivinada, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(panelFrase, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LetraA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LetraL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraÑ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LetraV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LetraT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LetraBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraBActionPerformed
        char letra = 'b';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraBActionPerformed

    private void LetraAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraAActionPerformed
        char letra = 'a';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraAActionPerformed

    private void LetraCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraCActionPerformed
        char letra = 'c';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraCActionPerformed

    private void LetraDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraDActionPerformed
        char letra = 'd';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraDActionPerformed

    private void LetraEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraEActionPerformed
        char letra = 'e';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraEActionPerformed

    private void LetraFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraFActionPerformed
        char letra = 'f';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraFActionPerformed

    private void LetraGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraGActionPerformed
        char letra = 'g';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraGActionPerformed

    private void LetraHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraHActionPerformed
        char letra = 'h';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraHActionPerformed

    private void LetraIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraIActionPerformed
        char letra = 'i';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraIActionPerformed

    private void LetraJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraJActionPerformed
        char letra = 'j';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraJActionPerformed

    private void LetraKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraKActionPerformed
        char letra = 'k';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraKActionPerformed

    private void LetraLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraLActionPerformed
        char letra = 'l';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraLActionPerformed

    private void LetraMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraMActionPerformed
        char letra = 'm';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraMActionPerformed

    private void LetraNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraNActionPerformed
        char letra = 'n';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraNActionPerformed

    private void LetraÑActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraÑActionPerformed
        char letra = 'ñ';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraÑActionPerformed

    private void LetraOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraOActionPerformed
        char letra = 'o';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraOActionPerformed

    private void LetraPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraPActionPerformed
        char letra = 'p';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraPActionPerformed

    private void LetraQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraQActionPerformed
        char letra = 'q';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraQActionPerformed

    private void LetraRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraRActionPerformed
        char letra = 'r';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraRActionPerformed

    private void LetraSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraSActionPerformed
        char letra = 's';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraSActionPerformed

    private void LetraTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraTActionPerformed
        char letra = 't';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraTActionPerformed

    private void LetraUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraUActionPerformed
        char letra = 'u';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraUActionPerformed

    private void LetraVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraVActionPerformed
        char letra = 'v';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraVActionPerformed

    private void LetraWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraWActionPerformed
        char letra = 'w';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraWActionPerformed

    private void LetraXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraXActionPerformed
        char letra = 'x';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraXActionPerformed

    private void LetraYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraYActionPerformed
        char letra = 'y';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraYActionPerformed

    private void LetraZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetraZActionPerformed
        char letra = 'z';
        setletraSeleccionada(letra);
    }//GEN-LAST:event_LetraZActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JuegoAhorcado_grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoAhorcado_grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoAhorcado_grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoAhorcado_grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoAhorcado_grafico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FraseAdivinada;
    private javax.swing.JButton LetraA;
    private javax.swing.JButton LetraB;
    private javax.swing.JButton LetraC;
    private javax.swing.JButton LetraD;
    private javax.swing.JButton LetraE;
    private javax.swing.JButton LetraF;
    private javax.swing.JButton LetraG;
    private javax.swing.JButton LetraH;
    private javax.swing.JButton LetraI;
    private javax.swing.JButton LetraJ;
    private javax.swing.JButton LetraK;
    private javax.swing.JButton LetraL;
    private javax.swing.JButton LetraM;
    private javax.swing.JButton LetraN;
    private javax.swing.JButton LetraO;
    private javax.swing.JButton LetraP;
    private javax.swing.JButton LetraQ;
    private javax.swing.JButton LetraR;
    private javax.swing.JButton LetraS;
    private javax.swing.JButton LetraT;
    private javax.swing.JButton LetraU;
    private javax.swing.JButton LetraV;
    private javax.swing.JButton LetraW;
    private javax.swing.JButton LetraX;
    private javax.swing.JButton LetraY;
    private javax.swing.JButton LetraZ;
    private javax.swing.JButton LetraÑ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombreDelJugador;
    private javax.swing.JLabel nombreJugador1;
    private javax.swing.JLabel nombreJugador2;
    private javax.swing.JLabel nombreJugador3;
    private javax.swing.JLabel nombreJugador4;
    private javax.swing.JPanel panelFrase;
    private javax.swing.JLabel puntuacionActual;
    private javax.swing.JLabel puntuacionJugador1;
    private javax.swing.JLabel puntuacionJugador2;
    private javax.swing.JLabel puntuacionJugador3;
    private javax.swing.JLabel puntuacionJugador4;
    private javax.swing.JLabel puntuacionMaxima;
    // End of variables declaration//GEN-END:variables
}
