/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peselmain;

import java.util.Scanner;
/**
 *
 * @author kris
 */
public class PeselMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Podaj numer pesel: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        
        if(Pesel.check(text))
            System.out.println("Poprawny numer pesel! ");
        else
            System.out.println("Niepoprawny numer pesel! ");
    }
    
}
