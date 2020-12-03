import java.util.*;

public class User {
    Scanner Sc = new Scanner(System.in);
    String name;
    ArrayList<Book> borrowed = new ArrayList<Book>();
    User(String name) {
        this.name = name;
    }
    void borrowBook(BookList B) {
        ArrayList<Book> B1 = B.avaBooks();
        if(B1.size()==0) {
            System.out.println("No avaiable books");
            return;
        }
        System.out.println("----------\nEnter the number of the book you want to borrow");
        int choice = Sc.nextInt();
        try {
            B1.get(choice-1).borrowBook(name);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Invalid option");
            return;
        }
        borrowed.add(B1.get(choice-1));
        System.out.println("You have borrowed:" + (/*B.bookList.get(choice-1).getName()*/B1.get(choice-1).name) + "\nThank you for borrowing!");
    }
    void returnBook(BookList B) {
        if (borrowed.size() == 0) {
            System.out.println("You have no books to return!");
            return;
        }
        borrowed.forEach(i -> System.out.println(borrowed.indexOf(i)+1 + "."+ i.name));
        System.out.println("----------\nEnter the number of the book you want to return");
        int choice = Sc.nextInt();
        try {
            B.bookList.get(B.bookList.indexOf(borrowed.get(choice-1))).returnBook();
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Invalid option");
            return;
        }
        borrowed.remove(choice-1);
        System.out.println("You have returned: " + (B.bookList.get(choice-1).getName()) + "\nCome again!");
    }
    
}
