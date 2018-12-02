package database;

import javafx.beans.property.SimpleStringProperty;

public class Book {
 
        SimpleStringProperty isbn;
        SimpleStringProperty title;
        SimpleStringProperty author;
        SimpleStringProperty year;
 
        public Book(String isbnIn, String titleIn, String authorIn, String yearIn) {
            this.isbn = new SimpleStringProperty(isbnIn);
            this.title = new SimpleStringProperty(titleIn);
            this.author = new SimpleStringProperty(authorIn);
            this.year = new SimpleStringProperty(yearIn);
        }
 
        public String getIsbn() {
            return isbn.get();
        }
 
        public void setIsbn(String isbnIn) {
            isbn.set(isbnIn);
        }
 
        public String getTitle() {
            return title.get();
        }
 
        public void setTitle(String titleIn) {
            title.set(titleIn);
        }
 
        public String getAuthor() {
            return author.get();
        }
 
        public void setAuthor(String authorIn) {
            author.set(authorIn);
        }
        
        public String getYear() {
            return year.get();
        }
 
        public void setYear(String yearIn) {
            year.set(yearIn);
        }
    }