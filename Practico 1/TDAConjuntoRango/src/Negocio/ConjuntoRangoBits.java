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
public class ConjuntoRangoBits  {
    
        VectorGenBit c;
        int dim;

    public ConjuntoRangoBits() {
        
         this.c = new VectorGenBit(20,6);
         this.dim = -1;
    }
        
        public boolean vacia( ){
        return (dim == -1);
        }
        
       public boolean pertenece(int ele) {
           int i = 0;
           while ((i <= dim) && (c.Sacar(i) != ele)) {
               i++;
           }
           return (i <= dim);
       } 
        
       public void insertar(int ele){
           if (vacia()){
               dim++;
               c.Insertar(ele, dim);
           } else {
               if (!pertenece(ele)){
                   dim++;
                   c.Insertar(ele, dim);
               }
           }
       }
       
       public void elimi(int ele){
           if (!vacia() ){
               int i = 0;
               while ((i <= dim) && (c.Sacar(i) != ele)){
                   i++;
               }
               if (i <= dim) {
                   for (int j = i; j < dim; j++) {
                       c.Insertar(c.Sacar(j + 1),  j);
                   }
                   dim--;
               }
           }
       }
       
       
       
}
