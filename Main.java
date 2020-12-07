import java.util.*;

public class Main {
    Scanner Sc = new Scanner(System.in);
    String name;
    ArrayList<User> Users = new ArrayList<User>();
    void login(){
        System.out.println("Enter your name:");
        name = Sc.next();
        for(User U: Users) {
            if(U.getName().equals(name)) {
                System.out.println("\nWelcome " + name);
                homepage(U);
                return;
            }
        }
            User U1 = new User(name);
            Users.add(U1);
            System.out.println("\nWelcome " + name);
            homepage(U1); 
    }
    void homepage(User U){
        System.out.println("\nEnter the number for the action you wish to take;");
        System.out.println("1.Borrow Book\n2.Return Book\n3.Book List\n4.Logout");
        System.out.println("Books Borrowed:");
        if(U.getBorrowed().isEmpty())  System.out.println("-");
        else {
            for(Book b: U.getBorrowed()) {
                System.out.println("--" + b.getName());
            }
        }
        try {
            int choice = Sc.nextInt();
        switch(choice) {
            case 1: U.borrowBook(); break;
            case 2: U.returnBook(); break;
            case 3: U.displayBooks(); break; // Make this displayBookStatus
            case 4: login(); break;
            default: System.out.println("Invalid Input");
        }
        }
        catch(InputMismatchException e) {
            System.out.println("Enter a valid number");
            Sc.nextLine();
        }
        homepage(U); 
    }

    public static void main(String args[]) {
        Main M = new Main();
        LibraryList.initialize();
        M.login();
    }
}
