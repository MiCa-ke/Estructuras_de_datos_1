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
public class BicolaL {
    Nodo frente;
    Nodo atras;
    int cant;

    public BicolaL() {
        frente = null;
        atras = null;
        cant = 0;
    }
    
        public boolean vacio( ){
        return (frente == null);
    }
    
        public int Get( ){
            return (frente.getDato());
        }
        
    public void encolar(int ele){
        Nodo aux = new Nodo(ele);
        if (vacio()){
            frente = aux;
            atras = aux;
        } else{
        atras.setEnlace(aux);
        atras = aux;
        }       
        cant ++;
}
    
    public int decolar(){
        int x = frente.getDato();
        frente = frente.getEnlace();
        cant--;
        if (frente == null){
            atras = null;
        }
        return x;
    }

    @Override
    public String toString() {
        String s = "Q[";
        Nodo aux = frente;
        while (aux != null){
            s = s + aux.getDato();
            aux = aux.getEnlace();
            if (aux != null){
             s = s + ", ";   
            }
        }
        s = s + "]";
        return s;
    }
    
}