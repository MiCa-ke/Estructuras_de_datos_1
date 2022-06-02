/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectonodo;

import Negocio.Nodo;

/**
 *
 * @author micae
 */
public class ProyectoNodo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Nodo a = new Nodo();
        a.setDato(9);
        Nodo b = new Nodo();
        b.setDato(12);
        Nodo c = new Nodo(2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        c.setEnlace(a);
        a.setEnlace(b);
        
        System.out.println(c.toString()+" ->"+c.getEnlace().toString()+" ->"+c.getEnlace().getEnlace().toString());
    }
    
}
