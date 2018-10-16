package macierz;

import java.util.Scanner;

public class Macierz {
    
    private int rozmiar;
    double[] tablica;
    
    Macierz() {
        rozmiar = 0;
    }
    
    Macierz(int n) {
        if (rozmiar > 0) {
            rozmiar = n;
            tablica = new double [rozmiar * rozmiar];   
        }
        else
            System.out.println("Rozmiar musi być większy od zera!");
           
    }
   
   void getMacierz() {
       if (rozmiar > 0) {
           for(int i=0; i<rozmiar*rozmiar; i++) {
               System.out.print(tablica[i] + " ");
               if ((i+1)%rozmiar == 0)
                   System.out.println("");
           }
       }
   } 
    
   void setMacierz() {
       System.out.println("Podaj rozmiar macierzy: ");
        Scanner input = new Scanner(System.in);
        rozmiar = input.nextInt();
        if (rozmiar > 0) {
            tablica = new double [rozmiar * rozmiar];  
            for(int i=0; i<rozmiar*rozmiar; i++) 
                tablica[i] = input.nextDouble();
        }
   }
   
   public void sum(Macierz tmp) {
       Macierz wynik = new Macierz();
       wynik.rozmiar = this.rozmiar;
       wynik.tablica = new double[rozmiar*rozmiar];
       if (this.rozmiar == tmp.rozmiar) {
           for(int i=0; i<rozmiar*rozmiar; i++) {
               wynik.tablica[i] = this.tablica[i] + tmp.tablica[i];
           }
       }
       else
           System.out.println("Podano macierze różnych rozmiarów");
       
       wynik.getMacierz();
       
//       return wynik;
   }
   
   Macierz sub(Macierz tmp) {
       Macierz wynik = new Macierz();
       wynik.rozmiar = this.rozmiar;
       wynik.tablica = new double[rozmiar*rozmiar];
       if (this.rozmiar == tmp.rozmiar) {
           for(int i=0; i<rozmiar*rozmiar; i++) {
               wynik.tablica[i] = this.tablica[i] - tmp.tablica[i];
           }
       }
       else
           System.out.println("Podano macierze różnych rozmiarów");
       
       return wynik;
   }
   
   Macierz mul(Macierz tmp) {
       Macierz wynik = new Macierz();
       wynik.rozmiar = this.rozmiar;
       wynik.tablica = new double[rozmiar*rozmiar];
        int kolumna;
        int wiersz;
        for (int i = 0; i < rozmiar * rozmiar; i++)
        {
            kolumna = i % rozmiar;
            wiersz = i / rozmiar;

            for (int j = wiersz * rozmiar; j < (rozmiar * wiersz + rozmiar); j++)
            {
                wynik.tablica[i] += (tablica[j] * tmp.tablica[kolumna]);
                kolumna += rozmiar;
            }
        }
        
        return wynik;
   }
}
