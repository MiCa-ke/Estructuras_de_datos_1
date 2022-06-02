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
public class PilaV {
   int p[];
    int cima;

    public PilaV(int cant) {
        p = new int[cant];
        cima = -1;
    }

    public boolean Vacia() {
        return (cima == -1);
    }

    public boolean Llena() {
        return (cima == p.length - 1);
    }

    //la pila no debe estar vacia
    public int Get() {
        return (p[cima]);
    }

    public void push(int ele) {
        if (!Llena()) {
            cima++;
            p[cima] = ele;
        } else {
            System.out.println("ERROR:Pila Llena!!");
        }
    }

    //la pila no debe estar vacia
    public int pop() {
        cima--;
        return (p[cima + 1]);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = cima; i >= 0; i--) {
            s = s + p[i];
            s = s + "\n";
        }
        return s;
    } 
}
