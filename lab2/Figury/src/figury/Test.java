package figury;

import java.util.*;

public class Test {
    
    static LinkedList<Prostokat> figury = new LinkedList<>();
    
    public static void main(String[] arguments) {
        System.out.println("MENU");
        System.out.println("----------------------");
        System.out.println("1. Wczytaj prostokat");
        System.out.println("2. Wyświetl wszystkie prostokaty");
        System.out.println("3. Oblicz sume wszystkch pól prostokątów");
        System.out.println("4. Zakończ");
        
        Scanner input = new Scanner(System.in);
        System.out.println("Wybór: ");
        int wybor;
        wybor = input.nextInt();
        
        while(wybor != 4) {
            switch(wybor) {
                case 1:
                    System.out.println("Podaj bok a: ");
                    int a = input.nextInt();
                    System.out.println("Podaj bok b: ");
                    int b = input.nextInt();
                    Prostokat nowy = new Prostokat(a,b);
                    figury.add(nowy);
                    break;
                 
                case 2:
                    if (figury.isEmpty())
                        System.out.println("Nie dodano żadnego prostokąta");
                    for(int i=0; i < figury.size(); i++) {
                        System.out.println("Prostokąt nr " + (i+1) +": " + "a = "
                                + figury.get(i).getA() + ", b = " + figury.get(i).getB() );
                    }
                    break;
                    
                case 3:
                    double suma = 0;
                    for(int i=0; i < figury.size(); i++) {
                        suma += figury.get(i).area();
                    }
                    System.out.println("Suma pól: " + suma);
                    break;
                default: 
                    System.out.println("Nie ma takiej opcji, podano złą liczbę");
                    break;
            }
            
            System.out.println("Wybór: ");
            wybor = input.nextInt();
        }
    }
}