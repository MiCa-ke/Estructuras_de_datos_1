/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolistadoble;

import Negocio.NodoDoble;

/**
 *
 * @author micae
 */
public class ProListaDoble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NodoDoble a = new NodoDoble();
        a.setDato(6);
        NodoDoble b = new NodoDoble(3);
        NodoDoble c = new NodoDoble(1);
        c.setEnlaceDer(b);
        b.setEnlaceIzq(c);
        b.setEnlaceDer(a);
        a.setEnlaceIzq(b);
        System.out.println("L < "+c.getDato()+", "+c.getEnlaceDer().getDato()+", "+c.getEnlaceDer().getEnlaceDer().getDato()+" >");
    }
    
}
