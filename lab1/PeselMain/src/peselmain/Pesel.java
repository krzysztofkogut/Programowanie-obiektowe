/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peselmain;

/**
 *
 * @author kris
 */
public class Pesel {
   
    public static boolean check (String tmp)
    {
        if (tmp.length() != 11)
        {
            return false;
        }
        
        
        int liczbaKontrolna = Character.getNumericValue(tmp.charAt(10));
        int suma = 9 * Character.getNumericValue(tmp.charAt(0))+
            7 * Character.getNumericValue(tmp.charAt(1)) +
            3 * Character.getNumericValue(tmp.charAt(2)) +
            1 *Character.getNumericValue(tmp.charAt(3)) +
            9 * Character.getNumericValue(tmp.charAt(4)) +
            7 * Character.getNumericValue(tmp.charAt(5)) +
            3 * Character.getNumericValue(tmp.charAt(6)) +
            1 *Character.getNumericValue(tmp.charAt(7)) +
            9 * Character.getNumericValue(tmp.charAt(8)) +
            7 * Character.getNumericValue(tmp.charAt(9));

        int modulo = suma % 10;

         return liczbaKontrolna == modulo;       
    }
}
