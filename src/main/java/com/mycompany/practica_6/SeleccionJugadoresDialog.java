package com.mycompany.practica_6;

import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;

public class SeleccionJugadoresDialog extends JDialog {
    private int cantidadJugadores;
    private JButton btn2Jugadores;
    private JButton btn3Jugadores;
    private JButton btn4Jugadores;
    
    public SeleccionJugadoresDialog(Frame parent){
        super(parent, "Seleccionar Cantidad de Jugadores",true);
        
        setLayout(new GridLayout(4,1));
        
        btn2Jugadores = new JButton("2 jugadores");
        btn3Jugadores = new JButton("3 jugadores");
        btn4Jugadores = new JButton("4 jugadores");
        
        add(btn2Jugadores);
        add(btn3Jugadores);
        add(btn4Jugadores);
        
        btn2Jugadores.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
               cantidadJugadores = 2;
               dispose();
           } 
        });
        
        btn3Jugadores.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
               cantidadJugadores = 3;
               dispose();
           } 
        });
        
        btn4Jugadores.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
               cantidadJugadores = 4;
               dispose();
           } 
        });
        
        pack();
        setLocationRelativeTo(parent);
    }
    
    public int getCantidadJugadores(){
        return cantidadJugadores;
    }
}