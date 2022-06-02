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
public class Nodo { int Dato;
                               //Object Dato;
                            Nodo Enlace;
                          
     public Nodo( ){
         this.Enlace = null;
         //this.Dato=null;
     }                      
                            
    public Nodo( int dato )/*Object dato*/ {
        this.Enlace = null;
        this.Dato = dato;
    }

    public void setDato(int Dato)/*Object dato*/ {
        this.Dato = Dato;
    }

    public void setEnlace(Nodo Enlace) {
        this.Enlace = Enlace;
    }

    public int getDato()/*Object getdato*/ {
        return Dato;
    }

    public Nodo getEnlace() {
        return Enlace;
    }

    @Override
    public String toString() {
        return " " + "Dato = " + Dato;
    }
    
}
