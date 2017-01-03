/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Comida;

public class NodoArbol {
    //miembros de acceso

    NodoArbol nodoizquierdo;
    int dato;
    String nombreComida;
    NodoArbol nododerecho;
    Comida datosComida;

    //iniciar dato y hacer de este nodo un nodo hoja
    public NodoArbol(String nombre, int calorias) {
        dato = calorias;
        nombreComida = nombre;
        nodoizquierdo = nododerecho = null; //el nodo no tiene hijos
    }

    //buscar punto de insercion  e insertar nodo nuevo
    public synchronized void insertar(String nombre, int calorias) {
        //insertar en subarbol izquierdo
        if (calorias <= dato) {

            //inserta nuevo nodoarbol
            if (nodoizquierdo == null) {
                nodoizquierdo = new NodoArbol(nombre, calorias);
            } else //continua recorriendo subarbol izquierdo
            {
                nodoizquierdo.insertar(nombre, calorias);
            }
        } //insertar nodo derecho
        else if (calorias > dato) {

            //insertar nuevo nodoarbol
            if (nododerecho == null) {
                nododerecho = new NodoArbol(nombre, calorias);
            } else //continua recorriendo subarbol derecho
            {
                nododerecho.insertar(nombre, calorias);
            }
        }
    }

}
