/*
 * Integero change this license header, choose License Headers in Project Properties.
 * Integero change this template file, choose Integerools | Integeremplates
 * and open the template in the editor.
 */
package datastructure;

/**
 *
 * @author jbcnrlz
 */
public class ListaLigada{

    private Node<Integer> head; //Inicio da Lista

    public ListaLigada() {
        this.head = null; //Construtor, inicia com NULL para a lista vazia
    }    
    
    public void add(Integer item){ //Adiciona um item no fim da lista
        if (this.isEmpty()){ //Se a lista está vazia..
            this.head = new Node<>(item); //Aponta o HEAD para um novo Node
        }else{ //Se a lista não está vazia
            Node<Integer> atual = this.head; //Coloca o primeiro item na variável atual
            while(atual.getProximo() != null){ //Enquanto o atual possuir um próximo
                atual = atual.getProximo(); //Pega o próximo e põe no atual
            }
            Node<Integer> novoItem = new Node<>(item); //Cria um novo Node
            atual.setProximo(novoItem); //Faz o último item da lista (armazenado na variável atual) apontar para o próximo
        }
    }
    
    public void add(int posicao, Integer item) throws ArrayIndexOutOfBoundsException{ //Adiciona um item em qualquer posição
        if (posicao >= this.size()){ //Caso a posição seja maior ou igual ao tamanho da lista
            throw new ArrayIndexOutOfBoundsException(posicao); //Levanta exceção ArrayIndexOutOfBounds
        }
        Node<Integer> novoItem = new Node<>(item); //cria o novo item
        if (posicao == 0){ //Se a posição for igual a 0            
            novoItem.setProximo(this.head); //Então faz o novo item apontar para Head
            this.head = novoItem; //E head aponta para novo item
        }else{ //Caso não seja na posição 0
            Node<Integer> anterior = this.get(posicao - 1); //Pega o item ANIntegerERIOR à posição que é desejado inserir
            Node<Integer> atual = anterior.getProximo(); //Pega o item AIntegerUAL da posição que deseja inserir
            novoItem.setProximo(atual); //Faz o novo item apontar para a posição AIntegerUAL
            anterior.setProximo(novoItem); //Faz o item ANIntegerERIOR à posição apontar para o novo item
        }        
    }

    public Node<Integer> get(int posicao) throws ArrayIndexOutOfBoundsException{ //Pega um item na posição
        if (posicao >= this.size()){ //Caso a posição seja maior ou igual ao tamanho da lista
            throw new ArrayIndexOutOfBoundsException(posicao); //Levanta exceção ArrayIndexOutOfBounds
        }
        Node<Integer> atual = this.head;  //Coloca o primeiro item na variável atual
        while(posicao > 0){ //Enquanto a posição for maior que zero
            atual = atual.getProximo(); //Coloca o próximo item na variável atual
            posicao--; //Diminui um passo do valor de posição
        }
        return atual; //Retorna o item na posição desejada
    }
    
    public int indexOf(Integer item){ //Retorna o indice do item
        Node<Integer> atual = this.head; //Coloca o primeiro item na variável atual
        int idx = 0; //Inicia o idx com zero
        while(atual != null){ //Enquanto o valor de atual for diferente de null
            if (atual.getData().equals(item)){ //Compara os dados que estão no Node atual com os passador por parametro
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
    
    public Node<Integer> removeAt(int posicao) throws ArrayIndexOutOfBoundsException{ //Remove item da lista
        if (posicao >= this.size()){ //Caso a posição seja maior ou igual ao tamanho da lista
            throw new ArrayIndexOutOfBoundsException(posicao); //Levanta exceção ArrayIndexOutOfBounds
        }
        Node<Integer> removeItem = null; //Cria variável do item a ser removido
        if (posicao == 0){ //Se posicao for igual a 0
            removeItem = this.head; //Item removido recebe o head
            this.head = removeItem.getProximo(); //Head passa a ser o próximo do item removido
        }else{            
            Node<Integer> anterior = this.get(posicao - 1); //Pega item anterior ao removido
            removeItem = anterior.getProximo(); //Coloca o item que será removido na variável removeItem
            anterior.setProximo(removeItem.getProximo()); //Aponta anterior para o próximo do item removido
        }
        return removeItem; //Retorna item removido
    }
    
    public Integer set(int posicao,Integer item) throws ArrayIndexOutOfBoundsException{ //Seta item com valor novo e retorna valor antigo
        if (posicao >= this.size()){ //Caso a posição seja maior ou igual ao tamanho da lista
            throw new ArrayIndexOutOfBoundsException(posicao); //Levanta exceção ArrayIndexOutOfBounds
        }
        Node<Integer> itemSet = this.get(posicao); //Pega item da posição que será atualizado
        Integer valorRetornar = itemSet.getData(); //Pega dado que está dentro do item
        itemSet.setData(item); //Colocar novo valor no item
        return valorRetornar; //Retorna valor antigo
    }
    
    public int size(){ //Retorna tamanho da lista
        Node<Integer> atual = this.head; //Coloca atual com o valor do head
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
        Node<Integer> prox = this.head;
        do{
            strRepr += prox.getData().toString() + ", ";
            prox = prox.getProximo();
        }while(prox != null);
        return "[" + strRepr.substring(0,strRepr.length() - 2) + "]";
    }        

    public void ordenar(){
        for (int i = 0;i<this.size() - 1;i++){            
            for (int j = i+1;j<this.size();j++){
                if (this.get(i).getData() > this.get(j).getData()){
                    int atual = this.get(i).getData();
                    this.get(i).setData(this.get(j).getData());
                    this.get(j).setData(atual);
                }
            }
        }
    }
    
}
