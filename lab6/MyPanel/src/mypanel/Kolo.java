package mypanel;

import java.awt.*;
import java.util.Random;

public class Kolo extends Shape {
    
    public Kolo() {
        Random rand = new Random();
        radius = 50;
        width = 0;
        height = 0;
        x = rand.nextInt(200) + radius;
        y = rand.nextInt(200) + radius;
        color = Color.BLUE;
    }
    
    public Kolo(int xIn, int yIn, int radiusIn, Color colorIn) {
        Random rand = new Random();
        if (xIn > radiusIn && xIn < 240 + radiusIn) 
            x = xIn;
        else 
            x = rand.nextInt(240) + radiusIn;
        
        if (yIn > radiusIn && yIn < 240 + radiusIn) 
            y = yIn;
        else
            y = rand.nextInt(240) + radiusIn;
        
        if (radiusIn > 0 && radiusIn < 100)
            radius = radiusIn;
        else
            radius = 50;
        
        color = colorIn;
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
            Random rand = new Random();
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(color);
            g2.fillOval(x, y, radius, radius);
    }
}