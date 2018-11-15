package polynomials;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import javax.swing.*;
public class Polynomials extends JFrame {

    private String errorLog = null;
    private HashMap<Double, Double> points;
    private Double sampling;
    private LinkedList<Double> factors;
    private Double beginning;
    private Double end;

    private JButton drawButton;
    private JTextField factorsField;
    private JLabel factorsLabel;
    private JPanel graphPanelIn;
    private JPanel graphPanelOut;
    private JPanel optionsPanel;
    private JTextField rangeBegField;
    private JLabel rangeBegLabel;
    private JTextField rangeEndField;
    private JLabel rangeEndLabel;
    private JTextField samplingField;
    private JLabel samplingLabel;

    public Polynomials() {
        super("Graph");
        initComponents();
        setLookAndFeel();
        pack();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionsPanel = new JPanel();
        drawButton = new JButton();
        factorsField = new JTextField();
        rangeBegField = new JTextField();
        rangeEndField = new JTextField();
        samplingField = new JTextField();
        factorsLabel = new JLabel();
        rangeBegLabel = new JLabel();
        rangeEndLabel = new JLabel();
        samplingLabel = new JLabel();
        graphPanelOut = new JPanel();
        graphPanelIn = new GraphPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        optionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));

        drawButton.setText("Draw");
        drawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawButtonActionPerformed(evt);
            }
        });

        factorsField.setText("1");
        factorsField.setInputVerifier(new StrictInputVerifier("[-?[0-9]*//.?[0-9]*,]*"));
        factorsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                factorsFieldActionPerformed(evt);
            }
        });

        rangeBegField.setText("0");
        rangeBegField.setInputVerifier(samplingField.getInputVerifier());
        rangeBegField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rangeBegFieldActionPerformed(evt);
            }
        });

        rangeEndField.setText("100");
        rangeEndField.setInputVerifier(samplingField.getInputVerifier());
        rangeEndField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rangeEndFieldActionPerformed(evt);
            }
        });

        samplingField.setText("0.1");
        samplingField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        samplingField.setInputVerifier(new StrictInputVerifier("-?[0-9]{1,}\\.?[0-9]*"));
        samplingField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                samplingFieldActionPerformed(evt);
            }
        });

        factorsLabel.setText("Factors");

        rangeBegLabel.setText("Range from");

        rangeEndLabel.setText("Range to");

        samplingLabel.setText("Sampling");

        GroupLayout optionsPanelLayout = new GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGroup(optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(factorsLabel)
                    .addComponent(factorsField, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(rangeBegLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rangeBegField))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(rangeEndField)
                    .addComponent(rangeEndLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(samplingLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(samplingField))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drawButton)
                .addGap(65, 65, 65))
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(optionsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(factorsLabel)
                    .addComponent(rangeBegLabel)
                    .addComponent(rangeEndLabel)
                    .addComponent(samplingLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rangeEndField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(rangeBegField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(factorsField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(samplingField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(drawButton)))
        );

        graphPanelOut.setBorder(BorderFactory.createTitledBorder("Graph"));

        graphPanelIn.setBackground(new Color(254, 254, 254));

        javax.swing.GroupLayout graphPanelInLayout = new GroupLayout(graphPanelIn);
        graphPanelIn.setLayout(graphPanelInLayout);
        graphPanelInLayout.setHorizontalGroup(
            graphPanelInLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        graphPanelInLayout.setVerticalGroup(
            graphPanelInLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout graphPanelOutLayout = new GroupLayout(graphPanelOut);
        graphPanelOut.setLayout(graphPanelOutLayout);
        graphPanelOutLayout.setHorizontalGroup(
            graphPanelOutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(graphPanelIn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        graphPanelOutLayout.setVerticalGroup(
            graphPanelOutLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(graphPanelIn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(graphPanelOut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(optionsPanel, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(optionsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(graphPanelOut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void rangeEndFieldActionPerformed(ActionEvent evt) {
    }

    private void samplingFieldActionPerformed(ActionEvent evt) { 
    }

    private void drawButtonActionPerformed(ActionEvent evt) {
        errorLog = null;
        Double temp;

        InputVerifier doubleVerifier = samplingField.getInputVerifier();

        if (!factorsField.getInputVerifier().verify(factorsField)) {
            errorLog = "Błędnie wpisane współczynniki (liczby rzeczywiste oddzielane przecinkami)!";
        } else if (!doubleVerifier.verify(rangeBegField)) {
            errorLog = "Błędnie wpisany początek zakresu (liczba rzeczywista)!";
        } else if (!doubleVerifier.verify(rangeEndField)) {
            errorLog = "Błędnie wpisany koniec zakresu (liczba rzeczywista)!";
        } else if (!doubleVerifier.verify(samplingField)) {
            errorLog = "Błędnie wpisane próbkowanie (liczba rzeczywista)!";
        } else if (Double.parseDouble(rangeBegField.getText()) == Double.parseDouble(rangeEndField.getText())) {
            errorLog = "Błędne dane wejściowe - początek równy końcowi zakresu!";
        } else {
            beginning = Double.parseDouble(rangeBegField.getText());
            end = Double.parseDouble(rangeEndField.getText());
            sampling = Double.parseDouble(samplingField.getText());
            factors = new LinkedList<>();
            for (String factor : factorsField.getText().split(",")) {
                factors.add(Double.parseDouble(factor));
            }
            if (beginning > end) {
                temp = beginning;
                beginning = end;
                end = temp;
            }
            points = new HashMap<>();
            for (Double i = beginning; i <= end; i += sampling) {
                points.put(i, fPoly(i));
            }
        }
        graphPanelIn.paint(graphPanelIn.getGraphics());
    }

    private Double fPoly(Double x) {
        Double result = 0.0;
        for (Double factor : factors) {
            result = result * x + factor;
        }
        return result;
    }

    private class GraphPanel extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Integer width = this.getWidth() - 15;
            Integer height = this.getHeight() - 15;
            Long temp;
            if (errorLog != null) {
                g.drawString(errorLog, 10, 15);
            } else if (beginning != null) {
                g.drawLine(15, 0, 15, height);
                g.drawLine(15, height, width + 15, height);
                temp = Math.round(beginning);
                g.drawString(temp.toString(), 10, height + 15);
                temp = Math.round(end);
                g.drawString(temp.toString(), width - 10, height + 15);
                Double scaleX = width / Math.abs(beginning - end);

                Double minY = points.get(beginning);
                Double maxY = minY;
                for (Entry<Double, Double> point : points.entrySet()) {
                    if (point.getValue() < minY) {
                        minY = point.getValue();
                    } else if (point.getValue() > maxY) {
                        maxY = point.getValue();
                    }
                }

                if (maxY != minY) {
                    temp = Math.round(maxY);
                    g.drawString(temp.toString(), 0, 15);
                    temp = Math.round(minY);
                    g.drawString(temp.toString(), 0, height);
                    Double scaleY = height / Math.abs(maxY - minY);
                    Double prevX = null, prevY = null;
                    for (Double i = beginning; i <= end; i += sampling) {
                        if (prevY == null) {
                            prevY = points.get(i);
                            prevX = i;
                        } else {
                            g.drawLine((int) ((prevX - beginning) * scaleX) + 15, 
                                    (int) (height - (prevY - minY) * scaleY), (int) 
                                            ((i - beginning) * scaleX) + 15, (int) 
                                                    (height - (points.get(i) - minY) * scaleY));
                            prevY = points.get(i);
                            prevX = i;
                        }
                    }
                } else if (minY != 0) {
                    g.drawLine(15, (int) height/2, width + 15, (int) height/2);
                    temp = Math.round(maxY);
                    g.drawString(temp.toString(), 0, (int) height/2 + 5);                    
                }
            }
        }
    }

    private void rangeBegFieldActionPerformed(ActionEvent evt) {
    }

    private void factorsFieldActionPerformed(ActionEvent evt) {
    }
    
    private class StrictInputVerifier extends InputVerifier {

        private final String validString;

        StrictInputVerifier(String validString) {
            this.validString = validString;
        }

        @Override
        public boolean verify(JComponent input) {
            JTextField textField;
            textField = (JTextField) input;
            return textField.getText().matches(validString);
        }   
    }
    
    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Nie potrafię wczytać "
                + "systemowego wyglądu: " + e);
        }
    }
    
    public static void main(String args[]) {
        Polynomials polymians = new Polynomials();
    }
}