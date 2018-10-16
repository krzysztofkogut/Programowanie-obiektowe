package abc;

public class A {
    protected int number;
    protected String name;
    
    public A() {
        number = 100;
        name = "Krzysztof";
    }
    
    public A(int number, String name) {
        this.number = number;
        this.name = name;
    }
    
    public void callDecrement() {
        this.decrement();
        System.out.println(number);
    }
    
    public void callChangeName(String tmp) {
        this.changeName(tmp);
    }
    
    public void callIncrement() {
        this.increment();
        System.out.println(number);
    }
    
    private void increment() {
        number++;
    }
    
    protected void decrement() {
        number--;
    }
    
    protected void changeName(String tmp) {
        String text = new String(tmp);
        this.name = text;
        System.out.println(this.name);
    } 
}