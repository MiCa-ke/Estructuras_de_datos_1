/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;
/**
 *
 * @author micae
 */
public class Vector {

 /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    VectorBit vec;
    vec = new VectorBit(15);
    vec.Insertar(45,6);
    //vec.Insertar(0, 2);
    //vec.Insertar(0, 3);
    //vec.Insertar(0, 4);
    //vec.Insertar(0, 5);
    //vec.Insertar(1, 6);
    //System.out.println(vec);
    //vec.CalcularE(6);
    vec.Sacar(6);
    System.out.println(vec);
    }
}
