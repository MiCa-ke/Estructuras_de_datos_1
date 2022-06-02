/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author User
 */
public class Conjunto {

    int C[];
    int dim;

    public Conjunto() {
        this.C = new int[10];
        this.dim = -1;
    }
    
    public Conjunto(int cant){
        C= new int[cant];
        dim=-1;
    }

    public boolean vacia() {
        return (dim == -1);
    }

    public boolean Pertenece(int ele) {
        int i = 0;
        while ((i <= dim) && (C[i] != ele)) {
            i++;
        }
        return (i <= dim);
    }

    public void Insertar(int ele) {
        if (vacia()) {
            dim++;
            C[dim] = ele;
        } else {
            if (!Pertenece(ele)) {
                Redimencionar();
                dim++;
                C[dim] = ele;
            }
        }
    }

    private void Redimencionar() {
        if (dim == C.length - 1) {
            int C1[];
            C1 = new int[C.length];
            System.arraycopy(C, 0, C1, 0, C.length);
            C = new int[C.length + 10];
            System.arraycopy(C1, 0, C, 0, C1.length);
        }
    }

    public void Eliminar(int ele) {
        if (!vacia()) {
            int i = 0;
            while ((i <= dim) && (C[i] != ele)) {
                i++;
            }
            if (i >= dim) {
                for (int j = i; j < dim; j++) {
                    C[j] = C[j + 1];
                }
                dim--;
            }
        }
    }

    public void Union(Conjunto A, Conjunto B) {
        for (int i = 0; i <= A.dim; i++) {
            this.Insertar(A.C[i]);
        }
        for (int j = 0; j <= B.dim; j++) {
            this.Insertar(B.C[j]);
        }
    }

    public void Interseccion(Conjunto A, Conjunto B) {
        for (int i = 0; i <= A.dim; i++) {
            if (B.Pertenece(A.C[i])) {
                this.Insertar(A.C[i]);
            }
        }
    }
    
    public void DiferenciaA(Conjunto A, Conjunto B){
        for(int i=0; i<=A.dim; i++){
            if(!B.Pertenece(A.C[i])){   
                this.Insertar(A.C[i]);
            }  
        }
    }
    
    public void DiferenciaB(Conjunto A, Conjunto B){
        for(int i=0; i<=B.dim; i++){
            if(!A.Pertenece(B.C[i])){   
                this.Insertar(B.C[i]);
            }  
        }
        
    }
    
    public void DiferenciaS(Conjunto A, Conjunto B){
        for(int i=0; i<=A.dim; i++){
            if(!B.Pertenece(A.C[i])){   
                this.Insertar(A.C[i]);
           }        
        } 
        for(int i=0; i<=B.dim; i++){
            if(!A.Pertenece(B.C[i])){   
                this.Insertar(B.C[i]);
            }  
        }
        
    }

    @Override
    public String toString() {
        String S = "C={";
        for (int i = 0; i <= dim; i++) {
            S = S + C[i] + ",";
        }
        S = S + "}";
        return (S);
    }

     //To change body of generated methods, choose Tools | Templates.
}


