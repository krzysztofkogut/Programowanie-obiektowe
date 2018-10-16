package figury;

public class Kwadrat {
    protected double a;
    
    public Kwadrat(double a) {
        this.a = a;
    }
    
    public double getA() {
        return a;
    }
    
    public void setA(double a) {
        this.a = a;
    }
    
    public double area() {
        return a*a;
    }
    
    public boolean isBigger(Kwadrat tmp) {
        if(tmp.area() > this.area())
            return true;
        else
            return false;
    }  
}