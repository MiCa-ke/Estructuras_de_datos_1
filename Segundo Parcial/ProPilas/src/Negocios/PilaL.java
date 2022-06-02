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
public class PilaL {
    Nodo cima;
    int cant;

    public PilaL() {
        cima = null;
        cant = 0;
    }

    public boolean Vacia() {
        return (cima == null);
    }

    //la pila no debe estar vacia
    public int Get() {
        return (cima.getDato());
    }

    public void push(int ele) {
        Nodo aux = new Nodo(ele);
        aux.setEnlace(cima);
        cima = aux;
        cant++;
    }

    //la pila no debe estar vacia
    public int pop() {
        int aux = cima.getDato();
        cima = cima.getEnlace();
        cant--;
        return aux;
    }

    @Override
    public String toString() {
        String s = "";
        Nodo aux = cima;
        while (aux != null) {
            s = s + aux.getDato();
            s = s + "\n";
            aux = aux.getEnlace();
        }
        return s;
    }
}
