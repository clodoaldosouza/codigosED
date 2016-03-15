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
public class EloDuplamenteLigado<T>{
    
    private EloDuplamenteLigado<T> proximo;
    private EloDuplamenteLigado<T> anterior;
    private T dados;

    public EloDuplamenteLigado() {
        this.proximo = null;
        this.anterior = null;
        this.dados = null;
    }

    public EloDuplamenteLigado(T dados) {
        this.proximo = null;
        this.anterior = null;
        this.dados = dados;
    }
    
    public EloDuplamenteLigado(EloDuplamenteLigado<T> proximo, EloDuplamenteLigado<T> anterior, T dados) {
        this.proximo = proximo;
        this.anterior = anterior;
        this.dados = dados;
    }
    
    public EloDuplamenteLigado<T> getProximo() {
        return proximo;
    }

    public void setProximo(EloDuplamenteLigado<T> proximo) {
        this.proximo = proximo;
    }

    public EloDuplamenteLigado<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(EloDuplamenteLigado<T> anterior) {
        this.anterior = anterior;
    }

    public T getDados() {
        return dados;
    }

    public void setDados(T dados) {
        this.dados = dados;
    }
    
}
