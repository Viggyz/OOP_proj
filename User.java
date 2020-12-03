import java.util.*;

public class User {
    Scanner Sc = new Scanner(System.in);
    String name;
    ArrayList<Book> borrowed = new ArrayList<Book>();
    User(String name) {
        this.name = name;
    }
    void borrowBook(BookList B) {
        B.displayBooks();
        System.out.println("----------\nEnter the number of the book you want to borrow");
        int choice = Sc.nextInt();
        B.bookList.get(choice-1).borrowBook(name);
        borrowed.add(B.bookList.get(choice-1));
        System.out.println("You have borrowed:" + (B.bookList.get(choice-1).getName()) + " Thank you for borrowing!");
    }
    void returnBook(BookList B) {
        borrowed.forEach(i -> System.out.println(borrowed.indexOf(i)+1 + "."+ i.name));
        System.out.println("----------\nEnter the number of the book you want to return");
        int choice = Sc.nextInt();
        B.bookList.get(B.bookList.indexOf(borrowed.get(choice-1))).returnBook();
        borrowed.remove(choice-1);
        System.out.println("You have returned: " + (B.bookList.get(choice-1).getName()) + "\nCome again!");
    }
    
}
