import java.util.*;

public class Main {
    Scanner Sc = new Scanner(System.in);
    String name;
    ArrayList<User> Users = new ArrayList<User>();
    BookList B = new BookList();
    void login(){
        System.out.println("Enter your name:");
        name = Sc.next();
        if(Users.stream().anyMatch(i -> i.getName().equals(name))) {
            for( User U2: Users) {
                if(U2.getName().equals(name)) {
                    System.out.println("Welcome " + name);
                    homepage(U2);
                }
            }
        }
        else {
            User U1 = new User(name);
            Users.add(U1);
            System.out.println("Welcome " + name);
            homepage(U1);
        } 
        
    }
    void homepage(User U){
        System.out.println("\nEnter the number for the action you wish to take;");
        System.out.println("1.Borrow Book\n2.Return Book\n3.Book List\n4.Logout");
        System.out.println("Books Borrowed:");
        if(U.getBorrowed().isEmpty())  System.out.println("-");
        else U.getBorrowed().forEach(i -> System.out.println("--" + i.getName()));
        try {
            int choice = Sc.nextInt();
        switch(choice) {
            case 1: U.borrowBook(B); break;
            case 2: U.returnBook(B); break;
            case 3: B.displayBooks(); break; // Make this displayBookStatus
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
        M.login();
    }
}
