import java.util.*;

public class User {
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
    void borrowBook() {
        ArrayList<Book> B1 = LibraryList.getAvailableBooks();
        if(B1.size()==0) {
            System.out.println("No available books");
            return;
        }
        System.out.println("----------\nEnter the number of the book you want to borrow");
        Scanner Sc = new Scanner(System.in);
        try{
            int choice = Sc.nextInt();
            B1.get(choice-1).borrowBook(name);
            borrowed.add(B1.get(choice-1));
            System.out.println("You have borrowed:" + (B1.get(choice-1).getName()) + "\nThank you for borrowing!");
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
    void returnBook() {
        if (borrowed.size() == 0) {
            System.out.println("You have no books to return!");
            return;
        }
        for(Book i: borrowed) {
            System.out.println(borrowed.indexOf(i)+1 + "."+ i.getName());
        }
        System.out.println("----------\nEnter the number of the book you want to return");
        Scanner Sc = new Scanner(System.in);

        try {
            int choice = Sc.nextInt();
            LibraryList.returnBook(borrowed.get(choice-1));
            System.out.println("You have returned: " + (borrowed.get(choice-1).getName()) + "\nCome again!");
            borrowed.remove(choice-1);
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
    void displayBooks() {
        ArrayList<Book> Books = LibraryList.getBooks();
        System.out.println("Book No.\tName\tavailability\tborrowed by");
        Books.forEach(i -> System.out.println(Books.indexOf(i)+1+ "." + i.getName() + "\t" + i.isAvailable() + "\t" + i.getBorrower()));
    }
}



class Guest extends User {
    private static final int borrow_limit = 1;
    Guest(String name) {
        super(name);
    }

    void borrowBook() {
        if(getBorrowed().size() == borrow_limit) {
            System.out.println("Sorry you cannot borrow more book as your limit is " + borrow_limit + "book(s)");
            return;
        }
        super.borrowBook();
    }
}

class Member extends User {
    private static final int borrow_limit = 5;
    Member(String name) {
        super(name);
    }

    void borrowBook() {
        if(getBorrowed().size() == borrow_limit) {
            System.out.println("Sorry you cannot borrow more book as your limit is " + borrow_limit + "book(s)");
            return;
        }
        super.borrowBook();
    }
}