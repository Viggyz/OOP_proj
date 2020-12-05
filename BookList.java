import java.util.*;

public class BookList {
    private ArrayList<Book> bookList = new ArrayList<Book>();
    BookList() {
        bookList.add(new Book("A Tale of Two Cities"));
        bookList.add(new Book("R.D. Sharma"));
        bookList.add(new Book("Prisoner Of Azkaban"));
        bookList.add(new Book("The Godfather"));
    }

    void returnBook(Book book) {
        for(Book b : bookList) {
            if(b.getName().equals(book.getName())) {
                b.returnBook();
            }
        }
    } 

    Book getBook(int i) {
        return bookList.get(i);
    }

    void displayBookList() {
        System.out.println("Book No.\tName\tavailability\tborrowed by");
        bookList.forEach(i -> System.out.println(bookList.indexOf(i)+1+ "." + i.getName() + "\t" + i.isAvailable() + "\t" + i.getBorrower()));
    }

    ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> B = new ArrayList<Book>();
        System.out.println("Book No.\tName");
        int i=0;
        for(Book b: bookList) 
            if(b.isAvailable()){
                System.out.println(i+1 + "." + b.getName());
                B.add(b);i++;
            }
        return B;   
    } 
}
