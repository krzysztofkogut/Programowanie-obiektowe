package mypanel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener{

    public LinkedList<Shape> myFigures;
    LinkedList<Point> points;
    Point movingPoint = null;
    
    public MyPanel() {
        super();
        this.myFigures = new LinkedList<>();
        this.points = new LinkedList<>();
        Kolo kolo = new Kolo();
        Trojkat trojkat = new Trojkat();
        Kwadrat kwadrat = new Kwadrat();
        addMouseMotionListener(this);
        addMouseListener(this);
        myFigures.add(kolo);
        myFigures.add(trojkat);
        myFigures.add(kwadrat);
        points.add(new Point(kolo.x, kolo.y));
        points.add(new Point(trojkat.x, trojkat.y));
        points.add(new Point(kwadrat.x, kwadrat.y)); 
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        movingPoint = null;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        int x1 = e.getX();
        int y1 = e.getY();
        int x2, y2;
        int index = 0;
        int size = points.size();
        Point p;
        Shape f;
        while (movingPoint == null && index < size) {
            p = points.get(index);
            f = myFigures.get(index);
            x2 = (int) p.getX();
            y2 = (int) p.getY();
            if (x1 >= x2 && y1 >= y2 && x1 <= x2 + 50 && y1 <= y2 + 50)
                movingPoint = p;
            index++;
        }
        repaint();
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if (movingPoint != null) {
            movingPoint.x = e.getX();
            movingPoint.y = e.getY();
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
    @Override
    public void paint(Graphics graphic) {
        super.paint(graphic);
        Graphics2D g2 = (Graphics2D) graphic;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600);
        drawAll(graphic);
    }
    
    private void drawAll(Graphics g) {
       for (int i = 0; i < myFigures.size(); i++) {
            myFigures.get(i).setBounds(points.get(i).x, points.get(i).y);
            myFigures.get(i).draw(g);
        } 
    }
}