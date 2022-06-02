/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro1cola;

import Negocio.BicolaBit;
import Negocio.BicolaL;
import Negocio.BicolaV;

/**
 *
 * @author micae
 */
public class Pro1Cola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BicolaV a = new BicolaV(5);
        a.encolar(8);
        a.encolar(5);
        a.encolar(4);
        a.encolar(3);
        a.encolar(2);
        System.out.print(a);
        a.decolar();
        a.decolar();
        a.decolar();
        System.out.println(a);
        a.encolar(8);
        System.out.println(a);
        a.encolar(10);
        System.out.println(a);
    }
    
}
