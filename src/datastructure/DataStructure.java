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

        /*
        ListaDuplamenteLigada<Integer> ll = new ListaDuplamenteLigada<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        System.out.println(ll);
        ll.add(1, 25);
        System.out.println(ll);
        ll.add(0, 12);
        System.out.println(ll);
        ll.add(3, 28);
        System.out.println(ll);
        ll.add(123);
        System.out.println(ll);
        
        System.out.println(ll.get(2).getDados().toString());
        System.out.println(ll.get(0).getDados().toString());
        
        System.out.println(Integer.toString(ll.indexOf(25)));
        
        System.out.println("Item removido - idx 3 " + ll.removeAt(3).getDados().toString());
        System.out.println(ll);
        
        System.out.println(ll.set(4,2010));
        System.out.println(ll);
        
        System.out.println(Integer.toString(ll.size()));
        */
        
        ListaLigada ll = new ListaLigada();
        ll.add(30);
        ll.add(5);
        ll.add(123);
        ll.add(40);
        ll.add(32);
        System.out.println(ll.toString());
        ll.ordenar();
        System.out.println(ll.toString());
        
    }
    
}