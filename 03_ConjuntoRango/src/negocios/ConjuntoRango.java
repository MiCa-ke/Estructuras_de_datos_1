/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

/**
 *
 * @author Yeri
 */
public class ConjuntoRango {
    VectorBitGenerico Vector;
    int CantEle,RInicial,RFinal,cant;

    public ConjuntoRango(int CantEle,int RInicial,int RFinal) {
        this.RInicial=RInicial;
        this.RFinal=RFinal;
        this.CantEle=CantEle;
        int cantBits=RFinal-RInicial+1;
        double aux=0;
        int c=0;
        for(int i=1;cantBits>aux;i++){
            aux=Math.pow(2, i);
            c++;
        }
        cantBits=c;
        Vector= new VectorBitGenerico(c,CantEle);
        cant=0;
    }
    
    public boolean Insertar(int nro){
        if ((nro>=RInicial)&&(nro<=RFinal)){
            if (CantEle>cant){
                nro-=RInicial;
                cant++;
                Vector.insertar(nro, cant);
            }
            return true;
        }
        return false;
    }
    
    public int GetNro(int posicion){
        int mask=Vector.sacar(posicion);
        mask+=RInicial;
        return mask;
    }
    
    public int GetCant(){
        return cant;
    }
    
    public int GetCantEle(){
        return CantEle;
    }

    @Override
    public String toString() {
        String S="C=[ ";
        for (int i=1;i<=cant;i++){
            if (i!=cant){
                 S+=GetNro(i)+" , ";
            }else{
                S+=GetNro(i);
            }        
        }
        S+=" ]";
        return S;
    }
    
    
}
