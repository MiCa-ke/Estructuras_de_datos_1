/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

/**
 *
 * @author Yeri
 */
public class VectorBitGenerico {
    private int vector[];
    private int cantidadDeBitsPorElemento;
    private int cantidadDeElementos;//5

    public VectorBitGenerico(
            int cantidadDeBitsRequeridaPorElemento, 
            int cantidadRequeridaDeElementos) {
        int cantidadTotalDeBits = 
                cantidadDeBitsRequeridaPorElemento * cantidadRequeridaDeElementos;
        int cantidadDeInts = cantidadTotalDeBits / 32;
        if (cantidadTotalDeBits % 32 > 0) {
            cantidadDeInts++;
        }
        vector = new int[cantidadDeInts];
        cantidadDeBitsPorElemento = cantidadDeBitsRequeridaPorElemento;
        cantidadDeElementos = cantidadRequeridaDeElementos;
    }

    private int elevar(int base, int exponente) {
        return exponente <= 0 ? 1 : elevar(base, exponente - 1) * base;
    }

    private int Nbit(int pos) {
        return ((((pos - 1) * cantidadDeBitsPorElemento)) % 32) + 1;
    }

    private int NEnter(int pos) {
        return ((((pos - 1) * cantidadDeBitsPorElemento) / 32));
    }

    public void insertar(int conjuntoDeDatos, int pos) {
        if (pos <= cantidadDeElementos) {
            int x = Nbit(pos);
            int y = NEnter(pos);
            if (x + cantidadDeBitsPorElemento <= 32) {
                conjuntoDeDatos = conjuntoDeDatos << x - 1;
                int mask1 = elevar(2, cantidadDeBitsPorElemento) - 1;
                mask1 = mask1 << x - 1;
                mask1 = ~mask1;
                vector[y] = vector[y] & mask1;
                vector[y] = vector[y] | conjuntoDeDatos;
            } else {
                int dato1 = conjuntoDeDatos;
                conjuntoDeDatos = conjuntoDeDatos << x - 1;
                int mask1 = elevar(2, cantidadDeBitsPorElemento) - 1;
                mask1 = mask1 << x - 1;
                mask1 = ~mask1;
                vector[y] = vector[y] & mask1;
                vector[y] = vector[y] | conjuntoDeDatos;
                dato1 = dato1 >>> 32 - x + 1;
                mask1 = elevar(2, cantidadDeBitsPorElemento) - 1;
                mask1 = mask1 >>> 32 - x + 1;
                mask1 = ~mask1;
                vector[y + 1] = vector[y + 1] & mask1;
                vector[y + 1] = vector[y + 1] | dato1;
            }
        } else {
            System.out.print("Error la capacidad fue sobrepasada aumente elementos");
        }
    }

    public int sacar(int pos) {
        int aux = 0;
        if (pos <= cantidadDeElementos) {
            int x = Nbit(pos);
            int y = NEnter(pos);
            if (x + cantidadDeBitsPorElemento <= 32) {
                aux = vector[y];
                aux = aux >>> x - 1;
                int mask1 = elevar(2, cantidadDeBitsPorElemento) - 1;
                aux = aux & mask1;
            } else {
                int aux2 = vector[y];
                aux2 = aux2 >>> x - 1;
                aux = vector[y + 1];
                int mask1 = elevar(2, cantidadDeBitsPorElemento) - 1;
                mask1 = mask1 >>> 32 - x + 1;
                aux = aux & mask1;
                aux = aux << 32 - x + 1;
                aux = aux | aux2;

            }
        }

        return aux;
    }
    
}
