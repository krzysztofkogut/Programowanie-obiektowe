package macierz;

public class MacierzApplication {
    public static void main(String[] arguments) {
        Macierz m1 = new Macierz();
        Macierz m2 = new Macierz();
        m1.setMacierz();
        m1.getMacierz();
        m2.setMacierz();
        m2.getMacierz();
        
        m1.sum(m2);
        
    }
}