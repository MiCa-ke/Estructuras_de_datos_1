/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolista;

import Negocio.Lista;

/**
 *
 * @author micae
 */
public class ProLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lista A = new Lista();
        A.Insertar(5);
        A.Insertar(2);
        A.Insertar(3);
        A.Insertar(1);
        A.Insertar(10);
        A.Insertar(5);
        A.Insertar(15);
        A.Insertar(4);
        A.Insertar(15);
        System.out.println(A);
        A.Eliminar(15);
        A.Eliminar(1);
        A.Eliminar(5);
        A.Insertar(0);
        A.Insertar(8);
        System.out.println(A);
    }
    
}
