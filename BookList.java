import java.util.*;

public class BookList {
    Scanner Sc = new Scanner(System.in);
    ArrayList<Book> bookList = new ArrayList<Book>();
    BookList() {
        bookList.add(new Book("A Tale of Two Cities",2));
        bookList.add(new Book("R.D. Sharma",1));
        bookList.add(new Book("Prisoner Of Azkaban",2));
        bookList.add(new Book("Reader's Digest",3));
        bookList.add(new Book("The Week", 3));
    }
    void displayBooks() {
        System.out.println("Book No.\tName\tavailability\tborrowed by");
        bookList.forEach(i -> System.out.println(bookList.indexOf(i)+1+ "." + i.name + "\t" + (i.av?"Available":"Unavailable")  + "\t" + i.borby));
    }
    ArrayList<Book> avaBooks(int n) {
        ArrayList<Book> B = new ArrayList<Book>();
        System.out.println("Book No.\tName");
        int i=0;
        for(Book b: bookList) {
            if(b.av && n == 4) {
                System.out.println(i+1 + "." + b.name);
                B.add(b);i++;
            }
            else if(b.av && b.type==n){
                System.out.println(i+1 + "." + b.name);
                B.add(b);i++;
            }
        }
        return B;   
    }
}
