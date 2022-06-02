/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pmatrizfracion;

import Negocios.CMatrizSparse;

/**
 *
 * @author johnn
 */
public class PMatrizFracion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CMatrizSparse m;
        m=new CMatrizSparse(3, 3, 1, 2);
        m.Set(1, 1, 10, -3);
        m.Set(1, 2, -2, 7);
        m.Set(1, 3, -2, 9);
        System.out.println(m);
    }
    
}
