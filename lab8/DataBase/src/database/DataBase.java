package database;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.sql.*;
import javafx.collections.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class DataBase extends Application {
    
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
  
    @Override
    public void start(Stage primaryStage) {
        
        connectionCheck();
        TextField factorsField = zrobTextField();
        Label allRecords = new Label("Wyświetl wszystkie dane");
        Button allRecordsButton = new Button("Wyświetl");
        Label searchAuthor = new Label("Wyszukaj po nazwisku autora lub po isbn");
        TextField authorName = zrobTextField();
        authorName.setPromptText("Nazwisko");
        TextField isbnNumber = zrobTextField();
        isbnNumber.setPromptText("Numer ISBN");
        Button authorNameButton = new Button("Wyświetl");
        Label addBook = new Label("Dodaj książkę (*wymagane pola)");
        TextField isbn = zrobTextField();
        isbn.setPromptText("ISBN*");
        TextField title = zrobTextField();
        title.setPromptText("Tytuł*");
        TextField author = zrobTextField();
        author.setPromptText("Autor*");
        TextField year = zrobTextField();
        year.setPromptText("Rok*");
        Button addBookButton = new Button("Dodaj");
        
        allRecordsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TableView table = new TableView();
                ObservableList<Book> data = FXCollections.observableArrayList();
                table.setEditable(true);
 
                TableColumn isbnCol = new TableColumn("ISBN");
                isbnCol.setMinWidth(130);
                isbnCol.setCellValueFactory(
                        new PropertyValueFactory<Book, String>("isbn"));

                TableColumn titleCol = new TableColumn("Title");
                titleCol.setMinWidth(250);
                titleCol.setCellValueFactory(
                        new PropertyValueFactory<Book, String>("title"));

                TableColumn authorCol = new TableColumn("Author");
                authorCol.setMinWidth(150);
                authorCol.setCellValueFactory(
                        new PropertyValueFactory<Book, String>("author"));
                
                TableColumn yearCol = new TableColumn("Year");
                yearCol.setMinWidth(50);
                yearCol.setCellValueFactory(
                        new PropertyValueFactory<Book, String>("year"));

                table.setItems(data);
                table.getColumns().addAll(isbnCol, titleCol, authorCol, yearCol);
                try {
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT * FROM books");
                    int i = 0;
                    while(rs.next()){
                      String isbn = rs.getString(1);
                      String title = rs.getString(2);
                      String author = rs.getString(3);
                      String year = rs.getString(4);
                      data.add(new Book(isbn, title, author, year));
                      i++;
                    }
                    Stage newStage = new Stage();
                    newStage.setWidth(580);
                    newStage.setHeight(600);
                    newStage.setTitle("All Records");
                    
                    Scene scene = new Scene(table);

                    newStage.setScene(scene);
                    newStage.show();
                }catch (SQLException ex){
                    
                }finally {
                  if (rs != null) {
                    try {
                      rs.close();
                    } catch (SQLException sqlEx) { } 
                    rs = null;
                  }
                  if (stmt != null) {
                    try {
                      stmt.close();
                    } catch (SQLException sqlEx) { }
                    stmt = null;
                  }
                }  
            }
        });
        
        authorNameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TableView table = new TableView();
                ObservableList<Book> data = FXCollections.observableArrayList();
                table.setEditable(true);
 
                TableColumn isbnCol = new TableColumn("ISBN");
                isbnCol.setMinWidth(130);
                isbnCol.setCellValueFactory(
                        new PropertyValueFactory<Book, String>("isbn"));

                TableColumn titleCol = new TableColumn("Title");
                titleCol.setMinWidth(250);
                titleCol.setCellValueFactory(
                        new PropertyValueFactory<Book, String>("title"));

                TableColumn authorCol = new TableColumn("Author");
                authorCol.setMinWidth(150);
                authorCol.setCellValueFactory(
                        new PropertyValueFactory<Book, String>("author"));
                
                TableColumn yearCol = new TableColumn("Year");
                yearCol.setMinWidth(50);
                yearCol.setCellValueFactory(
                        new PropertyValueFactory<Book, String>("year"));

                table.setItems(data);
                table.getColumns().addAll(isbnCol, titleCol, authorCol, yearCol);
                try {
                    stmt = conn.createStatement();
                    String text = authorName.getText();
                    String query = "author like '% " + text +"%'";
                    if(text.isEmpty()) {
                        text = isbnNumber.getText();
                        query = "isbn like '" + text + "%'";
                    }
                    
                    rs = stmt.executeQuery("SELECT * FROM books WHERE " + query);
                    int i = 0;
                    while(rs.next()){
                      String isbn = rs.getString(1);
                      String title = rs.getString(2);
                      String author = rs.getString(3);
                      String year = rs.getString(4);
                      data.add(new Book(isbn, title, author, year));
                      i++;
                    }
                    Stage newStage = new Stage();
                    newStage.setWidth(580);
                    newStage.setHeight(600);
                    newStage.setTitle("Query");
                    
                    Scene scene = new Scene(table);

                    newStage.setScene(scene);
                    newStage.show();
                }catch (SQLException ex){
                    
                }finally {
                  if (rs != null) {
                    try {
                      rs.close();
                    } catch (SQLException sqlEx) { } 
                    rs = null;
                  }
                  if (stmt != null) {
                    try {
                      stmt.close();
                    } catch (SQLException sqlEx) { }
                    stmt = null;
                  }
                }  
            }
        });
        
        addBookButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    stmt = conn.createStatement();
                    stmt.executeUpdate(
                    "INSERT INTO books (isbn, title, author, year) "
                    + "VALUES ('" + isbn.getText() +"','"
                    + title.getText() + "','" + author.getText() + "','" 
                    + year.getText() +"')");
                } catch (SQLException ex){
                    System.out.println("Błąd: " + ex.getMessage());
                    
                }finally {
                  if (rs != null) {
                    try {
                      rs.close();
                    } catch (SQLException sqlEx) { } 
                    rs = null;
                  }
                  if (stmt != null) {
                    try {
                      stmt.close();
                    } catch (SQLException sqlEx) { }
                    stmt = null;
                  }
                } 
            }
        });
        
        GridPane root = new GridPane();
        root.setPadding(new Insets(5));
        root.setHgap(10);
        root.setVgap(10);
        
        root.add(allRecords, 0, 0);
        root.add(allRecordsButton, 1, 0);
      
        root.add(searchAuthor, 0, 1);
        root.add(authorName, 1, 1);
        root.add(isbnNumber, 2, 1);
        root.add(authorNameButton, 3, 1);
        
        root.add(addBook, 0, 2);
        root.add(isbn, 1, 2);
        root.add(title, 2, 2);
        root.add(author, 3, 2);
        root.add(year, 4, 2);
        root.add(addBookButton, 5, 2);
        
        Scene scene = new Scene(root, 920, 120);
        
        primaryStage.setTitle("Books Data Base");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public Connection connect(){
        try {
            Connection con;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = 
            DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/kriskogu",
                "kriskogu","xAFojbdZdXQVyuZx");
            return con;
        } catch (SQLException ex) {
          // handle any errors
          System.out.println("SQLException: " + ex.getMessage());
          System.out.println("SQLState: " + ex.getSQLState());
          System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){e.printStackTrace();}
        
        return null;
    }
    
    private void connectionCheck(){

        for (int i=0; i< 3; ++i) {
            conn = connect();
            if (conn == null){
                continue;
            }
            else
                return;
        }

        Alert connectionFault = new Alert(Alert.AlertType.ERROR);
        connectionFault.setTitle("Connection Fault");
        connectionFault.setHeaderText("Błąd połączenia z bazą");
        connectionFault.setContentText("Brak możliwości nawiązania połączenia z bazą");
        connectionFault.showAndWait();

        System.exit(1);
    }

    public static TextField zrobTextField () {
        TextField tf = new TextField();
        tf.setMaxWidth(130);
        tf.setMinWidth(130);
        return tf;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
