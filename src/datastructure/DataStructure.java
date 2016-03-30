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

        PilhaDinamica p = new PilhaDinamica();
        p.push(10);
        p.push(20);
        p.push(30);
        p.push(123);
        System.out.println(p.toString());        
        System.out.println();
        System.out.println(Integer.toString(p.pop()));
        System.out.println();
        System.out.println(p.toString());
    }
    
}