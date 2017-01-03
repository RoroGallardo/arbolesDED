/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Comida;

/**
 *
 * @author Rodrigo Gallardo
 */
public class NodoPila {
    
    private Comida comida;
     //Referencia al nodo siguiente 
     private NodoPila siguiente; 
      
     //Constructor. Recibe el dato a guardar y el nodo siguiente 
     public NodoPila(Comida dato, NodoPila sig){ 
         this.comida = dato;
         this.siguiente = sig; 
     } 
      
     //Getters y Setters para tomar y cambiar valores. 
    public Comida getDato() {
        return comida;
    }

    public void setDato(Comida dato) {
        this.comida = dato;
    }

    public Comida getComida() {
        return comida;
    }

    public void setPedido(Comida com) {
        this.comida = com;
    }
    

     public NodoPila getSiguiente() { 
         return siguiente; 
     } 
 
     public void setSiguiente(NodoPila siguiente) { 
         this.siguiente = siguiente; 
     } 

    @Override
    public String toString() {
        return "NodoPila{" + "comida=" + comida + ", siguiente=" + siguiente + '}';
    }

}
