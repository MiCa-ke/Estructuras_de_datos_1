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
public class Conjuntob {
    BitWise c[];
    int cant;
    
    public Conjuntob() {
        this.c = new BitWise[1];
        c[0] = new BitWise();
        cant = 0;
    }
    
    public boolean Vacia(){
        return (cant==-1);
    }
    
       private int CalcNBW(int ele){
            return ((ele - 1)/32);
        }
        
        private int CalcNbit(int ele){
            return (((ele-1)%32+1));
        }   
        
    public void Insertar(int ele){
        int Nbw = ele / 32;
        if  (ele % 32 !=0){
            Nbw++;
        }
        if (Nbw > c.length) {
            Redimencionar(ele);
        }
        int NBW = CalcNBW (ele);
        int Nbit = CalcNbit(ele);
        c[NBW].SetBit1(Nbit);
        if (ele > cant ){
             cant = ele;
        }
    }

        public boolean Pertenece(int ele){
            int NBW = CalcNBW(ele);
            int Nbit =CalcNbit(ele);
            return (c[NBW].Getbit(Nbit) == 1);
        }
        
        public void union(Conjuntob a, Conjuntob b){
            for (int i = 1; i <= a.cant; i++){
                if(a.Pertenece(i)){
                    this.Insertar(i);
                }
            }
            for (int i = 1; i <=b.cant; i++){
                if (b.Pertenece(i)){
                    this.Insertar(i);
                }
            }
        }
        
        
        public void interseccion(Conjuntob a, Conjuntob b){
            for (int i = 1; i < a.cant; i++){
                if (a.Pertenece(i)){
                    if (b.Pertenece(i)) {
                        this.Insertar(i);
                    }
                }
            }
        }
        
        public void Redimencionar(int ele) {
        BitWise c1[];
        c1 = new BitWise[c.length];
        System.arraycopy(c, 0, c1, 0, c.length);
        c = new BitWise[ele];
        System.arraycopy(c1, 0, c, 0, c.length);
        for (int i=c1.length; i<c.length; i++){
            c[i] = new BitWise();
        }
    }

    @Override
    public String toString() {
        String s = "C={";
            for (int i = 1; i <= cant; i++) {
                int NBW = CalcNBW (i);
                 int Nbit = CalcNbit(i);
                   int x = c[NBW].Getbit(Nbit);
                if (x == 1 ) {
                    s = s + i + ", ";
                }
            }
            
            s = s + "}";
         return s;
    }
}
