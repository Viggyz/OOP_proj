import java.util.*;

public class BookList {
    ArrayList<Book> bookList = new ArrayList<Book>();
    BookList() {
        bookList.add(new Book("A Tale of Two Cities"));
        bookList.add(new Book("R.D. Sharma"));
        bookList.add(new Book("Prisoner Of Azkaban"));
        bookList.add(new Book("The Godfather"));
    }
    void displayBooks() {
        System.out.println("Book No.\tName\tavailability\tborrowed by");
        bookList.forEach(i -> System.out.println(bookList.indexOf(i)+1+ "." + i.name + "\t" + i.av + "\t" + i.borby));
    }
}
