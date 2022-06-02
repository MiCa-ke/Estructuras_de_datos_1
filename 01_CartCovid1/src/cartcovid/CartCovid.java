/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartcovid;

import Negocios.VectorGenBit;
/**
 *
 * @author micae
 */

// Micaela Olga Roca Garnica
//217073875

public class CartCovid {

    VectorGenBit c;
    VectorGenBit C1;
    int cant;
    int carnets[];
    String nombres[];

    public CartCovid(int ncant) {
        this.cant = ncant;
        c = new VectorGenBit(ncant, 29);
        C1 = new VectorGenBit(ncant, 27);
        carnets = new int[ncant];
        nombres = new String[ncant];
    }

    public void InsertarC(int Num, String nombre, int carnet, int Dia, int Mes, int anio, int sexo, int edad, int vacun, int dia2, int dosis,
            int dian, int mesn, int anoN, int mes2, int anio2, int vacu2, int dosis2) {

        int mask = Dia;
        Mes = Mes << 5;
        mask = mask | Mes;

        anio = anio - 2020;
        anio = anio << 9;
        mask = mask | anio;

        sexo = sexo << 11;
        mask = mask | sexo;

        edad = edad << 12;
        mask = mask | edad;

        vacun = vacun << 19;
        mask = mask | vacun;
        
        dosis = dosis << 22;
        mask = mask | dosis;
        
        dia2 = dia2<<24;
        mask = mask | dia2;

        c.Insertar(mask, Num);
        //----------------------------------------------------------------------
        mask = dian;
        mesn = mesn << 5;
        mask = mask | mesn;

        anoN = anoN << 9;
        mask = mask | anoN;
        
        mes2 = mes2 << 16;
       mask = mask | mes2;
       
       anio2 = anio2 - 2020;
       anio2 = anio2 << 20;
       mask = mask | anio2;
       
       vacu2 = vacu2 << 22;
       mask = mask | vacu2;
       
       dosis2 = dosis2 << 25;
       mask = mask | dosis2;
        

        C1.Insertar(mask, Num);

        nombres[Num - 1] = nombre;
        carnets[Num - 1] = carnet;
    }

    /*
     GET
     */
    public int GetDia(int num) {
        int x = c.Sacar(num);
        int mask = (int) (Math.pow(2, 5) - 1);
        mask = mask & x;
        return (mask);
    }

    public int GetMes(int num) {
        int x = c.Sacar(num);
        int mask = (int) (Math.pow(2, 4) - 1);
        mask = mask << 5;
        mask = mask & x;
        mask = mask >> 5;
        return (mask);
    }

    public int GetAnio(int num) {
        int x = c.Sacar(num);
        int mask = (int) (Math.pow(2, 2) - 1);
        mask = mask << 9;
        mask = mask & x;
        mask = mask >> 9;
        return (mask + 2020);
    }

    public String GetSex(int num) {
        int x = c.Sacar(num);
        int mask = 1;
        mask = mask << 11;
        mask = mask & x;
        mask = mask >>> 11;
        if (mask == 1) {
            return "Masculino";
        } else {
            return "Femenino";
        }
    }

    public int GetEdad(int num) {
        int x = c.Sacar(num);
        int mask = (int) (Math.pow(2, 7) - 1);
        mask = mask << 12;
        mask = mask & x;
        mask = mask >> 12;
        return mask;
    }

    public String GetVacun(int num) {
        int x = c.Sacar(num);
        int mask = (int) (Math.pow(2, 3) - 1);
        mask = mask << 19;
        mask = mask & x;
        mask = mask >> 19;
        if (mask == 0) {
            return "Sputnik V";
        } else {
            if (mask == 1) {
                return "Sinopharm";
            } else {
                if (mask == 2){
                       return "Astrazeneca";
                   }else{
                    if (mask == 3 ){
                return "Pfizer";
                    }else{
                        return"Sinovac";
                    }
                }
            }
        }
    }
    

public String Getdosis(int num) {
        int x = c.Sacar(num);
        int mask = (int) (Math.pow(2, 2) - 1);
        mask = mask << 22;
        mask = mask & x;
        mask = mask >> 22;
        if (mask == 1) {
            return "2da Dosis";
        } else {
            return "1ra Dosis";
        }
    }

public int GetDia2(int num) {
        int x = c.Sacar(num);
        int mask = (int) (Math.pow(2, 5) - 1);
        mask = mask << 24;
        mask = mask & x;
        mask = mask >> 24;
        return (mask);
}
    //-----------------------------------------------------------------------------------------------------------------------------

    public int getdia_naci(int num) {
        int x = C1.Sacar(num);
        int mask = (int) (Math.pow(2, 5) - 1);
        mask = mask & x;
        return (mask);
    }

    public int getmes_naci(int num) {
        int x = C1.Sacar(num);
        int mask = (int) (Math.pow(2, 4) - 1);
        mask = mask << 5;
        mask = mask & x;
        mask = mask >> 5;
        return (mask);
    }

    public int getano_naci(int num) {
        int x = C1.Sacar(num);
        int mask = (int) (Math.pow(2, 7) - 1);
        mask = mask << 9;
        mask = mask & x;
        mask = mask >> 9;
        return (mask + 1937);
    }
    
        public int GetMes2(int num) {
        int x = C1.Sacar(num);
        int mask = (int) (Math.pow(2, 4) - 1);
        mask = mask << 16;
        mask = mask & x;
        mask = mask >> 16;
        return (mask);
    }
        
