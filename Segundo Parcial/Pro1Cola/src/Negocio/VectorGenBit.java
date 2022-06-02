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
public class VectorGenBit {

    int v[];
    public int cant;
    int nb;

    public VectorGenBit(int nele, int Numb) {
        int nbit = nele * Numb;
        int ne = nbit / 32;
        if (nbit % 32 != 0) {
            ne++;
        }
        v = new int[ne];
        cant = nele;
        nb = Numb;
    }

    public void Insertar(int ele, int pos) {
        if (pos <= cant) {
            int ele1 = ele;
            int nbt = CalcularBit(pos);  //Numero de Bit
            int ne = CalcularE(pos);      //Numero de Entero
            int mask = (int) Math.pow(2, nb) - 1;
            mask = mask << nbt;
            mask = ~mask;
            ele = ele << nbt;
            v[ne] = v[ne] & mask;
            v[ne] = v[ne] | ele;
            if (nbt + nb > 32) {
                int mask1 = (int) Math.pow(2, (nbt + nb) - 32) - 1;
                mask1 = ~mask1;
                v[ne + 1] = v[ne + 1] & mask1;
                ele1 = ele1 >>> 32 - nbt;
                v[ne + 1] = v[ne + 1] | ele1;
            }
        }
    }

    public int Sacar(int pos) {
        int nbt = CalcularBit(pos);  //Numero de Bit
        int ne = CalcularE(pos);      //Numero de Entero
        int mask = (int) Math.pow(2, nb) - 1;
        mask = mask << nbt;
        mask = mask & v[ne];
        mask = mask >>> nbt;
        if (nbt + nb > 32) {
            int mask1 = (int) Math.pow(2, (nbt + nb) - 32) - 1;
            mask1 = mask1 & v[ne + 1];
            mask1 = mask1 << 32 - nbt;
            mask = mask | mask1;
        }
        return mask;
    }

    @Override
    public String toString() {
        String S = "{ ";
        boolean sw = true;
        for (int i = 0; i < cant; i++) {
            int ele = Sacar(i + 1);
            
                sw = false;
                S = S + ele + " , ";
           
        }
        S = S + " }";
        if (sw) {
            S = "VACIO";
        }
        return S;
    }

    private int CalcularBit(int pos) {
        int bit;
        bit = nb * (pos - 1);
        bit = bit % 32;
        return bit;
    }

    private int CalcularE(int pos) {
        int bit;
        bit = nb * (pos - 1);
        bit = bit / 32;
        return bit;
    }

}
