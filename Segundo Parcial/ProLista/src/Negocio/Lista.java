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
public class Lista { Nodo L;
                            int cant;

    public Lista( ) {
        this.L = null;
        this.cant = 0;
    }
                            
    public boolean Vacia(){
        return (L==null);
    }          
    
    public void Insertar(int ele){
    if (Vacia()){
        Nodo P = new Nodo(ele);
        L = P;
        cant++;
    }
    else {
        Nodo aux = L;
        Nodo Ant = null;
        while ((aux != null) && (aux.getDato()<=ele)) {
            Ant = aux;
            aux = aux.getEnlace();
             }
        if (Ant == null){
            Nodo P = new Nodo(ele);
            P.setEnlace(L);
            L = P;
            cant++;
        }
        else{
            if (Ant.getDato() != ele){
                Nodo P =new Nodo(ele);
                Ant.setEnlace(P);
                P.setEnlace(aux);
                cant++;
            }
        }
      }
   }

 public void Eliminar(int ele){
    Nodo aux = L;
    Nodo ant = null;
    while ((aux != null) && (aux.getDato() != ele)) {
            ant = aux;
            aux = aux.getEnlace();
     }
    if (aux != null){
        if (ant == null){
            L = L.getEnlace();
            cant--;
        }
        else{
            ant.setEnlace(aux.getEnlace());
            cant++;
            
        }
    }   
 }  
    
public int Get(int pos){
    Nodo aux = L;
    for (int i = 1; i < pos-1; i++) {
        aux = aux.getEnlace();
    }
    return (aux.getDato());
}
 
    @Override
    public String toString() {
        String s = "L < ";
        Nodo aux = L;
        while (aux != null){
            s = s + aux.getDato() + ", ";
            aux = aux.getEnlace();
        }
        s = s + " >";
        return s;
    }
    
}
