/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author micae
 */
public class NodoDoble {int Dato;
                                        NodoDoble EnlaceIzq;
                                        NodoDoble EnlaceDer;

    public NodoDoble() {
        this.EnlaceIzq = null;
        this.EnlaceDer = null;
    }

    public NodoDoble(int Dato) {
        this.Dato = Dato;
        this.EnlaceIzq = null;
        this.EnlaceDer = null;
    }

    public void setDato(int Dato) {
        this.Dato = Dato;
    }

    public void setEnlaceIzq(NodoDoble EnlaceIzq) {
        this.EnlaceIzq = EnlaceIzq;
    }

    public void setEnlaceDer(NodoDoble EnlaceDer) {
        this.EnlaceDer = EnlaceDer;
    }

    public int getDato() {
        return Dato;
    }

    public NodoDoble getEnlaceIzq() {
        return EnlaceIzq;
    }

    public NodoDoble getEnlaceDer() {
        return EnlaceDer;
    }

    @Override
    public String toString() {
        return (" " + Dato);
    }
 
                                        
    
}
