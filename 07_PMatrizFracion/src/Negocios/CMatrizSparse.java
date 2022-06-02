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
public class CMatrizSparse {
    
    int VFC[];
    CFraccion VD[];
    int NFil;
    int NCol;
    CFraccion EP;
    int Dim;
    
    public CMatrizSparse(int fil, int col, int epNum, int epDen) {
        VFC = new int[10];
        VD = new CFraccion[10];
        
        for (int i = 0; i < VD.length; i++) {
            VD[i] = new CFraccion();
        }
        
        this.NFil = fil;
        this.NCol = col;
        //////////////////
        EP = new CFraccion();
        
        EP.setNum(epNum);
        EP.setDeno(epDen);
        
        if (epNum * epDen >= 0) {
            EP.SetSigno('+');
        } else {
            EP.SetSigno('-');
        }
        
        this.Dim = -1;
    }
    
    public void Set(int fil, int col, int num, int den) {
        if ((fil > NFil) || (col > NCol)) {
            System.out.println("Error: Fila y/o Columna Fuera de Rango!!");
            // System.exit(1);
        } else {
            int fc = (fil - 1) * NCol + col;
            int pos = Buscar(fc);
            if (pos == -1) {    //Elemento a insertar no existe
                if (num != EP.getNum() || (den != EP.getDeno())) {
                    Redimencionar();
                    Dim++;
                    VFC[Dim] = fc;
                    
                    VD[Dim].setNum(num);
                    VD[Dim].setDeno(den);
                    
                    if (num * den >= 0) {
                        VD[Dim].SetSigno('+');
                    } else {
                        VD[Dim].SetSigno('-');
                    }
                    
                }
            } else {
                if (num != EP.getNum() || (den != EP.getDeno())) {    //SI ES DIFERENTE A (EP) INSERTAR
                    VD[pos].setNum(num);
                    VD[pos].setDeno(den);
                     if (num * den >= 0) {
                        VD[pos].SetSigno('+');
                    } else {
                        VD[pos].SetSigno('-');
                    }
                    
                    
                } else {            //SI ES IGUAL ENTONCES ELIMINAR DATO
                    for (int i = pos; i < Dim; i++) {
                        VFC[i] = VFC[i + 1];
                        VD[i].setNum(VD[i + 1].getNum());   // VD[i] = VD[i + 1];
                        VD[i].setDeno(VD[i + 1].getDeno());
                        
                        VD[i].SetSigno(VD[i + 1].getsigno());
                    }
                    Dim--;
                }
            }
        }
    }
    
    public void SetFila(int fil) {
        this.NFil = fil;
    }
    
    public void SetColumna(int col) {
        this.NCol = col;
    }
    
    public CFraccion Get(int fil, int col) {
        int fc = (fil - 1) * NCol + col;
        int pos = Buscar(fc);
        /////////////////////////
        if (pos == -1) {
            return EP;
        } else {
            return VD[pos];
        }
    }
    
    public int GetFil() {
        return NFil;
    }
    
    public int GetCol() {
        return NCol;
    }
    
    @Override
    public String toString() {
        String s = "";
        for (int i = 1; i <= NFil; i++) {
            for (int j = 1; j <= NCol; j++) {
                CFraccion f1 = Get(i, j);
                s = s + f1.getsigno() + f1.getNum() + "/" + f1.getDeno() + "      ";
            }
            s = s + "\n";
        }
        return s;
    }
    
    private int Buscar(int fc) {
        int i = 0;
        while ((i <= Dim) && (VFC[i] != fc)) {
            i++;
        }
        
        if (i > Dim) {
            i = -1;
        }
        return i;
    }
    
    private void Redimencionar() {
        int VFC1[];
        CFraccion VD1[];
        
        if (Dim == VFC.length - 1) {
            
            VFC1 = new int[VFC.length]; //copiando su longitud
            System.arraycopy(VFC, 0, VFC1, 0, VFC.length);
            VFC = new int[VFC1.length + 10];
            System.arraycopy(VFC1, 0, VFC, 0, VFC1.length);
            
            VD1 = new CFraccion[VD.length];
            System.arraycopy(VD, 0, VD1, 0, VD.length);
            VD = new CFraccion[VD1.length + 10];
            System.arraycopy(VD1, 0, VD, 0, VD1.length);
            
            for (int i = 0; i < VD.length; i++) {
                VD[i] = new CFraccion();
            }
        }
    }
}
