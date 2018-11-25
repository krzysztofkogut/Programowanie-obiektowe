package imageviewer;

import java.io.*;
import javafx.application.Application;
import javafx.scene.input.MouseButton;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class ImageViewer extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        ScrollPane root = new ScrollPane();
        TilePane tile = new TilePane(Orientation.VERTICAL);
        tile.setTileAlignment(Pos.CENTER);
        tile.setHgap(10);
        tile.setVgap(10);
        
        Button openButton = new Button("Open a Folder...");
        tile.getChildren().add(openButton);

        root.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.setFitToWidth(true);
        root.setContent(tile);

        primaryStage.setWidth(1080);
        primaryStage.setHeight(720);

        primaryStage.setTitle("ImageViewer");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        openButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    DirectoryChooser chooser = new DirectoryChooser();
                    chooser.setTitle("Select Folder");
                    File selectedFolder = chooser.showDialog(primaryStage);

                    File[] listOfFiles = selectedFolder.listFiles();
                    tile.getChildren().clear();
                    tile.getChildren().add(openButton);
                    for (final File file : listOfFiles) {
                        ImageView imageView = createImageView(file);
                        tile.getChildren().add(imageView);
                    }
                    primaryStage.show();
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("Check your path");
                }
            }
        });
    }

    private ImageView createImageView(final File imageFile) {

        ImageView imageView = null;
        try {
            final Image image = new Image(new FileInputStream(imageFile), 120, 0, true, true);

            imageView = new ImageView(image);
            imageView.setFitWidth(120);
            imageView.setOnMouseClicked(mouseEvent -> {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
                    try {
                        BorderPane borderPane = new BorderPane();
                        ImageView setImageView = new ImageView();
                        Image setImage = new Image(new FileInputStream(imageFile));
                        setImageView.setImage(setImage);
                        setImageView.setFitHeight(stage.getHeight());
                        setImageView.setPreserveRatio(true);

                        borderPane.setCenter(setImageView);

                        Stage newStage = new Stage();
                        newStage.setWidth(stage.getWidth());
                        newStage.setHeight(stage.getHeight());
                        newStage.setTitle(imageFile.getName());
                        Scene scene = new Scene(borderPane);

                        newStage.setScene(scene);
                        newStage.show();

                    } catch (Exception e) {
                        System.out.println("Problem with image: " + e.getMessage());
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("Problem with image: " + e.getMessage());
        }
        return imageView;
    }

    public static void main(String[] args) {
        launch(args);
    }

}