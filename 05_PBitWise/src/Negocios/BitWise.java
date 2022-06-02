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
public class BitWise {int x;

    public BitWise() {
        this.x = 0;
    }
    
    public void SetBit1(int pos) {
        if (pos <= 32) {
            int mask = 1;
            mask = mask << pos - 1;
            x = x | mask;
        }
    }

    public void SetBit0(int pos) {
        if (pos <= 32) {
            int mask = 1;
            mask = mask << pos - 1;
            mask = ~mask;
            x = x & mask;
        }
    }
    
    public int Getbit(int pos) {
        if (pos <= 32) {
            int mask =1 ;
            mask = mask << pos - 1;
            mask = mask & x;
            mask = mask >>> pos - 1;
            return (mask);
        }
        return 0;
    }
    
    @Override
    public String toString() {
        String s = "x= ";
        for (int i = 32; i >= 1; i--) {
            s = s + " " + Getbit(i);
        }
        return (s);
    }
}
