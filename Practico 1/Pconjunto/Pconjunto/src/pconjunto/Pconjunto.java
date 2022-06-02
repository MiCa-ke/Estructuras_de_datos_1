/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pconjunto;

import Negocio.Conjunto;

/**
 *
 * @author User
 */
public class Pconjunto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conjunto A= new Conjunto();
        A.Insertar(5);
        A.Insertar(1);
        A.Insertar(7);
        A.Insertar(1);
        A.Insertar(10);
        System.out.println(A);
        Conjunto B= new Conjunto();
        B.Insertar(6);
        B.Insertar(1);
        B.Insertar(9);
        B.Insertar(9);
        B.Insertar(11);
        B.Insertar(2);
        B.Insertar(5);
        B.Insertar(20);
        System.out.println(B);
        Conjunto C= new Conjunto();
        C.Union(A, B);
        System.out.println(C);
        Conjunto D= new Conjunto();
        D.Interseccion(A, B);
        System.out.println(D); 
        Conjunto E= new Conjunto();
        E.DiferenciaA(A, B);
        System.out.println(E);
        Conjunto F= new Conjunto();
        F.DiferenciaB(A, B);
        System.out.println(F);
        Conjunto G= new Conjunto();
        G.DiferenciaS(A, B);
        System.out.println(G);
    }
    
}
