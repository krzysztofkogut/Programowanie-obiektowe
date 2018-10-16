package abc;

public class ABCApplication {
    public static void main(String[] arguments) {
        
        A a = new A();
        B b = new B();
        C c = new C();

        c.callChangeName("Kris");
        b.callIncrement();
        
    }
    
}