import java.util.*;

public class User {
    private Scanner Sc = new Scanner(System.in);
    private String name;
    private ArrayList<Book> borrowed = new ArrayList<Book>();
    User(String name) {
        this.name = name;
    }
    ArrayList<Book> getBorrowed() {
        return borrowed;
    }
    String getName() {
        return name;
    }
    void borrowBook(BookList B) {
        ArrayList<Book> B1 = B.avaBooks();
        if(B1.size()==0) {
            System.out.println("No available books");
            return;
        }
        System.out.println("----------\nEnter the number of the book you want to borrow");
        try{
            int choice = Sc.nextInt();
            B1.get(choice-1).borrowBook(name);
            borrowed.add(B1.get(choice-1));
            System.out.println("You have borrowed:" + (/*B.bookList.get(choice-1).getName()*/B1.get(choice-1).name) + "\nThank you for borrowing!");
        }
        catch(InputMismatchException e) {
            System.out.println("Enter a number please!");
            Sc.nextLine();
            return;
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Invalid option");
            return; 
        } 
    }
    void returnBook(BookList B) {
        if (borrowed.size() == 0) {
            System.out.println("You have no books to return!");
            return;
        }
        borrowed.forEach(i -> System.out.println(borrowed.indexOf(i)+1 + "."+ i.name));
        System.out.println("----------\nEnter the number of the book you want to return");
        
        try {
            int choice = Sc.nextInt();
            B.getBooklist().get(B.getBooklist().indexOf(borrowed.get(choice-1))).returnBook();
            borrowed.remove(choice-1);
            System.out.println("You have returned: " + (B.getBooklist().get(choice-1).getName()) + "\nCome again!");
        }
        catch(InputMismatchException e) {
            System.out.println("Enter a number please!");
            Sc.nextLine();
            return;
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("Invalid option");
            return;
        } 
    }
    
}
