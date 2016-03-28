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
public class ListaLigadaCircular extends ListaLigada{

    @Override
    public void add(Integer item) {
        Node<Integer> novoElo = new Node<>(item); //Cria novo elo para lista
        if (this.isEmpty()){ //Se a lista está vazia
            this.setHead(novoElo); //Aponto o Head para o novoItem
        }else{
            Node<Integer> atual = this.get(this.size() - 1);
            atual.setProximo(novoElo); //Aponto o ultimo item para o novo
        }
        novoElo.setProximo(this.getHead()); //Aponto o ultimo item para o Head
    }

    
    
    @Override
    public int size(){ //Retorna tamanho da lista
        Node<Integer> atual = this.getHead(); //Coloca atual com o valor do head
        if (atual == null){
            return 0;
        }
        int size = 1; //Inicia tamanho em 0
        while(atual.getProximo() != this.getHead()){ //Enquanto atual for diferente de null
            atual = atual.getProximo(); //Joga o próximo na variável atual
            size++; //Aumenta em 1 o tamanho
        }
        return size; //Retorna tamanho
    }     
    
}
