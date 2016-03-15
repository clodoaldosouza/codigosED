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
public class Node<T>{

    private T data;
    private Node<T> proximo;

    public Node() {
        this.data = null;
        this.proximo = null;
    }

    public Node(T data) {
        this.data = data;
        this.proximo = null;
    }    

    public Node(T data, Node<T> proximo) {
        this.data = data;
        this.proximo = proximo;
    }        

    public T getData() {
        return data;
    }    
    
    public Node<T> getProximo() {
        return proximo;
    }

    public void setProximo(Node<T> proximo) {
        this.proximo = proximo;
    }        

    public void setData(T data) {
        this.data = data;
    }
     
    
}
