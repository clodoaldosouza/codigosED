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
public class Vetor {
    
    private int[] innerVector;

    public Vetor(int[] innerVector) {
        this.innerVector = innerVector;
    }

    public int[] getInnerVector() {
        return this.innerVector;
    }        
    
    public void soma(Vetor v) throws ArithmeticException{
        int[] v2 = v.getInnerVector();
        if (this.innerVector.length != v2.length){
            throw new ArithmeticException("As dimensões dos vetores não estão corretas");
        }
        for (int i = 0;i < this.innerVector.length;i++){
            this.innerVector[i] = this.innerVector[i] + v2[i];
        }
    }
    
    public void multiplicacaoEscalar(int s){
        for (int i = 0;i < this.innerVector.length;i++){
            this.innerVector[i] = this.innerVector[i] * s;
        }        
    }

    public void subtracao(Vetor v) throws ArithmeticException{
        int[] v2 = v.getInnerVector();
        if (this.innerVector.length != v2.length){
            throw new ArithmeticException("As dimensões dos vetores não estão corretas");
        }
        for (int i = 0;i < this.innerVector.length;i++){
            this.innerVector[i] = this.innerVector[i] - v2[i];
        }
    }
    
    public int[] fatiamento(int inicio, int fim) throws ArrayIndexOutOfBoundsException{
        if (inicio < 0){
            throw new ArrayIndexOutOfBoundsException(inicio);
        }
        if (fim > this.innerVector.length){
            throw new ArrayIndexOutOfBoundsException(fim);
        }
        int sliceSize = fim - inicio;
        if (sliceSize <= 0){
            throw new ArrayIndexOutOfBoundsException("O fim deve ser maior que o inicio");
        }
        int[] slice = new int[sliceSize];
        int countInner = 0;
        for (int i = inicio;i<fim;i++){
            slice[countInner] = this.innerVector[i];
            countInner++;
        }
        return slice;
    }

    public void reverter(){
        int[] temp = new int[this.innerVector.length];
        int countInner = 0;
        for (int i = temp.length-1;i>=0;i--){
            temp[countInner] = this.innerVector[i];
            countInner++;
        }
        this.innerVector = temp;
    }

    @Override
    public String toString() {
        String dados = "";
        for(int i : this.innerVector){
            dados += Integer.toString(i) + ",";
        }
        return "[" + dados.substring(0,dados.length()-1) + "]";
    }        
    
}
