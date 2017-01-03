/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Comida;

public class Pila { 

    public Comida comida;
    private Pila siguiente;
    public Pila top= null;
    
    public Pila(){
        comida = null;
        siguiente = null;
    }

    public void setDato(Comida com) {
        this.comida = com;
    }
    
    public Comida getDato() {
        return comida;
    }
    
    public boolean esVacia(){
        return (top == null);
    }
    
    public void apilar(Comida com){
        Pila aux = new Pila();
        aux.comida = com;
        aux.siguiente = top;
        top = aux;
        System.out.println( "agregado( "+top.getDato()+" )" );

    }
    
    public void desapilar(){
        if(esVacia())
            System.out.println("No hay elementos en la Pila");
        else{
            System.out.println( "eliminado( "+top.getDato()+" )" );

            top= top.siguiente;
            
        }
    }
    
    public void print(){
        Pila aux;
        aux= top;
        System.out.println("Elementos:");
        while(aux != null){
            if(aux.siguiente != null){
                System.out.println(aux.comida);
            }
            else{
                System.out.println(aux.comida);
            }
            aux =aux.siguiente;
        }
    }
    
    public Object verTope(){
        if (esVacia())
            return null;
        else
            return(top.comida);
    }
    
    public int size(){
        Pila aux = top;
        int contador = 0;
        while (aux!= null){
            contador++;
            aux = aux.siguiente;
        }
        return contador;
    }
    
    public Pila get(int posicion) {
        Pila aux = top;
        int contador=0;
        while(contador != posicion){
            aux = aux.siguiente;
            contador++;
        }
        return aux;
    }
    public String presentar(){
        String texto="";
        Pila aux= top;
        while(aux!=null){
            texto +=aux.comida.getNombre()+"\n";
            System.out.println(texto+"\n");
            aux=aux.siguiente;
        }
        return texto;
    }
    
  
    
 } 

  