import java.util.*;

public class BookList {
    Scanner Sc = new Scanner(System.in);
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
    ArrayList<Book> avaBooks() {
        ArrayList<Book> B = new ArrayList<Book>();
        System.out.println("Book No.\tName");
        int i=0;
        for(Book b: bookList) 
            if(b.av){
                System.out.println(i+1 + "." + b.name);
                B.add(b);i++;
            }
        return B;   
    }
}
