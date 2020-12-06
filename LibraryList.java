import java.util.*;

public class LibraryList {
    private ArrayList<Book> Books = new ArrayList<Book>();
    LibraryList() {
        Books.add(new Book("A Tale of Two Cities"));
        Books.add(new Book("R.D. Sharma"));
        Books.add(new Book("Prisoner Of Azkaban"));
        Books.add(new Book("The Godfather"));
    }

    void returnBook(Book book) {
        for(Book b : Books) {
            if(b.getName().equals(book.getName())) {
                b.returnBook();
            }
        }
    } 

    Book getBook(int i) {
        return Books.get(i);
    }

    void displayBooks() {
        System.out.println("Book No.\tName\tavailability\tborrowed by");
        Books.forEach(i -> System.out.println(Books.indexOf(i)+1+ "." + i.getName() + "\t" + i.isAvailable() + "\t" + i.getBorrower()));
    }

    ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> B = new ArrayList<Book>();
        System.out.println("Book No.\tName");
        int i=0;
        for(Book b: Books) 
            if(b.isAvailable()){
                System.out.println(i+1 + "." + b.getName());
                B.add(b);i++;
            }
        return B;   
    } 
}
