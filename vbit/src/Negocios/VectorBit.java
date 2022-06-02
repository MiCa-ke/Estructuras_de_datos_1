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
public class VectorBit {

    int v[];
    public int cant;

    public VectorBit(int cant) {
       this.cant= cant;
        int ne = cant*7 / 32;
        if (cant*7 % 32 != 0) {
            ne++;
        }
        v = new int[ne];
    }

    public void Insertar(int ele, int pos) {
        if  (pos <= cant) {
        } else {
            int mask = (int) Math.pow(2, 7) - 1;
            int nbt = CalcularBit(pos);  //Numero de Bit
            int ne = CalcularE(pos);      //Numero de Entero
            int ele1 = ele;
            mask = mask << nbt;
            mask = ~mask;
            v[ne] = v[ne] & mask; 
            ele = ele << nbt;
            v[ne] = v[ne] | ele;
            if (nbt + 7 > 32) {
                int mask1 = (int) Math.pow(2, (nbt +7) - 32) - 1;
                mask1 = ~mask1;
                v[ne + 1] = v[ne + 1] & mask1;
                ele1 = ele1 >>> 32 - nbt;
                v[ne + 1] = v[ne + 1] | ele1;
            }
        }
    }

    public int Sacar(int pos) {
        int mask = (int) Math.pow(2, 7) - 1;
        int nbt = CalcularBit(pos);  //Numero de Bit
        int ne = CalcularE(pos);      //Numero de Entero
        mask = mask << nbt;
        mask = mask & v[ne];
        mask = mask >>> nbt;
        if (nbt + 7 > 32) {
            int mask1 = (int) Math.pow(2, (nbt + 7) - 32) - 1;
            mask1 = mask1 & v[ne + 1];
            mask1 = mask1 << 32 - nbt;
            mask = mask | mask1;
        }
        return mask;
    }
    
   public int CalcularBit(int pos) {
        int bit;
        bit = 7 * (pos - 1);
        bit = bit % 32;
        return bit;
    }

    public int CalcularE(int pos) {
        int bit;
        bit = 7 * (pos - 1);
        bit = bit / 32;
        return bit;
    }
 
    @Override
    public String toString() {
        String S = "{ ";
        for (int i = 1; i < cant; i++) {
            S = S+ Sacar(i) + ", ";
        }       
        S = S + " }";
        return S;
    }

 
}
