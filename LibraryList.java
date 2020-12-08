import java.util.*;

public class LibraryList {
    private static ArrayList<Book> Books = new ArrayList<Book>();
    private LibraryList() {};
    static void initialize() {
        Books.add(new Book("A Tale of Two Cities"));
        Books.add(new Book("R.D. Sharma"));
        Books.add(new Book("Prisoner Of Azkaban"));
        Books.add(new Book("The Godfather"));
    }

    static void returnBook(Book book) {
        for(Book b : Books) {
            if(b.getName().equals(book.getName())) {
                b.returnBook();
            }
        }
    } 

    static Book getBook(int i) {
        return Books.get(i);
    }

    static ArrayList<Book> getBooks() {
        return Books;
    }

    static ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> B = new ArrayList<Book>();
        //System.out.println("Book No.\tName");
        int i=0;
        for(Book b: Books) 
            if(b.isAvailable()){
                //System.out.println(i+1 + "." + b.getName());
                B.add(b);i++;
            }
        return B;   
    } 
}
