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
                
        
        HashTable ht = new HashTable();
        ht.adicionar(383);
        ht.adicionar(487);
        ht.adicionar(235);
        ht.adicionar(527);
        ht.adicionar(203);
        ht.adicionar(510);
        
        System.out.println(ht.toString());
        System.out.println(ht.getItemChave(487));
        
    }
    
}