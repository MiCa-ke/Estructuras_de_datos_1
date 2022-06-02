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
public class tda_alarmaB {

    VectorGenBit a;
    int cant;
    String nombre[];

    public tda_alarmaB(int ncant) {
        this.cant = ncant;
        a = new VectorGenBit(ncant, 27);
        nombre = new String[ncant];
    }

    public void insertarA(int num, String nombres, int dia, int mes, int año, int min, int hor, int mer, int tim, int rep, int du) {

        int mask = dia;
        
        mes = mes << 5;
        mask = mask | mes;

        año = año - 2021;
        año = año << 9;
        mask = mask | año;

        min = min << 10;
        mask = mask | min;

        hor = hor << 16;
        mask = mask | hor;

        mer = mer << 20;
        mask = mask | mer;

        tim = tim << 21;
        mask = mask | tim;

        rep = rep << 22;
        mask = mask | rep;

        du = du << 24;
        mask = mask | du;

        a.Insertar(mask, num);

        nombre[num - 1] = nombres;
    }

    // GET ------------------------------------------------------------------------------------------------------------------------------------------
    public String getnom (int num){
        return nombre[num - 1];
    }
    
    public int getdia(int num) {
        int x = a.Sacar(num);
        int mask = (int) (Math.pow(2, 5) - 1);
        mask = mask & x;
        return (mask);
    }

    public int getmes(int num) {
        int x = a.Sacar(num);
        int mask = (int) (Math.pow(2, 4) - 1);
        mask = mask << 5;
        mask = mask & x;
        mask = mask >> 5;
        return (mask);
    }

    public int getaño(int num) {
        int x = a.Sacar(num);
        int mask = 1;
        mask = mask << 9;
        mask = mask & x;
        mask = mask >> 9;
        return (mask + 2021);
    }


    public int getm(int num) {
        int x = a.Sacar(num);
        int mask = (int) (Math.pow(2, 6) - 1);
        mask = mask << 10;
        mask = mask & x;
        mask = mask >> 10;
        return (mask);
    }

        public int geth(int num) {
        int x = a.Sacar(num);
        int mask = (int) (Math.pow(2, 4) - 1);
        mask = mask << 16;
        mask = mask & x;
        mask = mask >> 16;
        return (mask);
    }
    
    
    public String getmer(int num) {
        int x = a.Sacar(num);
        int mask = 1;
        mask = mask << 20;
        mask = mask & x;
        mask = mask >>> 20;
        if (mask == 1) {
            return "Pm";
        } else {
            return "Am";
        }
    }

    public String gettimbrar(int num) {
        int x = a.Sacar(num);
        int mask = 1;
        mask = mask << 21;
        mask = mask & x;
        mask = mask >>> 21;
        if (mask == 0) {
            return "Si";
        } else {
            return "No";
        }
    }

    public String getrepetir(int num) {
        int x = a.Sacar(num);
        int mask = (int) (Math.pow(2, 2) - 1);
        mask = mask << 22;
        mask = mask & x;
        mask = mask >>> 22;
        if (mask == 0) {
            return " 5";
        } else {
            if (mask == 1) {
                return "10";
            } else {
                return "15";
            }
        }
    }

    public int getdu(int num) {
        int x = a.Sacar(num);
        int mask = (int) (Math.pow(2, 3) - 1);
        mask = mask << 24;
        mask = mask & x;
        mask = mask >> 24;
        return (mask);
    }
    
    
}
