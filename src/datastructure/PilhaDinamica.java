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
public class PilhaDinamica {
    
    private ListaLigada<Integer> pilhaInterna;

    public PilhaDinamica() {
        this.pilhaInterna = new ListaLigada<>();
    }
    
    public boolean empty(){
        return this.pilhaInterna.isEmpty();
    }
    
    public void push(int item){
        if (this.pilhaInterna.isEmpty()){
            this.pilhaInterna.add(item);
        }else{
            this.pilhaInterna.add(0, item);
        }        
    }
    
    public int pop() throws StackOverflowError{
        if (this.empty()){
            throw new StackOverflowError("Pilha vazia");
        }
        return this.pilhaInterna.removeAt(0).getData();
    }
    
    public int stackTop(){
        int itemRetornar = this.pop();
        this.push(itemRetornar);
        return itemRetornar;
    }

    @Override
    public String toString() {
        String retornoString = "";
        for(int i = 0;i < this.pilhaInterna.size();i++){
            retornoString += this.pilhaInterna.get(i).getData().toString() + "\n";
        }
        return retornoString;
    }        
    
}
