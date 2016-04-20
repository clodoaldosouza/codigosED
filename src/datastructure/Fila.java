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
public class Fila<T>{

    private ListaDuplamenteLigada<T> itens;

    public Fila() {
        this.itens = new ListaDuplamenteLigada<>();
    }
    
    public void enfileirar(T item){
        this.itens.add(item);
    }
    
    public T desenfileirar(){
        T itemReturn = this.itens.removeAt(0).getDados();
        return itemReturn;
    }
    
    public boolean vazio(){
        return this.itens.isEmpty();
    }
    
    public T espiar(){
        return this.itens.get(0).getDados();
    }
    
    public int tamanho(){
        return this.itens.size();
    }

    @Override
    public String toString() {
        String retorno = "";
        for (int i = 0;i<this.tamanho();i++){
            retorno += this.itens.get(i).getDados().toString() + " - ";
        }
        return retorno;
    }
    
}
