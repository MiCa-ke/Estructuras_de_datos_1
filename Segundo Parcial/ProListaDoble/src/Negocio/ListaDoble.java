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
public class ListaDoble {NodoDoble Primero;
                                        NodoDoble Ultimo;
                                        int Cant;

    public ListaDoble() {
        this.Primero = null;
        this.Ultimo = null;
        this.Cant = 0;
    }
      
    public boolean vacia(){
        return (Primero == null);
    }
    
    public void insertar(int ele){
        if(vacia()){
            NodoDoble L = new NodoDoble (ele);
                Primero = L;
                Ultimo = L;
                
        }
            
    }
    
}
