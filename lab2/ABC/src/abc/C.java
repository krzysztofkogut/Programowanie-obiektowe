package abc;

public class C extends B {
    
    public C() {
        number = 50;
        name = "Patryk";
    }
    
    protected void changeName(String tmp) {
        String text = new String(tmp);
        this.name = text;
        System.out.println(this.name);
    }
}