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
public class Arvore {
    
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }        
    
    public boolean vazia(){
        return (this.raiz == null);
    }
    
    public void adicionar(int item){        
        if (this.raiz == null){
            this.raiz = new No(item);
        }else{
            this.adicionar(this.raiz,item);
        }
    }
    
    public void adicionar(No no,int item){
        
        if ( item < no.getNumero()){
            if (no.getEsquerdo() == null){
                no.setEsquerdo(new No(item));
            }else{
                this.adicionar(no.getEsquerdo(),item);
            }
        }else{
            if(no.getDireito() == null){
                no.setDireito(new No(item));
            }else{
                this.adicionar(no.getDireito(),item);
            }   
        }        
    }
    
    public int calculaAltura(No n){
        return this.calculaAltura(n, 1);
    }
    
    private int calculaAltura(No n, int altura){
        if (n == null){
            return altura - 1;
        }else{
            int arvoreEsquerda = this.calculaAltura(n.getEsquerdo(),altura + 1);
            int arvoreDireita = this.calculaAltura(n.getDireito(), altura + 1);
            if (arvoreEsquerda > arvoreDireita){
                return arvoreEsquerda;
            }else{
                return arvoreDireita;
            }
        }
    }
    
    public No preOrdem(No n,int item){
        if (n != null){
            if (n.getNumero() == item){
                return n;
            }else{
                No retorno = null;
                retorno = this.preOrdem(n.getEsquerdo(),item);
                if (retorno == null){
                    return this.preOrdem(n.getDireito(), item);
                }else{
                    return retorno;
                }
            }
        }
        return n;
    }
    
    public void inOrdem(No n){
        if (n != null){            
            this.inOrdem(n.getEsquerdo());
            System.out.print(n.getNumero());
            System.out.print(" - ");
            this.inOrdem(n.getDireito());
        }
    }
    
    public void posOrdem(No n){
        if (n != null){            
            this.posOrdem(n.getEsquerdo());
            this.posOrdem(n.getDireito());
            System.out.print(n.getNumero());
            System.out.print(" - ");
        }
    }
    
    public String largura(){
        String larguraResult = "";
        Fila<No> f = new Fila<>();
        f.enfileirar(this.raiz);
        while(!f.vazio()){
            No n = f.desenfileirar();
            larguraResult = Integer.toString(n.getNumero()) + " - ";
            if (n.getEsquerdo() != null){
                f.enfileirar(n.getEsquerdo());
            }
            if (n.getDireito() != null){
                f.enfileirar(n.getDireito());
            }
        }
        return larguraResult;
    }
    
    public No rotacaoDireita(No n){
        No nEsquerdo = n.getEsquerdo();
        n.setEsquerdo(nEsquerdo.getDireito());
        nEsquerdo.setDireito(n);
        return nEsquerdo;
    }

    public No rotacaoEsquerda(No n){
        No nDireito = n.getDireito();
        n.setDireito(nDireito.getEsquerdo());
        nDireito.setEsquerdo(n);
        return nDireito;
    }
    
    public No duplaRotacaoDireita(No n){
        No n1 = n.getEsquerdo();
        No n2 = n1.getDireito();
        n.setEsquerdo(n2.getDireito());
        n1.setDireito(n2.getEsquerdo());
        n2.setEsquerdo(n1);        
        n2.setDireito(n);
        return n2;
    }

    public No duplaRotacaoEsquerda(No n){
        No n1 = n.getDireito();
        No n2 = n1.getEsquerdo();
        n.setDireito(n2.getDireito());
        n1.setEsquerdo(n2.getEsquerdo());
        n2.setEsquerdo(n);        
        n2.setDireito(n1);
        return n2;
    }

    
    public void setRaiz(No n){
        this.raiz = n;
    }
    
    public void mostrarArvore(int nivel,No n,String label){
        for(int i = 0;i<nivel;i++){
            System.out.print(" ");
        }
        System.out.print(n.getNumero());
        System.out.println(" " + label);
        if (n.getEsquerdo() != null){
            this.mostrarArvore(nivel + 1, n.getEsquerdo(),"Filho Esquerdo");
        }
        if (n.getDireito() != null){
            this.mostrarArvore(nivel + 1, n.getDireito(),"Filho Direito");
        }
    }
    
    public void cleanTree(){
        this.raiz = null;
    }
    
    public No busca(int n, No no){
        if (no == null){
            return no;
        }
        if (no.getNumero() == n){
            return no;
        }else if (n > no.getNumero()){
            return this.busca(n, no.getDireito());
        }else{
            return this.busca(n, no.getEsquerdo());
        }
    }
    
}
