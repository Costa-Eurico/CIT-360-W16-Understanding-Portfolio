/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit_example;

/**
 *
 * @author eucosta
 */
public class JUnitExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    //test calculation
    public int goodSum(int var1, int var2){
        System.out.println("Adding value: " + var1 + " + " + var2);
        return var1 + var2;
    }
    
    //test calculation
    public int badSum(int var1, int var2){
        System.out.println("Adding value: " + var1 + " + " + var2);
        return var1 - var2;
    }
}
