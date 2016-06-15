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
public class HashTable {
    
    private ListaLigada<Integer>[] tabela;

    public HashTable() {
        this.tabela = new ListaLigada[100];
        for (int i = 0;i<100;i++){
            this.tabela[i] = new ListaLigada<>();
        }
    }
    
    public ListaLigada<Integer> get(int endereco){
        return this.tabela[endereco];
    }
    
    public Integer getItemChave(int chave){
        int endereco = this.hash(chave);
        ListaLigada<Integer> ll = this.tabela[endereco];
        int enderecoLista = ll.indexOf(chave);
        return ll.get(enderecoLista).getData();
    }
    
    public void adicionar(int chave){
        int endereco = this.hash(chave);
        this.tabela[endereco].add(chave);
    }
    
    public Integer remover(int chave){
        int endereco = this.hash(chave);
        ListaLigada<Integer> ll = this.tabela[chave];
        int enderecoLista = ll.indexOf(chave);
        return ll.removeAt(enderecoLista).getData();
    }
    
    public int hash(int chave){
        return Math.abs(chave % 23);
    }

    @Override
    public String toString() {
        String lista = "";
        for (ListaLigada<Integer> tabela1 : this.tabela) {
            if (tabela1.isEmpty()) {
                lista += "Vazio \n";
            } else {
                lista += tabela1.toString() + "\n";
            }
        }
        return lista;
    }    
    
}
