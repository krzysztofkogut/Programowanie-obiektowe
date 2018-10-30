package cryptographer;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Cryptographer {
    
    public static void cryptfile (String sourceName, String whereSave, Algorithm key) {
        try {
            FileSystem fs = FileSystems.getDefault();
            Path source = fs.getPath(sourceName);
            Path where = fs.getPath(whereSave);
            
            FileReader fr = new FileReader(source.toFile());
            BufferedReader in = new BufferedReader(fr);
            
            FileWriter fw = new FileWriter(where.toFile());
            BufferedWriter out = new BufferedWriter(fw);
            
            boolean eof = false;
            String inLine;
            String outLine;
            while(!eof) {
                inLine = in.readLine();
                if (inLine == null)
                    eof = true;
                else{
                    outLine = key.crypt(inLine);
                    out.write(outLine);
                }       
            }
            in.close();
            out.close();
            
            
        } catch (IOException|SecurityException se) {
            System.out.println("Błąd: " + se.getMessage());
        }
            
    }
    
    public static void decryptfile (String sourceName, String whereSave, Algorithm key) {
        try {
            FileSystem fs = FileSystems.getDefault();
            Path source = fs.getPath(sourceName);
            Path where = fs.getPath(whereSave);
            
            FileReader fr = new FileReader(source.toFile());
            BufferedReader in = new BufferedReader(fr);
            
            FileWriter fw = new FileWriter(where.toFile());
            BufferedWriter out = new BufferedWriter(fw);
            
            boolean eof = false;
            String inLine;
            String outLine;
            while(!eof) {
                inLine = in.readLine();
                if (inLine == null)
                    eof = true;
                else{
                    outLine = key.decrypt(inLine);
                    out.write(outLine);
                }       
            }
            in.close();
            out.close();
            
            
        } catch (IOException|SecurityException se) {
            System.out.println("Błąd: " + se.getMessage());
        }
            
    }
    
    public static void main(String[] arguments) {
        if (arguments.length < 2)
            System.out.println("Podano zbyt małą ilość argumentów");
        else {
            System.out.println("MENU");
            System.out.println("----------------------");
            System.out.println("1. Szyfruj");
            System.out.println("2. Deszyfruj");

            Scanner input = new Scanner(System.in);
            System.out.println("Wybór: ");
            int wybor;
            wybor = input.nextInt();
            
            switch(wybor) {
                case 1:
                    System.out.println("Algorytm szyfrowania: ");
                    System.out.println("1. ROT11   ");
                    System.out.println("2. Polibiusz");
                    int szyfr = input.nextInt();
                    
                    if (szyfr == 1) {
                        ROT11 rot = new ROT11();
                        Cryptographer.cryptfile(arguments[0], arguments[1], rot);
                    }
                    else if (szyfr == 2) {
                        Polibiusz pol = new Polibiusz();
                        Cryptographer.cryptfile(arguments[0], arguments[1], pol);
                    }
                    else
                        System.out.println("Nie ma takiej opcji");
                   
                    break;
                 
                case 2:
                    System.out.println("Algorytm szyfrowania: ");
                    System.out.println("1. ROT11   ");
                    System.out.println("2. Polibiusz");
                    int deszyfr = input.nextInt();
                    
                    if (deszyfr == 1) {
                        ROT11 rot = new ROT11();
                        Cryptographer.decryptfile(arguments[0], arguments[1], rot);
                    }
                    else if (deszyfr == 2) {
                        Polibiusz pol = new Polibiusz();
                        Cryptographer.decryptfile(arguments[0], arguments[1], pol);
                    }  
                    else 
                        System.out.println("Nie ma takiej opcji");
 
                    break;
                        
                        
                    
                default:
                    System.out.println("Nie ma takiej opcji");
                    break;
                    
            }
            
        }
    }
}
