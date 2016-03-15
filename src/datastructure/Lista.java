/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

/**
 *
 * @author jbcnrlz
 * @param <T>
 */
public class Lista <T>{
    
    private int tamanho;
    private T[] itensLista;

    public Lista() {
        this.itensLista = (T[]) new Object[1];
        this.tamanho = 0;
    }
    
    private void resizeInnerList(){
        T[] listaTemporaria = this.itensLista;
        this.itensLista = (T[]) new Object[this.itensLista.length * 2];
        System.arraycopy(listaTemporaria, 0, this.itensLista, 0, listaTemporaria.length);
    }
        
    public void add(T item){
        if (this.tamanho == this.itensLista.length){
            this.resizeInnerList();
        }
        this.itensLista[this.tamanho] = item;
        this.tamanho++;
    }
    
    public void add(int posicao, T item) throws ArrayIndexOutOfBoundsException{
        if (posicao >= this.tamanho){
            throw new ArrayIndexOutOfBoundsException(posicao);
        }
        if (posicao == (this.tamanho - 1)){
            this.resizeInnerList();
        }
        for(int i = this.tamanho - 1;i >= posicao; i--){
            this.itensLista[i+1] = this.itensLista[i];
        }
        this.itensLista[posicao] = item;
        this.tamanho++;
    }
    
    public T get(int posicao) throws ArrayIndexOutOfBoundsException{
        if (posicao >= this.tamanho){
            throw new ArrayIndexOutOfBoundsException(posicao);
        }
        return this.itensLista[posicao];
    }
    
    public int indexOf(T item){
        for(int i = 0;i<this.tamanho;i++){
            if (this.get(i) == item){
                return i;
            }
        }
        return -1;
    }
    
    public boolean isEmpty(){
        return (this.tamanho == 0);
    }
    
    public T removeAt(int posicao) throws ArrayIndexOutOfBoundsException{
        if (posicao >= this.tamanho){
            throw new ArrayIndexOutOfBoundsException(posicao);
        }
        this.tamanho--;
        T itemRemoved = this.get(posicao);
        for (int i = posicao;i<this.tamanho;i++){
            this.itensLista[i] = this.itensLista[i+1];
        }
        this.itensLista[this.tamanho + 1] = null;
        return itemRemoved;
    }
    
    public T set(int posicao,T item) throws ArrayIndexOutOfBoundsException{
        if (posicao >= this.tamanho){
            throw new ArrayIndexOutOfBoundsException(posicao);
        }
        T itemRemoved = this.get(posicao);
        this.itensLista[posicao] = item;
        return itemRemoved;
    }
    
    public int size(){
        return this.tamanho;
    }
    
    public void printList(){
        for(int i = 0;i<this.tamanho;i++){
            System.out.print(this.get(i).toString() + " ");
        }
        System.out.print("\n");
    }
    
}
