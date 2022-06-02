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
public class BicolaV {
    int Q[];
    int frente;
    int atras;

    public BicolaV(int cant) {
        Q = new int [cant];
        frente = -1;
        atras = -1;
    }
    
    public boolean vacio( ){
        return (frente == -1);
    }
    
    // si es que no esta vacia
    public int get(){
        return (Q[frente]);
    }
    
    public boolean llena(){
        return ((atras + 1) % Q.length == frente);
    }
    
    public void encolar(int ele){
        if (vacio()){
            frente = 0;
            atras = 0;
            Q[atras] = ele;
        } else{
            if (!llena()){
                atras = (atras + 1) % Q.length;
                //pos = (4 + 1) MOD long= 5 = 0; (RESIDUO)
                Q[atras] = ele;
            } else {
                System.out.println("Error! : Pila Llena");
            }
        }
    }
    
    // si es que no esta vacia
    public int decolar(){
        int x = Q[frente];
        if (frente == atras){
            frente = -1;
            atras = -1;
        }   else{
            frente = (frente +1) % Q.length;
        }
        return x;
    }
    
    @Override
    public String toString(){
      String s = "Q[";
        boolean aux = !vacio();
        int x = Q[frente];
        while (aux) {
            s = s + x;
            if (x != atras) {
               x = (x + 1)  % Q.length;
                s = s + ", ";
            } else {
                aux = false;
            }
        }
        s = s + " ]";
        return (s); 
    }
}
