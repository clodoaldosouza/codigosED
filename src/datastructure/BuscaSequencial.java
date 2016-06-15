/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

/**
 *
 * @author jbcnrlz
 */
public class BuscaSequencial {
        
    static public int buscar(int[] itens, int item){
        for (int i = 0;i < itens.length;i++){
            if (itens[i] == item){
                return i;
            }
        }
        return -1;
    }

    static public int buscaBinaria(int[] itens, int item){        
        int esquerda = 0;
        int direita = itens.length;
        while (esquerda <= direita){
            int medio = (esquerda + direita) / 2;
            if (itens[medio] == item){
                return medio;
            }else if(itens[medio] > item){
                direita = medio - 1;
            }else{
                esquerda = medio + 1;
            }
        }
        return -1;
    }
    
}
