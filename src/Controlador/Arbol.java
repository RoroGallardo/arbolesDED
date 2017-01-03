/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Comida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sql.Conexion;

public class Arbol implements Calcular{

    private NodoArbol raiz;

    //contruir un arbol vacio
    public Arbol() {
        raiz = null;
    }

    //insertar un nuevo nodo en el arbol de busqueda binaria
    public synchronized void insertarNodo(String nombre, int calorias) {
        if (raiz == null) {
            raiz = new NodoArbol(nombre, calorias); //crea nodo raiz
        } else {
            raiz.insertar(nombre, calorias); // llama al metodo insertar
        }
    }

    public synchronized void recorridoPreorden() {
        ayudantePreorden(raiz);
    }
    //metodo recursivo para recorrido en preorden

    private void ayudantePreorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }

        System.out.print(nodo.nombreComida+ " "); // mostrar datos del nodo
        ayudantePreorden(nodo.nodoizquierdo); //recorre subarbol izquierdo
        ayudantePreorden(nodo.nododerecho); //recorre subarbol derecho
    }

    public synchronized void recorridoInorden() {
        ayudanteInorden(raiz);
    }

    // metodo recursivo para recorrido inorden
    private void ayudanteInorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }

        ayudanteInorden(nodo.nodoizquierdo);
        System.out.print(nodo.nombreComida + " ");
        ayudanteInorden(nodo.nododerecho);
    }

    public synchronized void recorridoPosorden() {
        ayudantePosorden(raiz);
    }

    //metodo recursivo para recorrido posorden
    private void ayudantePosorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        }

        ayudantePosorden(nodo.nodoizquierdo);
        ayudantePosorden(nodo.nododerecho);
        System.out.print(nodo.nombreComida + " ");
    }
    

    //Devuelve las cantidad de calorias de un producto en particular
    public int buscarCalorias(String nombre)
    {
        int calorias = 0;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "SELECT calorias FROM comida WHERE nombre = ?";
            PreparedStatement buscar = conexion.prepareStatement(query);
            buscar.setString(1, nombre);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                calorias = rs.getInt("calorias");
            }
            buscar.close();
            conexion.close();
            return calorias;
        }catch (SQLException w){
            System.out.println("Error sql al buscar Comida "+ w.getMessage());
            return 0;
        }catch(Exception e){
            System.out.println("Error al buscarComida "+e.getMessage());
            return 0;
        }
    }
    /*Este metodo retornara una lista contodas las comidas de la base de datos
    para ser cargados en un combobox    */
    public List<String> listarComidas(){
        List<String> lista = null;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "SELECT nombre FROM comida";
            PreparedStatement listar = conexion.prepareStatement(query);
            ResultSet rs = listar.executeQuery();
            lista = new ArrayList<String>();
            while(rs.next())
                lista.add(rs.getString("nombre"));
            listar.close();
            conexion.close();
        }catch (SQLException w){
            System.out.println("Error sql al buscar Comida "+ w.getMessage());
        }catch(Exception e){
            System.out.println("Error al buscarComida "+e.getMessage());
        }
        return lista;
    }
}
