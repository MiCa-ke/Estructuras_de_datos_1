/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catastrobitg;

import Negocios.VectorGenBit;

/**
 *
 * @author micae
 */
public class CatastroBitG {

    VectorGenBit v1;
    VectorGenBit v2;
    String nombre[];
    int max;

    public CatastroBitG(int cant){
        this.max = cant;
        v1 = new VectorGenBit(max,24);
        v2 = new VectorGenBit(max,12);
        nombre = new String[max];
    } 
    
    public void insert(int num, String nombres, int uv, int mz, int lote, int h2o, int luz, int pav, int alcan, int tele, int gas, int supcie, int zona) {
                               
        int mask = uv;
        
        mz = mz << 8;
        mask = mask | mz;
        
        lote = lote << 13;
        mask = mask | lote;
        
        h2o = h2o << 18;
        mask = mask | h2o;
        
        luz = luz << 19;
        mask = mask | luz;
        
        pav = pav << 20;
        mask = mask | pav;
        
        alcan = alcan << 21;
        mask = mask | alcan;
        
        tele =  tele << 22;
        mask = mask | tele; 
        
        gas = gas << 23;
        mask = mask | gas;
        
        v1.Insertar(mask, num);
        
        mask = supcie;
         
        zona = zona << 9;
        mask = mask | zona;
        
        v2.Insertar(mask, num);
        
        nombre[num-1] = nombres;
        }
    
    // getters--------------------------------------------------------------------------------------------------------------------
    
    public String getnom (int num){
        return nombre[num - 1];
    }
    
    public int getuv (int num){
        int x = v1.Sacar(num);
        int mask = (int) (Math.pow(2, 8)-1);
        mask = mask & x;
        return (mask);
    }
    
    public int getmz(int num){
        int x = v1.Sacar(num);
        int mask = (int) (Math.pow(2, 5)-1);
        mask = mask << 8;
        mask = mask & x;
        mask = mask >> 8;
        return (mask);
    }
    
     public int getlt(int num){
        int x = v1.Sacar(num);
        int mask = (int) (Math.pow(2, 5)-1);
        mask = mask << 13;
        mask = mask & x;
        mask = mask >> 13;
        return (mask);
    }
     
      public int getsup(int num){
        int x = v2.Sacar(num);
        int mask = (int) (Math.pow(2, 9)-1);
        mask = mask & x;
        return (mask);
    }
      
        public String getzona(int num){
             int x = v2.Sacar(num);
             int mask = (int) (Math.pow(2, 3) - 1);
             mask = mask << 9;
             mask = mask & x;
            mask = mask >> 9;
            if (mask == 0) {
                return "Norte";
            } else {
               if (mask == 1) {
                 return "Sur";
             } else {
                   if (mask == 2){
                       return "Este ";
                   }else{
                return "Oeste";
                 }
            }
        }
    }
                        
      public String geth2o(int num){
          int x = v1.Sacar(num);
          int mask = 1;
          mask = mask << 18;
          mask = mask & x;
          mask = mask >> 18;
          if (mask == 0 ){
              return "Si";
          }else{
              return "No";
          }
      }
      
       public String getluz(int num){
          int x = v1.Sacar(num);
          int mask = 1;
          mask = mask << 19;
          mask = mask & x;
          mask = mask >> 19;
          if (mask == 0 ){
              return "Si";
          }else{
              return "No";
          }
      }
       
        public String getpavi(int num){
          int x = v1.Sacar(num);
          int mask = 1;
          mask = mask << 20;
          mask = mask & x;
          mask = mask >> 20;
          if (mask == 0 ){
              return "Si";
          }else{
              return "No";
          }
      }
        
         public String getalcan(int num){
          int x = v1.Sacar(num);
          int mask = 1;
          mask = mask << 21;
          mask = mask & x;
          mask = mask >> 21;
          if (mask == 0 ){
              return "Si";
          }else{
              return "No";
          }
      }
         

         
          public String getTele(int num){
          int x = v1.Sacar(num);
          int mask = 1;
          mask = mask << 22;
          mask = mask & x;
          mask = mask >> 22;
          if (mask == 0 ){
              return "Si";
          }else{
              return "No";
          }
      }
          
           public String getgas(int num){
          int x = v1.Sacar(num);
          int mask = 1;
          mask = mask << 23;
          mask = mask & x;
          mask = mask >> 23;
          if (mask == 0 ){
              return "Si";
          }else{
              return "No";
          }
      }
           

         
      public String toString (int num){
          String s="";
                s = s + "Nombre: " + getnom(num) +"\n" ;
                s = s + "Uv: " + getuv(num) + "\n"; 
                s = s + "Mz: " + getmz(num) + "\n";
                s = s + "Lote: "+ getlt(num) + "\n";
                s = s + "Zona: "+ getzona(num) + "\n";
                s = s + "Superficie: "+ getsup(num) + "M2" + "\n";
                s = s + "Servicios Basicos con los que se cuenta: " + "\n";
                s = s + "Agua: "+ geth2o(num) + "\n";
                s = s + "Luz: "+ getluz(num) + "\n";
                s = s + "Pavimento: " + getpavi(num) + "\n";
                s = s + "Alcantarillado: "+ getalcan(num) + "\n";
                s = s + "Telefono: " + getTele(num) + "\n";
                s = s + "Gas Dom.: " + getgas(num);
          return s;
      }     
         
}


