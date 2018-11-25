/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomialsfx;

import java.util.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PolynomialsFX extends Application {
    
    private String errorLog = null;
    private HashMap<Double, Double> points;
    private Double sampling;
    private LinkedList<Double> factors;
    private Double beginning;
    private Double end;
    
    @Override
    public void start(Stage primaryStage) {
        
        TextField factorsField = zrobTextField();
        Label factorsLabel = new Label("Factors");
        TextField rangeBegField = zrobTextField();
        Label rangeBegLabel = new Label("Range from");
        TextField rangeEndField = zrobTextField();
        Label rangeEndLabel = new Label("Range to");
        TextField samplingField = zrobTextField();
        Label samplingLabel = new Label("Sampling");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number,Number> lineChart = 
            new LineChart<Number,Number>(xAxis,yAxis);
        XYChart.Series series = new XYChart.Series();
        series.setName("W(x)");
        Button drawButton = new Button("Draw");
        drawButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double temp;
                series.getData().clear();
                
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
                
                for (Double i = beginning; i <= end; i += sampling) {
                series.getData().add(new XYChart.Data(i,points.get(i)));
                }   
            }
        });
        
        GridPane root = new GridPane();
        root.setPadding(new Insets(5));
        root.setHgap(30);
        root.setVgap(10);
        
        root.add(factorsLabel, 0, 0);
        root.add(rangeBegLabel, 1, 0);
        root.add(rangeEndLabel, 2, 0);
        root.add(samplingLabel, 3, 0);
        
        root.add(factorsField, 0, 1);
        root.add(rangeBegField, 1, 1);
        root.add(rangeEndField, 2, 1);
        root.add(samplingField, 3, 1);
        root.add(drawButton, 4, 1);
       
        lineChart.getData().add(series);
        
        VBox root_all = new VBox(10);
        root_all.getChildren().add(root);
        root_all.getChildren().add(lineChart);
        
        Scene scene = new Scene(root_all, 600, 400);
        
        primaryStage.setTitle("Graph");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Double fPoly(Double x) {
        Double result = 0.0;
        for (Double factor : factors) {
            result = result * x + factor;
        }
        return result;
    }
    
    public static TextField zrobTextField () {
        TextField tf = new TextField();
        tf.setMaxWidth(80);
        tf.setMinWidth(80);
        return tf;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
