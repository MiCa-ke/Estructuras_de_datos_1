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
public class PilaBit {
   VectorGenBit p;
    int cima;
    int Nbit;

    public PilaBit(int cant, int nbit) {
        p = new VectorGenBit(cant, nbit);
        cima = 0;
        Nbit = nbit;
    }

    public boolean Vacia() {
        return (cima == 0);
    }

    public boolean Llena() {
        return (cima == p.cant);
    }

    // la pila no debe estar vacia!!
    public int Get() {
        return (p.Sacar(cima));
    }

    public void Push(int ele) {
        if (!Llena()) {
            cima++;
            p.Insertar(ele, cima);
        } else {
            System.out.println("ERROR:Pila Llena!!");
        }
    }

    //la pila no debe estar vacia
    public int pop() {
        cima--;
        return (p.Sacar(cima + 1));
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = cima; i > 0; i--) {
            s = s + p.Sacar(i);
            s = s + "\n";
        }
        return s;
    } 
}
