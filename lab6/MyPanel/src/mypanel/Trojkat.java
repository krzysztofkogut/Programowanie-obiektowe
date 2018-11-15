package mypanel;

import java.awt.*;
import java.util.Random;

public class Trojkat extends Shape {

    public Trojkat() {
        Random rand = new Random();
        x = Math.abs(rand.nextInt()) % 200;
        y = Math.abs(rand.nextInt()) % 200;
        radius = 0;
        width = 0;
        height = 0;
        color = Color.GREEN;
    }
    
    public Trojkat(int xIn, int yIn, Color colorIn) {
        Random rand = new Random();
        if (xIn > 0 && xIn < 200) 
            x = xIn;
        else
            x = Math.abs(rand.nextInt()) % 200;
        if (yIn > 0 && yIn < 200) 
            y = yIn;
        else
            y = Math.abs(rand.nextInt()) % 200;
        
        color = colorIn;
        radius = 0;
        width = 0;
        height = 0;
    }

    @Override
    public void setBounds(int xIn, int yIn) {
        x = xIn;
        y = yIn;
    }
    
    @Override
    public void draw(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        int[] a = { x , x + 20 , x + 40};
        int[] b = { y + 50, y , y + 50};
        g2.setColor(color);
        g2.fillPolygon(a, b, 3);
    }
}