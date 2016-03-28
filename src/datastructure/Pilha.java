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
public class Pilha {
    
    private int[] itens;
    int topo;

    public Pilha() {
        this.itens = new int[50];
        this.topo = -1;
    }
        
    public void push(int item){
        this.topo++;
        this.itens[this.topo] = item;
    }    
    
    public int pop(){
        int returnItem = this.itens[this.topo];
        this.topo--;
        return returnItem;
    }
    
    public boolean empty(){
        return (this.topo == -1);
    }
    
    public int stackTop(){
        int itemTop = this.pop();
        this.push(itemTop);
        return itemTop;
    }

    @Override
    public String toString() {
        String stackRepr = "";
        for(int i = this.topo;i>= 0;i--){
            stackRepr += Integer.toString(this.itens[i]) + "\n";
        }
        return stackRepr;
    }        
    
}
