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
public class ListaArray {
    
    private int[] itensLista;
    private int tamanho;

    public ListaArray() {
        this.tamanho = 0;
        this.itensLista = new int[50];
    }
    
    public void add(int item){
        this.itensLista[this.tamanho] = item;
        this.tamanho++;
    }
    
    public boolean isEmpty(){
        return (this.tamanho == 0);
    }
    
    public int get(int posicao) 
            throws ArrayIndexOutOfBoundsException{
        if (posicao >= this.tamanho){
            throw new ArrayIndexOutOfBoundsException(posicao);
        }
        return this.itensLista[posicao];
    }
    
    public int removeAt(int posicao)
            throws ArrayIndexOutOfBoundsException{
        if (posicao >= this.tamanho){
            throw new ArrayIndexOutOfBoundsException(posicao);
        }
        this.tamanho--;
        int itemRemovido = this.get(posicao);
        for (int i = posicao;i<this.tamanho;i++){
            this.itensLista[i] = this.itensLista[i+1];
        }
        return itemRemovido;
    }
    
}
