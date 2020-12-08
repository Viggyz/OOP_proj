import java.util.*;
import javax.swing.*;

public class Main {
    Scanner Sc = new Scanner(System.in);
    String name;
    JFrame f = new JFrame();
    ArrayList<User> Users = new ArrayList<User>();
    void login(){
        //System.out.println("Enter your name:");
        try {
            name = JOptionPane.showInputDialog(f, "Enter your name", "LibSys", JOptionPane.PLAIN_MESSAGE).strip();
        }
        catch (NullPointerException e) {
            System.exit(1);
        }
        
        if (name.equals("") || name.length() < 3 || name.length() > 20) {
            JOptionPane.showMessageDialog(f, "Enter a valid name that has 3-20 characters", "LibSys", JOptionPane.ERROR_MESSAGE);
            login();
        }
        for(User U: Users) {
            if(U.getName().equals(name)) {
                //System.out.println("\nWelcome " + name);
                homepage(U);
                return;
            }
        }
            User U1 = new User(name);
            Users.add(U1);
            //System.out.println("\nWelcome " + name);
            homepage(U1); 
    }
    void homepage(User U){
        //Custom button text
        Object[] options = {"Borrow Book","Return Book","Book List",/*"Show Borrowed",*/ "Logout"};
        int choice = JOptionPane.showOptionDialog(f, "Choose one of the following options", "LibSys", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        /* System.out.println("\nEnter the number for the action you wish to take;");
        System.out.println("1.Borrow Book\n2.Return Book\n3.Book List\n4.Logout");
        System.out.println("Books Borrowed:");
        if(U.getBorrowed().isEmpty())  System.out.println("-");
        else {
            for(Book b: U.getBorrowed()) {
                System.out.println("--" + b.getName());
            }
        }*/
        switch(choice+1) {
            case 1: U.borrowBook(); break;
            case 2: U.returnBook(); break;
            case 3: U.displayBooks(); break; // Make this displayBookStatus
            //case 4: U.showBorrowed(); break;
            case 4: login(); break;
            default: System.exit(1);
        }
        homepage(U);
    }

    public static void main(String args[]) {
        Main M = new Main();
        LibraryList.initialize();
        M.login();
    }
}
