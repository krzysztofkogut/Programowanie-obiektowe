package abc;

public class B extends A{
    
    public B() {
        number = 70;
        name = "Damian";
}
    
    protected void decrement() {
        number--;
    }
    
    protected void changeName(String tmp) {
        String text = new String(tmp);
        this.name = text;
        System.out.println(this.name);
    }
    
    private void increment() {
        number++;
    }
    
}