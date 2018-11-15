package mypanel;

import java.awt.*;
import java.util.Random;

public class Kwadrat extends Shape {
    
    public Kwadrat() {
        Random rand = new Random();
        x = rand.nextInt(200);
        y = rand.nextInt(200);
        width = 50;
        height = 50;
        radius = 0;
        color = Color.RED;
    }
    
    public Kwadrat(int xIn, int yIn, int widthIn, int heightIn, Color colorIn) {
        Random rand = new Random();
        if (xIn > 0 && xIn < 200) 
            x = xIn;
        else 
            x = rand.nextInt(200);
        
        if (yIn > 0 && yIn < 200) 
            y = yIn;
        else
            y = rand.nextInt(200);
        
        if (widthIn > 0 && widthIn < 200)
            width = widthIn;
        else
            width = 50;
        
        if (heightIn > 0 && heightIn < 200)
            height = heightIn;
        else
            height = 50;
        
        color = colorIn;
        radius = 0;
    }
    
    @Override
    public void setBounds(int xIn, int yIn) {
        x = xIn;
        y = yIn;
    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fillRect(x, y, width, height);
    }
}