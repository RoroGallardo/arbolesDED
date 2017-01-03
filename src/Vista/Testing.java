package Vista;

import Controlador.*;

public class Testing {


    public static void main(String args[]) {
        Arbol arbol = new Arbol();
        
        System.out.println("Insertando los siguientes valores: ");

        arbol.insertarNodo("Pure",300);
        arbol.insertarNodo("Agua",1);
        arbol.insertarNodo("Tequilla",900);

        System.out.println("\n\nRecorrido preorden");
        arbol.recorridoPreorden();

        System.out.println("\n\nRecorrido inorden");
        arbol.recorridoInorden();

        System.out.println("\n\nRecorrido posorden");
        arbol.recorridoPosorden();
    }
}

