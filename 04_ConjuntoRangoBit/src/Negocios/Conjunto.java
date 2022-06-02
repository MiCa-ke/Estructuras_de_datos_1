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
public class Conjunto {

    VectorGenBit c;
    int dim;

    public Conjunto() {
        this.c = new VectorGenBit(20, 6);
        this.dim = -1;
    }

    public boolean Vacia() {
        return (dim == -1);
    }

    public boolean Pertenece(int ele) {
        int i = 0;

        while ((i <= dim) && (c.Sacar(i + 1) != ele)) {
            i++;
        }
        return (i <= dim);
    }

    public void Insertar(int ele) {
        if ((ele >= 20) && (ele <= 80)) {
            ele = ele - 20;
            if (Vacia()) {
                dim++;
                c.Insertar(ele, dim + 1);    // c[dim] = ele;
            } else {
                if (!Pertenece(ele)) {
                    //Redimencionar();
                    dim++;
                    c.Insertar(ele, dim + 1);   // c[dim] = ele;
                }
            }
        }
    }

    public void Eliminar(int ele) {
        if (!Vacia()) {
            int i = 0;
            while ((i <= dim) && (c.Sacar(i + 1) != ele)) {   // c[i] != ele)
                i++;
            }
            if (i <= dim) {
                for (int j = i; j < dim; j++) {
                    c.Insertar(c.Sacar(j + 1 + 1), j + 1);                  // c[j] = c[j + 1];
                }
                dim--;
            }
        }
    }

    /* private void Redimencionar() {
        if (dim == c.length - 1) {
            int c1[];
            c1 = new int[c.length];
            System.arraycopy(c, 0, c1, 0, c.length);
            c = new int[c.length + 10];
            System.arraycopy(c1, 0, c, 0, c.length);
        }
    }*/
 /*public void Union(Conjunto A, Conjunto B) {
        for (int i = 0; i <= A.dim; i++) {
            this.Insertar(A.c[i]);
        }
        for (int i = 0; i <= B.dim; i++) {
            this.Insertar(B.c[i]);
        }
    }
    
    public void Interseccion(Conjunto A, Conjunto B) {
        for (int i = 0; i <= A.dim; i++) {
            if (B.Pertenece(A.c[i])) {
                this.Insertar(A.c[i]);
            }
        }
    }
    
    public void Complemento(Conjunto A, Conjunto B) {
        for (int i = 0; i <= B.dim; i++) {
            if (!A.Pertenece(B.c[i])) {
                this.Insertar(B.c[i]);
            }
        }
    }
    
    public boolean SubConjunto(Conjunto A) {
        int i = 0;
        while ((i <= this.dim) && (A.Pertenece(this.c[i]))) {
            i++;
        }
        return (i > this.dim);
    }
     */
    @Override
    public String toString() {
        String S = "{";
        int x;
        if (Vacia()) {
            S = "CONJUNTO VACIO!!";
        } else {
            for (int i = 0; i < dim; i++) {
                x = c.Sacar(i + 1);
                x = x + 20;
                S = S + x + " , ";    //c[i] 
            }
            x = c.Sacar(dim + 1);
            x = x + 20;
            S = S + x;
            S = S + "}";
        }
        return (S);
    }
}