        public int GetAnio2(int num) {
        int x =C1.Sacar(num);
        int mask = (int) (Math.pow(2, 2) - 1);
        mask = mask << 20;
        mask = mask & x;
        mask = mask >> 20;
        return (mask + 2020);
        }
        
      public String GetVacun2(int num) {
        int x = C1.Sacar(num);
        int mask = (int) (Math.pow(2, 3) - 1);
        mask = mask << 22;
        mask = mask & x;
        mask = mask >> 22;
        if (mask == 0) {
            return "Sputnik V";
        } else {
            if (mask == 1) {
                return "Sinopharm";
            } else {
                if (mask == 2){
                       return "Astrazeneca";
                   }else{
                    if (mask == 3 ){
                return "Pfizer";
                    }else{
                        return"Sinovac";
                    }
                }
            }
        }
    }
        
public String Getdosis2(int num) {
        int x = C1.Sacar(num);
        int mask = (int) (Math.pow(2, 2) - 1);
        mask = mask << 25;
        mask = mask & x;
        mask = mask >> 25;
        if (mask == 1) {
            return "2da Dosis";
        } else {
            return "1ra Dosis";
        }
    }

    public String getnombre(int num) {
        return nombres[num - 1];
    }

    public int getCI(int num) {
        return carnets[num - 1];
    }

    //-----------------------------------------------------------------------------------------------------------------------------
    /*
    Setters
     */

    public void SetDia(int num, int Dia) {
        int x = c.Sacar(num);
        x = x >>> 5;
        x = x << 5;
        x = x | Dia;
        c.Insertar(x, num);
    }

    public void SetMES(int num, int MES) {
        int x = c.Sacar(num);
        int mask = (int) (Math.pow(2, 4) - 1);
        mask = mask << 5;
        mask = ~mask;
        mask = mask & x;
        MES = MES << 5;
        x = x | MES;
        c.Insertar(x, num);
    }

    public void SetANO(int num, int ANO) {
        int x = c.Sacar(num);
        int mask = (int) (Math.pow(2, 1) - 1);
        mask = mask << 9;
        mask = ~mask;
        mask = x & mask;
        ANO = ANO - 2020;
        ANO = ANO << 9;
        x = x | ANO;
        c.Insertar(x, num);
    }

    public void SetSEX0(int num, int SEXO) {
        int x = c.Sacar(num);
        int mask = (int) (Math.pow(2, 1) - 1);
        mask = mask << 10;
        mask = ~mask;
        mask = x & mask;
        SEXO = SEXO << 10;
        x = x | SEXO;
        c.Insertar(x, num);
    }

    public void SetEDAD(int num, int EDAD) {
        int x = c.Sacar(num);
        int mask = (int) (Math.pow(2, 7) - 1);
        mask = mask << 11;
        mask = ~mask;
        mask = x & mask;
        EDAD = EDAD << 11;
        x = x | EDAD;
        c.Insertar(x, num);
    }

    public void Setvacun(int num, int vacun) {
        int x = c.Sacar(num);
        int mask = (int) (Math.pow(2, 3) - 1);
        mask = mask << 18;
        mask = ~mask;
        mask = x & mask;
        vacun = vacun << 18;
        x = x | vacun;
        c.Insertar(x, num);
    }


    public void Setdosis(int num, int dosis) {
        int x = c.Sacar(num);
        int mask = (int) (Math.pow(2, 2) - 1);
        mask = mask << 24;
        mask = ~mask;
        mask = x & mask;
        dosis = dosis << 24;
        x = x | dosis;
        c.Insertar(x, num);
    }

    //----------------------------------------------------------------------------------------------------
    public void setdian(int num, int dian) {
        int x = C1.Sacar(num);
        int mask = (int) (Math.pow(2, 5) - 1);
        mask = ~mask;
        mask = x & mask;
        x = x | dian;
        C1.Insertar(x, num);
    }

    public void Setmesn(int num, int mesn) {
        int x = C1.Sacar(num);
        int mask = (int) (Math.pow(2, 4) - 1);
        mask = mask << 5;
        mask = ~mask;
        mask = mask & x;
        mesn = mesn << 5;
        x = x | mesn;
        C1.Insertar(x, num);
    }

    public void Setanon(int num, int anon) {
        int x = C1.Sacar(num);
        int mask = (int) (Math.pow(2, 7) - 1);
        mask = mask << 9;
        mask = ~mask;
        mask = x & mask;
        anon = anon - 1900;
        anon = anon << 9;
        x = x | anon;
        C1.Insertar(x, num);
    }

    //--------------------------------------------------------------------------------------------------------
    /**
     *
     * @return
     */
    public String toString(int num) {
        String s = "";
        s = s + "Nombre: " + getnombre(num) + " | ";
        s = s + "Carnet: " + getCI(num) + " | ";
        s = s + "Fecha de Nacimiento: " + getdia_naci(num) + "/" + getmes_naci(num) + "/" + getano_naci(num) + " | ";
        s = s + " Sexo: " + GetSex(num) + " | ";
        s = s + " Edad: " + GetEdad(num) + " | "  ;
        s = s + "\n";
        //--------------------------------------------------------------------------------------------------------------------------
        s = s + "Fecha Vacunacion: " + GetDia(num) + "/ " + GetMes(num) + "/" + GetAnio(num) + " | ";
        s = s + "Vacuna: " + GetVacun(num) +  " | ";
        s = s + "Dosis: " + Getdosis(num) + ".";
        

        return s;
    }

}
