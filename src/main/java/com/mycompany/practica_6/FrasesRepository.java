package com.mycompany.practica_6;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jayson
 */
public class FrasesRepository {
    private ArrayList<String> frases;
    private Random random;

    public FrasesRepository() {
        frases = new ArrayList<>();
        cargarFrases();
        random = new Random();
    }
    
    private void cargarFrases() {
        frases.add("La vida es un viaje no un destino");
        frases.add("El conocimiento es poder");
        frases.add("La practica hace al maestro");
        frases.add("El tiempo es oro");
        frases.add("Quien rie ultimo rie mejor");
        frases.add("Mas vale tarde que nunca");
        frases.add("No hay mal que por bien no venga");
        frases.add("El que mucho abarca poco aprieta");
        frases.add("A mal tiempo buena cara");
        frases.add("La curiosidad mato al gato");
        frases.add("Camaron que se duerme se lo lleva la corriente");
        frases.add("En casa de herrero cuchillo de palo");
        frases.add("Ojos que no ven corazon que no siente");
        frases.add("La esperanza es lo ultimo que se pierde");
        frases.add("Al que madruga Dios le ayuda");
        frases.add("No hay camino para la paz la paz es el camino");
        frases.add("Una imagen vale mas que mil palabras");
        frases.add("El que no arriesga no gana");
        frases.add("Dime con quien andas y te dire quien eres");
        frases.add("Quien busca encuentra");
        frases.add("Cada dia es una nueva oportunidad");
        frases.add("A caballo regalado no le mires el diente");
        frases.add("Mas vale pajaro en mano que ciento volando");
        frases.add("El saber no ocupa lugar");
        frases.add("A palabras necias oidos sordos");
        frases.add("La union hace la fuerza");
        frases.add("El que algo quiere algo le cuesta");
        frases.add("Cuento de nunca acabar");
        frases.add("En el pais de los ciegos el tuerto es rey");
        frases.add("Perro que ladra no muerde");
        frases.add("Al mal paso darle prisa");
        frases.add("Las palabras se las lleva el viento");
    }
    
    public String obtenerFraseAleatoria() {
        int indice = random.nextInt(frases.size());
        return frases.get(indice);
    }
}