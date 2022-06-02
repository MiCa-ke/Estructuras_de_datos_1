/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro2recursivo;

import Negocio.ListaR;

/**
 *
 * @author micae
 */
public class Pro2Recursivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ListaR a = new ListaR();
        
        a.Insertar(3);
        a.Insertar(4);
        a.Insertar(7);
        a.Insertar(8);
        
        System.out.println(a);
        
        //a.invertir();
        a.insertarR(5);
        System.out.println(a);
    }
    
}
