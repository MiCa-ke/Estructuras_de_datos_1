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
public class BicolaBit {
    VectorGenBit Q;
    int frente;
    int atras;

    public BicolaBit(int cant, int nbit) {
        Q = new VectorGenBit(cant, nbit);
        frente = -1;
        atras = -1;
    }
    
     public boolean vacio( ){
        return (frente == -1);
    }
    
     public int Get() {
      return (Q.Sacar(frente + 1));
     }
     
      public boolean llena(){
        return ((atras + 1) % Q.cant == frente);
    }       
      
        public void encolar(int ele){
        if (vacio()){
            frente = 0;
            atras = 0;
            Q.Insertar(ele, frente + 1);
        } else{
            if (!llena()){
                atras = (atras + 1) % Q.cant;
                //pos = (4 + 1) / long= 5 = 1;
                Q.Insertar(ele, atras+1);
            } else {
                System.out.println("Error! : Pila Llena");
            }
        }
    }
     
    public int decolar(){
        int x = Q.Sacar(frente);
        if (frente == atras){
            frente = 0;
            atras = 0;
        }   else{
            frente = (frente +1) % Q.cant;
        }
        return x;
    }

    @Override
    public String toString() {
        String s = "Q[";
        boolean aux = !vacio();
        int x = frente;
        while (aux) {
            s = s + Q.Sacar(x+1);
            if (x != atras) {
                x = (x + 1)  % Q.cant;
                s = s + ", ";
            } else {
                aux = false;
            }
        }
        s = s + " ]";
        return (s); 
    }
    
}
