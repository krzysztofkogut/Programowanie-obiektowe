package mypanel;

import java.awt.*;

public abstract class Shape{
    public String name;
    public int x, y, width, height, radius;    
    public Color color;
    public abstract void setBounds(int xIn, int yIn);
    public abstract void draw(Graphics g);
}