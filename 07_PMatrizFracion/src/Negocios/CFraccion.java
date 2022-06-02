/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

/**
 *
 * @author johnn
 */
public class CFraccion {

    int Num;    // contiene informacion del numerador y signo
    int Deno;   // contiene informacion del denominador

    // Constructor sobrecargado
    public CFraccion(int Num, int Deno) {
        this.Num = Num;
        this.Deno = Deno;
    }

    // Constructor por defecto
    public CFraccion() {
        this.Num = 0;
        this.Deno = 1;
    }

    // Cambia el numerador de la fraccion(Self)
    public void setNum(int Num) {
        if (this.Num >= 0) {
            this.Num = +Math.abs(Num);
        } else {
            this.Num = -Math.abs(Num);
        }
        simplificar();
    }

    // Cambia el denominador de la fraccion(Self)
    public void setDeno(int Deno) {
        if (Deno == 0) {
            System.out.print("Error::SetDeno:Denominador 0\n");
            //System.exit(1);
        } else {
            this.Deno = Math.abs(Deno);
            simplificar();
        }
    }

    public void SetSigno(char signo) {
        if (signo == '+') {
            this.Num = +Math.abs(Num);
        } else {
            this.Num = -Math.abs(Num);
        }
    }

    public int getNum() {
        return Math.abs(Num);
    }

    public int getDeno() {
        return Deno;
    }

    public char getsigno() {
        if (Num >= 0) {
            return ('+');
        } else {
            return ('-');
        }
    }

    public float calcular() {
        return (Num / Deno);
    }

    public void Sumar(CFraccion A, CFraccion B) {
        Deno = A.getDeno() * B.getDeno();
        Num = Deno / A.getDeno() * A.Num + Deno / B.getDeno() * B.Num;
        simplificar();

    }

    public void Restar(CFraccion A, CFraccion B) {
        Deno = A.getDeno() * B.getDeno();
        Num = Deno / A.getDeno() * A.Num - Deno / B.getDeno() * B.Num;
        simplificar();
    }

    public void Mutiplicar(CFraccion A, CFraccion B) {
        Deno = A.getDeno() * B.getDeno();
        Num = A.Num * B.Num;
        simplificar();
    }

    public void Dividir(CFraccion A, CFraccion B) {
        //pre
        Deno = A.getDeno() * B.getNum();
        Num = A.getNum() * B.getDeno();
        simplificar();
    }

    public void simplificar() {
        int VMCD = MCD(Num, Deno);
        Num = Num / VMCD;
        Deno = Deno / VMCD;
    }

    public int MCD(int a, int b) {
        int min;
        min = (a > b) ? b : a;

        int val;
        val = ((a % min == 0) && (b % min == 0)) ? min : 1;
        return val;
    }
}
