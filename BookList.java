import java.util.*;

public class BookList {
    private ArrayList<Book> bookList = new ArrayList<Book>();
    BookList() {
        bookList.add(new Book("A Tale of Two Cities"));
        bookList.add(new Book("R.D. Sharma"));
        bookList.add(new Book("Prisoner Of Azkaban"));
        bookList.add(new Book("The Godfather"));
    }
    ArrayList<Book> getBooklist() {
        return bookList;
    }
    void displayBooks() {
        System.out.println("Book No.\tName\tavailability\tborrowed by");
        bookList.forEach(i -> System.out.println(bookList.indexOf(i)+1+ "." + i.getName() + "\t" + i.getAvailability() + "\t" + i.getBorrower()));
    }
    ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> B = new ArrayList<Book>();
        System.out.println("Book No.\tName");
        int i=0;
        for(Book b: bookList) 
            if(b.getAvailability()){
                System.out.println(i+1 + "." + b.getName());
                B.add(b);i++;
            }
        return B;   
    } 
}
