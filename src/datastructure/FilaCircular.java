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
public class FilaCircular<T>{
    
    private int inicio;
    private int fim;
    private int quantidadeItens;
    private T[] itens;

    public FilaCircular(int tamanho) {
        this.quantidadeItens = tamanho + 1;
        this.itens = (T[]) new Object[tamanho + 1];
        this.inicio = 0;
        this.fim = 0;
    }
    
    public void enfileirar(T item) throws ArrayIndexOutOfBoundsException{
        if (((this.fim + 1) % this.quantidadeItens) == this.inicio){
            throw new ArrayIndexOutOfBoundsException("Fila cheia");
        }
        this.fim = (this.fim + 1)%this.quantidadeItens;
        this.itens[this.fim] = item;
    }
    
    public T desenfileirar() throws ArrayIndexOutOfBoundsException{
        if(this.inicio == this.fim){
            throw new ArrayIndexOutOfBoundsException("Fila vazia");
        }
        T item = this.itens[(this.inicio + 1) % this.quantidadeItens];
        this.inicio = (this.inicio + 1) % this.quantidadeItens;
        return item;
    }
    
    public T espiar(){
        return this.itens[(this.inicio + 1) % this.quantidadeItens];
    }
    
    public boolean vazia(){
        return (this.inicio == this.fim);
    }
    
    public int tamanho(){
        int tamanho = 0;
        for (int i = this.inicio;i != this.fim;i=(i+1)%this.quantidadeItens){
            tamanho += 1;            
        }
        return tamanho;
    }

    @Override
    public String toString() {
        String retorno = "";
        for (int i = this.inicio;i != this.fim;i=(i+1)%this.quantidadeItens){
            retorno += this.itens[(i + 1)%this.quantidadeItens] + " ";
        }
        return retorno;
    }        
    
}
