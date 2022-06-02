/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntorangobit;

import Negocios.Conjunto;

/**
 *
 * @author johnn
 */
public class ConjuntoRangoBit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conjunto Con;
        Con = new Conjunto();
        Con.Insertar(20);
        Con.Insertar(22);
        Con.Insertar(30);
         Con.Insertar(40);
        System.out.println(Con);
    }

}
