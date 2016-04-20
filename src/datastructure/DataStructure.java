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
public class DataStructure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Fila<Integer> f = new Fila<>();
        f.enfileirar(1);
        f.enfileirar(5);
        f.enfileirar(11);
        System.out.println(f.toString());
        System.out.println(f.desenfileirar().toString());
        System.out.println(f.toString());
    }
    
}