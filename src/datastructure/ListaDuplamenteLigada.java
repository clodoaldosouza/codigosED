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
public class ListaDuplamenteLigada<T>{

    private EloDuplamenteLigado<T> head; //Inicio da Lista

    public ListaDuplamenteLigada() {
        this.head = null; //Construtor, inicia com NULL para a lista vazia
    }    

    public EloDuplamenteLigado<T> get(int posicao) throws ArrayIndexOutOfBoundsException{ //Pega um item na posição
        if (posicao >= this.size()){ //Caso a posição seja maior ou igual ao tamanho da lista
            throw new ArrayIndexOutOfBoundsException(posicao); //Levanta exceção ArrayIndexOutOfBounds
        }
        EloDuplamenteLigado<T> atual = this.head;  //Coloca o primeiro item na variável atual
        while(posicao > 0){ //Enquanto a posição for maior que zero
            atual = atual.getProximo(); //Coloca o próximo item na variável atual
            posicao--; //Diminui um passo do valor de posição
        }
        return atual; //Retorna o item na posição desejada
    }

    
    public void add(T item){ //Adiciona um item no fim da lista
        EloDuplamenteLigado<T> novoItem = new EloDuplamenteLigado<>(item);
        if (this.isEmpty()){ //Se a lista está vazia..
            this.head = novoItem;
        }else{ //Se a lista não está vazia
            EloDuplamenteLigado<T> atual = this.get(this.size() - 1); //Pega o último item da lista
            atual.setProximo(novoItem); //Coloca o atual apontando para o novo item            
            novoItem.setAnterior(atual); //Coloca o anterior do novo item como o atual
        }
    }
    
    public void add(int posicao, T item) throws ArrayIndexOutOfBoundsException{ //Adiciona um item em qualquer posição
        if (posicao >= this.size()){ //Caso a posição seja maior ou igual ao tamanho da lista
            throw new ArrayIndexOutOfBoundsException(posicao); //Levanta exceção ArrayIndexOutOfBounds
        }
        EloDuplamenteLigado<T> novoItem = new EloDuplamenteLigado<>(item); //cria o novo item
        if (posicao == 0){ //Se a posição for igual a 0
            novoItem.setProximo(this.head); //Então faz o novo item apontar para Head
            this.head.setAnterior(novoItem); //Coloca o head atual apontando para o Novo Item como anteior
            this.head = novoItem; //E head aponta para novo item
        }else{ //Caso não seja na posição 0
            EloDuplamenteLigado<T> atual = this.get(posicao); //Pega o item que está na posição que deseja incluir
            EloDuplamenteLigado<T> anterior = atual.getAnterior(); //Pega o item anterior da posição que deseja inserir
            novoItem.setProximo(atual); //Faz o novo item apontar para a posição ATUAL
            novoItem.setAnterior(anterior); //Faz o novo item apontar para o anteior
            anterior.setProximo(novoItem); //Faz o item ANTERIOR à posição apontar para o novo item
            atual.setAnterior(novoItem); //Faz o atual apontar para o novo item como anteior
        }
    }
    
    public int indexOf(T item){ //Retorna o indice do item
        EloDuplamenteLigado<T> atual = this.head; //Coloca o primeiro item na variável atual
        int idx = 0; //Inicia o idx com zero
        while(atual != null){ //Enquanto o valor de atual for diferente de null
            if (atual.getDados().equals(item)){ //Compara os dados que estão no Node atual com os passador por parametro
                return idx; //Retorna o indice
            }
            atual = atual.getProximo(); //Coloca o próximo Node dentro da variável atual
            idx++; //Incrementa o indice em mais 1
        }
        return -1; //Caso não ache o item dentro da lista retorna -1
    }
    
    public boolean isEmpty(){ //Verifica se lista está vazia
        return (this.head == null); //Caso head == null então a lista está vazia
    }
    
    public EloDuplamenteLigado<T> removeAt(int posicao) throws ArrayIndexOutOfBoundsException{ //Remove item da lista
        if (posicao >= this.size()){ //Caso a posição seja maior ou igual ao tamanho da lista
            throw new ArrayIndexOutOfBoundsException(posicao); //Levanta exceção ArrayIndexOutOfBounds
        }
        EloDuplamenteLigado<T> removeItem; //Cria variável do item a ser removido
        if (posicao == 0){ //Se posicao for igual a 0
            removeItem = this.head; //Item removido recebe o head
            this.head = removeItem.getProximo(); //Head passa a ser o próximo do item removido
            if (this.head != null){
                this.head.setAnterior(null); //Aponta o anterior do head para null
            }
        }else{
            
            removeItem = this.get(posicao); //Pega o item a ser removido
            EloDuplamenteLigado<T> anterior = removeItem.getAnterior(); //Pega o anterior dele
            EloDuplamenteLigado<T> proximo = removeItem.getProximo(); //Pega o próximo dele
            anterior.setProximo(proximo); //Aponta o anteior para o próximo
            proximo.setAnterior(anterior); //Aponta o proximo para anterior
        }
        return removeItem; //Retorna item removido
    }
    
    public T set(int posicao,T item) throws ArrayIndexOutOfBoundsException{ //Seta item com valor novo e retorna valor antigo
        if (posicao >= this.size()){ //Caso a posição seja maior ou igual ao tamanho da lista
            throw new ArrayIndexOutOfBoundsException(posicao); //Levanta exceção ArrayIndexOutOfBounds
        }
        EloDuplamenteLigado<T> itemSet = this.get(posicao); //Pega item da posição que será atualizado
        T valorRetornar = itemSet.getDados(); //Pega dado que está dentro do item
        itemSet.setDados(item); //Colocar novo valor no item
        return valorRetornar; //Retorna valor antigo
    }
    
    public int size(){ //Retorna tamanho da lista
        EloDuplamenteLigado<T> atual = this.head; //Coloca atual com o valor do head
        int size = 0; //Inicia tamanho em 0
        while(atual != null){ //Enquanto atual for diferente de null
            atual = atual.getProximo(); //Joga o próximo na variável atual
            size++; //Aumenta em 1 o tamanho
        }
        return size; //Retorna tamanho
    }
    
    @Override
    public String toString() {
        String strRepr = "";
        EloDuplamenteLigado<T> prox = this.head;
        do{
            strRepr += prox.getDados().toString() + ", ";
            prox = prox.getProximo();
        }while(prox != null);
        return "[" + strRepr.substring(0,strRepr.length() - 2) + "]";
    }        
    
    
}
