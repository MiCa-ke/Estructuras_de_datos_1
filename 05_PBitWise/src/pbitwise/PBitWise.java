/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbitwise;

import Negocios.BitWise;
import Negocios.Conjuntob;

/**
 *
 * @author micae
 */
public class PBitWise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BitWise A = new BitWise();
        A.SetBit1(1);
        A.SetBit1(2);
        A.SetBit1(3);
        A.SetBit1(4);
        A.SetBit1(5);
        A.SetBit1(20);
        System.out.println(A);
        A.SetBit0(1);
        A.SetBit0(2);
        A.SetBit0(3);
        A.SetBit0(4);
        System.out.println(A);
        
        Conjuntob a = new Conjuntob();
        Conjuntob b = new Conjuntob();
        //Conjuntob c = new Conjuntob();
        //Conjuntob d = new Conjuntob();
        
        a.Insertar(2);
        a.Insertar(4);
        a.Insertar(10);
        a.Insertar(15);
        a.Insertar(32);
        
        System.out.println(a);
        
        b.Insertar(3);
        b.Insertar(1);
        b.Insertar(25);
        b.Insertar(14);
        
        System.out.println(b);
        
        //c.union(a,b);
        //System.out.println(c);
        
        //d.interseccion(a, b);
        //System.out.println(d);
    }
    
}
